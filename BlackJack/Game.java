package BlackJack;

import java.util.*;

public class Game implements BlackJack {
    static Scanner s = new Scanner(System.in);
    ArrayList<Card> cards = new ArrayList<>();
    Integer winningValue, playerTotal = 0, dealerTotal = 0;

    Game(Integer deckCount) {
        for (int i = 0; i < deckCount; i++) {
            cards.addAll(new Deck().cards);
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card drawCard() {
        return cards.remove(cards.size() - 1);
    }

    public Integer getCardValue(Card card, String person) {
        if (person.equals("Player")) {
            if (card.type.equals("Ace")) {
                if (card.value + playerTotal > 21)
                    return 1;
            }
            return card.value;
        } else {
            if (card.type.equals("Ace")) {
                if (card.value + dealerTotal > 21)
                    return 1;
            }
            return card.value;
        }
    }

    public Boolean isWin(String person) {
        if (person.equals("Player")) {
            if (playerTotal == winningValue)
                return true;
            return false;
        } else {
            if (dealerTotal == winningValue)
                return true;
            return false;
        }
    }

    public String getChoice() {
        return s.nextLine();
    }

    public void start() {
        Boolean playerWon = false, dealerWon = false;
        System.out.println("Enter the winning value");
        winningValue = s.nextInt();
        s.nextLine();
        shuffle();
        Integer valueOfCard1 = getCardValue(drawCard(), "Player");
        Integer valueOfCard2 = getCardValue(drawCard(), "Player");

        playerTotal += valueOfCard1 + valueOfCard2;

        System.out.println("You get a " + valueOfCard1 + " and a " + valueOfCard2);
        System.out.println("Your total is " + playerTotal);
        System.out.println();

        if (isWin("Player")) {
            System.out.println("YOU WON!!!");
            playerWon = true;
        } else {
            valueOfCard1 = getCardValue(drawCard(), "Dealer");
            Integer hiddenCard = getCardValue(drawCard(), "Dealer");
            dealerTotal += valueOfCard1 + hiddenCard;
            System.out.println("The Dealer has a " + valueOfCard1 + " showing and a hidden card.");
            System.out.println("His total is hidden, too.");
            String choice = "";

            while (!choice.equals("stay")) {
                System.out.println("Would you like to \"hit\" or \"stay\"?");
                choice = getChoice();

                if (choice.equals("hit")) {
                    valueOfCard1 = getCardValue(drawCard(), "Player");
                    playerTotal += valueOfCard1;

                    System.out.println("You drew a " + valueOfCard1);
                    System.out.println("Your total is " + playerTotal);
                } else if (!choice.equals("hit") && !choice.equals("stay")) {
                    System.out.println("Enter a proper choice");
                    continue;
                }
                if (isWin("Player")) {
                    System.out.println();
                    System.out.println("YOU WON!!!");
                    playerWon = true;
                    break;
                }

                if (playerTotal > winningValue) {
                    System.out.println("You busted");
                    System.out.println();
                    System.out.println("DEALER WON!!!");
                    dealerWon = true;
                    break;
                }
            }
            if (!playerWon && !dealerWon) {
                System.out.println("Okay, dealer's turn.");
                System.out.println("His hidden card was a " + hiddenCard);
                System.out.println("His total was " + dealerTotal);
                System.out.println();

                while (dealerTotal < playerTotal && dealerTotal < winningValue) {
                    System.out.println("Dealer chooses to hit");
                    valueOfCard1 = getCardValue(drawCard(), "Dealer");
                    dealerTotal += valueOfCard1;

                    System.out.println("He draws a " + valueOfCard1);
                    System.out.println("His total is " + dealerTotal);
                    System.out.println();
                }

                if (isWin("Dealer")) {
                    System.out.println("DEALER WON!!!");
                    dealerWon = true;
                } else if (dealerTotal > winningValue) {
                    System.out.println("Dealer is busted");
                    System.out.println("YOU WON!!!");
                    playerWon = true;
                } else {
                    System.out.println("Dealer stays.");
                    System.out.println();
                    System.out.println("Dealer total is " + dealerTotal);
                    System.out.println("Your total is " + playerTotal);

                    if (dealerTotal > playerTotal) {
                        System.out.println("DEALER WON!!!");
                    } else if (dealerTotal == playerTotal) {
                        System.out.println("It's a TIE!!!");
                    } else {
                        System.out.println("YOU WON!!!");
                    }
                }
            }
        }
        s.close();
    }
}