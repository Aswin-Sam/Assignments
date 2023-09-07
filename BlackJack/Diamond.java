package BlackJack;

import java.util.ArrayList;

public class Diamond extends Card{
    Diamond(Integer value,String type,String suits){
        super(value,type,suits);
    }

    static void addCards(ArrayList<Card>cards){
        cards.add(new Diamond(11,"Ace","Diamond"));
        cards.add(new Diamond(10,"King","Diamond"));
        cards.add(new Diamond(10,"Queen","Diamond"));
        cards.add(new Diamond(10,"Jack","Diamond"));

        for(int i = 2; i <= 10; i++){
            cards.add(new Diamond(i,"Numbers","Diamond"));
        }
    }
}
