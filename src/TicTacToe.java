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


public class TicTacToe implements Game {

int wins = 0;
private Stage gameStage;
private Scene gameScene;
private VBox root;
private HBox options;
private Button exit;
private Button restart;
private Board gameBoard;

public TicTacToe() {
initialize();
}

private void initialize() {
root = new VBox();
gameStage = new Stage();
gameScene = new Scene(root);
options = new HBox();
gameBoard = new Board();

gameStage.setScene(gameScene);
gameStage.setTitle("Tic-Tac-Toe");
gameStage.sizeToScene();

restart = new Button();
exit = new Button(); 

exit.setText("Exit");
restart.setText("Restart");
options.getChildren().addAll(exit, restart);
root.getChildren().addAll(options, gameBoard);
EventHandler<ActionEvent> handler = (ActionEvent ae) -> {
             exit.setText("T");
             //gameStage.close();
 };
 exit.setOnAction(handler);
}

public void play () {
      int turn = 0;
   while (gameBoard.hasWon() == -1 && gameBoard.moves < 9) {
      if(turn % 2 == 0) {
         gameBoard.playerOne();
      } else {
         gameBoard.playerTwo();
      }
      turn++;
   }
}

/*
* close the application and return the number of wins in this game session to add to total
*/
public int quit() {
return wins;
}

public Stage getStage() {
   return gameStage;
}

public void restart() {
}
}