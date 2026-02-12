import java.util.Scanner;

public class Armstrong {

    static boolean isArmstrong(int n) {
        int count = 0, temp = n;

        while (temp > 0) {
            count++;
            temp /= 10;
        }

        long total = 0;
        temp = n;

        while (temp > 0) {
            int ld = temp % 10;
            total += Math.pow(ld, count);
            temp /= 10;
        }

        return total == n;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        sc.close();

        if (isArmstrong(num)) {
            System.out.println(num + " is a Armstrong number.");
        } else {
            System.out.println(num + " is not a Armstrong number.");
        }
    }
}
