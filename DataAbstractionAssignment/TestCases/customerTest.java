import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class customerTest {
    Customer testCustomer;

    @Before
    public void setup(){
        testCustomer = new Customer();
    }

    @Test
    public void depositTest(){
        //Check that the size, saving balance, and checking balance are all 0
        assertEquals(testCustomer.getDeposits().size(), 0);
        assertEquals(testCustomer.getSavingBalance(), 0,1);
        assertEquals(testCustomer.getCheckBalance(), 0,1);
        //Deposit 250 into Savings and check size, saving balance, and checking balance
        assertEquals(testCustomer.deposit(250.0, new Date(), "Saving"), 250.0, 1);
        assertEquals(testCustomer.getDeposits().size(), 1);
        assertEquals(testCustomer.getSavingBalance(), 250.0, 1);
        assertEquals(testCustomer.getCheckBalance(), 0, 1);
        //Deposit 500 into Checking and check size, saving balance, and checking balance
        assertEquals(testCustomer.deposit(500.0, new Date(), "Checking"), 500.0, 1);
        assertEquals(testCustomer.getDeposits().size(), 2);
        assertEquals(testCustomer.getSavingBalance(), 250.0, 1);
        assertEquals(testCustomer.getCheckBalance(), 500, 1);
        //Deposit 321 into an un-valid account and check size, saving balance, and checking balance(make sure no new deposits are added)
        assertEquals(testCustomer.deposit(321.0, new Date(), "FakeAccount"), -1, 1);
        assertEquals(testCustomer.getDeposits().size(), 2);
        assertEquals(testCustomer.getSavingBalance(), 250.0, 1);
        assertEquals(testCustomer.getCheckBalance(), 500, 1);
    }

    @Test
    public void withdrawTest(){
        //Check that the size, saving balance, and checking balance are all 0
        assertEquals(testCustomer.getWithdraws().size(), 0);
        assertEquals(testCustomer.getSavingBalance(), 0,1);
        assertEquals(testCustomer.getCheckBalance(), 0,1);
        //Withdraw 30 into Saving and check size, saving balance, and checking balance
        assertEquals(testCustomer.withdraw(30.0, new Date(), "Saving"), 30.0, 1);
        assertEquals(testCustomer.getWithdraws().size(), 1);
        assertEquals(testCustomer.getSavingBalance(), -30.0, 1);
        assertEquals(testCustomer.getCheckBalance(), 0, 1);
        //Withdraw 100, which is overdraft into Saving and check size, saving balance, and checking balance
        assertEquals(testCustomer.withdraw(100.0, new Date(), "Saving"), -1, 1);
        assertEquals(testCustomer.getWithdraws().size(), 1);
        assertEquals(testCustomer.getSavingBalance(), -30.0, 1);
        assertEquals(testCustomer.getCheckBalance(), 0, 1);
        //Withdraw 100 into Checking and check size, saving balance, and checking balance
        assertEquals(testCustomer.withdraw(100.0, new Date(), "Checking"), 100.0, 1);
        assertEquals(testCustomer.getWithdraws().size(), 2);
        assertEquals(testCustomer.getSavingBalance(), -30.0, 1);
        assertEquals(testCustomer.getCheckBalance(), -100.0, 1);
        //Withdraw 167, which is overdraft into Checking and check size, saving balance, and checking balance
        assertEquals(testCustomer.withdraw(167.0, new Date(), "Checking"), -1, 1);
        assertEquals(testCustomer.getWithdraws().size(), 2);
        assertEquals(testCustomer.getSavingBalance(), -30.0, 1);
        assertEquals(testCustomer.getCheckBalance(), -100, 1);
        //Withdraw 57 into an un-valid account and check size, saving balance, and checking balance(make sure no new withdrawal is added)
        assertEquals(testCustomer.withdraw(57.0, new Date(), "FakeAccount"), -1, 1);
        assertEquals(testCustomer.getWithdraws().size(), 2);
        assertEquals(testCustomer.getSavingBalance(), -30.0, 1);
        assertEquals(testCustomer.getCheckBalance(), -100, 1);
    }
}
