import java.util.Date;

public class Withdraw {
    private double amount;
    private Date date;
    private String account;

    //getters and setters
    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }
    public String getAccount() { return account; }
    public void setAccount(String account) { this.account = account; }

    Withdraw(double amount, Date date, String account){
        this.amount = amount;
        this.date = date;
        this.account = account;
    }

    //Effects: returns "Withdrawal of: $amount Date: date into account: account" for a Withdraw.
    public String toString(){
        //your code here
        return "Withdrawal of: $" + amount + " Date: " + date + " into account: " + account;
    }
}
