import java.util.*;

public class Songs {
    public static void main(String[] args) {
        HashMap<String,String> trackList = new HashMap<String,String>();
        trackList.put("The Downfall of us All", "My lifes turned upside down");
        trackList.put("If it Means a Lot to You", "Because I cant come back home until their singing");
        trackList.put("Life @ 11", "Im a slave, to all the voices in my head");
        trackList.put("This is the House that Doubt Built", "Forget everything just for a night, we'll sing like eveyrone when their alone");

        System.out.println(trackList.get("Life @ 11"));

        Set<String> songs = trackList.keySet();

        for(String title : songs) {
            System.out.println(title);
            System.out.println(trackList.get(title));
        }

    }
}
