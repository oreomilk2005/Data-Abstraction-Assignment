import java.util.Date;

public class inputTests {
    public static int[] amount = {-100, 0, 10, 99, 100, 678};
    public static String[] account = {"Checking", "Checking", "Random","Checking", "Saving", "Checking"};
    public static int[] expectedWithdrawSize = {0,1,1,2,3,3};
    public static int[] expectedWithdrawCheckBal = {100, 100, 100, 1 , 1, 1};
    public static int[] expectedWithdrawSaveBal = {0, 0, 0, 0, -100, -100};
}
