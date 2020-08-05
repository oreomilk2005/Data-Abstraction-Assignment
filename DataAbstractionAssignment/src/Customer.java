import javax.security.sasl.SaslClient;
import java.util.ArrayList;
import java.util.Date;

public class Customer {
    private String name;
    private int accountNumber;
    private ArrayList<Deposit> deposits;
    private ArrayList<Withdraw> withdraws;
    private double checkBalance;
    private double savingBalance;
    private double savingRate;
    public static final String CHECKING = "Checking";
    public static final String SAVING = "Saving";
    private final int OVERDRAFT = -100;

    Customer(){
        //create default constructor
        name = "unknown";
        accountNumber = 1;
        checkBalance = 0;
        savingBalance = 0;
        deposits = new ArrayList<>();
        withdraws = new ArrayList<>();
    }
    Customer(String name, int accountNumber, double checkDeposit, double savingDeposit){
        //constructor code here
        this.name = name;
        this.accountNumber = accountNumber;
        this.checkBalance = checkDeposit;
        this.savingBalance = savingDeposit;
        deposits = new ArrayList<>();
        withdraws = new ArrayList<>();
    }

    //Requires: double, Date, String
    //Modifies: this
    //Effects: New deposit in deposit arraylist with amount amt on Date date into account account. Balance in account increases by amt.
    public double deposit(double amt, Date date, String account){
        //your code here
        deposits.add(new Deposit(amt, date, account));
        if (account.equals(CHECKING)) checkBalance = checkBalance + amt;
        else savingBalance = savingBalance + amt;
        return amt;
    }

    //Requires: double, Date, String
    //Modifies: this
    //Effects: If there is no overdraft, then new withdraw in withdraw arraylist with amount amt, Date date, and account account, and balance in account decreases by amt.
    public double withdraw(double amt, Date date, String account){
        //your code here
        withdraws.add(new Withdraw(amt, date, account));
        if(!checkOverdraft(amt, account)){
            if(account.equals(CHECKING)) checkBalance = checkBalance - amt;
            else savingBalance = savingBalance - amt;
        }
        return 0;
    }

    private boolean checkOverdraft(double amt, String account){
        //your code here
        boolean checkOverdraft = false;
        if(account.equals(CHECKING)) checkOverdraft = !(amt <= checkBalance);
        if(account.equals(SAVING)) checkOverdraft =!(amt <= savingBalance);
        return checkOverdraft;
    }

    //do not modify
    public void displayDeposits(){
        for(Deposit d : deposits){
            System.out.println(d);
        }
    }
    //do not modify
    public void displayWithdraws(){
        for(Withdraw w : withdraws){
            System.out.println(w);
        }
    }

}
