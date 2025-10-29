import java.util.*;

public class HangMan {
    public static void main(String[] args) {
        // Create a word
        // accept user input
        // if user input is within chosen word print match
        // if not, then draw make an askii art of a man
        // repeat loop

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter a word");
        String word = scan.next(); // get word Goofy
        
        char[] charArray = word.toCharArray();
            for (char c : charArray) {
                System.out.println(c);
            }


        for (int i = 0; i < word.length(); i++) {
            System.out.print("_ ");
        }
        System.out.println();

/* 
        String guess;
        try {
            guess = scan.next();
            if (guess.equals(word)) {
                System.out.println("Hooray!!! You win :)");
            } else if (guess.is)
        } catch { 

        }
        */
    }
}
