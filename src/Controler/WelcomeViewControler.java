package Controler;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import Vues.MainWindow;

public class WelcomeViewControler implements mainControler{

	MainWindow main;
	@FXML
	private Button next;
	
	@FXML
	private Label erreur;
	//@FXML
	//Label welcome1;
	@FXML
	Label welcome2;
	
	@FXML
	ImageView imageFond;
	@FXML
	TextField name;
	public WelcomeViewControler() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initialize(MainWindow main) {
		this.main=main;
		Image image = new Image("file:images/blurred-background-7-min (1).jpeg");
		imageFond.setImage(image);
		//welcome1.setText("  Boosting your Culture");
		welcome2.setText(" Do You Speak ENGLISH ? ");
	
		
		
		//welcome1.setFont(Font.loadFont("file:police/accueil.TTF", 40));
		//welcome2.setFont(Font.loadFont("file:police/accueil.TTF", 40));
		
	//	welcome1.setWrapText(true);
		
	}
	
	
	@FXML
	public void next(){
		if (name.getText().isEmpty()==false){
			main.joueur.setName(name.getText());
			main.changeScene(1);
		}
		else{
			erreur.setText("Please ! enter your surname");
			
		}
		
		
	}
	
	public void onEnter(){
		next();
	}
}
