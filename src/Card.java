import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Circle;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.FontWeight;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.TabPane;
import javafx.scene.control.Tab;
import javafx.event.Event;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.ImagePattern;
import javafx.application.Platform;
import javafx.scene.layout.VBox;

//Creates a card class that will display the rank and suit of the card
public class Card extends StackPane {

/**
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
*/

public final cardRank rank;
public final cardSuit suit;
public final int cardValue;
private Rectangle playingcard;
//Enum for the card Rank

public enum cardRank {
   ACE(1), //0
   TWO(2), //1
   THREE(3), //2
   FOUR(4), //3
   FIVE(5), //4
   SIX(6), //5
   SEVEN(7), //6
   EIGHT(8), //7
   NINE(9),//8
   TEN(10), //9
   JACK(10), //10
   QUEEN(10), //11
   KING(10);//12
   
   final int cardValue;
   private cardRank(int cardValue) {
      this.cardValue = cardValue;
   }
};



//Enum for the card Suit
public enum cardSuit {
   DIAMONDS, //0
   SPADES, //1
   HEARTS, //2
   CLUBS; //3

}

//getting the card with the rank and suit
public Card(cardSuit suit, cardRank rank) {
   this.suit = suit;
   this.rank = rank;
   this.cardValue = rank.cardValue;
   
   playingcard = new Rectangle(80, 110);
   if (suit == null || rank == null) {
      throw new IllegalArgumentException("Rank and Suit cannot be null");
   }
   if (suit == cardSuit.DIAMONDS) {
      if (rank == cardRank.ACE) {
         Image d1 = new Image("D-Ace.png");
         playingcard.setFill(new ImagePattern(d1));
       } else if (rank == cardRank.TWO) {
            Image d2 = new Image("D-2.png");
            playingcard.setFill(new ImagePattern(d2));
       } else if (rank == cardRank.THREE) {
            Image d3 = new Image("D-3.png");
            playingcard.setFill(new ImagePattern(d3));
       } else if (rank == cardRank.FOUR) {
            Image d4 = new Image("D-4.png");
            playingcard.setFill(new ImagePattern(d4));
       } else if (rank == cardRank.FIVE) {
            Image d5 = new Image("D-5.png");
            playingcard.setFill(new ImagePattern(d5));
       } else if (rank == cardRank.SIX) {
            Image d6 = new Image("D-6.png");
            playingcard.setFill(new ImagePattern(d6));
       } else if (rank == cardRank.SEVEN) {
            Image d7 = new Image("D-7.png");
            playingcard.setFill(new ImagePattern(d7));
       } else if (rank == cardRank.EIGHT) {
            Image d8 = new Image("D-8.png");
            playingcard.setFill(new ImagePattern(d8));
       } else if (rank == cardRank.NINE) {
            Image d9 = new Image("D-9.png");
            playingcard.setFill(new ImagePattern(d9));
       } else if (rank == cardRank.TEN) {
            Image d10 = new Image("D-10.png");
            playingcard.setFill(new ImagePattern(d10));
       } else if (rank == cardRank.JACK) {
            Image dj = new Image("D-J.jpeg");
            playingcard.setFill(new ImagePattern(dj));
       } else if (rank == cardRank.QUEEN) {
            Image dq = new Image("D-Q.jpeg");
            playingcard.setFill(new ImagePattern(dq));
       } else {
            Image dk = new Image("D-K.jpeg");
            playingcard.setFill(new ImagePattern(dk));
       } 
     } else if (suit == cardSuit.SPADES){
         if (rank == cardRank.ACE) {
         Image s1 = new Image("S-Ace.png");
         playingcard.setFill(new ImagePattern(s1));
       } else if (rank == cardRank.TWO) {
            Image s2 = new Image("S-2.png");
            playingcard.setFill(new ImagePattern(s2));
       } else if (rank == cardRank.THREE) {
            Image s3 = new Image("S-3.png");
            playingcard.setFill(new ImagePattern(s3));
       } else if (rank == cardRank.FOUR) {
            Image s4 = new Image("S-4.png");
            playingcard.setFill(new ImagePattern(s4));
       } else if (rank == cardRank.FIVE) {
            Image s5 = new Image("S-5.png");
            playingcard.setFill(new ImagePattern(s5));
       } else if (rank == cardRank.SIX) {
            Image s6 = new Image("S-6.png");
            playingcard.setFill(new ImagePattern(s6));
       } else if (rank == cardRank.SEVEN) {
            Image s7 = new Image("S-7.png");
            playingcard.setFill(new ImagePattern(s7));
       } else if (rank == cardRank.EIGHT) {
            Image s8 = new Image("S-8.png");
            playingcard.setFill(new ImagePattern(s8));
       } else if (rank == cardRank.NINE) {
            Image s9 = new Image("S-9.png");
            playingcard.setFill(new ImagePattern(s9));
       } else if (rank == cardRank.TEN) {
            Image s10 = new Image("S-10.png");
            playingcard.setFill(new ImagePattern(s10));
       } else if (rank == cardRank.JACK) {
            Image sj = new Image("S-J.jpeg");
            playingcard.setFill(new ImagePattern(sj));
       } else if (rank == cardRank.QUEEN) {
            Image sq = new Image("S-Q.jpeg");
            playingcard.setFill(new ImagePattern(sq));
       } else {
            Image sk = new Image("S-K.jpeg");
            playingcard.setFill(new ImagePattern(sk));
       } 
    } else if (suit == cardSuit.HEARTS) {
      if (rank == cardRank.ACE) {
         Image h1 = new Image("H-Ace.png");
         playingcard.setFill(new ImagePattern(h1));
       } else if (rank == cardRank.TWO) {
            Image h2 = new Image("H-2.png");
            playingcard.setFill(new ImagePattern(h2));
       } else if (rank == cardRank.THREE) {
            Image h3 = new Image("H-3.png");
            playingcard.setFill(new ImagePattern(h3));
       } else if (rank == cardRank.FOUR) {
            Image h4 = new Image("H-4.png");
            playingcard.setFill(new ImagePattern(h4));
       } else if (rank == cardRank.FIVE) {
            Image h5 = new Image("H-5.png");
            playingcard.setFill(new ImagePattern(h5));
       } else if (rank == cardRank.SIX){
            Image h6 = new Image("H-6.png");
            playingcard.setFill(new ImagePattern(h6));
       } else if (rank == cardRank.SEVEN) {
            Image h7 = new Image("H-7.png");
            playingcard.setFill(new ImagePattern(h7));
       } else if (rank == cardRank.EIGHT) {
            Image h8 = new Image("H-8.png");
            playingcard.setFill(new ImagePattern(h8));
       } else if (rank == cardRank.NINE) {
            Image h9 = new Image("H-9.png");
            playingcard.setFill(new ImagePattern(h9));
       } else if (rank == cardRank.TEN) {
            Image h10 = new Image("H-10.png");
            playingcard.setFill(new ImagePattern(h10));
       } else if (rank == cardRank.JACK) {
            Image hj = new Image("H-J.jpg");
            playingcard.setFill(new ImagePattern(hj));
       } else if (rank == cardRank.QUEEN) {
            Image hq = new Image("H-Q.jpg");
            playingcard.setFill(new ImagePattern(hq));
       } else {
            Image hk = new Image("H-K.jpg");
            playingcard.setFill(new ImagePattern(hk));
       }
   } else {
      if (rank == cardRank.ACE) {
         Image c1 = new Image("C-Ace.png");
         playingcard.setFill(new ImagePattern(c1));
       } else if (rank == cardRank.TWO) {
            Image c2 = new Image("C-2.png");
            playingcard.setFill(new ImagePattern(c2));
       } else if (rank == cardRank.THREE) {
            Image c3 = new Image("C-3.png");
            playingcard.setFill(new ImagePattern(c3));
       } else if (rank == cardRank.FOUR) {
            Image c4 = new Image("C-4.png");
            playingcard.setFill(new ImagePattern(c4));
       } else if (rank == cardRank.FIVE) {
            Image c5 = new Image("C-5.png");
            playingcard.setFill(new ImagePattern(c5));
       } else if (rank == cardRank.SIX) {
            Image c6 = new Image("C-6.png");
            playingcard.setFill(new ImagePattern(c6));
       } else if (rank == cardRank.SEVEN) {
            Image c7 = new Image("C-7.png");
            playingcard.setFill(new ImagePattern(c7));
       } else if (rank == cardRank.EIGHT) {
            Image c8 = new Image("C-8.png");
            playingcard.setFill(new ImagePattern(c8));
       } else if (rank == cardRank.NINE) {
            Image c9 = new Image("C-9.png");
            playingcard.setFill(new ImagePattern(c9));
       } else if (rank == cardRank.TEN) {
            Image c10 = new Image("C-10.png");
            playingcard.setFill(new ImagePattern(c10));
       } else if (rank == cardRank.JACK) {
            Image cj = new Image("C-J.jpg");
            playingcard.setFill(new ImagePattern(cj));
       } else if (rank == cardRank.QUEEN) {
            Image cq = new Image("C-Q.jpg");
            playingcard.setFill(new ImagePattern(cq));
       } else {
            Image ck = new Image("C-K.jpg");
            playingcard.setFill(new ImagePattern(ck));
       }
   }

   this.getChildren().addAll(playingcard);
 } 
 
