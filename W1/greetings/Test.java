import java.util.*;

public class Test {
    public static void main(String[] args) {
        System.out.println("Hello world!");

            
            int age = 29;

            double weight = 180.2;

            String homeTown = "Polson, MT";

            String name = "Bobby Nemeth ";

            System.out.println(name);
            System.out.println(age);
            System.out.println(homeTown);
            System.out.println(weight);

            if(age>30) {
                System.out.println("I am 31!");
            }
            else {
                System.out.println("I am not 30");
            }
            
            switch(age) {
                case 29:
                        System.out.println("I am not old yet");
                        break;
                case 30:
                        System.out.println("I am old now");
                        break;
                case 31:
                        System.out.println("I am not older");
                        break;
                default:
                        System.out.println("This is not what i was looking for!");
            }

            System.out.println(age == 31 ? "Still 31" : "Not 31");

            
        String test = "how many characters is this string.";
        int testLength = test.length();
        System.out.println(testLength);

        String myTown = name.concat(homeTown);
        System.out.println(myTown);

        int[] newArray = {6, 24, 1991};
        newArray[0] = 9;
        newArray[1] = 26;
        newArray[2] = 1992;

        for(int i = 0; i < newArray.length; i++) {
            System.out.println(newArray[i]);
            }

        ArrayList<Object> things = new ArrayList<Object>();
        System.out.println(things);
        things.add(6);
        things.add("hello world");
        things.add(3.20);
        things.add(false);
        things.add(new ArrayList<Integer>());
        System.out.println(things);

        HashMap<String, String> yankees = new HashMap<String, String>();
        yankees.put("Second Base", "DJ LaMahiue");
        yankees.put("First Base", "Anthony Rizzo");
        yankees.put("Right Field", "Aaron Judge");
        System.out.println(yankees);
        Set<String> players = yankees.keySet();
        for(String position : players) {
            System.out.println(position);
            System.out.println(yankees.get(position));
        }

        

        }


    }
