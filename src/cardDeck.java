
//Class for the card Deck
public class cardDeck {
   private Card[] cards = new Card[52];
   
   //Assigns the card to its suit and rank
   public final void cardInfo() {
      int cardIndex = 0;
      for (Card.cardSuit suit : Card.cardSuit.values()) {
         for (Card.cardRank rank : Card.cardRank.values()) {
            card[cardIndex++] = new Card(suit, rank);
            }
       }
   }
   
   public cardDeck () {
      cardInfo();
   }
   
   public Card[] getDeck() {
      return card;
   }

}