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


/**
 *@author Team 17
 *@version 1.0 
 */
public class GameSuite extends Application {

int totalWins = 0;

TicTacToe one = new TicTacToe();
Wordle two = new Wordle();
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
        
        //Exit button
        Button exit = new Button();
        exit.setOnAction((ActionEvent event) -> {
               Platform.exit();
        });
        Image exitapp = new Image("exitbutton.png");
        ImageView view = new ImageView(exitapp);
        view.setFitHeight(50);
        view.setPreserveRatio(true);
        exit.setPrefSize(15,15);
        exit.setGraphic(view);
        HBox exitbutton = new HBox(exit);
        exitbutton.setAlignment(Pos.BOTTOM_CENTER);

        
        // Game block Grid
        Rectangle sq1 = new Rectangle(125, 125, 125, 125);
        Image display1 = new Image("tictactoe.png");
        sq1.setFill(new ImagePattern(display1));
        
        Rectangle sq2 = new Rectangle(125, 125, 125, 125);
        Image display2 = new Image("worldle.jpg");
        sq2.setFill(new ImagePattern(display2));
        
        Rectangle sq3 = new Rectangle(125, 125, 125, 125);
        Image display3 = new Image("blackjack.jpg");
        sq3.setFill(new ImagePattern(display3));
        
        StackPane sq1stack = new StackPane();
        //setting up game1 (tictactoe)
        Button game1 = new Button();
        game1.setText("PLAY!");
        
        EventHandler<ActionEvent> launchGameOne = (ActionEvent ae) -> {
        //one = new TicTacToe();
        one.restart();
        one.getStage().show();
        };
        
        game1.setOnAction(launchGameOne);
        
        //setting up game2 (Wordle)
        Button game2 = new Button();
        game2.setText("PLAY!");
        
        EventHandler<ActionEvent> launchGameTwo = (ActionEvent ae) -> {
        two.play();
        };         
       game2.setOnAction(launchGameTwo);

        
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
        
        Text winCount = new Text("Wins: " + 0);
        winCount.setFont(Font.font("Comic Sans MS", 20));
        winCount.setFill(Color.WHITE);
        HBox win = new HBox(winCount);
        win.setAlignment(Pos.CENTER);
        VBox home = new VBox(title, grid, win, exitbutton);
        home.setSpacing(30);
        

        
        //Tabs
        BorderPane root = new BorderPane();
        StackPane homepage = new StackPane();
        homepage.getChildren().add(home);
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
        
        Thread t2 = new Thread(() -> {
		   while(true) {
         totalWins = one.wins;
		   winCount.setText("Win Counter: " + totalWins);
         //System.out.println("Wins");
		}
	});
	t2.setDaemon(true);
	t2.start();

    }
        
   }
