import javafx.scene.paint.Color;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
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

/**
 *@author Adeja Mann
 *@version 1.0 
 */
public class GameSuite extends Application {
    /**
     * Creates a main method.
     * @param args String
     */
    public static void main(String[] args) {
        launch(args);
    }
    /**
     * Creates the layout and nodes for the gui.
     * @param primaryStage Stage
     */
    public void start(Stage primaryStage) {
    //Title
        primaryStage.setTitle("Skad Games");
        Text label = new Text("SKAD Games");
        label.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 65));
        label.setUnderline(true);
        label.setFill(Color.WHITE);
        label.setStrokeWidth(2);
        label.setStroke(Color.BLACK);
        HBox title = new HBox(label);
        title.setAlignment(Pos.TOP_CENTER);
        
        // Game block Grid
        Rectangle sq1 = new Rectangle(100, 100, 100, 100);
        sq1.setFill(Color.WHITE);
        Rectangle sq2 = new Rectangle(100, 100, 100, 100);
        sq2.setFill(Color.WHITE);
        Rectangle sq3 = new Rectangle(100, 100, 100, 100);
        sq3.setFill(Color.WHITE);
        GridPane grid = new GridPane();
        grid.add(sq1, 0, 0, 1, 1);
        grid.add(sq2, 1, 0, 1, 1);
        grid.add(sq3, 2, 0, 1, 1);
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(15);

        // Background
        Image img = new Image("background2.JPG");
        ImageView bg = new ImageView(img);
        bg.setFitHeight(500);
        bg.setFitWidth(500);
        
        //Setting Stage
        StackPane backg = new StackPane();
        backg.getChildren().addAll(bg, title, grid);
        primaryStage.setScene(new Scene(backg, 500, 500));
        primaryStage.show();

    }
}