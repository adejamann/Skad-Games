import javafx.event.Event;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.ImagePattern;
import javafx.scene.image.Image;
import javafx.application.Application;
import javafx.stage.Stage;

//Method that will restart the game
public void restartgame() {
count = 0;
begin = "";
System.out.println("Game Restarting...");
start(stage);


//A button that will call the restart method
Button restart = new Button("Restart);
restart.setOnAction((ActionEvent e) -> {
   restartgame();
});
