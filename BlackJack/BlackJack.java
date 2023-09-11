package BlackJack;

import java.util.*;

interface BlackJack {
	void shuffle();
	
	Card drawCard();
	
	Integer getCardValue(Card card,String person);
	
	Boolean isWin(String person);
	
	String getChoice();
}
