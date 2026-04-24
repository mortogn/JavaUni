
import java.util.Scanner;

public class MidProblem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        // Sieve
        boolean[] isPrime = new boolean[n + 1];

        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i < n; i++)
            isPrime[i] = true;

        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        if (n % 2 == 0 && isPrime[n / 2]) {
            System.out.println("Chocolate: " + n / 2);
            return;
        }

        int way = 0;
        // Main Code
        for (int i = 2; i < n; i++) {
            if (!isPrime[i])
                continue;

            int left = n - i;

            if (isPrime[left]) {
                way++;
            }
        }

        System.out.println("Way: " + way);

    }

}
