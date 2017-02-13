package Controler;



import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import Modeles.Question;
import Vues.MainWindow;

public class ChoiceNiveauViewControler implements mainControler {

	MainWindow main;
	
	@FXML
	Button level1;
	@FXML
	Button level2;
	@FXML 
	Button level3;
	@FXML
	Label choose;
	
	ArrayList<Question>QuestionsChoisies;
	//faireJeux(ArrayList<Question>QuestionsChoisies,int niveau)
	
	
	
	public ChoiceNiveauViewControler() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initialize(MainWindow main) {
		// TODO Auto-generated method stub
		this.main=main;
		
		/*pour l'ecriture des labels*/
		
		choose.setFont(Font.loadFont("file:police/choose.ttf", 30));
		
		/*creation du jeux de questions*/
		//main.jeu.faireJeuxEcrit();
		//main.jeu.faireJeuxOral();
		//main.jeu.faireJeuxPhoto();
		
		//on remets les points a 0
		main.jeu.Points=0;
		
		
		QuestionsChoisies=main.jeu.getQuestionChoisies();
		
	}
	
	public void level1(){
		
		//listChoice.setCellFactory(ComboBoxListCell.forListView(items));
		System.out.println("maman level 1");
		main.jeu.faireJeux(QuestionsChoisies,1);
		main.changeScene(1,0);
		
	}
	public void level2(){
		
		//listChoice.setCellFactory(ComboBoxListCell.forListView(items));
		System.out.println("maman level 2");
		main.jeu.faireJeux(QuestionsChoisies,2);
		main.changeScene(1,0);
	}
	public void level3(){
		System.out.println("maman level 3");
		main.jeu.faireJeux(QuestionsChoisies,3);
		main.changeScene(1,0);
	
		
	}
	
	//pour le retour au menu
	public void backMenu(){
		main.changeScene(1);
	}
	
	
	
	


}
