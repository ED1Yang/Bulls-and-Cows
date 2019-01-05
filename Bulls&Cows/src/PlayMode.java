import java.util.ArrayList;
import java.util.Arrays;

public class PlayMode {

    public static int playModeSelector() {
        int choice = 0;
        System.out.println("Do you wish to enter your guesses manually, or to automatically guess based on pre-supplied guesses in a file");
        System.out.println("1. Enter manually    2.By file");
        String selection = null;
        while (true) {
            selection = Keyboard.readInput();
            if (selection.equals("")) {
                System.out.println("Please enter you selection");
            } else {
                selection = selection.toLowerCase();
                if (selection.equals("1") || selection.equals("enter manually") || selection.equals("entermanually")) {
                    choice = 1;
                    break;
                } else if (selection.equals("2") || selection.equals("by file") || selection.equals("byfile")) {
                    choice = 2;
                    break;
                } else {
                    System.out.println("Please enter a valid selection");
                }
            }

        }
        return choice;
    }
    // get the selected game mode from user.

    public static void methodSelect(int mode, int hard, String[] usercode, ArrayList<String[]> guessList, int turnNum, int codeLength, String characters) {
        if (mode == 1) {
            methodByEnter(hard, usercode, turnNum, codeLength, characters);
        } else {
            methodByFile(hard, usercode, guessList, turnNum, codeLength, characters);
        }
    }
    // set the game by using the mode.


    public static void methodByEnter(int hard, String[] usercode, int turnNum, int codeLength, String characters) {
        UserGuess userG = new UserGuess();
        String[] computerCode = ComputerGuess.generateCode(codeLength, characters);
        Main.onlyRecord("Computer code: " + FileMethod.intArraytoString(computerCode));
        Main.onlyRecord("---");
        for (int i = 0; i < turnNum; i++) {
            Main.onlyRecord("Turn " + (i + 1) + ":");
            String[] userGuess = null;
            while (userGuess == null) {
                userGuess = userG.UserGuess(computerCode, codeLength, characters);
            }
            String[] computerGuess = HardLevel.methodSelect(hard, usercode, i, turnNum, codeLength, characters);
            if (Arrays.equals(userGuess, computerCode)) {
                Main.printNRecord("You win!  :)");
                break;
            } else if (Arrays.equals(computerGuess, usercode)) {
                Main.printNRecord("Computer win!");
                break;
            } else if (i == (turnNum - 1)) {
                Main.printNRecord("Draw,no one wins.");
            }

        }
    }
    // the original game mode. Play by enter the code manually.

    public static void methodByFile(int hard, String[] usercode, ArrayList<String[]> guessList, int turnNum, int codeLength, String characters) {
        UserGuess userG = new UserGuess();
        String[] computerCode = ComputerGuess.generateCode(codeLength, characters);
        Main.onlyRecord("Computer code: " + FileMethod.intArraytoString(computerCode));
        Main.onlyRecord("---");
        for (int i = 0; i < turnNum; i++) {
            Main.onlyRecord("Turn " + (i + 1) + ":");
            String[] userGuess = null;
            if (i < guessList.size()) {
                System.out.println("Your guess:");
                userGuess = guessList.get(i);
                System.out.println(FileMethod.intArraytoString(userGuess));
                System.out.println();
                ;
                ResultCheck.check(computerCode, userGuess);
            } else {
                while (userGuess == null) {
                    userGuess = userG.UserGuess(computerCode, codeLength, characters);
                }
            }
            String[] computerGuess = HardLevel.methodSelect(hard, usercode, i, turnNum, codeLength, characters);
            if (Arrays.equals(userGuess, computerCode)) {
                Main.printNRecord("You win! :)");
                break;
            } else if (Arrays.equals(computerGuess, usercode)) {
                Main.printNRecord("Computer win!");
                break;
            } else if (i == (turnNum - 1)) {
                Main.printNRecord("Draw,no one wins.");
            }

        }
    }

    // mode which reads the file first, and may use the original mode if the number of guesses is not enough.
    //Use "Array.equals()" to compare if the guess completely matches the answer. I use the array returned by UserGuess
    // and ComputerGuess class to help me achieve this goal.


}
