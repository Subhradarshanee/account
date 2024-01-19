public abstract  class BankAccount {

  double balance;

  public abstract  void deposit(double amount);
    public abstract void  withdraw(double amount) throws AmountException;
  public abstract double  getBalance();
}
