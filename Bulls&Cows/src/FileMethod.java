import java.io.*;
import java.util.ArrayList;

public class FileMethod {

    public static ArrayList<String[]> guessReader() {

        ArrayList<String[]> guessList = new ArrayList<>();
        while (true) {
            String filename = null;
            while (filename == null) {
                System.out.println("Please enter the filename:");
                filename = Keyboard.readInput();
            }
            File guessFile = new File(filename);

            try (BufferedReader reader = new BufferedReader(new FileReader(guessFile))) {
                String line;
                String[] guess;
                for (int i = 0; (line = reader.readLine()) != null; i++) {
                    guess = new String[line.length()];
                    for (int j = 0; j < line.length(); j++) {
                        guess[j] = String.valueOf(line.charAt(j) - '0');

                    }
                    guessList.add(i, guess);

                }
                break;
            } catch (IOException e) {
                System.out.println("File not found, please enter the filename again.");
            }
        }
        return guessList;

    }
    //return a useful arraylist generated from the specific file.

    public static void output(ArrayList<String> record, String saveName) {
        File saveFile = new File(saveName);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(saveFile))) {
            for (String str : record) {
                writer.write(str);
                writer.newLine();
                writer.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();

        }
    }
    // method to generated a file including all the saved information.


    public static boolean saveOrNot() {
        System.out.println("Do you wish to save the results to a text file?");
        System.out.println("1. YES   2. NO");
        String selection;
        boolean save;
        while (true) {
            selection = Keyboard.readInput();
            if (selection.equals("")) {
                System.out.println("Please enter you selection");
            } else {
                selection = selection.toLowerCase();
                if (selection.equals("1") || selection.equals("yes")) {
                    save = true;
                    break;
                } else if (selection.equals("2") || selection.equals("no")) {
                    save = false;
                    break;
                } else {
                    System.out.println("Please enter a valid selection");
                }
            }

        }
        return save;
    }
    // ask the user whether they'd like to save the result to a file.

    public static String getSaveName() {

        String savename;
        while (true) {
            System.out.println("Please enter you Save File Name");
            savename = Keyboard.readInput();
            if (savename.equals("")) {
                System.out.println("File name cannot be empty");
            } else {
                break;
            }
        }
        return savename;
    }

    //get the saving file name from the user.

    public static String intArraytoString(String[] intArray) {
        String str = "";
        for (String num : intArray) {
            str += num;
        }
        return str;
    }


//    public static String[] intToIntArray(int i) {
//
//        String s = String.valueOf(i);
//        int length = s.length();
//        String[] intArray = new String[length];
//        for (int j = 0; j < length; j++) {
//            intArray[j] = String.valueOf(s.charAt(j) - '0');
//        }
//        return intArray;
//    }
//
//    public static String[] intToIntArrayFrom0(int i) {
//
//        String s = String.valueOf(i);
//        int length = s.length();
//        String[] intArray = new String[length + 1];
//        intArray[0] = "0";
//        for (int j = 1; j <= length; j++) {
//            intArray[j] = String.valueOf(s.charAt(j - 1) - '0');
//        }
//        return intArray;
//    }


    //turn all the int[] to a readable and printable String.

}
