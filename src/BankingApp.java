import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.io.File;
import java.util.Scanner;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Scanner;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
public class BankingApp implements Runnable  {

    public void run() {
        System.out.println("Inside : " + Thread.currentThread().getName());
    }

    public static  void main(String[] args) {
        /**
         * This is a simple welcome screen message for the Bank-O app after logging into it
         */

        System.out.println("Inside : " + Thread.currentThread().getName());

        //concurrency used
        Thread myRunnableThread = new Thread(new MyRunnable() {
            @Override
            public void run() {
                File welcomeFile = new File("C:\\Users\\Asiya Ahmed\\IdeaProjects\\BankingProject\\src\\welcome.txt");
                try {
                    Scanner sc = new Scanner(welcomeFile);
                    while (sc.hasNextLine())
                        System.out.println(sc.nextLine());

                } catch (FileNotFoundException e) {
                    System.out.println("COULD NOT FIND FILE");
                    e.printStackTrace();
                }
                System.out.println("Hello from the anonymous class's implementation of run()");
            }
        });
        myRunnableThread.start();


        /** if i had more time to work on this project, the welcome screen of the app
         * would list authorized employees and ask individals to verify their identity before
         * having access to the bank information of the costumers. However for now, I created a list out of the generic
         * linkedlist class to meet the requirements for homework three
         */
        System.out.println("Below is a list of authorized employees that can access this page: ");
        LinkedList1<String> employeeList = new LinkedList1<>();

        employeeList.insert(new LinkedListNode<String>("Stacy McAdams"));
        employeeList.insert(new LinkedListNode<String>("Asiya Ahmed"));
        employeeList.insert(new LinkedListNode<String>("Conner Johnson"));
        employeeList.insert(new LinkedListNode<String>("Lee Daniel"));
        employeeList.insert(new LinkedListNode<String>("Angela Juan"));
        employeeList.insert(new LinkedListNode<String>("Raj Abdul "));
        employeeList.insert(new LinkedListNode<String>("Steve Jobs"));
        employeeList.print();

        System.out.println("Enter your employee ID ? ");

        Scanner empID = new Scanner(System.in);
        System.out.println("Please be aware that this ID  " + empID.nextLine() + " will be recorded for security and authentication purposes "
                );





        //LAMBDA
        //employeeList.forEach(name -> {
            //System.out.println(name);
        //});




        System.out.println();
        System.out.println();




        List<Account> accounts = new LinkedList<Account>();



        String file = "C:\\Users\\Asiya Ahmed\\IdeaProjects\\BankingProject\\src\\NewBankAccounts.csv";

        //Read a CSV file then create new accounts based on that data

        List<String[]> newAccountHolders = utilities.CSV.read(file);
        for(String[] accountHolder : newAccountHolders){
            String name = accountHolder[0];
            String sSN = accountHolder[1];
            String accountType = accountHolder[2];
            double initDeposit = Double.parseDouble(accountHolder[3]);
            if(accountType.equals("Savings")){
                accounts.add(new Savings(name, sSN, initDeposit));
            }
            else if (accountType.equals("Checking")){
                accounts.add(new Checking(name, sSN, initDeposit));
            }
            else {
                System.out.println("ERROR: READING ACCOUNT TYPE");
            }
        }

        accounts.get(5).showInfo();
        for(Account acc : accounts){
            System.out.println("\n************");
            acc.showInfo();
        }




        Checking person1 = new Checking("John", "890334545", 500.0);
        Checking person2 = new Checking("Rachel", "921337766", 300.0);

        try {
            FileOutputStream f = new FileOutputStream(new File("myObjects.txt"));
            ObjectOutputStream o = new ObjectOutputStream(f);

            // Write objects to file
            o.writeObject(person1);
            o.writeObject(person2);
            o.close();
            f.close();
            FileInputStream fi = new FileInputStream(new File("myObjects.txt"));
            ObjectInputStream oi = new ObjectInputStream(fi);
            // Read objects
            Checking pr1 = (Checking) oi.readObject();
            Checking pr2 = (Checking) oi.readObject();
            System.out.println(pr1.toString());
            System.out.println(pr2.toString());
            oi.close();
            fi.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }














    }
}
