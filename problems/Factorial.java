import java.math.BigInteger;
import java.util.Scanner;

public class Factorial {
    BigInteger result = new BigInteger("1");

    void factorial(int n) {
        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        Factorial fc = new Factorial();

        fc.factorial(n);

        System.out.println(n + "! = " + fc.result);
    }
}
