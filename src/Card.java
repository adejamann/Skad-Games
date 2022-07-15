import javafx.scene.Parent;
import javafx.scene.StackPane;
import javafx.scene.Color;
import javafx.scene.Rectangle;
import java.scene.text.Text;

//Creates a card class that will display the rank and suit of the card
public class Card extends Parent {

//Enum for the card Rank
public final cardRank rank;
public final cardSuit suit;
public final int cardValue;

enum cardRank {
   ACE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9),
   TEN(10), JACK(10), QUEEN(10), KING(10);
   
   final int cardValue ;
   private cardRank(int cardValue) {
      this.cardValue = cardValue;
   }
}

//Enum for the card Suit
enum cardSuit {
   DIAMONDS, SPADES, HEARTS, CLUBS
};

//ge{tting the card with the rank and suit
public Card(cardSuit suit, cardRank rank) {
   this.suit = suit;
   this.rank = rank;
   this.cardValue = rank.value;
   
   Text label = new Text(toString());
   label.setWrappingingWidth(70);
   
   Rectangle cardbg = new Rectangle(50, 80);
   cardbg.setFill(Color.WHITE);
   
   StackPane card = new StackPane();
   card.getChildren.addAll(cardbg, label);
   
}

//toStting method that will be the label on the game cards
@Override
public String toString() {
   return rank.toString() + suit.toString();
}
}

