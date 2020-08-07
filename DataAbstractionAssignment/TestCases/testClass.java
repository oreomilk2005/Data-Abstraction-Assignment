import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class testClass {

    Date day = new Date(2020-1900, 00, 01, 00, 00, 00);
    Customer c = new Customer("c", 123, 100, 0);

    @Test
    public void testDepositToString() {
        //Add a deposit
        c.deposit(100, day, "Checking");
        //Check if toString is correct
        assertEquals("[Deposit of: $100.0 Date: Wed Jan 01 00:00:00 PST 2020 into account: Checking]", c.getDeposits().toString());
    }

    @Test
    public void testWithdrawToString() {
        //Add a deposit
        c.withdraw(100, day, "Checking");
        //Check if toString is correct
        assertEquals("[Withdrawal of: $100.0 Date: Wed Jan 01 00:00:00 PST 2020 into account: Checking]", c.getWithdraws().toString());
    }

    @Test
    public void testWithdraw(){
        for (int i =0; i<inputTests.amount.length; i++){
            //Assigning inputs and expectations to variables
            int amt = inputTests.amount[i];
            String account = inputTests.account[i];
            int expectedSize = inputTests.expectedWithdrawSize[i];
            int expectedCheckBal = inputTests.expectedWithdrawCheckBal[i];
            int expectedSaveBal = inputTests.expectedWithdrawSaveBal[i];
            //Add a withdrawal to the list
            c.withdraw(amt, day, account);
            //Check that the size of the ArrayList withdraws and the saving and checking balance are correct
            assertEquals(expectedSize, c.getWithdraws().size());
            assertEquals(expectedCheckBal, c.getCheckBalance(), 1);
            assertEquals(expectedSaveBal, c.getSavingBalance(), 1);
        }
    }
}
