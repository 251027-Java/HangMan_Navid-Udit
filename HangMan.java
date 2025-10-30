import java.util.*;

public class HangMan {
    static String word;
    static char[] charArray;
    static char[] underscoreArray;
    static int numberOfGuesses;
    static char guess;

    public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    word = getWord();
    
    // create a character array that houses each character of the word in 
    // each index of the array
    charArray = word.toCharArray();
    
    underscoreArray = underscoreArray(word);
    
    // initialize the number of guesses remaning to be equal to the length of the word
    numberOfGuesses = word.length();
    
    System.out.println();
    System.out.println("You have " + numberOfGuesses + " remaning guesses");
    System.out.println();

    while (numberOfGuesses > 0 && !isWordComplete()) {
        guess = getGuess();
        guessIsValid();
        System.out.println("Guesses remaining: " + numberOfGuesses);
    }
    
    if (isWordComplete()) {
        System.out.println("You won! The word was: " + word);
    } else {
        System.out.println("Game Over! The word was: " + word);
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
            underscoreArray[i] = '_';
            System.out.print("_ ");
        }
        System.out.println();

        return underscoreArray;
    }

    public static char getGuess() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Guess a letter of the word!");
        guess = scan.next().charAt(0);
        return guess;
    }

    public static void guessIsValid() {
        // need to check if the character is ANYWHERE in the word not at each index
        boolean found = false;

        for (int i = 0; i < charArray.length; i++) {
            if (guess == charArray[i]) {
                found = true;
                underscoreArray[i] = guess;
            }
        }

        if (found == true) {
            System.out.println("Nice! You guessed a correct letter!");
            displayUnderscores();
        } else {
            guessIsNotValid();
            numberOfGuesses--;
        }
    }

    public static void guessIsNotValid() {
        System.out.println("You guessed wrong :/ Try again...");
    }

    public static void displayUnderscores() {
        for (int i = 0; i < underscoreArray.length; i++) {
            System.out.print(underscoreArray[i] + " ");
        }
        System.out.println();
    }

    public static boolean isWordComplete() {
        for (int i = 0; i < underscoreArray.length; i++) {
            if (underscoreArray[i] == '_') {
                return false;
            }
        }
        return true;
    }
}
