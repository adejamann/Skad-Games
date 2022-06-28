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
BlackJack two = new BlackJack();
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
        Text teaminfo = new Text("We are Team 17: \n\nOghenekome Onoyona: oonoyona3@gatech.edu\n\nAdeja Mann: " +
        "amann34@gatech.edu\n\nChukwudumebi Ejikeme: cejikeme3@gatech.edu\n\nSachin Rajeev: srajeev8@gatech.edu\n\nWelcome to Skad Games!!");
        teaminfo.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 20));
        teaminfo.setFill(Color.BLACK);
        HBox info = new HBox(teaminfo);
        info.setAlignment(Pos.CENTER);

        
        // Game block Grid
        Rectangle sq1 = new Rectangle(125, 125, 125, 125);
        Image display1 = new Image("tictactoe.png");
        sq1.setFill(new ImagePattern(display1));
        
        Rectangle sq2 = new Rectangle(125, 125, 125, 125);
        Image display2 = new Image("blackjack.jpg");
        sq2.setFill(new ImagePattern(display2));
        
        Rectangle sq3 = new Rectangle(125, 125, 125, 125);
        Image display3 = new Image("worldle.jpg");
        sq3.setFill(new ImagePattern(display3));
        
        StackPane sq1stack = new StackPane();
        Button game1 = new Button();
        game1.setText("PLAY!");
        
        EventHandler<ActionEvent> handler = (ActionEvent ae) -> {
        one = new TicTacToe();
        primaryStage.hide();
        one.getStage().show();
        };
        
        game1.setOnAction(handler);
     
        Button game2 = new Button();
        game2.setText("PLAY!");
        
        EventHandler<ActionEvent> handler2 = (ActionEvent ae) -> {
        two = new BlackJack();
        primaryStage.hide();
        two.getStage().show();
        };

        
        Button game3 = new Button();
        game3.setText("PLAY!");
        GridPane grid = new GridPane();
        grid.add(sq1, 0, 0, 1, 1);
        grid.add(sq2, 1, 0, 1, 1);
        grid.add(sq3, 2, 0, 1, 1);
        grid.add(game1, 0, 1, 1, 1);
        grid.add(game2, 1, 1, 1, 1);
        grid.add(game3, 2, 1, 1, 1);
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(15);
        grid.setVgap(15);
        
        //Tabs
        BorderPane root = new BorderPane();
        StackPane homepage = new StackPane();
        homepage.getChildren().addAll(title, grid);
        TabPane tabs = new TabPane();
        Tab information = new Tab("Team Information");
        information.setClosable(false);
        information.setContent(info);
        Tab games = new Tab("Games");
        games.setClosable(false);
        games.setContent(homepage);
        
        tabs.getTabs().add(information);
        tabs.getTabs().add(games);
        Tab selectedTab = tabs.getSelectionModel().getSelectedItem();
        

        root.setCenter(tabs);
        
        
        // Background
        Image img = new Image("background.jpeg");
        ImageView bg = new ImageView(img);
        bg.setFitHeight(Screen.getPrimary().getVisualBounds().getHeight());
        bg.setFitWidth(Screen.getPrimary().getVisualBounds().getWidth());
        
        //Setting Stage
        StackPane backg = new StackPane();
        backg.getChildren().addAll(bg, root);
        primaryStage.setScene(new Scene(backg, 500, 500));
        primaryStage.show();

    }
}
