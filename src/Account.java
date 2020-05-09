import java.io.Serializable;

public abstract class Account implements Serializable, InterestRate{

    //List common properties for savings and checking account
    private static final long serialVersionUID = 1L;
    private String name;
    private String sSN;
    private double balance;

    private static int index = 10000;
    protected String accountNumber;
    protected double rate;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getsSN() {
        return sSN;
    }

    public void setsSN(String sSN) {
        this.sSN = sSN;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public static int getIndex() {
        return index;
    }

    public static void setIndex(int index) {
        Account.index = index;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    //constructor to set base properties and initialize the account
    public Account(String name, String sSN, double initDeposit) {
        index++;
        this.name = name;
        this.sSN = sSN;
        this.balance = initDeposit;
        this.accountNumber = setAccountNumber();
        setRate();

    }

    public abstract void setRate();

    private String setAccountNumber(){
        /* Account number is generated with the following: 1 or 2 depending
        on Savings or Checking, last two digit of SSN, unique 5-digit number, and
        random 3-digit number
         */
        String lastTwoOfSSN = sSN.substring(sSN.length()-2);
        int uniqueID = index;
        int randomNumber = (int) (Math.random() * Math.pow(10, 3));
        return lastTwoOfSSN + uniqueID + randomNumber;

    }

    public void compound(){
        double accruedInterest = balance * (rate/100);
        balance = balance + accruedInterest;
        System.out.println("Accured Interest: $ " + accruedInterest);
        printBalance();
    }



    //List common methods... transactions

    public void deposit(double amount){
        balance = balance + amount;
        System.out.println("Depositing $ " + amount);
        printBalance();
    }
    public void withdraw(double amount){
        balance = balance - amount;
        System.out.println("Withdrawing $ " + amount);
        printBalance();
    }
    public void transfer(String toWhere, double amount){
        balance = balance - amount;
        System.out.println("Transferring $ " + amount + "to" + toWhere);
        printBalance();
    }

    public void printBalance(){
        System.out.println("Your balance now is: $ " + balance);
    }
    public void showInfo(){
        System.out.println(
                "NAME: " +name +
                        "\nACCOUNT NUMBER: " + accountNumber +
                        "\nBALANCE: " + balance +
                        "\nRATE: " + rate + "%"
        );
    }


}
