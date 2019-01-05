
import java.util.Arrays;

public class ResultCheck {

    public static boolean contains(String[] array, String v) {

        boolean result = false;

        for (String i : array) {
            if (i.equals(v)) {
                result = true;
                break;
            }
        }
        return result;
    }

    //check whether an integer is contained inside an array.

    public static boolean intarraycontains(String[][] array, String[] v) {

        boolean result = false;

        for (String[] i : array) {
            if (Arrays.equals(i, v)) {
                result = true;
                break;
            }
        }
        return result;
    }

    // very similar to the forward one. Method for the mediumAI.


    private static int count = 0;
    public static void check(String[] code, String[] guess) {
        count++;
        int bull = 0;
        int cows = 0;

        for (int i = 0; i < guess.length; i++) {
            if (code[i].equals(guess[i])) {
                bull++;
            } else if (contains(code, guess[i])) {
                cows++;
            }


        }

        System.out.println("Result: " + bull + " bull and " + cows + " cows");
        if (count % 2 == 1) {
            Main.onlyRecord("You guessed " + FileMethod.intArraytoString(guess) + ", scoring " + bull + " bulls and " + cows + " cows");
        } else {
            Main.onlyRecord("Computer guessed " + FileMethod.intArraytoString(guess) + ", scoring " + bull + " bulls and " + cows + " cows");
        }
//

    }

    //check the similarity of the code(answer) and the guess(by user or computer), and the print out the result.
    // here I set a count. If the count is odd number, means the user is checking the answer, while the computer checks the answer when
    // the count is a even number. This helps me to write the result into the final file.

    public static String checkAndReturn(String[] code, String[] guess) {
        int bull = 0;
        int cows = 0;

        for (int i = 0; i < guess.length; i++) {
            if (code[i].equals(guess[i])) {
                bull++;
            } else if (contains(code, guess[i])) {
                cows++;
            }


        }
        return String.valueOf(bull) + String.valueOf(cows);

    }

    //check and return the similarity of the code. Method used for hardAI.


}
