package Controler;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
	
	public VueResumeControler() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initialize(MainWindow main) {
		// TODO Auto-generated method stub
		this.main=main;
		
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
		}
		nom.setText(main.joueur.getName()+" !");
		point.setText(""+main.jeu.Points+ "/30");
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
