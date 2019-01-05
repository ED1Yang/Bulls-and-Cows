public class Usercode {


    public static boolean haveSameCode(String text) {
        for (int i = 0; i < text.length() - 1; i++) {
            for (int j = i + 1; j < text.length(); j++) {
                if (text.charAt(i) == text.charAt(j)) {
                    return true;
                }
            }
        }
        return false;

    }
    //check whether there is same character inside a String.

    public String[] getUserCode(int codeLength, String characters) {
        String code = Keyboard.readInput();
        if (code.equals("")) {
            System.out.println("Please enter something");
            return null;
        } else if (code.length() != codeLength) {
            System.out.println("Please enter a " + codeLength + "-digit code");
            return null;
        }

        //check whether the input is empty or the length is wrong.

        if (characters.length() == 0) { //whether there is extra character
            for (int i = 0; i < code.length(); i++) {
                if (code.charAt(i) < '0' || code.charAt(i) > '9') {
                    System.out.println("Please enter valid number");
                    return null;
                }
                if (haveSameCode(code)) {
                    System.out.println("Cannot have repetitive code");
                    return null;
                }

            }

        } else {
            for (int i = 0; i < code.length(); i++) {
                if (code.charAt(i) < '0' || code.charAt(i) > '9') {
                    int count = 0;
                    for (int j = 0; j < characters.length(); j++) {
                        if (code.charAt(i) != characters.charAt(j)) {
                            count++;
                        } else {
                            break;
                        }
                    }
                    // check if the input characters are inside the range.
                    if (count == characters.length()) {
                        System.out.println("please enter valid code");
                        return null;
                    }
                }

                if (haveSameCode(code)) {
                    System.out.println("Cannot have repetitive code");
                    return null;
                }

            }
        }
        // Cover all the possible exceptions and warn the user in different ways.
        String[] intArray = new String[code.length()];
        for (int i = 0; i < code.length(); i++) {
            intArray[i] = String.valueOf(code.charAt(i) - '0');
        }
        return intArray;

        // If the input of the user is fine, we then transfer it into a int array.

    }
}
