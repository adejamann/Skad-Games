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
tiles[i] = temp;
}

int count = 0;
for (int i = 0; i < 3; i++) {
   for (int j = 0; j < 3; j++) {
   this.add(tiles[count], i, j);
   count++;
   }
}
}

/**
* clear the GameBoard by setting the buttons images back to the default tile picture
*
*/
public void clear() {
}

/**
* check each button image to see if it spans 3 in a row. Add the function to determine which player won
*/
public boolean hasWon() {
}
}