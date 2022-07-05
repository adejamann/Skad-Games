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
import javafx.geometry.Insets;
import java.util.Random;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;




public class WordleBoard extends GridPane {

Button[][] letters = new Button[5][6];


public WordleBoard () {
 super();
 this.setHgap(6);
 this.setVgap(6);
 this.setPadding(new Insets(300, 300, 300, 300));
 initialize();
}

protected void initialize() {
 for (int i = 0; i < 5; i++) {
     for (int j = 0; j < 6; j++) {
         letters[i][j] = new Button();
         letters[i][j].setMinWidth(50);
         letters[i][j].setStyle("-fx-background-color: #F8F8FF; -fx-border-color: #000000");
         letters[i][j].setMinHeight(50);
         this.add(letters[i][j], i, j);
     }
 } 
}

public Button[][] getArray() {
   return letters.clone();
}

//getting the scene 
// public Scene getScene() {
//    return this.getScene();
// }




}
