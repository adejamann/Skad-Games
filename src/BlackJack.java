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
import javafx.scene.text.FontPosture;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.geometry.Insets;
import javafx.application.Platform;




public class BlackJack implements Game {
    //total wins for the game
    int wins = 0;
    private Stage gameStage;
    private HBox options;
    private Button exit;
    private Button restart;
    private Text label;
    private BorderPane bp;
    private Dealer d;
    private Player p;
    private HBox dealer;
    private HBox player;
    Text label1;
    Text label2;
    Card twoD;
    //private Image pic; 


    public BlackJack() {
	gameStage = new Stage();
	gameStage.setTitle("BlackJack");
	initialize();
	d = new Dealer();
	p = new Player();

    }
      
    /**
     * returns the stage to display the actual game in gamesuite
     */
    public Stage getStage() {
        return gameStage;
    }
    
    public void restart() {
         d.addDeck(d.getHand());
         d.addDeck(p.returnHand());
         twoD.show();
         d.resetHand();
         p.reset();
         System.out.println(d.getDeck().size()); 
         play();
         //player.getChildren().clear();
         //dealer.getChildren().clear();
         /*
         Card oneD = d.deal();
	      d.addHand(oneD);
         label1.setText("Dealer's Hand: " + d.returnValue()); 
	      twoD = d.deal(); 
         twoD.hide();  
	      d.addHand(twoD);
         dealer.getChildren().addAll(oneD, twoD);
         
         Card oneP = d.deal();
	      p.addHand(oneP);
	      Card twoP = d.deal();   
	      p.addHand(twoP); 
         label2.setText("Player's Hand: " + p.returnValue());
         player.getChildren().addAll(oneP, twoP);
         */
    }
    
    public int quit() {
    d.addDeck(d.getHand());
         d.addDeck(p.returnHand());
         twoD.show();
         d.resetHand();
         p.reset();
   gameStage.close();
	return wins;

    }
    
    public void play() {
	Card oneD = d.deal();
	d.addHand(oneD);
   label1 = new Text("Dealer's Hand: " + d.returnValue()); 
	twoD = d.deal(); 
   twoD.hide();  
	d.addHand(twoD);
   label1.setFont(Font.font("Comic Sans MS", 35));
   label1.setFill(Color.WHITE);  
	dealer = new HBox(oneD, twoD);       
	dealer.setAlignment(Pos.CENTER);
	dealer.setPadding(new Insets(10, 50, 50, 50));
	Card oneP = d.deal();
	p.addHand(oneP);
	Card twoP = d.deal();   
	p.addHand(twoP); 
   label2 = new Text("Player's Hand: " + p.returnValue());
   label2.setFont(Font.font("Comic Sans MS", 35));
   label2.setFill(Color.WHITE);       
	player = new HBox(oneP, twoP);
	player.setAlignment(Pos.CENTER);
   System.out.println("suit: " + oneD.suit + " rank: " + oneD.rank);
   System.out.println("suit: " + twoD.suit + " rank: " + twoD.rank);
   System.out.println("suit: " + oneP.suit + " rank: " + oneP.rank);
   System.out.println("suit: " + twoP.suit + " rank: " + twoP.rank);


	VBox box = new VBox(label1, dealer, label2, player);
	box.setAlignment(Pos.CENTER);
	bp = initialize();
	bp.setCenter(box);
	BackgroundFill background_fill = new BackgroundFill(Color.GREEN, 
							    CornerRadii.EMPTY, Insets.EMPTY);
  
	Background background = new Background(background_fill);
	bp.setBackground(background);
	Scene scene = new Scene(bp, 550, 610);
	gameStage.setScene(scene);
	gameStage.show();

    }

      
    private BorderPane initialize() {
	// creating the button for the instructions  
	Button rules = new Button("Instructions"); 
	rules.setOnAction(e -> display("Instructions",
				       "1. The game is played between 2 to 7 players and uses a 52-card deck. All the number cards score the value indicated on them.\n The face cards(Jack, Queen, and King) score 10 points and the Ace can either be 11 points or 1.\n"
				       + "2. All players place their bets and deal two cards face-up. "
				       + "The dealer receives two cards, one face-up and the other face-down.\n"
				       + "3. Each player is given a chance to draw more cards. The players can either call 'hit' or 'stand'. "
				       + "If the player calls out 'hit', they are given an extra card. They can call out 'hit' again or 'stand' if they do not want to draw any more cards\n."
				       + "The player can call 'hit' as many times as they want, but have to ain not to 'bust' (exceed a total of 21). \n" 
				       + "4. If the player busts, they immediately lose their bet.\n"
				       + "5. After each player has played and either stood or busted, the dealer takes their turn. They can either 'hit' or 'stand'.\n"
				       + "6. If the dealer's hand exceeds 21, all players who did not bust win immediately - their bet is returned along with a matching amount from the bank of the dealer.\n"
				       + "7. If the dealer reaches a valid hand, the cards are totalled and eahc player's hand is compared to the dealer's.\n"
				       + "8. If the player scored higher than the dealer, they win. If the player ties with the dealer, the original bet is returned to the player. Otherwise, the player loses their bet.\n"
				       + "9. A perfect hand combines an ace with a 10 (Jack, Queen, or King) and is known an a 'Blackjack'. \n"
				       ));
	rules.setAlignment(Pos.CENTER);
      
	options = new HBox();
	options.setAlignment(Pos.CENTER); 
     
	restart = new Button();
        exit = new Button();
        Font font = Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 20);
        label = new Text("Win Counter: " + wins);
        label.setFont(font);
        
