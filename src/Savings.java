public class Savings extends Account {

    //List properties specific to a savings account
    private int safetyDepositBoxID;
    private int safetyDepositBoxKey;

    //constructor to initialize savings account properties

    public Savings(String name, String sSN, double initDeposit) {
        super(name, sSN, initDeposit);
        accountNumber = "1" + accountNumber;

        setSafetyDepositBox();
    }

    private void setSafetyDepositBox(){
        safetyDepositBoxID = (int) (Math.random() * Math.pow(10, 3));
        safetyDepositBoxKey = (int) (Math.random() * Math.pow(10, 4));

    }

    @Override
    public void setRate() {
        rate = getBaseRate() - .25;
    }

    //list any methods specific to the savings account
    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println(
                " Your Savings Account Features" +
                "\n Safety Deposit Box ID: " + safetyDepositBoxID +
                "\n Safety Deposit Box Key: " + safetyDepositBoxKey
        );

    }
}
