import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class withdrawTest {
        Withdraw testWithdraw;
        Withdraw testWithdraw2;
        Date d;

        @Before
        public void setup(){
            d = new Date();
            testWithdraw = new Withdraw(250, d, "Saving");
            testWithdraw2 = new Withdraw(100, new Date(220, 8, 6), "Checking");
        }

        @Test
        public void toStringTest(){
            assertEquals(testWithdraw.toString(), "Withdrawal of: $250.0 Date: " + d + " into account: Saving");
            assertEquals(testWithdraw2.toString(), "Withdrawal of: $100.0 Date: Fri Sep 06 00:00:00 PDT 2120 into account: Checking");
        }
}
