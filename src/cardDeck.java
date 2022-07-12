
//Class for the card Deck
public class cardDeck {
   private Card[] card = new Card[52];
   
   //Assigns the card to its suit and rank
   public final void cardInfo() {
      int cardIndex = 0;
      for (cardSuit suit : cardSuit.values()) {
         for (cardRank rank : cardRank.values()) {
            card[cardIndex++] = new Card(suit, rank);
            }
       }
   }
}