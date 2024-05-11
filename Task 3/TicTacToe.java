import java.util.Scanner;

public class TicTacToe {

    private static char[][] board = new char[3][3];
    private static char currentPlayer = 'X';

    public static void main(String[] args) {
        initializeBoard();
        displayBoard();

        boolean gameEnd = false;
        while (!gameEnd) {
            int[] move = getPlayerMove();
            int row = move[0];
            int col = move[1];

            if (board[row][col] == ' ') {
                board[row][col] = currentPlayer;

                if (isWinningMove(row, col)) {
                    System.out.println("Player " + currentPlayer + " wins!");
                    gameEnd = true;
                } else if (isBoardFull()) {
                    System.out.println("It's a draw!");
                    gameEnd = true;
                }

                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                displayBoard();
            } else {
                System.out.println("Cell already occupied. Try again.");
            }
        }
    }

    private static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    private static void displayBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    private static int[] getPlayerMove() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Player " + currentPlayer + ", enter your move (row[1-3] column[1-3]): ");
        int row = sc.nextInt() - 1;
        int col = sc.nextInt() - 1;
        return new int[]{row, col};
        
    }

    private static boolean isWinningMove(int row, int col) {
        // Check row
        if (board[row][0] == board[row][1] && board[row][1] == board[row][2])
            return true;
        // Check column
        if (board[0][col] == board[1][col] && board[1][col] == board[2][col])
            return true;
        // Check diagonals
        if (row == col) {
            if (board[0][0] == board[1][1] && board[1][1] == board[2][2])
                return true;
        }
        if (row + col == 2) {
            if (board[0][2] == board[1][1] && board[1][1] == board[2][0])
                return true;
        }
        return false;
    }

    private static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
    sc.close();
}
