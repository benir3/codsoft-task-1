import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int maxAttempts = 5;
        int totalScore = 0;
        boolean playAgain;

        System.out.println("Welcome to the Number Guessing Game!");

        do {
            // Generate a random number between 1 and 100
            int targetNumber = random.nextInt(100) + 1;
            int attemptsLeft = maxAttempts;
            boolean isCorrect = false;
            int scoreForRound = 0;

            System.out.println("\nA random number between 1 and 100 has been generated.");
            System.out.println("You have " + maxAttempts + " attempts to guess it.");

            // Loop for user's guesses
            while (attemptsLeft > 0) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();

                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You guessed the number correctly.");
                    scoreForRound = attemptsLeft * 10; // Score based on attempts left
                    totalScore += scoreForRound;
                    isCorrect = true;
                    break;
                } else if (userGuess > targetNumber) {
                    System.out.println("Your guess is too high.");
                } else {
                    System.out.println("Your guess is too low.");
                }

                attemptsLeft--;
                System.out.println("Attempts remaining: " + attemptsLeft);
            }

            if (!isCorrect) {
                System.out.println("You've run out of attempts! The correct number was: " + targetNumber);
            }

            // Display the score for the round
            System.out.println("Score for this round: " + scoreForRound);
            System.out.println("Total score: " + totalScore);

            // Ask if the user wants to play again
            System.out.print("Do you want to play another round? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");

        } while (playAgain);

        System.out.println("\nThanks for playing! Your final score is: " + totalScore);
        scanner.close();
    }
}
