public class Credit extends Account {
    private int rateOfInterest;
    private double amount;

    Credit(double balance, int rateOfInterest, double amount) {
        super(balance, rateOfInterest);
        this.amount = amount;
        this.rateOfInterest = rateOfInterest;
    }

    public void withdraw(double amount) {

        if (amount > this.amount) {
            System.out.println("Insufficient balance!");
            return;
        }

        this.amount -= amount;

        System.out.println("Withdrew " + amount + " from credit account!");
    }

    public void deposit(double amount) {
        this.amount += amount;
        System.out.println("Deposit of  " + amount + " to credit account is successful.");

    }

    public void addInterest() {
        double totalInterest = amount * (rateOfInterest / 100.0);

        // Interest reducing the total credit amount
        amount -= totalInterest;

        System.out.println("Interest of " + totalInterest + " added to credit account!");

    }

    public void get_details() {

        System.out.println("Credit Amount: " + amount);
        System.out.println("Credit Rate of Interest: " + rateOfInterest);
    }
}
