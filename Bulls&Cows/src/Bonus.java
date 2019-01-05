public class Bonus {
    public static int setTurn() {
        while (true) {
            System.out.println("Please enter the maximum allowed number of turns.");
            String s = Keyboard.readInput();
            if (s.equals("")) {
                System.out.println("Please enter your choice!");
            } else {
                try {
                    int i = Integer.parseInt(s);
                    if (i <= 0) {
                        System.out.println("The value of turns must be greater than 1");
                        continue;
                    } else {
                        return i;
                    }

                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid number!");
                }

            }
        }
    }

    public static int setCodeLength(int characterLength) {
        while (true) {
            System.out.println("Please enter the length of the code.");
            String s = Keyboard.readInput();
            if (s.equals("")) {
                System.out.println("Please enter the length!");
            } else {
                try {
                    int i = Integer.parseInt(s);
                    if (i <= 0) {
                        System.out.println("The value of length must be greater than 1");
                        continue;
                    } else if (i > (10 + characterLength)) {
                        System.out.println("The value of length cannot be greater than " + (10 + characterLength));
                        continue;
                    } else {
                        return i;
                    }

                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid number!");
                }

            }
        }
    }

    public static boolean haveSameLetters(String text) {
        for (int i = 0; i < text.length() - 1; i++) {
            for (int j = i + 1; j < text.length(); j++) {
                if (text.charAt(i) == text.charAt(j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean haveNumbers(String text) {
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) - '0' >= 0 && text.charAt(i) - '0' < 9) {
                return true;
            }
        }
        return false;
    }


    public static String getCharacters() {
        while (true) {
            System.out.println("Please enter extra characters for the secret code");
            System.out.println("If you type nothing, default code range(0-9) will be applied.");
            String s = Keyboard.readInput();
            if (s.equals("")) {
                return "0";
            } else if (haveSameLetters(s)) {
                System.out.println("Please type different characters");
            } else if (haveNumbers(s)) {
                System.out.println("Don't type numbers here");
            } else {
                return s;
            }
        }

    }


    public static void main(String[] args) {
    }
}

