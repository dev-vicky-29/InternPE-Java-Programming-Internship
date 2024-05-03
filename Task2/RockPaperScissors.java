import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Let's play Rock, Paper, Scissors!");

        while (true) {
            System.out.print("Enter your move (rock, paper, or scissors): ");
            String playerMove = sc.nextLine().toLowerCase();

            if (!isValidMove(playerMove)) {
                System.out.println("Invalid move. Please try again.");
                continue;
            }

            String computerMove = generateComputerMove(random);
            System.out.println("Computer chooses: " + computerMove);

            String result = determineWinner(playerMove, computerMove);
            System.out.println(result);

            System.out.print("Play again? (yes/no): ");
            String playAgain = sc.nextLine().toLowerCase();
            if (!playAgain.equals("yes")) {
                break;
            }
        }

        System.out.println("Thanks for playing!");
        sc.close();
    }

    private static boolean isValidMove(String move) {
        return move.equals("rock") || move.equals("paper") || move.equals("scissors");
    }

    private static String generateComputerMove(Random random) {
        int computerInt = random.nextInt(3); // 0 for Rock, 1 for Paper, 2 for Scissors
        switch (computerInt) {
            case 0:
                return "rock";
            case 1:
                return "paper";
            case 2:
                return "scissors";
            default:
                return "unknown";
        }
    }

    private static String determineWinner(String playerMove, String computerMove) {
        if (playerMove.equals(computerMove)) {
            return "It's a tie!";
        } else if ((playerMove.equals("rock") && computerMove.equals("scissors")) ||
                   (playerMove.equals("paper") && computerMove.equals("rock")) ||
                   (playerMove.equals("scissors") && computerMove.equals("paper"))) {
            return "You win!";
        } else {
            return "Computer wins!";
        }
    }
    
}
