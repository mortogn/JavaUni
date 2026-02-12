import java.util.Scanner;

public class Palindrome {

    static boolean isPalindrome(int n) {
        int temp = n, reversed = 0;

        while (temp > 0) {
            int ld = temp % 10;
            reversed = reversed * 10 + ld;
            temp /= 10;
        }

        return n == reversed;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.close();

        if (isPalindrome(num)) {
            System.out.println(num + " is a palindrome number.");
        } else {
            System.out.println(num + " is not a palindrome number.");
        }
    }
}
