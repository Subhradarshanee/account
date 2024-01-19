public class CurrentAccount extends BankAccount implements InterestRate{

    private double overDraftAmount;

    private int noOfDays;
    private boolean overDraft;

    private final  double overDraftLimit=10000;


    CurrentAccount(boolean overDraft,int days,double amount){
        this.overDraft= overDraft;
        this.noOfDays = days;
        this.balance= amount;
    }

    @Override
    public void deposit(double amount) {

   this.balance= amount+this.balance;

    }

    @Override
    public void withdraw(double amount) {

        if (this.balance - amount < 0 ){
            if  (overDraft) {
               if (amount- this.balance <= overDraftLimit) {

                 applyOverDraft(amount-this.balance);

                 this.balance= 0;

               }
            }
        }

    }

    @Override
    public double getBalance() {
    if (this.balance > 0) {

        return this.balance;
    }
    else return overDraftAmount;
    }

    @Override
    public double calculateInterest() {
        if (this.overDraftAmount > 0){
           return  (Math.abs(this.overDraftAmount) * 0.18 * noOfDays )/365;

        }

        return 0.0;
    }

    private  void applyOverDraft(double amount){
        this.overDraftAmount= -amount;
    }
}
