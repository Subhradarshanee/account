import java.util.Scanner;

public class Account extends BankAccount  {

    private String customerName;
    private String  customerId;

   private  BankAccount account;

   private  String accountType;

   double balance;
   double previousTransaction;


    public Account(String memberName, String id, String type,double balance) {
        this.customerName = memberName;
        this.customerId= id;
        this.accountType= type;
        this.balance=balance;
  openAccount(this.accountType);
    }

    
     private void  openAccount(String accountType){

        switch(this.accountType.toLowerCase().charAt(0)){
            case('s')->{ this.account= new SavingsAccount(this.balance); }
            case('c')->{ this.account= new CurrentAccount(true,15,this.balance);}

        }
        }


    @Override
    public void deposit(double amount) {
        account.deposit(amount);
        previousTransaction= amount;

    }

    @Override
    public void withdraw(double amount) throws AmountException {
        account.withdraw(amount);
        previousTransaction = -amount;
    }

    @Override
    public double getBalance() {
       return  account.getBalance();
    }

    void showMenu(){
        char option='e';
        Scanner sc=  new Scanner(System.in);
        System.out.println("Welcome " + this.customerName );
        System.out.println("your customer ID is "+ this.customerId);
        System.out.println("\n");
        System.out.println("A.Check Balance");
        System.out.println("B. Deposit");
        System.out.println("C. Withdraw");
        System.out.println("D. Previous Transaction");
        System.out.println("E.Exit");

        do{
            System.out.println("-----------------------------------------------------------------------");
            System.out.println("Enter an Option");
            System.out.println("-----------------------------------------------------------------------");
            option= sc.next().charAt(0);

            switch(option){
                case 'A' :
                     System.out.println("------------------------------------------");
                     System.out.println("Balance ="+ this.account.getBalance() );
                    System.out.println("------------------------------------------");
                     System.out.println("\n");
                break;
                case'B':
                    System.out.println("------------------------------------------");
                    System.out.println("Enter the Amount" );
                    System.out.println("------------------------------------------");
                    this.account.deposit(sc.nextInt());
                    System.out.println("\n");
                    break;
                case'C':

                    System.out.println("------------------------------------------");
                    System.out.println("Enter the Amount" );
                    System.out.println("------------------------------------------");
                    try {
                        this.account.withdraw(sc.nextInt());
                    }
                    catch (AmountException e){
                        System.out.println(e.getMessage());
                    }
                    System.out.println("\n");

                    break;
                case'D' :
                    System.out.println("------------------------------------------");
                    System.out.println("previous transaction is  ="+ previousTransaction );
                    System.out.println("------------------------------------------");
                    System.out.println("\n");
                    break;
            }
        }while(option != 'E');

        System.out.println("Thank You.");

    }
}

