public class UserGuess extends Usercode {


    //UserGuess is very similar to Usercode, so I set a inheritance here, adding extra method for UserGuess, and check
    //the result right here, to keep the Main class more clear.


    public String[] UserGuess(String[] computerCode, int codeLength, String characters) {
        System.out.println("You guess:");
        String[] usercode = super.getUserCode(codeLength, characters);
        if (usercode == null) {
            return null;
        } else {
            ResultCheck.check(computerCode, usercode);
            return usercode;
        }

    }
    //In fact, it's enough to set a void method here. But in order to check whether the user's guess is completely correct before
    // the end of 7 tries, I make a int[] method here, returning the usercode ,which helps me to compare it to the answer code generated
    // by the computer in the Main Class.

}


