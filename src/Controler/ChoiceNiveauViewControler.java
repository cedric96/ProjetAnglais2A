package Controler;



import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
	
	@FXML
	MenuItem level;
	@FXML
	MenuItem exercice;
	@FXML
	MenuButton ReturnTo;
	@FXML
	ImageView imageFond;
	
	ArrayList<Question>QuestionsChoisies;
	//faireJeux(ArrayList<Question>QuestionsChoisies,int niveau)
	
	
	
	public ChoiceNiveauViewControler() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initialize(MainWindow main) {
		// TODO Auto-generated method stub
		this.main=main;
		Image image = new Image("file:images/blurred-background-7-min (1).jpeg");
		imageFond.setImage(image);
		/*pour l'ecriture des labels*/
		
		choose.setFont(Font.loadFont("file:police/choose.ttf", 30));
		
		/*creation du jeux de questions*/
		//main.jeu.faireJeuxEcrit();
		//main.jeu.faireJeuxOral();
		//main.jeu.faireJeuxPhoto();
		
		//on remets les points a 0
		main.jeu.Points=0;
		
		if (main.jeu.typeDeQuestions==3){//on a choisi la culture
			level1.setText("History");
			level2.setText("Geography");
			level3.setText("Fun Facts");
			choose.setText("CHOOSE A CATEGORY");
			
		}
		
		else if (main.jeu.typeDeQuestions==2){//on a choisi le listenning
			//level2.setVisible(false);
			//level2.setDisable(true);
			
			level1.setText("Short recording");
			//level3.setLayoutY(level2.getLayoutY()-3);
			level2.setText("Prononciation");
			level3.setText("Long recording");
			
		}
		
		
		QuestionsChoisies=main.jeu.getQuestionChoisies();
		
	}
	
	public void level1(){
		
		//listChoice.setCellFactory(ComboBoxListCell.forListView(items));
		
		main.jeu.faireJeux(QuestionsChoisies,1);
		main.changeScene(main.jeu.getTypeDeQuestions(),0);
		
	}
	public void level2(){
		
		//listChoice.setCellFactory(ComboBoxListCell.forListView(items));
		main.jeu.faireJeux(QuestionsChoisies,2);
		if (main.jeu.getTypeDeQuestions()!=2){
			
			main.changeScene(main.jeu.getTypeDeQuestions(),0);
		}
		else{
			
			main.changeScene(6,0);
		}
		
	}
	public void level3(){
		if (main.jeu.getTypeDeQuestions()!=2){
		
		main.jeu.faireJeux(QuestionsChoisies,3);
		main.changeScene(main.jeu.getTypeDeQuestions(),0);
	
		}else{//questionSpeciale
			main.jeu.faireJeux(QuestionsChoisies,3);
			main.changeScene(4,0);
		}
	}
	
	//pour le retour au menu
	
	
	public void level(){
		main.changeScene(2);
		
	}
	
	public void exercice(){
		main.changeScene(1);
	}
	public void player(){
		main.changeScene(0);
	}
	
	


}
