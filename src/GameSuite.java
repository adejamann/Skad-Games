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
import javafx.scene.text.FontPosture;
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
import javafx.scene.control.TextField;


/**
 *@author Team 17
 *@version 1.0 
 */
public class GameSuite extends Application {

int totalWins = 0;
String userName = "Player";
Image avatar; 
String content = "";
Text leaderContent;
LeaderBoard lb = new LeaderBoard();

TicTacToe one = new TicTacToe();
Wordle two = new Wordle();
BlackJack three = new BlackJack();
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
        
        EventHandler<ActionEvent> launchGameThree = (ActionEvent ae) -> {
        three.play();
        };         
       game3.setOnAction(launchGameThree);

        
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
        
        //tab with team information
        Tab information = new Tab("Team Information");
        information.setClosable(false);
        information.setContent(info);
        
        //tab with games
        Tab games = new Tab("Games");
        games.setClosable(false);
        games.setContent(homepage);
        
        //tab with leader board
        Tab leader = new Tab("LeaderBoard");
        BorderPane leaderRoot = new BorderPane();
        lb.read();
        for (LeaderBoard.Player p: lb.leaderboard) {
         content = content + p.getName() + ": " + p.getScore() + "\n";
        }
        leaderContent = new Text(content);
        leaderContent.setFont(Font.font("Comic Sans MS", 20));
        Button update = new Button ("Update LeaderBoard");
         EventHandler<ActionEvent> leaderUpdate = (ActionEvent ae) -> {
            lb.insert(userName, totalWins);
            lb.update();
            lb.clear();
            lb.read();
            content = "";
           for (int i = 0; i < 10; i++) {
           LeaderBoard.Player p = lb.leaderboard.get(i);
          content = content + p.getName() + ": " + p.getScore() + "\n";
         }
         leaderContent.setText(content);
         System.out.println("Done");
        };         
       update.setOnAction(leaderUpdate);

        update.setAlignment(Pos.CENTER);
        leaderRoot.setTop(update);
        leaderRoot.setCenter(leaderContent);
        //leaderRoot.getChildren().addAll(update, leaderContent);
        leader.setContent(leaderRoot);
        leader.setClosable(false);
        
        //tab with User profile
        Tab profile = new Tab("Profile");
        profile.setClosable(false);
            // avator choices
        Label pic = new Label("Choose your gamer avatar"); 
        pic.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 20));
        Image img2;
        ImageView view2;
        
        // different avatars
        Button av1 = new Button(); 
        img2 = new Image("av1.jpg");
        view2 = new ImageView(img2);
        view2.setFitHeight(80);
        view2.setPreserveRatio(true);
        av1.setGraphic(view2); 
        
        Button av2 = new Button(); 
        img2 = new Image("av2.png");
        view2 = new ImageView(img2);
        view2.setFitHeight(80);
        view2.setPreserveRatio(true);
        av2.setGraphic(view2);
        
        Button av3 = new Button();
        img2 = new Image("av3.jpg");
        view2 = new ImageView(img2);
        view2.setFitHeight(80);
        view2.setPreserveRatio(true);
        av3.setGraphic(view2);
        
        Button av4 = new Button();
        img2 = new Image("av4.jpg");
        view2 = new ImageView(img2);
        view2.setFitHeight(80);
        view2.setPreserveRatio(true);
        av4.setGraphic(view2);
        
        // what happens when each button is clicked? 
        EventHandler<ActionEvent> setAv1 = (ActionEvent ae) -> {
         avatar = new Image("av1.jpg");
         av2.setDisable(true);
         av3.setDisable(true);
         av4.setDisable(true);
         // one.setPic(avatar);
//          two.setPic(avatar);
//          three.setPic(avatar);
        };
        av1.setOnAction(setAv1);
        
        EventHandler<ActionEvent> setAv2 = (ActionEvent ae) -> {
         avatar = new Image("av2.png");
         av1.setDisable(true);
         av3.setDisable(true);
         av4.setDisable(true);
         // one.setPic(avatar);
//          two.setPic(avatar);
//          three.setPic(avatar);
        };
        av2.setOnAction(setAv2);
        
        EventHandler<ActionEvent> setAv3 = (ActionEvent ae) -> {
         avatar = new Image("av3.jpg");
         av1.setDisable(true);
         av2.setDisable(true);
         av4.setDisable(true);
         // one.setPic(avatar);
//          two.setPic(avatar);
//          three.setPic(avatar);
        };
        av3.setOnAction(setAv3);
        
        EventHandler<ActionEvent> setAv4 = (ActionEvent ae) -> {
         avatar = new Image("av4.jpg");
         av1.setDisable(true);
         av2.setDisable(true);
         av3.setDisable(true);
         // one.setPic(avatar);
//          two.setPic(avatar);
//          three.setPic(avatar);
        };
        av4.setOnAction(setAv4);
        
        HBox avaPics = new HBox(av1, av2, av3, av4); // all the avatar options
        avaPics.setSpacing(10.0);
        avaPics.setAlignment(Pos.CENTER);
        
        VBox picAva = new VBox(pic, avaPics); 
        picAva.setSpacing(5.0);
        picAva.setAlignment(Pos.CENTER);
        
        Label gamerName1 = new Label("What's your gamer name: ");
        gamerName1.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 20));
        TextField gamerName2 = new TextField();
        Button enterButton = new Button("Enter");
        EventHandler<ActionEvent> getName = (ActionEvent ae) -> {
         userName = gamerName2.getText();
         System.out.println("Name changed");
        };
        enterButton.setOnAction(getName);
        HBox gamerNameE = new HBox(gamerName1, gamerName2, enterButton);
        gamerNameE.setAlignment(Pos.CENTER);
        
        VBox everything = new VBox(picAva, gamerNameE);
        everything.setSpacing(15.0);
        everything.setAlignment(Pos.CENTER);

        profile.setContent(everything); 
        
        
        
        // getting all tabs 
        tabs.getTabs().add(information);
        tabs.getTabs().add(games);
        tabs.getTabs().add(leader);
        tabs.getTabs().add(profile);
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
         totalWins = one.wins + two.wins + three.wins;
		   winCount.setText("Win Counter: " + totalWins);
         //System.out.println("Wins");
		}
	});
	t2.setDaemon(true);
	t2.start();

    }
        
   }
