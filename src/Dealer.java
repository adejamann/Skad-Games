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
   
      
   
}