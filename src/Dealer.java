import java.util.ArrayList;
import java.util.*;


public class Dealer {
   // will have a hand and the deck
   private ArrayList<Card> hand = new ArrayList<>();
   private ArrayList<Card> deck = new ArrayList<>(); 
   

   public Dealer() {
   cardDeck d = new cardDeck();
      for (int i = 0; i < 52; i++ ) {
            deck.add(d.getDeck()[i]);
      }
     Collections.shuffle(deck);
   }
   /*
   * takes a card and adds it to the hand of the dealer
   */
   public void addHand(Card c) {
      hand.add(c);
   }
   
   /*
   * takes an arraylist of cards and adds it back to the deck 
   */
   public void addDeck(ArrayList<Card> a) {
      for (int i = 0; i < a.size(); i++) {
         Card c = a.remove(i);
         deck.add(c);
      }
   }
   
   // takes in the card to remove and returns the removed card
   // the card is no longer in the hand of the dealer
   public Card removeHand(Card a) {
       Card c = hand.remove(hand.indexOf(a));

      return c;
   }
   
   // removes from the deck
   // the card should no longer be in the deck anymore
   public Card removeDeck(Card c) {
      Card a = deck.remove(deck.indexOf(c)); 
      return a; 
   }
   
   public Card deal() {
      return deck.remove(deck.size() - 1);
   }
public int returnValue() {
   int handValue = 0;
   for (int i = 0; i < hand.size(); i++) {
   handValue+= hand.get(i).cardValue;
   }
   return handValue;
}

public void resetDeck() {
   deck.clear();
   cardDeck d = new cardDeck();
      for (int i = 0; i < 52; i++ ) {
            deck.add(d.getDeck()[i]);
      }
     Collections.shuffle(deck);
} 

public void reset() {
   hand.clear();
   resetDeck();
}  
}