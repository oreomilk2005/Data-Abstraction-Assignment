import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class depositTest {
    Deposit testDeposit;
    Deposit testDeposit2;
    Date d;

    @Before
    public void setup(){
        d = new Date();
        testDeposit = new Deposit(250, d, "Saving");
        testDeposit2 = new Deposit(100, new Date(220, 8, 6), "Checking");
    }

    @Test
    public void toStringTest(){
        assertEquals(testDeposit.toString(), "Deposit of: $250.0 Date: " + d + " into account: Saving");
        assertEquals(testDeposit2.toString(), "Deposit of: $100.0 Date: Fri Sep 06 00:00:00 PDT 2120 into account: Checking");
    }
}
