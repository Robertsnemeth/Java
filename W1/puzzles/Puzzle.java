import java.util.ArrayList;

public class Puzzle {
    public static void main(String[] args) {

        Calculator calculate = new Calculator();
        // RANDOMLY GENERATE 10 NUMBERS INTO AN ARRAY//
        calculate.getTenRolls(20);
        // RANDOMLY GENERATE A LETTER OUT OF THE ALPHABET//
        ArrayList<Character> alphabet = new ArrayList<Character>();
        alphabet.add('a');
        alphabet.add('b');
        alphabet.add('c');
        alphabet.add('d');
        alphabet.add('e');
        alphabet.add('f');
        alphabet.add('g');
        alphabet.add('h');
        alphabet.add('i');
        alphabet.add('j');
        alphabet.add('k');
        alphabet.add('l');
        alphabet.add('m');
        alphabet.add('n');
        alphabet.add('o');
        alphabet.add('p');
        alphabet.add('q');
        alphabet.add('r');
        alphabet.add('s');
        alphabet.add('t');
        alphabet.add('u');
        alphabet.add('v');
        alphabet.add('w');
        alphabet.add('x');
        alphabet.add('y');
        alphabet.add('z');
        calculate.randChar(alphabet);
        // RANDOMLY GENERATES PASSWORD //
        calculate.generatePwd(alphabet);
        // RANDOMLY GENERATES PASSWORD SETS //
        calculate.getNewPwdSet(alphabet, 3);
        // SHUFFLES VALUES IN ARRAY //
        calculate.shuffleArray(alphabet);
    }
}
