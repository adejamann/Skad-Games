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

public final cardRank rank;
public final cardSuit suit;
public final int cardValue;
private Rectangle playingcard;

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
         Image d1 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/d/d3/Playing_card_diamond_A.svg/200px-Playing_card_diamond_A.svg.png?20070326033900");
         playingcard.setFill(new ImagePattern(d1));
       } else if (rank == cardRank.TWO) {
            Image d2 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/5/59/Playing_card_diamond_2.svg/200px-Playing_card_diamond_2.svg.png?20070326033915");
            playingcard.setFill(new ImagePattern(d2));
       } else if (rank == cardRank.THREE) {
            Image d3 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/8/82/Playing_card_diamond_3.svg/200px-Playing_card_diamond_3.svg.png?20070326033933");
            playingcard.setFill(new ImagePattern(d3));
       } else if (rank == cardRank.FOUR) {
            Image d4 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/2/20/Playing_card_diamond_4.svg/300px-Playing_card_diamond_4.svg.png?20070326033947");
            playingcard.setFill(new ImagePattern(d4));
       } else if (rank == cardRank.FIVE) {
            Image d5 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/f/fd/Playing_card_diamond_5.svg/300px-Playing_card_diamond_5.svg.png?20070326034008");
            playingcard.setFill(new ImagePattern(d5));
       } else if (rank == cardRank.SIX) {
            Image d6 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/8/80/Playing_card_diamond_6.svg/300px-Playing_card_diamond_6.svg.png?20070326034029");
            playingcard.setFill(new ImagePattern(d6));
       } else if (rank == cardRank.SEVEN) {
            Image d7 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/e/e6/Playing_card_diamond_7.svg/300px-Playing_card_diamond_7.svg.png?20070326034044");
            playingcard.setFill(new ImagePattern(d7));
       } else if (rank == cardRank.EIGHT) {
            Image d8 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/7/78/Playing_card_diamond_8.svg/300px-Playing_card_diamond_8.svg.png");
            playingcard.setFill(new ImagePattern(d8));
       } else if (rank == cardRank.NINE) {
            Image d9 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/9/9e/Playing_card_diamond_9.svg/300px-Playing_card_diamond_9.svg.png?20070326034140");
            playingcard.setFill(new ImagePattern(d9));
       } else if (rank == cardRank.TEN) {
            Image d10 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/3/34/Playing_card_diamond_10.svg/300px-Playing_card_diamond_10.svg.png");
            playingcard.setFill(new ImagePattern(d10));
       } else if (rank == cardRank.JACK) {
            Image dj = new Image("https://media.istockphoto.com/photos/playing-card-jack-of-diamonds-picture-id163052036?s=612x612");
            playingcard.setFill(new ImagePattern(dj));
       } else if (rank == cardRank.QUEEN) {
            Image dq = new Image("https://media.istockphoto.com/vectors/queen-of-diamonds-playing-card-vector-id499378190?s=612x612");
            playingcard.setFill(new ImagePattern(dq));
       } else {
            Image dk = new Image("https://media.istockphoto.com/vectors/king-of-diamonds-two-playing-card-vector-id165558074?k=20&m=165558074&s=612x612&w=0&h=xTrhPT9rbgdjN8M3Hmd-DgLU_JiItrBb8dSFyPTvx-4=");
            playingcard.setFill(new ImagePattern(dk));
       } 
     } else if (suit == cardSuit.SPADES){
         if (rank == cardRank.ACE) {
         Image s1 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/a/ab/01_of_spades_A.svg/255px-01_of_spades_A.svg.png");
         playingcard.setFill(new ImagePattern(s1));
       } else if (rank == cardRank.TWO) {
            Image s2 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/f/f2/Playing_card_spade_2.svg/300px-Playing_card_spade_2.svg.png?20070326035258");
            playingcard.setFill(new ImagePattern(s2));
       } else if (rank == cardRank.THREE) {
            Image s3 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/5/52/Playing_card_spade_3.svg/300px-Playing_card_spade_3.svg.png?20070326035314");
            playingcard.setFill(new ImagePattern(s3));
       } else if (rank == cardRank.FOUR) {
            Image s4 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/2/2c/Playing_card_spade_4.svg/300px-Playing_card_spade_4.svg.png?20070326035330");
            playingcard.setFill(new ImagePattern(s4));
       } else if (rank == cardRank.FIVE) {
            Image s5 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/9/94/Playing_card_spade_5.svg/300px-Playing_card_spade_5.svg.png?20070326035345");
            playingcard.setFill(new ImagePattern(s5));
       } else if (rank == cardRank.SIX) {
            Image s6 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/d/d2/Playing_card_spade_6.svg/300px-Playing_card_spade_6.svg.png?20070326035401");
            playingcard.setFill(new ImagePattern(s6));
       } else if (rank == cardRank.SEVEN) {
            Image s7 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/6/66/Playing_card_spade_7.svg/300px-Playing_card_spade_7.svg.png?20070326035421");
            playingcard.setFill(new ImagePattern(s7));
       } else if (rank == cardRank.EIGHT) {
            Image s8 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/2/21/Playing_card_spade_8.svg/300px-Playing_card_spade_8.svg.png?20070326035436");
            playingcard.setFill(new ImagePattern(s8));
       } else if (rank == cardRank.NINE) {
            Image s9 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/e/e0/Playing_card_spade_9.svg/300px-Playing_card_spade_9.svg.png?20090429053434");
            playingcard.setFill(new ImagePattern(s9));
       } else if (rank == cardRank.TEN) {
            Image s10 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/8/87/Playing_card_spade_10.svg/300px-Playing_card_spade_10.svg.png?20070326035506");
            playingcard.setFill(new ImagePattern(s10));
       } else if (rank == cardRank.JACK) {
            Image sj = new Image("https://media.istockphoto.com/photos/playing-card-jack-of-spades-picture-id458107633?s=612x612");
            playingcard.setFill(new ImagePattern(sj));
       } else if (rank == cardRank.QUEEN) {
            Image sq = new Image("https://media.istockphoto.com/photos/large-index-playing-card-queen-of-spades-picture-id657378020?s=612x612");
            playingcard.setFill(new ImagePattern(sq));
       } else {
            Image sk = new Image("https://media.istockphoto.com/illustrations/king-of-spades-two-playing-card-illustration-id165587843?s=612x612");
            playingcard.setFill(new ImagePattern(sk));
       } 
    } else if (suit == cardSuit.HEARTS) {
      if (rank == cardRank.ACE) {
         Image h1 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/5/57/Playing_card_heart_A.svg/195px-Playing_card_heart_A.svg.png");
         playingcard.setFill(new ImagePattern(h1));
       } else if (rank == cardRank.TWO) {
            Image h2 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/d/d5/Playing_card_heart_2.svg/300px-Playing_card_heart_2.svg.png?20070326034413");
            playingcard.setFill(new ImagePattern(h2));
       } else if (rank == cardRank.THREE) {
            Image h3 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/b/b6/Playing_card_heart_3.svg/300px-Playing_card_heart_3.svg.png?20070326034439");
            playingcard.setFill(new ImagePattern(h3));
       } else if (rank == cardRank.FOUR) {
            Image h4 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/a/a2/Playing_card_heart_4.svg/300px-Playing_card_heart_4.svg.png?20070326034453");
            playingcard.setFill(new ImagePattern(h4));
       } else if (rank == cardRank.FIVE) {
            Image h5 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/5/52/Playing_card_heart_5.svg/300px-Playing_card_heart_5.svg.png?20070326034508");
            playingcard.setFill(new ImagePattern(h5));
       } else if (rank == cardRank.SIX){
            Image h6 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/c/cd/Playing_card_heart_6.svg/300px-Playing_card_heart_6.svg.png?20070326034522");
            playingcard.setFill(new ImagePattern(h6));
       } else if (rank == cardRank.SEVEN) {
            Image h7 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/9/94/Playing_card_heart_7.svg/300px-Playing_card_heart_7.svg.png?20070326034536");
            playingcard.setFill(new ImagePattern(h7));
       } else if (rank == cardRank.EIGHT) {
            Image h8 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/5/50/Playing_card_heart_8.svg/300px-Playing_card_heart_8.svg.png?20070326034552");
            playingcard.setFill(new ImagePattern(h8));
       } else if (rank == cardRank.NINE) {
            Image h9 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/5/50/Playing_card_heart_9.svg/300px-Playing_card_heart_9.svg.png?20070326034611");
            playingcard.setFill(new ImagePattern(h9));
       } else if (rank == cardRank.TEN) {
            Image h10 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/9/98/Playing_card_heart_10.svg/300px-Playing_card_heart_10.svg.png?20070326034633");
            playingcard.setFill(new ImagePattern(h10));
       } else if (rank == cardRank.JACK) {
            Image hj = new Image("https://media.istockphoto.com/vectors/jack-of-hearts-vector-id165501014?k=20&m=165501014&s=612x612&w=0&h=H6p1VkfA4kMZK6kQAUnBkde9e8SkieF-zsnyCw9rO_w=");
            playingcard.setFill(new ImagePattern(hj));
       } else if (rank == cardRank.QUEEN) {
            Image hq = new Image("https://media.istockphoto.com/vectors/queen-of-hearts-two-playing-card-vector-id165528945?s=612x612");
            playingcard.setFill(new ImagePattern(hq));
       } else {
            Image hk = new Image("https://media.istockphoto.com/photos/playing-card-king-of-hearts-picture-id166089307?s=612x612");
            playingcard.setFill(new ImagePattern(hk));
       }
   } else {
      if (rank == cardRank.ACE) {
         Image c1 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/3/36/Playing_card_club_A.svg/300px-Playing_card_club_A.svg.png?20071013033815");
         playingcard.setFill(new ImagePattern(c1));
       } else if (rank == cardRank.TWO) {
            Image c2 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/f/f5/Playing_card_club_2.svg/300px-Playing_card_club_2.svg.png?20071013033848");
            playingcard.setFill(new ImagePattern(c2));
       } else if (rank == cardRank.THREE) {
            Image c3 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/6/6b/Playing_card_club_3.svg/300px-Playing_card_club_3.svg.png?20071013033857");
            playingcard.setFill(new ImagePattern(c3));
       } else if (rank == cardRank.FOUR) {
            Image c4 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/3/3d/Playing_card_club_4.svg/300px-Playing_card_club_4.svg.png?20071013033908");
            playingcard.setFill(new ImagePattern(c4));
       } else if (rank == cardRank.FIVE) {
            Image c5 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/5/50/Playing_card_club_5.svg/300px-Playing_card_club_5.svg.png?20071013033920");
            playingcard.setFill(new ImagePattern(c5));
       } else if (rank == cardRank.SIX) {
            Image c6 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/a/a0/Playing_card_club_6.svg/300px-Playing_card_club_6.svg.png?20071013033931");
            playingcard.setFill(new ImagePattern(c6));
       } else if (rank == cardRank.SEVEN) {
            Image c7 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/4/4b/Playing_card_club_7.svg/300px-Playing_card_club_7.svg.png?20071013033942");
            playingcard.setFill(new ImagePattern(c7));
       } else if (rank == cardRank.EIGHT) {
            Image c8 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/e/eb/Playing_card_club_8.svg/300px-Playing_card_club_8.svg.png");
            playingcard.setFill(new ImagePattern(c8));
       } else if (rank == cardRank.NINE) {
            Image c9 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/2/27/Playing_card_club_9.svg/300px-Playing_card_club_9.svg.png?20090429053054");
            playingcard.setFill(new ImagePattern(c9));
       } else if (rank == cardRank.TEN) {
            Image c10 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/3/3e/Playing_card_club_10.svg/300px-Playing_card_club_10.svg.png?20071013034017");
            playingcard.setFill(new ImagePattern(c10));
       } else if (rank == cardRank.JACK) {
            Image cj = new Image("https://media.istockphoto.com/photos/jack-of-clubs-picture-id466256313?k=20&m=466256313&s=612x612&w=0&h=azzML34wDzqyqbN8b0ME3mfk4Wu3ZjPxE17YS0KNaLw=");
            playingcard.setFill(new ImagePattern(cj));
       } else if (rank == cardRank.QUEEN) {
            Image cq = new Image("https://media.istockphoto.com/photos/playing-card-queen-of-clubs-picture-id155652049?k=20&m=155652049&s=612x612&w=0&h=eo4HLhhpMFlVwLIw-iA7gqF2gib83peNLgW7hvqCDnE=");
            playingcard.setFill(new ImagePattern(cq));
       } else {
            Image ck = new Image("https://media.istockphoto.com/photos/playing-card-king-of-clubs-picture-id149127808?s=612x612");
            playingcard.setFill(new ImagePattern(ck));
       }
   }

   this.getChildren().addAll(playingcard);
 } 
 
 public void hide() {
   Image hidden = new Image("https://i.pinimg.com/564x/6c/a0/16/6ca016115a894f69dea75cc80f95ad92--game-cards-card-games.jpg");
   playingcard.setFill(new ImagePattern(hidden));
 }
 
 public void show() {
 if (suit == cardSuit.DIAMONDS) {
      if (rank == cardRank.ACE) {
         Image d1 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/d/d3/Playing_card_diamond_A.svg/200px-Playing_card_diamond_A.svg.png?20070326033900");
         playingcard.setFill(new ImagePattern(d1));
       } else if (rank == cardRank.TWO) {
            Image d2 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/5/59/Playing_card_diamond_2.svg/200px-Playing_card_diamond_2.svg.png?20070326033915");
            playingcard.setFill(new ImagePattern(d2));
       } else if (rank == cardRank.THREE) {
            Image d3 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/8/82/Playing_card_diamond_3.svg/200px-Playing_card_diamond_3.svg.png?20070326033933");
            playingcard.setFill(new ImagePattern(d3));
       } else if (rank == cardRank.FOUR) {
            Image d4 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/2/20/Playing_card_diamond_4.svg/300px-Playing_card_diamond_4.svg.png?20070326033947");
            playingcard.setFill(new ImagePattern(d4));
       } else if (rank == cardRank.FIVE) {
            Image d5 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/f/fd/Playing_card_diamond_5.svg/300px-Playing_card_diamond_5.svg.png?20070326034008");
            playingcard.setFill(new ImagePattern(d5));
       } else if (rank == cardRank.SIX) {
            Image d6 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/8/80/Playing_card_diamond_6.svg/300px-Playing_card_diamond_6.svg.png?20070326034029");
            playingcard.setFill(new ImagePattern(d6));
       } else if (rank == cardRank.SEVEN) {
            Image d7 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/e/e6/Playing_card_diamond_7.svg/300px-Playing_card_diamond_7.svg.png?20070326034044");
            playingcard.setFill(new ImagePattern(d7));
       } else if (rank == cardRank.EIGHT) {
            Image d8 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/7/78/Playing_card_diamond_8.svg/300px-Playing_card_diamond_8.svg.png");
            playingcard.setFill(new ImagePattern(d8));
       } else if (rank == cardRank.NINE) {
            Image d9 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/9/9e/Playing_card_diamond_9.svg/300px-Playing_card_diamond_9.svg.png?20070326034140");
            playingcard.setFill(new ImagePattern(d9));
       } else if (rank == cardRank.TEN) {
            Image d10 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/3/34/Playing_card_diamond_10.svg/300px-Playing_card_diamond_10.svg.png");
            playingcard.setFill(new ImagePattern(d10));
       } else if (rank == cardRank.JACK) {
            Image dj = new Image("https://media.istockphoto.com/photos/playing-card-jack-of-diamonds-picture-id163052036?s=612x612");
            playingcard.setFill(new ImagePattern(dj));
       } else if (rank == cardRank.QUEEN) {
            Image dq = new Image("https://media.istockphoto.com/vectors/queen-of-diamonds-playing-card-vector-id499378190?s=612x612");
            playingcard.setFill(new ImagePattern(dq));
       } else {
            Image dk = new Image("https://media.istockphoto.com/vectors/king-of-diamonds-two-playing-card-vector-id165558074?k=20&m=165558074&s=612x612&w=0&h=xTrhPT9rbgdjN8M3Hmd-DgLU_JiItrBb8dSFyPTvx-4=");
            playingcard.setFill(new ImagePattern(dk));
       } 
     } else if (suit == cardSuit.SPADES){
         if (rank == cardRank.ACE) {
         Image s1 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/a/ab/01_of_spades_A.svg/255px-01_of_spades_A.svg.png");
         playingcard.setFill(new ImagePattern(s1));
       } else if (rank == cardRank.TWO) {
            Image s2 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/f/f2/Playing_card_spade_2.svg/300px-Playing_card_spade_2.svg.png?20070326035258");
            playingcard.setFill(new ImagePattern(s2));
       } else if (rank == cardRank.THREE) {
            Image s3 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/5/52/Playing_card_spade_3.svg/300px-Playing_card_spade_3.svg.png?20070326035314");
            playingcard.setFill(new ImagePattern(s3));
       } else if (rank == cardRank.FOUR) {
            Image s4 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/2/2c/Playing_card_spade_4.svg/300px-Playing_card_spade_4.svg.png?20070326035330");
            playingcard.setFill(new ImagePattern(s4));
       } else if (rank == cardRank.FIVE) {
            Image s5 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/9/94/Playing_card_spade_5.svg/300px-Playing_card_spade_5.svg.png?20070326035345");
            playingcard.setFill(new ImagePattern(s5));
       } else if (rank == cardRank.SIX) {
            Image s6 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/d/d2/Playing_card_spade_6.svg/300px-Playing_card_spade_6.svg.png?20070326035401");
            playingcard.setFill(new ImagePattern(s6));
       } else if (rank == cardRank.SEVEN) {
            Image s7 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/6/66/Playing_card_spade_7.svg/300px-Playing_card_spade_7.svg.png?20070326035421");
            playingcard.setFill(new ImagePattern(s7));
       } else if (rank == cardRank.EIGHT) {
            Image s8 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/2/21/Playing_card_spade_8.svg/300px-Playing_card_spade_8.svg.png?20070326035436");
            playingcard.setFill(new ImagePattern(s8));
       } else if (rank == cardRank.NINE) {
            Image s9 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/e/e0/Playing_card_spade_9.svg/300px-Playing_card_spade_9.svg.png?20090429053434");
            playingcard.setFill(new ImagePattern(s9));
       } else if (rank == cardRank.TEN) {
            Image s10 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/8/87/Playing_card_spade_10.svg/300px-Playing_card_spade_10.svg.png?20070326035506");
            playingcard.setFill(new ImagePattern(s10));
       } else if (rank == cardRank.JACK) {
            Image sj = new Image("https://media.istockphoto.com/photos/playing-card-jack-of-spades-picture-id458107633?s=612x612");
            playingcard.setFill(new ImagePattern(sj));
       } else if (rank == cardRank.QUEEN) {
            Image sq = new Image("https://media.istockphoto.com/photos/large-index-playing-card-queen-of-spades-picture-id657378020?s=612x612");
            playingcard.setFill(new ImagePattern(sq));
       } else {
            Image sk = new Image("https://media.istockphoto.com/illustrations/king-of-spades-two-playing-card-illustration-id165587843?s=612x612");
            playingcard.setFill(new ImagePattern(sk));
       } 
    } else if (suit == cardSuit.HEARTS) {
      if (rank == cardRank.ACE) {
         Image h1 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/5/57/Playing_card_heart_A.svg/195px-Playing_card_heart_A.svg.png");
         playingcard.setFill(new ImagePattern(h1));
       } else if (rank == cardRank.TWO) {
            Image h2 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/d/d5/Playing_card_heart_2.svg/300px-Playing_card_heart_2.svg.png?20070326034413");
            playingcard.setFill(new ImagePattern(h2));
       } else if (rank == cardRank.THREE) {
            Image h3 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/b/b6/Playing_card_heart_3.svg/300px-Playing_card_heart_3.svg.png?20070326034439");
            playingcard.setFill(new ImagePattern(h3));
       } else if (rank == cardRank.FOUR) {
            Image h4 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/a/a2/Playing_card_heart_4.svg/300px-Playing_card_heart_4.svg.png?20070326034453");
            playingcard.setFill(new ImagePattern(h4));
       } else if (rank == cardRank.FIVE) {
            Image h5 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/5/52/Playing_card_heart_5.svg/300px-Playing_card_heart_5.svg.png?20070326034508");
            playingcard.setFill(new ImagePattern(h5));
       } else if (rank == cardRank.SIX){
            Image h6 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/c/cd/Playing_card_heart_6.svg/300px-Playing_card_heart_6.svg.png?20070326034522");
            playingcard.setFill(new ImagePattern(h6));
       } else if (rank == cardRank.SEVEN) {
            Image h7 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/9/94/Playing_card_heart_7.svg/300px-Playing_card_heart_7.svg.png?20070326034536");
            playingcard.setFill(new ImagePattern(h7));
       } else if (rank == cardRank.EIGHT) {
            Image h8 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/5/50/Playing_card_heart_8.svg/300px-Playing_card_heart_8.svg.png?20070326034552");
            playingcard.setFill(new ImagePattern(h8));
       } else if (rank == cardRank.NINE) {
            Image h9 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/5/50/Playing_card_heart_9.svg/300px-Playing_card_heart_9.svg.png?20070326034611");
            playingcard.setFill(new ImagePattern(h9));
       } else if (rank == cardRank.TEN) {
            Image h10 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/9/98/Playing_card_heart_10.svg/300px-Playing_card_heart_10.svg.png?20070326034633");
            playingcard.setFill(new ImagePattern(h10));
       } else if (rank == cardRank.JACK) {
            Image hj = new Image("https://media.istockphoto.com/vectors/jack-of-hearts-vector-id165501014?k=20&m=165501014&s=612x612&w=0&h=H6p1VkfA4kMZK6kQAUnBkde9e8SkieF-zsnyCw9rO_w=");
            playingcard.setFill(new ImagePattern(hj));
       } else if (rank == cardRank.QUEEN) {
            Image hq = new Image("https://media.istockphoto.com/vectors/queen-of-hearts-two-playing-card-vector-id165528945?s=612x612");
            playingcard.setFill(new ImagePattern(hq));
       } else {
            Image hk = new Image("https://media.istockphoto.com/photos/playing-card-king-of-hearts-picture-id166089307?s=612x612");
            playingcard.setFill(new ImagePattern(hk));
       }
   } else {
      if (rank == cardRank.ACE) {
         Image c1 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/3/36/Playing_card_club_A.svg/300px-Playing_card_club_A.svg.png?20071013033815");
         playingcard.setFill(new ImagePattern(c1));
       } else if (rank == cardRank.TWO) {
            Image c2 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/f/f5/Playing_card_club_2.svg/300px-Playing_card_club_2.svg.png?20071013033848");
            playingcard.setFill(new ImagePattern(c2));
       } else if (rank == cardRank.THREE) {
            Image c3 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/6/6b/Playing_card_club_3.svg/300px-Playing_card_club_3.svg.png?20071013033857");
            playingcard.setFill(new ImagePattern(c3));
       } else if (rank == cardRank.FOUR) {
            Image c4 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/3/3d/Playing_card_club_4.svg/300px-Playing_card_club_4.svg.png?20071013033908");
            playingcard.setFill(new ImagePattern(c4));
       } else if (rank == cardRank.FIVE) {
            Image c5 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/5/50/Playing_card_club_5.svg/300px-Playing_card_club_5.svg.png?20071013033920");
            playingcard.setFill(new ImagePattern(c5));
       } else if (rank == cardRank.SIX) {
            Image c6 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/a/a0/Playing_card_club_6.svg/300px-Playing_card_club_6.svg.png?20071013033931");
            playingcard.setFill(new ImagePattern(c6));
       } else if (rank == cardRank.SEVEN) {
            Image c7 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/4/4b/Playing_card_club_7.svg/300px-Playing_card_club_7.svg.png?20071013033942");
            playingcard.setFill(new ImagePattern(c7));
       } else if (rank == cardRank.EIGHT) {
            Image c8 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/e/eb/Playing_card_club_8.svg/300px-Playing_card_club_8.svg.png");
            playingcard.setFill(new ImagePattern(c8));
       } else if (rank == cardRank.NINE) {
            Image c9 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/2/27/Playing_card_club_9.svg/300px-Playing_card_club_9.svg.png?20090429053054");
            playingcard.setFill(new ImagePattern(c9));
       } else if (rank == cardRank.TEN) {
            Image c10 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/3/3e/Playing_card_club_10.svg/300px-Playing_card_club_10.svg.png?20071013034017");
            playingcard.setFill(new ImagePattern(c10));
       } else if (rank == cardRank.JACK) {
            Image cj = new Image("https://media.istockphoto.com/photos/jack-of-clubs-picture-id466256313?k=20&m=466256313&s=612x612&w=0&h=azzML34wDzqyqbN8b0ME3mfk4Wu3ZjPxE17YS0KNaLw=");
            playingcard.setFill(new ImagePattern(cj));
       } else if (rank == cardRank.QUEEN) {
            Image cq = new Image("https://media.istockphoto.com/photos/playing-card-queen-of-clubs-picture-id155652049?k=20&m=155652049&s=612x612&w=0&h=eo4HLhhpMFlVwLIw-iA7gqF2gib83peNLgW7hvqCDnE=");
            playingcard.setFill(new ImagePattern(cq));
       } else {
            Image ck = new Image("https://media.istockphoto.com/photos/playing-card-king-of-clubs-picture-id149127808?s=612x612");
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
