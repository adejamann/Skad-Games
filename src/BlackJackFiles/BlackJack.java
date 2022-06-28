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
import javafx.scene.layout.VBox;
import javafx.stage.Modality;



public class BlackJack implements Game {
      //total wins for the game
      int wins = 0;
      
      public BlackJack() {
         initialize();
      }
      
      private void initialize() {
      // creating the button for the instructions  
      Button rules = new Button("Instructions"); 
      rules.setOnAction(e -> display("Instructions",
                "1. The game is played between 2 to 7 players and uses a 52-card deck. All the number cards score the value indicated on them. The face cards(Jack, Queen, and King) score 10 points and the Ace can either be 11 points or 1.\n"
                        + "2. All players place their bets and deal two cards face-up. "
                        + "The dealer receives two cards, one face-up and the other face-down.\n"
                        + "3. Each player is given a chance to draw more cards. The players can either call 'hit' or 'stand'. "
                        + "If the player calls out 'hit', they are given an extra card. They can call out 'hit' again or 'stand' if they do not want to draw any more cards. "
                        + "The player can call 'hit' as many times as they want, but have to ain not to 'bust' (exceed a total of 21). \n" 
                        + "4. If the player busts, they immediately lose their bet.\n"
                        + "5. After each player has played and either stood or busted, the dealer takes their turn. They can either 'hit' or 'stand'.\n"
                        + "6. If the dealer's hand exceeds 21, all players who did not bust win immediately - their bet is returned along with a matching amount from the bank of the dealer.\n"
                        + "7. If the dealer reaches a valid hand, the cards are totalled and eahc player's hand is compared to the dealer's.\n"
                        + "8. If the player scored higher than the dealer, they win. If the player ties with the dealer, the original bet is returned to the player. Otherwise, the player loses their bet.\n"
                        + "9. A perfect hand combines an ace with a 10 (Jack, Queen, or King) and is known an a 'Blackjack'. \n"
                        ));
      rules.setAlignment(Pos.CENTER);
      }
      
      
      
      
      /**
     * @param t - this is a String representing the title of the window
     * @param m - this is a String representing the message that will show in the
     *          window
     */
    void display(String t, String m) {
        Stage insWindow = new Stage();
        insWindow.initModality(Modality.APPLICATION_MODAL);
        insWindow.setTitle(t);
        insWindow.setMinWidth(300);
        Label l1 = new Label();
        l1.setText(m);
        Button exit = new Button("Exit");
        exit.setOnAction(e -> insWindow.close());
        VBox lay = new VBox(10);
        lay.getChildren().addAll(l1, exit);
        lay.setAlignment(Pos.CENTER);
        Scene s = new Scene(lay);
        insWindow.setScene(s);
        insWindow.showAndWait();
    }




}