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
import javafx.scene.control.Alert;
import java.util.Random;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;


public class Wordle implements Game{

public int counter = 0;
private WordleBoard gameBoard;
private Stage gameStage;
private Text labelWins;
public String start = "";
public String attempt;

    public Wordle() {
    gameStage = new Stage();
    gameStage.setTitle("Wordle");
    }

    /**
     * returns the stage to display the actual game in gamesuite
     */
    public Stage getStage() {
        return gameStage;
    }


    /**
     * @return BorderPane -  returns a border 
     *         containing buttons and title
     */
    BorderPane getButtonMenu() {
        Button input = new Button("Enter");
        
        Label name = new Label("WORDLE");
        name.setFont(Font.font("Comic Sans MS", 30));
        
       
        Button rules = new Button("rules");
        rules.setOnAction(e -> display("Instructions",
				       "1. The game is played on a grid that's 5 squares by 6 squares.\n"
				       + "2. You have 5 tries to guess the 6 letter word. \n "
				       + "3. A Green light means that the letter is in word and in the correct position. \n"
				       + "4. A Yellow light means the letter is in the word, but not in the correct position. \n"
				       + "5. Try to Guess the word as early as possible to brag to your friends"
				       + "!"));
        rules.setAlignment(Pos.CENTER); 
        //A button that will call the restart method
         Button restart = new Button("Restart");
         restart.setOnAction((ActionEvent e) -> {
            restartgame();
         });
         
        //A button that will exit the game
        Button exit = new Button("Exit");
        exit.setOnAction((ActionEvent e) -> {
            quit();
            
        });
        
        Button enter = new Button("Enter");
        enter.setOnAction((ActionEvent e) -> {
            guess();
            if (start.equalsIgnoreCase(guess)) {
                display("Wonderful!", "Great job! You got the word in " + counter + " attempts!");
                restartgame();
            }
            start = "";
            if (counter >= 6) {
                display("Failed", "Unfortunately, you ran out of guesses :(\nBetter luck next time!");
                restartgame();
            }
        });
        
        labelWins = new Text("Win Counter: " + wins);

        
        HBox options = new HBox(10);
        options.setSpacing(5);
        options.getChildren().addAll(rules, restart, exit, labelWins);
        options.setPadding(new Insets(0, 10, 0, 10));
        options.setAlignment(Pos.TOP_CENTER);
        
        
        VBox title = new VBox();
        title.getChildren().addAll(options, name);
        title.setAlignment(Pos.TOP_CENTER);
        title.setPadding(new Insets(50, 50, 50, 50));
       
        VBox stacking = new VBox();
        stacking.getChildren().addAll(input);
        stacking.setAlignment(Pos.BOTTOM_CENTER);
        BorderPane root = new BorderPane();
        root.setTop(title);
        root.setBottom(stacking);
        return root;
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
    
    public void guess() {
        for (int i = 0; i < 5; i++) {
            if (attempt.charAt(i) == start.charAt(i)) {
                letterArr[i][counter].setStyle("-fx-background-color: chartreuse; -fx-border-color: #000000");
            } else if (attempt.contains(start.subSequence(i, i+1))) {
                letterArr[i][counter].setStyle("-fx-background-color: goldenrod; -fx-border-color: #000000");
            } else {
                letterArr[i][counter].setStyle("-fx-background-color: lightgray; -fx-border-color: #000000");
            }
        }
        counter++;
    }

   //Method that will restart the game
    public void restartgame() {
      counter = 0;
      start = "";
      System.out.println("Game Restarting...");
      start(stage);
    }

    
    public void play() {
        gameBoard = new WordleBoard();
        HBox hbox = new HBox(10);
        hbox.setAlignment(Pos.CENTER);
        hbox.getChildren().addAll(gameBoard);
        StackPane sp = new StackPane();
        sp.getChildren().addAll(hbox, getButtonMenu());
        Scene scene = new Scene(sp, 550, 610);
        gameStage.setScene(scene);
        gameStage.show();

    }
     @Override
    public void start(Stage primary) {
        stage = primary;
        primary.setTitle("Welcome to Wordle");
        Random rand = new Random();
        int n = rand.nextInt(Words.list.size());
        playerGuess = (Words.list).get(n).toUpperCase();
    }
    
    
    public int quit() {
        gameStage.close();
        return counter;
    }
}


