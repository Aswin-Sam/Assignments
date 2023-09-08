package BlackJack;

import java.util.*;

public class Game implements Deck {
    Game() {
        this.addCards();
    }

    public void addCards() {
        Spade.addCards(cards);
        Heart.addCards(cards);
        Diamond.addCards(cards);
        Club.addCards(cards);
    }

    public void run() {
        Scanner s = new Scanner(System.in);
        System.out.println("Wellcome to the BlackJack Game!!!");
        Collections.shuffle(cards);

        Integer playerTotal = 0, dealerTotal = 0;
        Boolean playerWon = false, dealerWon = false;

        Integer valueOfCard1 = cards.remove(cards.size() - 1).value, valueOfCard2 = cards.get(cards.size() - 2).value;
        playerTotal += valueOfCard1 + valueOfCard2;

        if ((cards.get(cards.size() - 2).type).equals("Ace")) {
            if (playerTotal > 21) {
                valueOfCard2 = 1;
                playerTotal -= 10;
            }
        }
        cards.remove(cards.size() - 2);
        System.out.println("You get a " + valueOfCard1 + " and a " + valueOfCard2);
        System.out.println("Your total is " + playerTotal);
        System.out.println();
        if (playerTotal == 21) {
            System.out.println("YOU WON!!!");
            playerWon = true;
        } else {
            valueOfCard1 = cards.remove(cards.size() - 1).value;
            Integer hiddenCard = cards.get(cards.size() - 2).value;
            dealerTotal += valueOfCard1 + hiddenCard;
            if (cards.get(cards.size() - 2).type.equals("Ace")) {
                if (dealerTotal > 21) {
                    hiddenCard = 1;
                    playerTotal -= 10;
                }
            }
            cards.remove(cards.size() - 2);
            System.out.println("The Dealer has a " + valueOfCard1 + " showing and a hidden card.");
            System.out.println("His total is hidden, too.");
            String choice = "";

            while (!choice.equals("stay")) {
                System.out.println("Would you like to \"hit\" or \"stay\"?");
                choice = s.nextLine();

                if (choice.equals("hit")) {
                    valueOfCard1 = cards.get(cards.size() - 1).value;
                    playerTotal += valueOfCard1;
                    if (cards.get(cards.size() - 2).type.equals("Ace")) {
                        if (playerTotal > 21) {
                            valueOfCard1 = 1;
                            playerTotal -= 10;
                        }
                    }
                    cards.remove(cards.size() - 2);
                    System.out.println("You drew a " + valueOfCard1);
                    System.out.println("Your total is " + playerTotal);
                }
                else if(!choice.equals("hit") && !choice.equals("stay")){
                    System.out.println("Enter a proper choice");
                    continue;
                }
                if (playerTotal == 21) {
                    System.out.println();
                    System.out.println("YOU WON!!!");
                    playerWon = true;
                    break;
                }

                if (playerTotal > 21) {
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

                while (dealerTotal < playerTotal && dealerTotal < 21) {
                    System.out.println("Dealer chooses to hit");
                    valueOfCard1 = cards.get(cards.size() - 1).value;
                    dealerTotal += valueOfCard1;
                    if (cards.get(cards.size() - 2).type.equals("Ace")) {
                        if (dealerTotal > 21) {
                            valueOfCard1 = 1;
                            dealerTotal -= 10;
                        }
                    }
                    cards.remove(cards.size() - 2);
                    System.out.println("He draws a " + valueOfCard1);
                    System.out.println("His total is " + dealerTotal);
                    System.out.println();
                }

                if (dealerTotal == 21) {
                    System.out.println("DEALER WON!!!");
                    dealerWon = true;
                } else if (dealerTotal > 21) {
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
