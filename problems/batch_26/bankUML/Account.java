public class Account {
    private int accountNumber;
    private double balance;

    public void deposit(double amount) {
        balance += amount
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else {
            balance -= amount;
        }
    }

    public double getBalance() {
        return balance;
    }
}