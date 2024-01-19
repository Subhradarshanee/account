


public class SavingsAccount extends BankAccount implements  InterestRate {

    SavingsAccount(double amount){

        this.balance= amount;

    }



    @Override
    public double calculateInterest() {

        return (this.balance *0.08)/365;
    }

    @Override
    public void deposit(double amount) {

        if ( amount > 0){
            this.balance=this.balance+ amount;
         /* this.balance= this.balance +calculateInterest();*/

          System.out.println("current Balance stands at " + this.balance);

        }

    }

    @Override
    public void withdraw(double amount)  throws AmountException {

        if (this.balance - amount > 0){
            this.balance =this.balance - amount;
            System.out.println("current Balance stands at " + this.balance);

        }
        else {
            throw new AmountException("do not have sufficient amount to withdraw");
        }



    }

    @Override
    public double getBalance() {
      this.balance+= calculateInterest();
      return  this.balance;

    }
}
