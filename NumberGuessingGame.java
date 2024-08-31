import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int score = 0;

        while (playAgain) {
            int randomNumber = random.nextInt(100) + 1;  // Generate a random number between 1 and 100
            int attempts = 0;
            boolean guessedCorrectly = false;
            int maxAttempts = 10;  // Limit the number of attempts

            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("I have selected a number between 1 and 100.");
            System.out.println("Can you guess what it is? You have " + maxAttempts + " attempts.");

            while (attempts < maxAttempts && !guessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == randomNumber) {
                    guessedCorrectly = true;
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                    score += (maxAttempts - attempts + 1);  // Score based on remaining attempts
                } else if (userGuess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry! You've used all your attempts. The correct number was " + randomNumber + ".");
            }

            System.out.println("Your current score is: " + score);
            System.out.print("Do you want to play again? (yes/no): ");
            String response = scanner.next();

            if (!response.equalsIgnoreCase("yes")) {
                playAgain = false;
            }
        }

        System.out.println("Thanks for playing! Your final score is: " + score);
        scanner.close();
    }
}
