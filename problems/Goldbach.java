import java.util.ArrayList;
import java.util.Scanner;

public class Goldbach {

    static boolean isGoldbach(int n) {

        // Goldback numbers must be greater than 2
        if (n < 2)
            return false;

        // Odd numbers can't be goldbach
        if (n % 2 != 0)
            return false;

        boolean[] isPrime = new boolean[n + 1];

        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        ArrayList<Integer> primes = new ArrayList<Integer>();

        // get the list of prime numbers
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        // check if a number is goldbach
        for (int p = 0; p < primes.size(); p++) {
            int left = n - primes.get(p);

            if (isPrime[left]) {
                return true;
            }
        }

        return false;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the even number you want to check: ");

        int n = sc.nextInt();

        sc.close();

        if (isGoldbach(n)) {
            System.out.println(n + " is Goldbach");
        } else {
            System.out.println(n + " is not Goldbach");
        }
    }
}
