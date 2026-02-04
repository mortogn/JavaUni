public class Bank {
    double balance;
    int accNumber;
    String accName;
    int transaction = 1;

    Bank(String accName, int accNumber) {
        this.accName = accName;
        this.accNumber = accNumber;
        this.balance = 0;
    }

    Bank(String accName, int accNumber, double balance) {
        this.accName = accName;
        this.accNumber = accNumber;
        this.balance = balance;
    }

    void depositBalance(double amount) {
        System.out.printf("\nTransaction %d: %s, %d, +%.2f\n", transaction, accName, accNumber, amount);
        balance += amount;
        transaction++;

        this.printAccountInfo();
    }

    void withdrawBalance(double amount) {
        System.out.printf("\nTransaction %d: %s, %d, -%.2f\n", transaction, accName, accNumber, amount);
        transaction++;

        if (amount > balance) {
            System.out.println("Insufficient balance on account: " + accNumber + " to make this withdraw");
            return;
        }

        balance -= amount;

        this.printAccountInfo();
    }

    void printAccountInfo() {
        System.out.println("Account Name: " + accName);
        System.out.println("Account Number: " + accNumber);
        System.out.println("Balance: " + balance);
    }

    public static void main(String args[]) {
        Bank b1 = new Bank("Lamim", 13, 450);
        Bank b2 = new Bank("Muntaha", 44, 950);

        b1.depositBalance(100);
        b2.withdrawBalance(100);

        b1.withdrawBalance(800);
        b2.withdrawBalance(300);

        b1.depositBalance(5000);
        b2.depositBalance(4000);

    }
}