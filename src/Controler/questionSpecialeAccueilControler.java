package Controler;

import java.io.File;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import Modeles.Question;
import Vues.MainWindow;

public class questionSpecialeAccueilControler implements mainControler {

	MainWindow main;
	Media son;
	MediaPlayer mediaPlayer;
	@FXML
	ImageView imageFond;
	Question questCourante;
	@FXML
	Button play;
	@FXML
	Button next;
	@FXML
	Label sorry;
	
	int numQuest;
	Boolean lu=false;
	
	public questionSpecialeAccueilControler() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initialize(MainWindow main) {
		// TODO Auto-generated method stub
		this.main=main;
		Image image = new Image("file:images/blurred-background-7-min (1).jpeg");
		imageFond.setImage(image);
		sorry.setVisible(false);
	}
	
	public void  remplirLabel(int numQuest ){
		this.numQuest=numQuest;
		questCourante=main.jeu.getQuestionChoisieSpecial();
		//System.out.println("QuestionCourante :"+questCourante.getIntitule());
		//on instancie la musique
		final File file = new File("fileAudio/"+questCourante.getLienFichier()); 
        son = new Media(file.toURI().toString()); 
       mediaPlayer = new MediaPlayer(son); 
		
		//On instancie la question et les rep
	}
	
	public void play(){
		sorry.setVisible(false);
		if (lu==false){
			mediaPlayer.play();
			lu=true;
		}
		else if (lu==true){
			sorry.setVisible(true);
		}
	}
	
	public void next (){
		mediaPlayer.stop();
		System.out.println("imbecile");
		main.changeScene(5,0);
	}

}
