public class Test {

    public static void main (String[] args){

    BankAccount acc=  new SavingsAccount(10000);
    SavingsAccount savingAccount= (SavingsAccount) acc;
    double interestrate= savingAccount.calculateInterest();
    System.out.println("interestrate is " + interestrate);
    System.out.printf("current balance in account is %.2f " , acc.getBalance());

    BankAccount acc1 = new CurrentAccount(true,30,5000);
    System.out.printf("current balance in "+acc1.getClass().getSimpleName() +" is %.2f " , acc1.getBalance());
        try {
            acc1.withdraw(7000);
        } catch (AmountException e) {
            throw new RuntimeException(e);
        }

        acc1.getBalance();


    }
}