 public void hide() {
   Image hidden = new Image("hidden.jpeg");
   playingcard.setFill(new ImagePattern(hidden));
 }
 
 public void show() {
 if (suit == cardSuit.DIAMONDS) {
      if (rank == cardRank.ACE) {
         Image d1 = new Image("D-Ace.png");
         playingcard.setFill(new ImagePattern(d1));
       } else if (rank == cardRank.TWO) {
            Image d2 = new Image("D-2.png");
            playingcard.setFill(new ImagePattern(d2));
       } else if (rank == cardRank.THREE) {
            Image d3 = new Image("D-3.png");
            playingcard.setFill(new ImagePattern(d3));
       } else if (rank == cardRank.FOUR) {
            Image d4 = new Image("D-4.png");
            playingcard.setFill(new ImagePattern(d4));
       } else if (rank == cardRank.FIVE) {
            Image d5 = new Image("D-5.png");
            playingcard.setFill(new ImagePattern(d5));
       } else if (rank == cardRank.SIX) {
            Image d6 = new Image("D-6.png");
            playingcard.setFill(new ImagePattern(d6));
       } else if (rank == cardRank.SEVEN) {
            Image d7 = new Image("D-7.png");
            playingcard.setFill(new ImagePattern(d7));
       } else if (rank == cardRank.EIGHT) {
            Image d8 = new Image("D-8.png");
            playingcard.setFill(new ImagePattern(d8));
       } else if (rank == cardRank.NINE) {
            Image d9 = new Image("D-9.png");
            playingcard.setFill(new ImagePattern(d9));
       } else if (rank == cardRank.TEN) {
            Image d10 = new Image("D-10.png");
            playingcard.setFill(new ImagePattern(d10));
       } else if (rank == cardRank.JACK) {
            Image dj = new Image("D-J.jpeg");
            playingcard.setFill(new ImagePattern(dj));
       } else if (rank == cardRank.QUEEN) {
            Image dq = new Image("D-Q.jpeg");
            playingcard.setFill(new ImagePattern(dq));
       } else {
            Image dk = new Image("D-K.jpeg");
            playingcard.setFill(new ImagePattern(dk));
       } 
     } else if (suit == cardSuit.SPADES){
         if (rank == cardRank.ACE) {
         Image s1 = new Image("S-Ace.png");
         playingcard.setFill(new ImagePattern(s1));
       } else if (rank == cardRank.TWO) {
            Image s2 = new Image("S-2.png");
            playingcard.setFill(new ImagePattern(s2));
       } else if (rank == cardRank.THREE) {
            Image s3 = new Image("S-3.png");
            playingcard.setFill(new ImagePattern(s3));
       } else if (rank == cardRank.FOUR) {
            Image s4 = new Image("S-4.png");
            playingcard.setFill(new ImagePattern(s4));
       } else if (rank == cardRank.FIVE) {
            Image s5 = new Image("S-5.png");
            playingcard.setFill(new ImagePattern(s5));
       } else if (rank == cardRank.SIX) {
            Image s6 = new Image("S-6.png");
            playingcard.setFill(new ImagePattern(s6));
       } else if (rank == cardRank.SEVEN) {
            Image s7 = new Image("S-7.png");
            playingcard.setFill(new ImagePattern(s7));
       } else if (rank == cardRank.EIGHT) {
            Image s8 = new Image("S-8.png");
            playingcard.setFill(new ImagePattern(s8));
       } else if (rank == cardRank.NINE) {
            Image s9 = new Image("S-9.png");
            playingcard.setFill(new ImagePattern(s9));
       } else if (rank == cardRank.TEN) {
            Image s10 = new Image("S-10.png");
            playingcard.setFill(new ImagePattern(s10));
       } else if (rank == cardRank.JACK) {
            Image sj = new Image("S-J.jpeg");
            playingcard.setFill(new ImagePattern(sj));
       } else if (rank == cardRank.QUEEN) {
            Image sq = new Image("S-Q.jpeg");
            playingcard.setFill(new ImagePattern(sq));
       } else {
            Image sk = new Image("S-K.jpeg");
            playingcard.setFill(new ImagePattern(sk));
       } 
    } else if (suit == cardSuit.HEARTS) {
      if (rank == cardRank.ACE) {
         Image h1 = new Image("H-Ace.png");
         playingcard.setFill(new ImagePattern(h1));
       } else if (rank == cardRank.TWO) {
            Image h2 = new Image("H-2.png");
            playingcard.setFill(new ImagePattern(h2));
       } else if (rank == cardRank.THREE) {
            Image h3 = new Image("H-3.png");
            playingcard.setFill(new ImagePattern(h3));
       } else if (rank == cardRank.FOUR) {
            Image h4 = new Image("H-4.png");
            playingcard.setFill(new ImagePattern(h4));
       } else if (rank == cardRank.FIVE) {
            Image h5 = new Image("H-5.png");
            playingcard.setFill(new ImagePattern(h5));
       } else if (rank == cardRank.SIX){
            Image h6 = new Image("H-6.png");
            playingcard.setFill(new ImagePattern(h6));
       } else if (rank == cardRank.SEVEN) {
            Image h7 = new Image("H-7.png");
            playingcard.setFill(new ImagePattern(h7));
       } else if (rank == cardRank.EIGHT) {
            Image h8 = new Image("H-8.png");
            playingcard.setFill(new ImagePattern(h8));
       } else if (rank == cardRank.NINE) {
            Image h9 = new Image("H-9.png");
            playingcard.setFill(new ImagePattern(h9));
       } else if (rank == cardRank.TEN) {
            Image h10 = new Image("H-10.png");
            playingcard.setFill(new ImagePattern(h10));
       } else if (rank == cardRank.JACK) {
            Image hj = new Image("H-J.jpg");
            playingcard.setFill(new ImagePattern(hj));
       } else if (rank == cardRank.QUEEN) {
            Image hq = new Image("H-Q.jpg");
            playingcard.setFill(new ImagePattern(hq));
       } else {
            Image hk = new Image("H-K.jpg");
            playingcard.setFill(new ImagePattern(hk));
       }
   } else {
      if (rank == cardRank.ACE) {
         Image c1 = new Image("C-Ace.png");
         playingcard.setFill(new ImagePattern(c1));
       } else if (rank == cardRank.TWO) {
            Image c2 = new Image("C-2.png");
            playingcard.setFill(new ImagePattern(c2));
       } else if (rank == cardRank.THREE) {
            Image c3 = new Image("C-3.png");
            playingcard.setFill(new ImagePattern(c3));
       } else if (rank == cardRank.FOUR) {
            Image c4 = new Image("C-4.png");
            playingcard.setFill(new ImagePattern(c4));
       } else if (rank == cardRank.FIVE) {
            Image c5 = new Image("C-5.png");
            playingcard.setFill(new ImagePattern(c5));
       } else if (rank == cardRank.SIX) {
            Image c6 = new Image("C-6.png");
            playingcard.setFill(new ImagePattern(c6));
       } else if (rank == cardRank.SEVEN) {
            Image c7 = new Image("C-7.png");
            playingcard.setFill(new ImagePattern(c7));
       } else if (rank == cardRank.EIGHT) {
            Image c8 = new Image("C-8.png");
            playingcard.setFill(new ImagePattern(c8));
       } else if (rank == cardRank.NINE) {
            Image c9 = new Image("C-9.png");
            playingcard.setFill(new ImagePattern(c9));
       } else if (rank == cardRank.TEN) {
            Image c10 = new Image("C-10.png");
            playingcard.setFill(new ImagePattern(c10));
       } else if (rank == cardRank.JACK) {
            Image cj = new Image("C-J.jpg");
            playingcard.setFill(new ImagePattern(cj));
       } else if (rank == cardRank.QUEEN) {
            Image cq = new Image("C-Q.jpg");
            playingcard.setFill(new ImagePattern(cq));
       } else {
            Image ck = new Image("C-K.jpg");
            playingcard.setFill(new ImagePattern(ck));
       }
   }
    }
}   
   
   /*Text label = new Text(toString());
   label.setWrappingWidth(70);
   Rectangle cardbg = new Rectangle(50, 80);
   cardbg.setFill(Color.WHITE);
   this.getChildren().addAll(cardbg, label);
   
}

//toStting method that will be the label on the game cards
@Override
public String toString() {
  return rank.toString() + " of" + suit.toString();
}*/
