
//Class for the card Deck
public class cardDeck {
   private Card[] cards = new Card[52];
   
   //Assigns the card to its suit and rank
   public final void cardInfo() {
      int cardIndex = 0;
      for (Card.cardSuit suit : Card.cardSuit.values()) {
         for (Card.cardRank rank : Card.cardRank.values()) {
            cards[cardIndex++] = new Card(suit, rank);
            }
       }
   }
   /*public Card draw() {
      Card card = null;
      while(card == null) {
         int i = (int)(Math.random()*cards.length);
         card = cards[i];
         cards[i] = null;
       }
       return card;
   }*/
}