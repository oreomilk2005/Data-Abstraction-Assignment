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

    //Setters and Getters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAccountNumber() { return accountNumber; }
    public void setAccountNumber(int accountNumber) { this.accountNumber = accountNumber; }
    public ArrayList<Deposit> getDeposits() { return deposits; }
    public void setDeposits(ArrayList<Deposit> deposits) { this.deposits = deposits; }
    public ArrayList<Withdraw> getWithdraws() { return withdraws; }
    public void setWithdraws(ArrayList<Withdraw> withdraws) { this.withdraws = withdraws; }
    public double getCheckBalance() { return checkBalance; }
    public void setCheckBalance(double checkBalance) { this.checkBalance = checkBalance; }
    public double getSavingBalance() { return savingBalance; }
    public void setSavingBalance(double savingBalance) { this.savingBalance = savingBalance; }
    public double getSavingRate() { return savingRate; }
    public void setSavingRate(double savingRate) { this.savingRate = savingRate; }

    Customer(){
        //create default constructor
        //Initializing name, account number, checkBalance, savingBalance, and SavingRate to a default value.
        name = "unknown";
        accountNumber = 1;
        checkBalance = 0;
        savingBalance = 0;
        savingRate = 0;
        //Initializing two new ArrayLists for deposits and withdraws
        deposits = new ArrayList<>();
        withdraws = new ArrayList<>();
    }
    Customer(String name, int accountNumber, double checkDeposit, double savingDeposit){
        //constructor code here
        this.name = name;
        this.accountNumber = accountNumber;
        checkBalance = checkDeposit;
        savingBalance = savingDeposit;
        savingRate = 0;
        deposits = new ArrayList<>();
        withdraws = new ArrayList<>();
    }

    //Requires: double, Date, String
    //Modifies: this
    //Effects: New deposit in deposit arraylist with amount amt on Date date into account account. Balance in account increases by amt.
    public double deposit(double amt, Date date, String account){
        //your code here
        if(account.equals(CHECKING) || account.equals(SAVING) && amt >= 0) {
            deposits.add(new Deposit(amt, date, account));
            if (account.equals(CHECKING)) checkBalance += amt;
            else savingBalance += amt;
            return amt;
        }
        return -1;
    }

    //Requires: double, Date, String
    //Modifies: this
    //Effects: If there is no overdraft, then new withdraw in withdraw arraylist with amount amt, Date date, and account account, and balance in account decreases by amt.
    public double withdraw(double amt, Date date, String account) {
        //your code here
        if (!checkOverdraft(amt, account) && amt >= 0) {
                withdraws.add(new Withdraw(amt, date, account));
                if (account.equals(CHECKING)) checkBalance -= amt;
                else savingBalance -= amt;
                return amt;
            }
        return -1;
    }

    private boolean checkOverdraft(double amt, String account){
        //your code here
        if(account.equals(CHECKING)) return amt + OVERDRAFT > checkBalance;
        if(account.equals(SAVING)) return amt + OVERDRAFT > savingBalance;
        else return true;
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
