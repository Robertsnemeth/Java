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
        }
    }