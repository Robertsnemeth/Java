import java.util.Date;
public class AlfredQuotes {
    
    public String basicGreeting() {
        // You do not need to code here, this is an example method
        return "Hello, lovely to see you. How are you?";
    }
    
    public String guestGreeting(String name) {
        String newName = String.format("Hello, %s. Lovely to see you.", name);
        return newName;
    }

    public String batsWomen(String name) {
        if(name.indexOf("Cat") > -1) {
            return "Yes, Ms. Kyle is very devious";
        }
        if(name.indexOf("Poison") > -1) {
            return "I might stay avay from Ivy sir.";
        }
        return "It is lonely being the caped crusader sir.";
        
    }
    
    public String dateAnnouncement() {
        Date todaysDate = new Date();
        return "Todays date is " + todaysDate;
    }
    
    public String respondBeforeAlexis(String conversation) {
        if(conversation.indexOf("Alexis") > -1) {
            return "Ya ya ya, I will in a second.";
        }
        if(conversation.indexOf("Alfred") > -1) {
            return "Right away sir.";
        }
        else {
            return "Right, and with that I shall retire.";
        }
    }
    
	// NINJA BONUS
	// See the specs to overload the guessGreeting method
    // SENSEI BONUS
    // Write your own AlfredQuote method using any of the String methods you have learned!
}

