import java.util.Scanner;

public class Fibonacci {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int prev = 0;
        int current = 1;

        for (int i = 0; i < n; i++) {
            System.out.print(prev + " ");
            int temp = prev;
            prev = current;
            current += temp;
        }
    }
}