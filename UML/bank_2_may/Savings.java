public class Savings extends Account {
    private int rateOfInterest;

    Savings(double balance, int rateOfInterest) {
        super(balance, rateOfInterest);
        this.rateOfInterest = rateOfInterest;
    }

    public void withdraw(double amount) {
        double balance = get_balance();

        if (amount > balance) {
            System.out.println("Insufficient balance!");
            return;
        }

        set_balance(balance - amount);
        System.out.println("Withdrew " + amount + " from savings account!");

    }

    public void deposit(double amount) {
        set_balance(get_balance() + amount);
        System.out.println("Deposit of  " + amount + " to savings account is successful.");

    }

    public void addInterest() {
        double totalInterest = get_balance() * (rateOfInterest / 100.0);

        set_balance(get_balance() + totalInterest);

        System.out.println("Interest of " + totalInterest + " added to savings account!");

    }

    public void get_details() {
        System.out.println("Balance: " + get_balance());
        System.out.println("Rate of Interest: " + rateOfInterest);
    }
}
