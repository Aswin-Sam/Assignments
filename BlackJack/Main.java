package BlackJack;
import java.util.Scanner;
public class Main{
    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	System.out.println("Enter the nummber of Decks");
    	Integer deckCount = s.nextInt();
        Game game = new Game(deckCount);
        game.start();
        s.close();
    }
}
