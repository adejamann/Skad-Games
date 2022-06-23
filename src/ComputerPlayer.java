import javafx.application.Application;
import javafx.scene.paint.Color;
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

import java.util.Random();
//import java.util.ArrayList; 


public class ComputerPlayer extends TicTacToe{
   Random random = new Random();
   
   public void makeMove() {
      // finding an empty button on the board randomly
      int selectedMove = -1; 
      int i;
      while (selectedMove == -1) {
        int i = rand.nextInt[10];
        if (gameboard.tiles[i].getUserData().equals("") {
          selectedMove = 1; 
          break;
        } 
      }
      
      // i now has the button number that is empty
      final Button button = gameboard.tiles[i];
      button.setUserData("O");
      Image playerO = new Image("O.jpg");
      ImageView oView = new ImageView(playerO);
      oView.setFitWidth(150);
      oView.setFitHeight(150);
      oView.setPreserveRatio(true);
      button.setGraphic(oView);
      
      //add 1 to the number of moves of gameboard
      gameboard.moves += 1;
   }
}