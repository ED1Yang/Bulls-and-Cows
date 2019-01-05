
public class HardLevel {

    public static int selector() {
        int choice = 0;

        System.out.println("Please select a hard level");
        System.out.println("1.Easy AI   2. Medium AI   3. Hard AI");
        String selection;
        while (true) {
            selection = Keyboard.readInput();
            if (selection.equals("")) {
                System.out.println("Please enter you selection");
            } else {
                selection = selection.toLowerCase();
                if (selection.equals("1") || selection.equals("easy") || selection.equals("easyai") || selection.equals("easy ai")) {
                    choice = 1;
                    break;
                } else if (selection.equals("2") || selection.equals("medium") || selection.equals("mediumai") || selection.equals("medium ai")) {
                    choice = 2;
                    break;
                } else if ((selection.equals("3") || selection.equals("hard") || selection.equals("hardai") || selection.equals("hard ai"))) {
                    choice = 3;
                    break;
                } else {
                    System.out.println("Please enter a valid selection");
                }
            }

        }
        return choice;
    }
    // As you can see in here, I tried different ways in order to cover all the possibilities.

    public static String[] methodSelect(int choice, String[] usercode, int i, int turnNum, int codeLength, String characters) {
        String[] method = null;
        switch (choice) {
            case 1:
                method = ComputerGuess.easyAI(usercode, codeLength, characters);
                break;
            case 2:
                method = ComputerGuess.mediumAI(usercode, i, turnNum, codeLength, characters);
                break;
            case 3:
                method = ComputerGuess.hardAI(usercode, i, codeLength, characters);
                break;

        }
        return method;
    }


}
