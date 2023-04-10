import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Random rand = new Random();
        int guessNumber = rand.nextInt(100) + 1;
        int guessCount = 0;
        boolean isWin = false;
        System.out.println("Guess a number between 1 and 100");

        while (guessCount < 5) {
            int guess = input.nextInt();
            guessCount++;

            if (guess == guessNumber) {
                isWin = true;
                System.out.println("Congratulations! You win!");
                break;
            } else if (guess < guessNumber) {
                System.out.println("The number is higher than " + guess);
            } else {
                System.out.println("The number is lower than " + guess);
            }
        }

        if (!isWin) {
            System.out.println("Sorry, you lose! The number was " + guessNumber);
        }
    }
}
