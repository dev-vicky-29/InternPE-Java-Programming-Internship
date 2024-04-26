package java;
import java.util.Scanner;

public class NumberGuessing {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have chosen a number between 1 and 100.");
        System.out.println("You have to guess it. You have 10 attempts.");

        // Here is Generate a random number between 1 and 100 Operation
        int randomNumber = (int) (Math.random() * 100) + 1;
        int maxAttempts = 10;
        int attempts = 0;
        boolean hasGuessedCorrectly = false;

        while (attempts < maxAttempts) {
            System.out.println("Enter your guess (between 1 and 100):");
            int guess = scanner.nextInt();
            attempts++;

            if (guess < randomNumber) {
                System.out.println("Too low! Try guessing higher.");
            } else if (guess > randomNumber) {
                System.out.println("Too high! Try guessing lower.");
            } else {
                hasGuessedCorrectly = true;
                break; 
            }
        }

        // Check if the player guessed the correct number or Not
        if (hasGuessedCorrectly) {
            System.out.println("Congratulations! You guessed the number " + randomNumber + " correctly in " + attempts + " attempts.");
        } else {
            System.out.println("Game over! You have used all your attempts.");
            System.out.println("The correct number was: " + randomNumber);
        }

        scanner.close();
    }
}
