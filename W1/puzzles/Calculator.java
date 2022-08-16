import java.util.ArrayList;
import java.util.Random;

public class Calculator {

    Random randMachine = new Random();
        // RANDOMLY GENERATE 10 NUMBERS INTO AN ARRAY//
    public ArrayList<Integer> getTenRolls(Integer range) {
        ArrayList<Integer> randArray = new ArrayList<Integer>();
        for(int i = 0; i <= 10; i++) {
            randArray.add(randMachine.nextInt(range));
        }
        System.out.println(randArray);
        return randArray;
    }
        // RANDOMLY GENERATE A LETTER OUT OF THE ALPHABET//
    public Character randChar(ArrayList<Character> letterArray) {
        char randLetter = letterArray.get(randMachine.nextInt(letterArray.size()));
        System.out.println(randLetter);
        return randLetter;
    }
        // RANDOMLY GENERATES PASSWORD //
    public String generatePwd(ArrayList<Character> alphabet) {
        String randPwd = "";
        for(int i = 0; i < 8; i++) {
            randPwd += alphabet.get(randMachine.nextInt(alphabet.size()));
        }
        System.out.println(randPwd);
        return randPwd;
    }
        // RANDOMLY GENERATES PASSWORD SETS //
    public ArrayList<String> getNewPwdSet(ArrayList<Character> alphabet, int numOfArrays) {
        ArrayList<String> pwdSet = new ArrayList<String>();
        for(int i = 0; i < numOfArrays; i++) {
            String randPwd = "";
            for(int j = 0; j < 8; j++) {
                randPwd += alphabet.get(randMachine.nextInt(alphabet.size()));
            }
            pwdSet.add(randPwd);
        }
        System.out.println(pwdSet);
        return pwdSet;
    }
        // SHUFFLES VALUES IN ARRAY //
    public ArrayList<Character> shuffleArray(ArrayList<Character> alphabet) {
        ArrayList<Character> shuffled = new ArrayList<Character>();
        for(int i = 0; i < alphabet.size(); i++) {
            shuffled.add(alphabet.get(randMachine.nextInt(alphabet.size())));
        }
        System.out.println(shuffled);
        return shuffled;
    }
}
