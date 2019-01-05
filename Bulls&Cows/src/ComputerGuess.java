import java.util.*;

public class ComputerGuess {


    public static String[] generateCode(int codeLength, String characters) {
        ArrayList<String> numbers = new ArrayList<>();
        for (int l = 0; l < 10; l++) {
            numbers.add(Integer.toString(l));
        }
        numbers.addAll(Arrays.asList(characters.split("")));

        Collections.shuffle(numbers);
//        System.out.println(numbers.get(0) + "" + numbers.get(1) + "" + numbers.get(2) + "" + numbers.get(3));
        String[] code = new String[codeLength];
        for (int j = 0; j < codeLength; j++) {
            code[j] = numbers.get(j);

        }
        return code;
    }


    // In order to generate 4 different digit, firstly I put numbers of 0-9 to a list.
    // Then I shuffle them, and take 4 out of them later. In this case, the numbers selected will never be the same.


    public static String[] easyAI(String[] usercode, int codeLength, String characters) {
        System.out.println();
        ;
        System.out.println("Computer guess:");
        String[] computerGuess = generateCode(codeLength, characters);
        System.out.println(FileMethod.intArraytoString(computerGuess));
        ResultCheck.check(usercode, computerGuess);
        Main.printNRecord("---");
        return computerGuess;
    }

    // The method for the easyAI is nearly the same of the random generation of the initial code.
    private static String[][] guessList;
    private static String[] computerGuess;

    public static void getTurnNum(int turnNum) {
        guessList = new String[turnNum][];
    }


    public static String[] mediumAI(String[] usercode, int i, int turnNum, int codeLength, String characters) {
        System.out.println();
        System.out.println("Computer guess");
        getTurnNum(turnNum);

        if (i == 0) {
            computerGuess = generateCode(codeLength, characters);
            System.out.println(FileMethod.intArraytoString(computerGuess));
            ResultCheck.check(usercode, computerGuess);
            guessList[i] = computerGuess;
        } else {
            while (true) {
                computerGuess = generateCode(codeLength, characters);
                if (!ResultCheck.intarraycontains(guessList, computerGuess)) {
                    System.out.println(FileMethod.intArraytoString(computerGuess));
                    ResultCheck.check(usercode, computerGuess);
                    guessList[i] = computerGuess;
                    break;
                }
            }
        }
        Main.printNRecord("---");
        return computerGuess;
    }


    //The method of mediumAI is interesting, I put in "i" as a parameter, in order to know which place to put the newest
    // number to the recorded list. A loop is used here, so when repetition happens, it will automatically loop itself again.


    private static ArrayList<String[]> possibleList = new ArrayList<>();
    private static int length;

    public static String[] hardAI(String[] usercode, int i, int codeLength, String characters) {
        System.out.println();
        System.out.println("Computer guess");

        String[] computerGuess;
        if (i == 0) {
            possibleList = generateAllPossibilities(codeLength, characters);
            length = possibleList.size();
            computerGuess = generateCode(codeLength, characters);
            System.out.println(FileMethod.intArraytoString(computerGuess));
            ResultCheck.check(usercode, computerGuess);
        } else {
            length = possibleList.size();
            int randomPick = (int) (Math.random() * length);
            computerGuess = possibleList.get(randomPick);
            System.out.println(FileMethod.intArraytoString(computerGuess));
            ResultCheck.check(usercode, computerGuess);

        }
        String hint = ResultCheck.checkAndReturn(usercode, computerGuess);
        System.out.println("initial" + length);
        // check the initial length of the list.
        for (int j = 0; j < length; j++) {
            if (!ResultCheck.checkAndReturn(computerGuess, possibleList.get(j)).equals(hint)) {
                possibleList.remove(j);
                length--;
                j--;
            }
        }
        System.out.println("updated" + length);
        // check the updated length of the list after elimination.
        Main.printNRecord("---");
        return computerGuess;
    }
    // The hardAI is challenging. Firstly I need to make a list of all the possibilities(by using the following method)
    // and then get the result compared with the answer. Later on I compare numbers from the list with the computer guess code,
    // only the matched numbers exist. Last but not least I redo this process until the computer find the answer. In this way, the computer
    // may easily win the game.


