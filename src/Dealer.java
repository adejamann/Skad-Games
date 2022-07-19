import java.util.ArrayList;

public class Dealer {
   // will have a hand and the deck
   private ArrayList<Card> hand = new ArrayList<>();
   private ArrayList<Card> deck = new ArrayList<>(); 
   
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
   public Card removeHand(Card c) {
      Card c = hand.remove(hand.indexOf(c));
      return c;
   }
   
   // removes from the deck
   // the card should no longer be in the deck anymore
   public Card removeDeck(Card c) {
      Card c = deck.remove(deck.indexOf(c)); 
      return c; 
   }
   
   
}