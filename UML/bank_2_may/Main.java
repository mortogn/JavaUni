import java.util.Scanner;

public class Main {

    // 0 - MainMenu
    // 1 - Credit
    // 2 - Savings
    // 3 - Exit
    static int selectedAccount = 0;

    static void handleCreditOptions(Credit creditAcc, Scanner sc) {

        System.out.printf(
                "Choose an option to perform.\n1.Withdraw\n2.Deposit\n3.Add Interest (LOL)\n4.Get details\n5.Main Menu\n\n");
        int creditAction = sc.nextInt();

        switch (creditAction) {
            case 1:
                System.out.printf("Withdraw Amount: ");
                double withdrawAmount = sc.nextDouble();
                creditAcc.withdraw(withdrawAmount);
                break;
            case 2:
                System.out.printf("Deposit Amount: ");
                double depositAmount = sc.nextDouble();
                creditAcc.deposit(depositAmount);
                break;
            case 3:
                creditAcc.addInterest();
                break;

            case 4:
                creditAcc.get_details();
                break;

            default:
                break;
        }

        if (creditAction == 5)
            selectedAccount = 0;

    }

    static void handleSavingsOptions(Savings savingsAcc, Scanner sc) {

        System.out.printf(
                "Choose an option to perform.\n1.Withdraw\n2.Deposit\n3.Add Interest (NICE)\n4.Get details\n5.Main Menu\n\n");
        int savingsAction = sc.nextInt();

        switch (savingsAction) {
            case 1:
                System.out.printf("Withdraw Amount: ");
                double withdrawAmount = sc.nextDouble();
                savingsAcc.withdraw(withdrawAmount);
                break;
            case 2:
                System.out.printf("Deposit Amount: ");
                double depositAmount = sc.nextDouble();
                savingsAcc.deposit(depositAmount);
                break;
            case 3:
                savingsAcc.addInterest();
                break;

            case 4:
                savingsAcc.get_details();
                break;

            default:
                break;
        }

        if (savingsAction == 5)
            selectedAccount = 0;

    }

    public static void main(String[] args) {
        Savings savingsAcc = new Savings(50000, 4);
        Credit creditAcc = new Credit(0, 8, 500);

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your name");
        String name = sc.nextLine();

        while (true) {

            if (selectedAccount == 0) {
                System.out.println("Hello, " + name);
                System.out.printf("Choose Account\n1.Credit Account\n2.Savings Account\n3.Exit\n");
                selectedAccount = sc.nextInt();
            }

            if (selectedAccount != 1 && selectedAccount != 2 && selectedAccount != 0)
                break;

            System.out.println();
            System.out.println();
            System.out.println(
                    name + ", You are currently on " + (selectedAccount == 1 ? "credit" : "savings") + " account");

            if (selectedAccount == 1) {
                handleCreditOptions(creditAcc, sc);
            } else {
                handleSavingsOptions(savingsAcc, sc);
            }
        }
        sc.close();
    }

}
