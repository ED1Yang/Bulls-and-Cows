import java.util.ArrayList;

public class Main {

    static ArrayList<String> record = new ArrayList<>();
    static int count = 0;

    public static void printNRecord(String s) {
        System.out.println(s);
        record.add(count, s);
        count++;
    }
    // when this method is used, the content is not only printed out, but also added to a arraylist, which will be saved into
    // another file if necessary.


    public static void onlyRecord(String something) {
        record.add(count, something);
        count++;
    }
    // this method served only for those things should be saved into the final files.


    public static void main(String[] args) {
        Main guessGame = new Main();
        guessGame.start();

    }

    public void start() {
        String characters = Bonus.getCharacters(); // bonus no.3
        int characterLength = characters.length();
        int turnNum = Bonus.setTurn(); //bonus no.1
        int codeLength = Bonus.setCodeLength(characterLength); // bonus no.2
        onlyRecord("Bulls & Cows game result."); //save the heading.
        int mode = PlayMode.playModeSelector(); // ask the user to select a play mode and save it.
        ArrayList<String[]> guessList = new ArrayList<>();
        if (mode == 2) {
            guessList = FileMethod.guessReader();
        } // if the user select the 2nd mode(read from file mode), a guesslist will generate from the file.
        int hard = HardLevel.selector(); // ask the user to select a hard level and save it.
        System.out.println("Please enter your secret code:");
        Usercode userC = new Usercode();
        String[] usercode = null;
        while (usercode == null) {
            usercode = userC.getUserCode(codeLength, characters);
        } // get user's secret code.
        onlyRecord("Your code: " + FileMethod.intArraytoString(usercode)); // save the usercode for the file.
        System.out.println("---");
        PlayMode.methodSelect(mode, hard, usercode, guessList, turnNum, codeLength, characters); //use the saved mode generated ahead  to decide the gameplay.
        if (FileMethod.saveOrNot()) {
            String savename = FileMethod.getSaveName();
            FileMethod.output(record, savename);
        }
        // if the user choose to save the file, all the information saved before will be transferred to that file.

    }


}


