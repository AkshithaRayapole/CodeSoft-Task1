import java.util.*;

public class Task1 {

    public static void main(String[] args) {
        new Task1().runGame();
    }

    void runGame() {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        
        System.out.println("Hey there! Let's play a guessing game.");
        System.out.println("I'll pick a number between 1-100, you try to guess it.");
        
        int games = 0;
        int wins = 0;
        int totalGuesses = 0;
        
        boolean keepPlaying = true;
        while(keepPlaying) {
            games++;
            int number = rand.nextInt(100)+1;
            int tries = 0;
            boolean gotIt = false;
            
            System.out.println("\nGame #" + games + " - You get 10 tries");
            
            while(tries < 10 && !gotIt) {
                System.out.print("Guess #" + (tries+1) + ": ");
                
                int guess;
                try {
                    guess = input.nextInt();
                } catch(InputMismatchException e) {
                    System.out.println("Numbers only please!");
                    input.next();
                    continue;
                }
                
                if(guess < 1 || guess > 100) {
                    System.out.println("Between 1-100 please");
                    continue;
                }
                
                tries++;
                
                if(guess == number) {
                    System.out.println("You got it in " + tries + " tries!");
                    wins++;
                    totalGuesses += tries;
                    gotIt = true;
                } else if(guess < number) {
                    System.out.println("Too low");
                } else {
                    System.out.println("Too high");
                }
            }
            
            if(!gotIt) {
                System.out.println("Sorry, the number was " + number);
            }
            
            System.out.print("\nPlay again? (y/n): ");
            String again = input.next().toLowerCase();
            if(!again.startsWith("y")) {
                keepPlaying = false;
            }
        }
        
        System.out.println("\nGame over! Results:");
        System.out.println("Games played: " + games);
        System.out.println("Games won: " + wins);
        if(wins > 0) {
            System.out.printf("Avg guesses per win: %.1f%n", (double)totalGuesses/wins);
        }
        
        input.close();
    }
}