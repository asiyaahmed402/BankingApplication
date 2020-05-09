import org.junit.Test;

import static org.junit.Assert.*;

public class CheckingTest {

    @Test
    public void getBalance_deposit() throws Exception{
        Checking checkingtestt1 = new Checking("Asiya", "67676767", 2000.00);
        checkingtestt1.deposit(400);
        assertEquals(2400.00, checkingtestt1.getBalance(), 0);

    }


    @Test
    public void withdraw(){
        Checking checkingtest = new Checking("Asiya", "67676767", 2000.00);
        checkingtest.withdraw(200.00);
        assertEquals(1800.00, checkingtest.getBalance(), 0);

    }
}