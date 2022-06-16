import javafx.scene.layout.GridPane;
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
import javafx.geometry.Insets;

public class Board extends GridPane {

Button [] tiles = new Button[9];
Image playerX;
ImageView xView;
Image playerO = new Image("O.jpg");
ImageView oView = new ImageView(playerO);
public int moves = 0;

public Board () {
super();
this.setHgap(10);
this.setVgap(10);
this.setPadding(new Insets(0, 10, 0, 10));
initialize();
}

private void initialize() {
for (int i = 0; i < 9; i++) {
Button temp = new Button();
Image img = new Image("Tile.jpg");
ImageView view = new ImageView(img);
      temp.setGraphic(view);
      view.setFitWidth(150);
      view.setFitHeight(150);
      view.setPreserveRatio(true);
      
      oView.setFitWidth(150);
      oView.setFitHeight(150);
      oView.setPreserveRatio(true);
      temp.setUserData("empty");
tiles[i] = temp;
}

int count = 0;
for (int i = 0; i < 3; i++) {
   for (int j = 0; j < 3; j++) {
   this.add(tiles[count], i, j);
   count++;
   }
}
playerOne(); //When implementing rules delete this. Only to test it works
}

/**
* clear the GameBoard by setting the buttons images back to the default tile picture
*
*/
public void clear() {
}

/**
* check each button image to see if it spans 3 in a row. 
* return 1 if player1 won or 2 if player 2 one. return -1 if no one one
*/
public int hasWon() {
   if (tiles[0].getUserData().equals("X") && tiles[1].getUserData().equals("X") && tiles[2].getUserData().equals("X")) {
      return 1;
   } else if (tiles[3].getUserData().equals("X") && tiles[4].getUserData().equals("X") && tiles[5].getUserData().equals("X")) {
      return 1;
   } else if (tiles[6].getUserData().equals("X") && tiles[7].getUserData().equals("X") && tiles[8].getUserData().equals("X")) {
      return 1;
   } else if (tiles[0].getUserData().equals("X") && tiles[3].getUserData().equals("X") && tiles[6].getUserData().equals("X")) {
      return 1;
   } else if (tiles[1].getUserData().equals("X") && tiles[4].getUserData().equals("X") && tiles[7].getUserData().equals("X")) {
      return 1;
   } else if (tiles[2].getUserData().equals("X") && tiles[5].getUserData().equals("X") && tiles[8].getUserData().equals("X")) {
      return 1;
   } else if (tiles[0].getUserData().equals("X") && tiles[4].getUserData().equals("X") && tiles[8].getUserData().equals("X")) {
      return 1;
   } else if (tiles[6].getUserData().equals("X") && tiles[4].getUserData().equals("X") && tiles[2].getUserData().equals("X")) {
      return 1;
   } else if (tiles[0].getUserData().equals("O") && tiles[1].getUserData().equals("O") && tiles[2].getUserData().equals("O")) {
      return 2;
   } else if (tiles[3].getUserData().equals("O") && tiles[4].getUserData().equals("O") && tiles[5].getUserData().equals("O")) {
      return 2;
   } else if (tiles[6].getUserData().equals("O") && tiles[7].getUserData().equals("O") && tiles[8].getUserData().equals("O")) {
      return 2;
   } else if (tiles[0].getUserData().equals("O") && tiles[3].getUserData().equals("O") && tiles[6].getUserData().equals("O")) {
      return 2;
   } else if (tiles[1].getUserData().equals("O") && tiles[4].getUserData().equals("O") && tiles[7].getUserData().equals("O")) {
      return 2;
   } else if (tiles[2].getUserData().equals("O") && tiles[5].getUserData().equals("O") && tiles[8].getUserData().equals("O")) {
      return 2;
   } else if (tiles[0].getUserData().equals("O") && tiles[4].getUserData().equals("O") && tiles[8].getUserData().equals("O")) {
      return 2;
   } else if (tiles[6].getUserData().equals("O") && tiles[4].getUserData().equals("O") && tiles[2].getUserData().equals("O")) {
      return 2;
   }
   System.out.println("test");
   return -1;
}

/**
* Call this when its player 1 turn so when they click any tile it changes to X.
*/

public void playerOne() {
        
for (int i = 0; i < 9; i++) {
   final Button temp = tiles[i];
   temp.setOnAction(ae -> {
   temp.setUserData("O");
   playerX = new Image("X.jpg");
   xView = new ImageView(playerX);
   xView.setFitWidth(150);
   xView.setFitHeight(150);
   xView.setPreserveRatio(true);
   temp.setGraphic(xView);
   moves++;
   });
}
}

/**
* Call this when its playerTwo turn so when the button is clicked it changes to O's
*/

public void playerTwo() {
        
for (int i = 0; i < 9; i++) {
   final Button temp = tiles[i];
   temp.setOnAction(ae -> {
   temp.setUserData("O");
      playerO = new Image("O.jpg");
      oView = new ImageView(playerO);
      oView.setFitWidth(150);
      oView.setFitHeight(150);
      oView.setPreserveRatio(true);
      temp.setGraphic(oView);
      moves++;
   });
}
}
}