    //version bonus 3.0
    public static ArrayList<String[]> generateAllPossibilities(int codeLength, String characters) {
        List<String> outputs = new ArrayList<>();
        ArrayList<String[]> answer = new ArrayList<>();
        outputs.add("");

        Set<String> allCharacters = new HashSet<>(Arrays.asList(characters.split("")));
        for (int i = 0; i < 10; i++) {
            allCharacters.add("" + i);
        }
        for (int i = 0; i < codeLength; i++) {

            List<String> tempList = new ArrayList<>();

            for (String line : outputs) {
                Set<String> possibleNextCharacter = new HashSet<>(allCharacters);
                possibleNextCharacter.removeAll(Arrays.asList(line.split("")));

                for (String character : possibleNextCharacter) {
                    tempList.add(line + character);
                }
            }

            outputs.clear();
            outputs.addAll(tempList);
        }

        for (String i : outputs) {
            answer.add(i.split(""));
        }
        return answer;
    }

    //comments may be found in the reflection text document.


    //version 1.0
//    public static ArrayList<int[]> generateAllPossibilities() {
//        ArrayList<int[]> possibilities = new ArrayList<>();
//        int count = 0;
//        for (int a = 0; a < 10; a++) {
//            for (int b = 0; b < 10; b++) {
//                while (b == a) {
//                    b++;
//                }
//                if (b == 10) {
//                    break;
//                }
//                for (int c = 0; c < 10; c++) {
//                    while (c == a || c == b) {
//                        c++;
//                    }
//                    if (c == 10) {
//                        break;
//                    }
//                    for (int d = 0; d < 10; d++) {
//                        while (d == a || d == b || d == c) {
//                            d++;
//                        }
//                        if (d == 10) {
//                            break;
//                        }
//                        int[] newInt = new int[]{a, b, c, d};
//                        possibilities.add(count, newInt);
////                      System.out.println(a + "" + b + "" + c + "" + d+" "+count); check if all the possibilities are correctly gathered.
//                        count++;
//                    }
//                }
//            }
//        }
//        return possibilities;
//    }

    //The original method generateAllPosibilities simply tries to generate all the 4-digit no-repetitive numbers by using 4 loops, one inside another.


    //version 2.0
//    public static int generateTopNum(int codeLength) {
//        String s = "";
//        for (int i = 0; i < codeLength; i++) {
//            s += (9 - i);
//        }
//        return Integer.parseInt(s);
//    }
//
//    public static int generateBottomNum(int codeLength) {
//        String s = "";
//        if (codeLength == 1) {
//            return 0;
//        }
//        for (int i = 1; i <= codeLength - 1; i++) {
//            s += i;
//        }
//        return Integer.parseInt(s);
//    }
//
//
//    public static boolean numberValid(int num) {
//        String text = String.valueOf(num);
//        for (int i = 0; i < text.length() - 1; i++) {
//            for (int j = i + 1; j < text.length(); j++) {
//                if (text.charAt(i) == text.charAt(j)) {
//                    return false;
//                }
//            }
//        }
//        return true;
//
//    }
//
//
//    public static boolean notContainZero(int num) {
//        String s = String.valueOf(num);
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) - '0' == 0) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//
//    public static int generateBoundary(int codeLength) {
//        String s = "";
//        if (codeLength == 1) {
//            return 0;
//        }
//        for (int i = 0; i < codeLength - 1; i++) {
//            s += "1";
//        }
//        return Integer.parseInt(s) * 9;
//    }


//version 2.0
//    public static ArrayList<String[]> generateAllPossibilities(int codeLength) {
//        ArrayList<String[]> possibleList = new ArrayList<>();
//        int count = 0;
//        for (int i = generateBottomNum(codeLength); i <= generateBoundary(codeLength); i++) {
//            if (notContainZero(i) && numberValid(i)) {
//                possibleList.add(count, FileMethod.intToIntArrayFrom0(i));
////                System.out.println(FileMethod.intArraytoString(possibleList.get(count))+"    "+count);
//                count++;
//            }
//        }
//        for (int j = generateBoundary(codeLength) + 1; j <= generateTopNum(codeLength); j++) {
//            if (numberValid(j)) {
//                possibleList.add(count, FileMethod.intToIntArray(j));
////                System.out.println(FileMethod.intArraytoString(possibleList.get(count))+"    " +count);
//                count++;
//            }
//        }
//        return possibleList;
//    }

    // comments for this part may be find in the reflection document.


}
