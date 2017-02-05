package Tests;

import java.io.File;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class TestAudio extends Application {

	public TestAudio() {
		// TODO Auto-generated constructor stub
	}
	public void start(Stage primaryStage) { 
        final File file = new File("El perdon -Nicky Jam Ft Enrique Iglesias- Letra.mp3"); 
        final Media media = new Media(file.toURI().toString()); 
        final MediaPlayer mediaPlayer = new MediaPlayer(media); 
        Group root = new Group();
        Scene scene = new Scene(root, 300, 250, Color.LIGHTGREEN);
        Button btn = new Button();
        btn.setLayoutX(100);
        btn.setLayoutY(80);
        btn.setText("Hello World");
        btn.setOnAction(new EventHandler<ActionEvent>() {
       
            public void handle(ActionEvent event) {
            	if ((mediaPlayer.getStatus() == MediaPlayer.Status.valueOf("PLAYING"))){
            		mediaPlayer.pause();
            	}else{
            		mediaPlayer.play();
            	}
            	
                System.out.println("Hello World");
            }
        });
        root.getChildren().add(btn);        
        primaryStage.setScene(scene);
       // primaryStage.setVisible(true);
        //mediaPlayer.play(); 
        primaryStage.show();
    } 
	public static void main (String args[]){
		launch(args);
	}
	
}
