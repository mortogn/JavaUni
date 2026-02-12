import java.util.Scanner;

public class Prime {

    boolean isPrime(int n) {
        if (n < 2)
            return false;

        for (int i = 2; i * i < n; i++) {
            if (n % i == 2) {
                return false;
            }
        }

        return true;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Prime p = new Prime();

        sc.close();
        int num = sc.nextInt();

        if (p.isPrime(num)) {
            System.out.printf("%d is a prime number\n", num);
        } else {
            System.out.printf("%d is not a prime number\n", num);
        }
    }
}