        exit.setText("Exit");
        restart.setText("Restart");
        
        EventHandler<ActionEvent> restartHandler = (ActionEvent ae) -> {
            restart();
	};
        //fixing the functionality of the exit and restart tabs
        EventHandler<ActionEvent> exitHandler = (ActionEvent ae) -> {
            quit();
	};


        restart.setOnAction(restartHandler);
        exit.setOnAction(exitHandler);
        HBox game = new HBox();
        game.getChildren().addAll(label, rules, restart, exit);
        
        HBox gameButtons = new HBox();
        
        Button hit = new Button();
        EventHandler<ActionEvent> hitHandler = (ActionEvent ae) -> {
            Card c = d.deal();
            p.addHand(c);
            player.getChildren().addAll(c);
            label2.setText("Players's Hand: " + p.returnValue()); 
            if (p.returnValue() > 21) {
		display("", "You lose");
      restart();
            }
            
	};
        hit.setOnAction(hitHandler);
        Button stand = new Button();
        EventHandler<ActionEvent> standHandler = (ActionEvent ae) -> {
        twoD.show();
        label1.setText("Dealer's Hand: " + d.returnValue());
        Runnable task = () -> {   
              while (d.returnValue() < 17) {
		            Card c = d.deal();
		            d.addHand(c);
                  Platform.runLater(() -> {
                    label1.setText("Dealer's Hand: " + d.returnValue());        
		               dealer.getChildren().addAll(c);
            });
                   try
         		    {
         			Thread.sleep(800);   
         		    }
         		catch(InterruptedException e)
         		    {
         			e.printStackTrace();
         		    } 
                  }
               Platform.runLater(() -> {            
                if (d.returnValue() > 21) {
      		display("", "You Win");
            wins++;
             label.setText("Win Counter: " + wins);
                  } else if (d.returnValue() > p.returnValue()) {
      		display("", "You Lose");
                  } else if  (d.returnValue() < p.returnValue()) {
      		display("", "You Win");
               wins++;
             label.setText("Win Counter: " + wins);
                  } else {
      		display("", "Draw");
                  }
                  restart();
                           
        });
        };
        Thread thread = new Thread(task);
        thread.setDaemon(true);
        thread.start();
                    
	};
        stand.setOnAction(standHandler);
        hit.setText("Hit");
        stand.setText("Stand");
        
        gameButtons.getChildren().addAll(hit, stand);

        
        options.getChildren().addAll(game, gameButtons);
        bp = new BorderPane();
        bp.setTop(options);
        return bp;
        

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
    
    // public void setPic(Image p) {
//      pic = p;
//     }




}
