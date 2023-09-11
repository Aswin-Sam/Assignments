package BlackJack;

import java.util.ArrayList;

public class Deck {
    ArrayList<Card>cards = new ArrayList<>();
    Deck(){
    	Card.addCards(cards, "Club");
    	Card.addCards(cards, "Diamond");
    	Card.addCards(cards, "Spade");
    	Card.addCards(cards, "Heart");
    }
}