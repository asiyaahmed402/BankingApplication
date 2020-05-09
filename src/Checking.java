public class Checking extends Account {

    //List properties specific to a checking account
    private int debitCardNumber;
    private int debitCardPIN;

    //constructor to initialize checking account properties

    public Checking(String name, String sSN, double initDeposit) {
        super(name, sSN, initDeposit);
        accountNumber = "2" + accountNumber;

        setDebitCard();
    }

    //List any methods specific to the checking account


    @Override
    public void setRate() {
        rate = getBaseRate() * .15;
    }

    private void setDebitCard(){
        debitCardNumber = (int) (Math.random() * Math.pow(10,12));
        debitCardPIN = (int) (Math.random() * Math.pow(10,4));
    }






    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Checking Account Features " +
                "\n Debit Card Number: " + debitCardNumber +
                "\n Debit Card Pin: " + debitCardPIN

        );

    }
}
