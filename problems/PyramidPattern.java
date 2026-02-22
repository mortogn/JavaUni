import java.util.Scanner;

public class PyramidPattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("n = ");
        int n = sc.nextInt();

        sc.close();

        for (int i = 1; i <= n; i++) {
            for (int s = n - i; s > 0; s--) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i * 2 - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
