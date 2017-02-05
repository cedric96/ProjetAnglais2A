package Tests;

import java.io.File;
import java.net.URL;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class testImage extends Application{

	public testImage() {
		// TODO Auto-generated constructor stub
	}

	
	
		public void start(Stage primaryStage) { 
	         URL imageURL = getClass().getResource("image1.jpg"); 
	         Image image = new Image("file:image1.jpg"); 
	         ImageView imageView = new ImageView(image); 
	        imageView.setFitWidth(300); 
	        imageView.setFitHeight(100); 
	        imageView.preserveRatioProperty();
	        final Pane root = new Pane(); 
	        root.getChildren().add(imageView);
	        final Scene scene = new Scene(root, 350, 300); 
	        primaryStage.setTitle("Test d'affichage d'image"); 
	        primaryStage.setScene(scene); 
	        primaryStage.show(); 
	   
    } 
    public static void main(String[] args) { 
        launch(args); 
    } 

}
