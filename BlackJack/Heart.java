package BlackJack;

import java.util.ArrayList;

public class Heart extends Card{
    Heart(Integer value,String type,String suits){
        super(value,type,suits);
    }

    static void addCards(ArrayList<Card>cards){
        cards.add(new Heart(11,"Ace","Heart"));
        cards.add(new Heart(10,"King","Heart"));
        cards.add(new Heart(10,"Queen","Heart"));
        cards.add(new Heart(10,"Jack","Heart"));

        for(int i = 2; i <= 10; i++){
            cards.add(new Heart(i,"Numbers","Heart"));
        }
    }
}
