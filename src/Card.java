import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

//Creates a card class that will display the rank and suit of the card
public class Card extends StackPane {

//Enum for the card Rank
public final cardRank rank;
public final cardSuit suit;
public final int cardValue;

public enum cardRank {
   ACE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9),
   TEN(10), JACK(10), QUEEN(10), KING(10);
   
   final int cardValue;
   private cardRank(int cardValue) {
      this.cardValue = cardValue;
   }
}

//Enum for the card Suit
public enum cardSuit {
   DIAMONDS, SPADES, HEARTS, CLUBS
};

//ge{tting the card with the rank and suit
public Card(cardSuit suit, cardRank rank) {
   this.suit = suit;
   this.rank = rank;
   this.cardValue = rank.cardValue;
   
   Text label = new Text(toString());
   label.setWrappingWidth(70);
   
   Rectangle cardbg = new Rectangle(50, 80);
   cardbg.setFill(Color.WHITE);
   
      this.getChildren().addAll(cardbg, label);
   
}

//toStting method that will be the label on the game cards
@Override
public String toString() {
   return rank.toString() + suit.toString();
}
}

