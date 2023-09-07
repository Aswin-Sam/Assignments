package BlackJack;

import java.util.*;

public class Spade extends Card{
    Spade(Integer value,String type,String suits){
        super(value,type,suits);
    }

    static void addCards(ArrayList<Card>cards){
        cards.add(new Spade(11,"Ace","Spade"));
        cards.add(new Spade(10,"King","Spade"));
        cards.add(new Spade(10,"Queen","Spade"));
        cards.add(new Spade(10,"Jack","Spade"));

        for(int i = 2; i <= 10; i++){
            cards.add(new Spade(i,"Numbers","Spade"));
        }
    }
}
