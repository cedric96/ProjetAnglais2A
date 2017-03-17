package Controler;

import java.io.File;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import Vues.MainWindow;

public class VueResumeControler implements mainControler {

	MainWindow main;
	
	@FXML
	Label bravo;
	@FXML
	Label nom;
	@FXML
	Label tuAs;
	@FXML
	Label point;
	@FXML
	Button quitter;
	@FXML
	Button continuer;
	@FXML
	Button otherLevel;
	@FXML
	ImageView imageFond;
	
	public VueResumeControler() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initialize(MainWindow main) {
		// TODO Auto-generated method stub
		
		//activer ou pas bouton retry
		
		this.main=main;
		Image image = new Image("file:images/blurred-background-7-min (1).jpeg");
		imageFond.setImage(image);
		//set des diff labels
		bravo.setFont(Font.loadFont("file:police/accueil.TTF", 60));
		nom.setFont(Font.loadFont("file:police/accueil.TTF", 60));
		tuAs.setFont(Font.loadFont("file:police/accueil.TTF", 60));
		point.setFont(Font.loadFont("file:police/accueil.TTF", 60));
		
		//setText
		if (main.jeu.Points<20){
			bravo.setText("Sorry      ");
			
			
		}
		else{
			bravo.setText("Congrats      ");
			final File file = new File("fileAudio/applause.mp3"); 
	        Media son = new Media(file.toURI().toString()); 
	      MediaPlayer  mediaPlayer = new MediaPlayer(son); 
	      mediaPlayer.play();
		}
		nom.setText(main.joueur.getName()+" !");
		point.setText(""+main.jeu.Points+ "/25");
		
		
	}
	
	public void quitter(){
		main.primaryStage.close();
	}
	
	public void continuer(){
		main.changeScene(1);
	}
	
	public void otherLevel(){
		main.changeScene(2);
	}
	
	

}
