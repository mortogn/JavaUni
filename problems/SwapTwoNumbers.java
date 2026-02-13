import java.util.Scanner;

public class SwapTwoNumbers {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        sc.close();

        System.out.printf("a = %d\nb = %d\n", a, b);

        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.printf("After Change:\na = %d\nb = %d\n", a, b);
    }
}
