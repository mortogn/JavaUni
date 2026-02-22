import java.util.Scanner;

public class TicTacToe {
    // 0 -> Empty space
    // 1 -> Player 1 (X)
    // 2 -> Player 2 (O)
    static int[][] score = {
            { 0, 0, 0 },
            { 0, 0, 0 },
            { 0, 0, 0 },
    };

    // Mark the position the current player chooses
    static void markPosition(int r, int c, int player) {
        score[r][c] = player;
    }

    // Check if the current player has already won
    static boolean checkPlayerWin(int player) {
        for (int i = 0; i < 3; i++) {
            if ((score[i][0] == player && score[i][1] == player && score[i][2] == player) ||
                    (score[0][i] == player && score[1][i] == player && score[2][i] == player)) {
                return true;
            }
        }

        if ((score[0][0] == player && score[1][1] == player && score[2][2] == player) ||
                (score[0][2] == player && score[1][1] == player && score[2][0] == player)) {
            return true;

        }

        return false;
    }

    // Check if there are any empty space left
    static boolean hasGameEnded() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (score[i][j] == 0) {
                    return false;
                }
            }
        }

        return true;
    }

    // Print the current state of the game
    static void showGameState() {
        System.out.print("\n    0   1   2 \n");
        System.out.print("---------------\n");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + " | ");
            for (int j = 0; j < 3; j++) {

                System.out.printf(
                        score[i][j] == 0 ? " " : score[i][j] == 1 ? "X" : "O");

                System.out.print(" | ");
            }

            System.out.print("\n---------------\n");
        }
    }

    public static void main(String[] args) {
        int currentPlayer = 1;
        System.out.print("Enter your positions as input. For example for player X -> row col\n");
        Scanner sc = new Scanner(System.in);

        while (true) {
            showGameState();
            System.out.println("Current player is " + (currentPlayer == 1 ? "X" : "O") + " :");
            int row = sc.nextInt();
            int col = sc.nextInt();

            if (score[row][col] != 0) {
                System.out.println("The position is already taken by a player!");
                continue;
            }

            markPosition(row, col, currentPlayer);
            showGameState();

            if (checkPlayerWin(currentPlayer)) {
                System.out.println("Player " + (currentPlayer == 1 ? "X" : "O") + " is VICTORIOUS!");
                break;
            }
            if (hasGameEnded()) {
                System.out.println("Game has ended and we have no Winner!");
                break;
            }

            currentPlayer = currentPlayer == 1 ? 2 : 1;
        }

        sc.close();

    }
}
