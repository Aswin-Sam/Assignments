package BlackJack;

import java.util.ArrayList;

public class Club extends Card{
    Club(Integer value,String type,String suits){
        super(value,type,suits);
    }

    static void addCards(ArrayList<Card>cards){
        cards.add(new Club(11,"Ace","Club"));
        cards.add(new Club(10,"King","Club"));
        cards.add(new Club(10,"Queen","Club"));
        cards.add(new Club(10,"Jack","Club"));

        for(int i = 2; i <= 10; i++){
            cards.add(new Club(i,"Numbers","Club"));
        }
    }
}