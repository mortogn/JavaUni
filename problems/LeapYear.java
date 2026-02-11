import java.util.Scanner;

public class LeapYear {

    int fromYear;
    int toYear;
    int count = 0;

    boolean isLeapYear(int y) {
        if (y % 400 == 0)
            return true;
        if (y % 100 == 0)
            return false;
        if (y % 4 == 0)
            return true;

        return false;
    }

    void takeInput() {
        Scanner sc = new Scanner(System.in);
        System.out.println("From year: ");
        fromYear = sc.nextInt();
        System.out.println("To year: ");
        toYear = sc.nextInt();
        sc.close();
    }

    public static void main(String args[]) {
        LeapYear ly = new LeapYear();
        ly.takeInput();

        for (int year = ly.fromYear; year <= ly.toYear; year++) {
            if (ly.isLeapYear(year)) {
                ly.count++;
                System.out.printf("%d. %d\n", ly.count, year);
            }

        }

    }
}
