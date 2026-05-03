public class Account {
    private double balance;
    private int rateOfInterest;

    Account(double balance, int rateOfInterest) {
        this.balance = balance;
        this.rateOfInterest = rateOfInterest;
    }

    public double get_balance() {
        return balance;
    }

    public void set_balance(double balance) {
        this.balance = balance;
    }

    public void addInterest() {
        double totalInterest = balance * (rateOfInterest / 100);

        balance += totalInterest;
    }

    public void get_details() {
        System.out.println("Balance: " + balance);
        System.out.println("RateOfInterest: " + rateOfInterest);
    }
}
