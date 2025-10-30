import java.util.Scanner;

public class HangMan{
    public static void main(String[] args){

        System.out.print("Please Enter a word to start the game");

        //geting the word from the user
        Scanner Readin = new Scanner(System.in);
        String word = Readin.nextLine();

        //Using the word to create the output of the blank spaces
        char[] wordArray = new char[word.length()];
        for (int i =0; i<wordArray.length; i++)
        {
            wordArray[i]='_';
        }

        //an array to check if the guess is in the english alphabet
        boolean[] entered = new boolean[26];

        //Guess Tracker

        int NumberOfWrongGuesses =0;
        int totalGueses = 6;

        //Art for each stage

        String[] HangManArt = new String[] {
                // index 0  →  0 wrong guesses
                " +---+\n" +
                        " |   |\n" +
                        "     |\n" +
                        "     |\n" +
                        "     |\n" +
                        "     |\n" +
                        "=====\n",

                // index 1  →  1 wrong guese
                " +---+\n" +
                        " |   |\n" +
                        " O   |\n" +
                        "     |\n" +
                        "     |\n" +
                        "     |\n" +
                        "=====\n",

                // index 2  →  2 wrong guesses
                " +---+\n" +
                        " |   |\n" +
                        " O   |\n" +
                        " |   |\n" +
                        "     |\n" +
                        "     |\n" +
                        "=====\n",

                // index 3  →  3 wrong guesses
                " +---+\n" +
                        " |   |\n" +
                        " O   |\n" +
                        "/|   |\n" +
                        "     |\n" +
                        "     |\n" +
                        "=====\n",

                // index 4  →  4 wrong guesses
                " +---+\n" +
                        " |   |\n" +
                        " O   |\n" +
                        "/|\\  |\n" +
                        "     |\n" +
                        "     |\n" +
                        "=====\n",

                // index 5  →  5 wrong guesses
                " +---+\n" +
                        " |   |\n" +
                        " O   |\n" +
                        "/|\\  |\n" +
                        "/    |\n" +
                        "     |\n" +
                        "=====\n",

                // index 6  →  6 wrong guesses
                " +---+\n" +
                        " |   |\n" +
                        " O   |\n" +
                        "/|\\  |\n" +
                        "/ \\  |\n" +
                        "     |\n" +
                        "=====\n"
        };

        System.out.print(HangManArt[NumberOfWrongGuesses]);

        //The Logic for when the user is entering their gusses

        while(NumberOfWrongGuesses < totalGueses ){
            System.out.print("Word: ");
            for (int i = 0; i < wordArray.length; i++) {
                System.out.print(wordArray[i] + " ");
            }
            System.out.println();



        //This is the logic for posting the current letters already used

        System.out.print("Used: ");
        for (int i = 0; i < 26; i++) {
            if (entered[i]) {
                System.out.print((char) ('a' + i) + " "); // This is a type cas back to a char because when you + an int
                                                           // and char java promotes it to an in and the char makes a char
            }
        }
        System.out.println();

        //Make sure the usser actually enters a value
        System.out.print("Enter a letter: ");
        String token = Readin.next();

        if (token.length() == 0) {
            System.out.println("Please type a letter.");
            System.out.print(HangManArt[NumberOfWrongGuesses]);
            continue;
        }

        //making sure that user inputs only 1 letter
        if (token.length() != 1) {
            System.out.println("Please enter only ONE letter between a and z. Try again");
            System.out.print(HangManArt[NumberOfWrongGuesses]);
            continue;
        }

        //saving the guessed letter as a char
        char guess =Character.toLowerCase(token.charAt(0));

        // checking if the user enterted a valid letter between a-z
        if (guess < 'a' || guess > 'z') {
            System.out.println("The input you gave is not a letter between a to z. Try again");
            System.out.print(HangManArt[NumberOfWrongGuesses]);
            continue;
        }

        //This is used to check if the user inputted the same letter twice
        int index = guess - 'a';
        if (entered[index]) {
            System.out.println("You have already tried '" + guess + "'. Try again.");
            System.out.print(HangManArt[NumberOfWrongGuesses]);
            continue;
        }
        entered[index] = true;

        //Now for checking if the entered guess is in the word
        boolean guessStatus = false;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == guess) {
                wordArray[i] = guess;
                guessStatus = true;
            }
        }

        if (guessStatus) {
            System.out.println("Nice! '" + guess + "' is in the word. You have" + totalGueses );
            System.out.println("Number of guess left: " + totalGueses);
        } else {
            NumberOfWrongGuesses++;
            System.out.println("Nope! '" + guess + "' is not there.");
            System.out.println("Number of guess left: " + (totalGueses-NumberOfWrongGuesses));
        }

        //Displaying the current figure
        System.out.print(HangManArt[NumberOfWrongGuesses]);

        boolean allDone = true;
        for (int i = 0; i < wordArray.length; i++) {
            if (wordArray[i] == '_') {
                allDone = false;
                break;
            }
        }

        if (allDone) {
            System.out.print("Word: ");
            for (int i = 0; i < wordArray.length; i++) {
                System.out.print(wordArray[i] + " ");
            }
            System.out.println("You win! The word was " + word + ".");
            Readin.close();
            return;
        }
    }

    // if out of guesses
        System.out.println("You lost! The word was " + word + ".");
        Readin.close();



    }
}




