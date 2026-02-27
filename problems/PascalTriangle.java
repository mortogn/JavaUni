/*
     1
    1 1
   1 2 1
  1 3 3 1
 1 4 6 4 1
*/

import java.util.Scanner;

public class PascalTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("n = ");
        int row = sc.nextInt();
        sc.close();

        int[][] arr = new int[row][row];

        for (int i = 0; i < row; i++) {
            arr[i][0] = 1;
            arr[i][i] = 1;

            for (int j = 1; j < i; j++) {
                arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
            }
        }

        for (int i = 0; i < row; i++) {
            for (int s = row - i; s > 0; s--) {
                System.out.print(" ");
            }

            for (int j = 0; j <= i; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
