package BlackJack;
import java.util.*;
public class Card {
    Integer value;
    String type;
    String suits;

    Card(Integer value, String type, String suits) {
        this.type = type;
        this.value = value;
        this.suits = suits;
    }

    public static void addCards(ArrayList<Card>cards,String suits) {
    	cards.add(new Card(11,"Ace",suits));
    	cards.add(new Card(10,"King",suits));
    	cards.add(new Card(10,"Queen",suits));
    	cards.add(new Card(10,"Jack",suits));
    	
    	for(int i=2;i<=10;i++) {
    		cards.add(new Card(i,"Numbers",suits));
    	}
    }
}
