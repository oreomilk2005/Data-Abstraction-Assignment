import java.util.Date;

public class Deposit {
    private double amount;
    private Date date;
    private String account;

    Deposit(double amount, Date date, String account){
        this.amount = amount;
        this.date = date;
        this.account = account;
    }

    //Effects: returns "Deposit of: $amount Date: date into account:account" for a Deposit.
    public String toString(){
        //your code here
        return "Deposit of: $" + amount + " Date: " + date + " into account: " + account;
    }
}
