package Controler;



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
import Vues.MainWindow;

public class ChoiceViewControler implements mainControler {

	MainWindow main;
	
	@FXML
	Button ecrit;
	@FXML
	Button oral;
	@FXML 
	Button photo;
	@FXML
	Label choose;
	
	@FXML
	Label welcome;
	
	
	
	@FXML
	Label nom;
	
	
	public ChoiceViewControler() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initialize(MainWindow main) {
		// TODO Auto-generated method stub
		this.main=main;
		
		/*pour l'ecriture des labels*/
		nom.setText(main.joueur.getName()+"  !");
		nom.setFont(Font.loadFont("file:police/welcome.OTF", 80));
		welcome.setFont(Font.loadFont("file:police/welcome.OTF", 80));
		choose.setFont(Font.loadFont("file:police/choose.ttf", 30));
		
		/*creation du jeux de questions*/
		/*main.jeu.faireJeuxEcrit();
		main.jeu.faireJeuxOral();
		main.jeu.faireJeuxPhoto();*/
		
		
		
		//on remets les points a 0
		main.jeu.Points=0;
		
		
	}
	
	public void ecrit(){
		
		//listChoice.setCellFactory(ComboBoxListCell.forListView(items));
		//
		main.jeu.setQuestionChoisies(1);
		main.jeu.setTypeDeQuestions(1);
		main.changeScene(2);
		
	}
	public void oral(){
		
		//listChoice.setCellFactory(ComboBoxListCell.forListView(items));
		//main.changeScene(2,0);
		main.jeu.setQuestionChoisies(2);
		main.jeu.setTypeDeQuestions(2);
		main.changeScene(2);
	}
	public void photo(){
		//main.changeScene(3,0);
		//main.jeu.faireJeuxPhoto();
		main.jeu.setQuestionChoisies(3);
		main.jeu.setTypeDeQuestions(3);
		//listChoice.setCellFactory(ComboBoxListCell.forListView(items));
		main.changeScene(2);
	}
	
	
	


}
