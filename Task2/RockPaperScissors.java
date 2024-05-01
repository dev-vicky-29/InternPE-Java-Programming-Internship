import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Let's play Rock, Paper, Scissors!");

        while (true) {
            System.out.print("Enter your move (rock, paper, or scissors): ");
            String playerMove = scanner.nextLine().toLowerCase();

            if (!playerMove.equals("rock") && !playerMove.equals("paper") && !playerMove.equals("scissors")) {
                System.out.println("Invalid move. Please try again.");
                continue;
            }

            int computerInt = random.nextInt(3); // 0 for Rock, 1 for Paper, 2 for Scissors
            String computerMove;
            switch (computerInt) {
                case 0:
                    computerMove = "rock";
                    break;
                case 1:
                    computerMove = "paper";
                    break;
                case 2:
                    computerMove = "scissors";
                    break;
                default:
                    computerMove = "unknown";
                    break;
            }

            System.out.println("Computer chooses: " + computerMove);

            // Determine the winner
            if (playerMove.equals(computerMove)) {
                System.out.println("It's a tie!");
            } else if ((playerMove.equals("rock") && computerMove.equals("scissors")) ||
                    (playerMove.equals("paper") && computerMove.equals("rock")) ||
                    (playerMove.equals("scissors") && computerMove.equals("paper"))) {
                System.out.println("You win!");
            } else {
                System.out.println("Computer wins!");
            }

            // Ask if the player wants to play again
            System.out.print("Play again? (yes/no): ");
            String playAgain = scanner.nextLine().toLowerCase();
            if (!playAgain.equals("yes")) {
                break;
            }
        }

        System.out.println("Thanks for playing!");
        scanner.close();
    }
}
