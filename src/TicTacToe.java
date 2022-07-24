import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
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
import javafx.scene.layout.BorderPane;


public class TicTacToe implements Game{

    int wins = 0;
    private Stage gameStage;
    private Scene gameScene;
    private VBox root;
    private HBox options;
    private Button exit;
    private Button restart;
    private Text label;
    private Board gameBoard;
    private BorderPane center;
    //private Image pic; 
   
    public TicTacToe() {
        initialize();
    }

    private void initialize() {
        root = new VBox();
        gameStage = new Stage();
        options = new HBox();
        options.setAlignment(Pos.CENTER); 
        gameBoard = new Board();
        center = new BorderPane();

       

        Button rules = new Button("Instructions");
        restart = new Button();
        exit = new Button();
        Font font = Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 35);
        label = new Text("Win Counter: " + wins);
        label.setFont(font);
        //rules.setText("Rules");
        exit.setText("Exit");
        restart.setText("Restart");

        options.getChildren().addAll(rules, restart, exit, label);
        options.setPadding(new Insets(0, 10, 0, 10));
        root.getChildren().addAll(options, gameBoard);
        center.setCenter(root);
        center.setTop(new Text(""));
        Image tttimg = new Image("https://i.pinimg.com/564x/03/0b/b8/030bb86f8dd672d39b693cd94bfd1f4a.jpg");
        ImageView tttbg = new ImageView(tttimg);
        tttbg.setFitHeight(Screen.getPrimary().getVisualBounds().getHeight());
        tttbg.setFitWidth(Screen.getPrimary().getVisualBounds().getWidth());
        StackPane temp = new StackPane(tttbg, center);
        gameScene = new Scene(temp, 600, 600);
        gameStage.setScene(gameScene);
        gameStage.setTitle("Tic-Tac-Toe");
        gameStage.sizeToScene();
        


       
        // need to make the rules open up in a new window
        rules.setOnAction(e -> display("Instructions",
				       "1. The game is played on a grid that's 3 squares by 3 squares.\n"
				       + "2. You are X, your friend (or the computer in this case) is O. "
				       + "Players take turns putting their marks in empty squares.\n"
				       + "3. The first player to get 3 of her marks in a row (up, down, across, "
				       + "or diagonally) is the winner.\n4. When all 9 squares are full, "
				       + "the game is over. If no player has 3 marks in a row, the game ends in "
				       + "a tie."));
        rules.setAlignment(Pos.CENTER); 
        

        EventHandler<ActionEvent> restartHandler = (ActionEvent ae) -> {
            gameBoard.reset();
	};
        //fixing the functionality of the exit and restart tabs
        EventHandler<ActionEvent> exitHandler = (ActionEvent ae) -> {
            quit();
	     };


        restart.setOnAction(restartHandler);
        update();
        exit.setOnAction(exitHandler);
    }

    /**
     * @param t - this is a String representing the title of the window
     * @param m - this is a String representing the message that will show in the
     *          window
     */
    void display(String t, String m) {
        Stage insWindow = new Stage();
        insWindow.initModality(Modality.APPLICATION_MODAL);
        insWindow.setTitle(t);
        insWindow.setMinWidth(300);
        Label l1 = new Label();
        l1.setText(m);
        Button exit = new Button("Exit");
        exit.setOnAction(e -> insWindow.close());
        VBox lay = new VBox(10);
        lay.getChildren().addAll(l1, exit);
        lay.setAlignment(Pos.CENTER);
        Scene s = new Scene(lay);
        insWindow.setScene(s);
        insWindow.showAndWait();
    }
    
    /**
     * Restarts the game
     */
    public void restart() {
         /**
        //System.out.println("Restarting game...");
        TicTacToe tic = new TicTacToe();
        gameStage.hide();
        tic.getStage().show();
        initialize();
        **/
        gameBoard.reset();
    }


    /**
     * starts the game. 
     */
    public void play () {
      gameBoard.playerOne();
	 }
        
    

    /**
     * close the application and return the number of wins in this game session to add to total
     */
    public int quit() {
        gameStage.close();
        return wins;
    }

    /**
     * returns the stage to display the actual game in gamesuite
     */
    public Stage getStage() {
        return gameStage;
    }
    
    // public void setPic(Image p) {
//       pic = p;
//     }

    
    private void update() {
	Thread t1 = new Thread(() -> {
		while(true) {
          wins = gameBoard.wins;
		    label.setText("Win Counter: " + gameBoard.wins);
		}
	});
	t1.setDaemon(true);
	t1.start();
    }
}
