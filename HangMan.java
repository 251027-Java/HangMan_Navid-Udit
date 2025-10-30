import java.util.*;

public class HangMan {
    static String word;
    static char[] charArray;
    static char[] underscoreArray;
    static int numberOfGuesses;
    static char guess;

    public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
    String word = getWord();
    
    // create a character array that houses each character of the word in 
    // each index of the array
    char[] charArray = word.toCharArray();
    
    char[] underscoreArray = underscoreArray(word);
    
    // initialize the number of guesses remaning to be equal to the length of the word
    int numberOfGuesses = word.length();
    
    System.out.println();
    System.out.println("You have " + numberOfGuesses + " remaning guesses");
    guess = getGuess();
    
    try {
        guessIsValid();
    } catch (Exception e) {
        guessIsNotValid();
    }

    
}

    public static String getWord() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a word");
        String word = scan.next();
        return word;
    }

    public static char[] underscoreArray(String word) {

        // create an underscore array that houses underscores in each index 
        // and is equal to the length of the word
        char[] underscoreArray = new char[word.length()];
        
        for (int i = 0; i < word.length(); i++) {
            System.out.print("_ ");
        }

        return underscoreArray;
    }

    public static char getGuess() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Guess a letter of the word!");
        guess = scan.next().charAt(0);
        return guess;
    }

    public static void guessIsValid() {
        for (int i = 0; i < charArray.length; i++) {
            if (guess == charArray[i]) {
                System.out.println("Nice! You guessed a correct letter!");
            } else if (guess != charArray[i]) {
                guessIsNotValid();
            }
        }
    }

    public static void guessIsNotValid() {
        System.out.println("You guessed wrong :/ Try again...");
    }
}
