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


/**
 *@author Team 17
 *@version 1.0 
 */
public class GameSuite extends Application {

int totalWins = 0;

TicTacToe one = new TicTacToe();
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
        primaryStage.setTitle("Game Suite");
        Text label = new Text("SKAD GAMES");
        label.setFont(Font.font("Comic Sans MS", 65));
        label.setFill(Color.WHITE);
        HBox title = new HBox(label);
        title.setAlignment(Pos.TOP_CENTER);
        Text teaminfo = new Text("We are Team 17 \nOur Team includes: \nOghenekome Onoyona: oonoyona3@gatech.edu\nAdeja Mann; amann34@gatech.edu\nChukwudumebi Ejikeme: cejikeme3@gatech.edu\nSachin Rajeev: srajeev8@gatech.edu");
        teaminfo.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 15));
        teaminfo.setFill(Color.BLACK);
        HBox info = new HBox(teaminfo);
        info.setAlignment(Pos.BOTTOM_CENTER);
        
        //Tabs
        
        
        // Game block Grid
        Rectangle sq1 = new Rectangle(100, 100, 100, 100);
        sq1.setFill(Color.WHITE);
        Rectangle sq2 = new Rectangle(100, 100, 100, 100);
        sq2.setFill(Color.WHITE);
        Rectangle sq3 = new Rectangle(100, 100, 100, 100);
        sq3.setFill(Color.WHITE);
        StackPane sq1stack = new StackPane();
        Text sq1label = new Text("BlackJack");
        sq1label.setFont(Font.font("Comic Sans MS", FontWeight.EXTRA_BOLD, 20));
        sq1stack.getChildren().addAll(sq1, sq1label);
        StackPane sq2stack = new StackPane();
        Text sq2label = new Text("Wordle");
        sq2label.setFont(Font.font("Comic Sans MS", FontWeight.EXTRA_BOLD, 20));
        sq2stack.getChildren().addAll(sq2, sq2label);
        StackPane sq3stack = new StackPane();
        Text sq3label = new Text("Tic-Tac-Toe");
        sq3label.setFont(Font.font("Comic Sans MS", FontWeight.EXTRA_BOLD, 15));
        sq3stack.getChildren().addAll(sq3, sq3label);
        Button game1 = new Button();
        game1.setText("Tic-Tac-Toe");
        
        EventHandler<ActionEvent> handler = (ActionEvent ae) -> {
        one = new TicTacToe();
       //primaryStage.hide();
        one.getStage().show();
         };
        
        game1.setOnAction(handler);
        Button game2 = new Button();
        game2.setText("Play");
        Button game3 = new Button();
        game3.setText("Play");
        GridPane grid = new GridPane();
        grid.add(sq1stack, 0, 0, 1, 1);
        grid.add(sq2stack, 1, 0, 1, 1);
        grid.add(sq3stack, 2, 0, 1, 1);
        grid.add(game1, 0, 1, 1, 1);
        grid.add(game2, 1, 1, 1, 1);
        grid.add(game3, 2, 1, 1, 1);
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(15);
        grid.setVgap(15);
        
        

        // Background
        Image img = new Image("background.jpeg");
        ImageView bg = new ImageView(img);
        bg.setFitHeight(Screen.getPrimary().getVisualBounds().getHeight());
        bg.setFitWidth(Screen.getPrimary().getVisualBounds().getWidth());
        
        //Setting Stage
        StackPane backg = new StackPane();
        backg.getChildren().addAll(bg, title,info, grid);
        primaryStage.setScene(new Scene(backg, 500, 500));
        primaryStage.show();

    }
}
