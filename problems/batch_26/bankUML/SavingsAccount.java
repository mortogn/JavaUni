public class SavingAccount extends Account {
    private double interest_rate;

    public void addInterest() {
        int totalInterest = this.getBalance() * (interest_rate / 100);
        deposit(totalInterest);
    }
}