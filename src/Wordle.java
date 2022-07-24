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
import javafx.scene.text.TextAlignment;

public class Wordle implements Game {

    public int wins = 0;
    public int counter = 0;
    private WordleBoard gameBoard;
    private Stage gameStage;
    private Text labelWins;
    public String userGuess = "";
    public String word = "";
    public String attempt;
    private int count = 0;
    // private Image pic;
//     private ImageView view = new ImageView(pic);
 
    
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
        input.setOnAction((ActionEvent e) -> {
            if (userGuess.length() < 5) {
                     display("", "Words must be 5 characters or longer");
                  } else {
                        checkAnswer();
                        if (userGuess.equalsIgnoreCase(word)) {
                            display("Win", "You got the word in " + count + " tries");
                            wins++;
                            labelWins.setText("Win Counter: " + wins);
                            restart();
                        }
                        userGuess = "";
                        if (count >= 6) {
                            display("Fail", "The word was " + word);
                            restart();
                        }
                 }

        });

        
        Label name = new Label("WORDLE");
        name.setFont(Font.font("Comic Sans MS", 30));
        
       
        Button rules = new Button("Instruction");
        rules.setOnAction(e -> display("Instructions",
				       "1. The game is played on a grid that's 5 squares by 6 squares.\n"
				       + "2. You have 5 tries to guess the 6 letter word. \n"
				       + "3. A Green light means that the letter is in word and in the correct position. \n"
				       + "4. A Yellow light means the letter is in the word, but not in the correct position. \n"
				       + "5. Try to Guess the word as early as possible to brag to your friends"
				       + "!"));
        rules.setAlignment(Pos.CENTER); 
        Button reset = new Button("Restart");
        reset.setOnAction((ActionEvent e) -> {
            restart();
        });
        Button exit = new Button("Exit");
        exit.setOnAction((ActionEvent e) -> {
            restart();
            quit();
            
        });
        
        //hint button
        Button hint = new Button("Hint");
        hint.setOnAction(e -> display("Hint", "This word begins with: " + word.charAt(0) + " and ends with: " + word.charAt(4)));

        
        labelWins = new Text("Win Counter: " + wins);
        labelWins.setFont(Font.font("Comic Sans MS", 20));
        labelWins.setFill(Color.BLACK);
        labelWins.setTextAlignment(TextAlignment.CENTER);

        
        HBox options = new HBox(10);
        options.setSpacing(5);
        options.getChildren().addAll(rules, reset, exit, hint);
        options.setPadding(new Insets(0, 10, 0, 10));
        options.setAlignment(Pos.TOP_CENTER);
        
        
        VBox title = new VBox();
        title.getChildren().addAll(labelWins, options, name);
        title.setAlignment(Pos.TOP_CENTER);
        title.setPadding(new Insets(50, 50, 50, 50));
       
        BorderPane root = new BorderPane();
        root.setTop(title);
        HBox inputH = new HBox(input);
        inputH.setAlignment(Pos.TOP_CENTER);
        root.setBottom(inputH);
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

    /**
     *
     */
    
    
     public void checkAnswer() {
        for (int i = 0; i < 5; i++) {
            if (word.charAt(i) == userGuess.charAt(i)) {
                gameBoard.getArray()[i][count].setStyle("-fx-background-color: chartreuse; -fx-border-color: #000000");
            } else if (word.contains(userGuess.subSequence(i, i + 1))) {
                gameBoard.getArray()[i][count].setStyle("-fx-background-color: goldenrod; -fx-border-color: #000000");
            } else {
                gameBoard.getArray()[i][count].setStyle("-fx-background-color: lightgray; -fx-border-color: #000000");
            }
        }
        count += 1;
    }


    
    public void play() {
        gameBoard = new WordleBoard();
        HBox hbox = new HBox(10);
        hbox.setAlignment(Pos.CENTER);
        hbox.getChildren().addAll(gameBoard);
        StackPane sp = new StackPane();
        word = new Word().word;
        word = word.toUpperCase();
        System.out.println(word);
        Image img = new Image("https://img.freepik.com/premium-photo/pink-purple-blue-pastel-ombre-digital-paper-watercolor-gradient-watercolour-background-texture_199112-214.jpg?w=360");
        ImageView bg = new ImageView(img);
        bg.setFitHeight(Screen.getPrimary().getVisualBounds().getHeight());
        bg.setFitWidth(Screen.getPrimary().getVisualBounds().getWidth());
        sp.getChildren().addAll(bg, hbox, getButtonMenu());
        Scene scene = new Scene(sp, 550, 610);
        
        gameStage.setScene(scene);
        gameStage.show();
        

        
        EventHandler<KeyEvent> userinput = (KeyEvent e) -> {
             String input = e.getCode().toString();
                if (e.getCode() == KeyCode.ENTER) {
                  if (userGuess.length() < 5) {
                     display("Error", "Words must be 5 characters or longer");
                  } else {
                        checkAnswer();
                        if (userGuess.equalsIgnoreCase(word)) {
                            display("Win", "You got the word in " + count + " tries");
                            wins++;
                            labelWins.setText("Win Counter: " + wins);
                            restart();
                        }
                        userGuess = "";
                        if (count >= 6) {
                            display("Fail", "The word was " + word);
                            restart();
                        }
                 }
                } else if (e.getCode() == KeyCode.BACK_SPACE) {
                    if (userGuess.length() > 0) {
                        gameBoard.getArray()[userGuess.length() - 1][count].setText("");
                        userGuess = userGuess.substring(0, userGuess.length() - 1);
                    }
                } else if (userGuess.length() < 5 && input.length() == 1) {
                    if (!Character.isDigit(input.charAt(0)) && !input.equals("")) {
                        userGuess = userGuess + input;
                        gameBoard.getArray()[userGuess.length() - 1][count].setText(input);
                    }
                } else if (userGuess.length() == 5 && input.length() == 1) {
                    Alert a = new Alert(Alert.AlertType.ERROR, "This input is not allowed!");
                    a.show();
                }
            };
        scene.setOnKeyPressed(userinput);

    }
    
    public int quit() {
        gameStage.close();
        return wins;
    }
    
    public void restart() {
        gameBoard.reset();
        word = new Word().word;
        word = word.toUpperCase();
        System.out.println(word);
        count = 0;
        userGuess = "";
        
    }
    
    // public void setPic(Image p) {
//       pic = p;
//     }
    
    
}


