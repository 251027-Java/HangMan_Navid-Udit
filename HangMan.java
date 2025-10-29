import java.util.*;

public class HangMan {
    public static void main(String[] args) {
        // Create a word
        // accept user input
        // if user input is within chosen word print match
        // if not, then draw make an askii art of a man
        // repeat loop

        Scanner scan = new Scanner(System.in);

        // Get word from user
        System.out.println("Enter a word");
        String word = scan.next(); 
        
        // Create a character array named charArray and 
        // convert the word String into a character array
        char[] charArray = word.toCharArray();
            for (char c : charArray) {
                System.out.println(c);
            }

        // Display " _ " for each character of the word    
        for (int i = 0; i < word.length(); i++) {
            System.out.print("_ ");
        }
        System.out.println();

        // Accept a guessed letter
        int numberOfGuessesRemaining = word.length();
        char guess;
        System.out.println("Guess a letter!");
        guess = scan.next().charAt(0);

        for (int j = 0; j < charArray.length; j++) {
            try {
                if (guess == (charArray[j])) {
                    System.out.println("HOORAY! YOU GUESSED A LETTER!");  
                    --numberOfGuessesRemaining;
                } 
            } catch (Exception e) {
                System.out.println("The letter you guessed is not within the word :(");
            }
        }

        // Reduce possible guesses
        
        // Guessed a letter in word?

        // No

        // Yes

        // Reduce removing guesses
    }
}
