package Controler;

import java.util.ArrayList;

import Modeles.Question;
import Vues.MainWindow;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;

public class questionSpecialeControler implements mainControler {
	
	MainWindow main;
	
	@FXML
	Label numero;
	@FXML
	TextArea  question;
	@FXML
	TextField  rep1;
	@FXML
	TextField  rep2;
	@FXML 
	TextField  rep3;
	@FXML
	CheckBox case1;
	@FXML
	CheckBox case2;
	@FXML
	CheckBox case3;
	@FXML
	Label erreur;
	@FXML
	ImageView imageFond;
	
	@FXML
	Label juste;
	@FXML
	Label faux;
	@FXML
	Button next;
	
	
	int numQuest;//permet de savoir a quelle question on est sur les 5 questions de 
	//chaque serie
	Question questCourante;
	boolean dejaCheck=false;//pour ne pas pouvoir ajouter de points quand il a deja fait une faute
	
	//contient la liste des checkbox presente sur la page
	ArrayList<CheckBox> listCheck=new ArrayList<CheckBox>();

	public questionSpecialeControler() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initialize(MainWindow main) {
		// TODO Auto-generated method stub
		this.main=main;
		Image image = new Image("file:images/blurred-background-7-min (1).jpeg");
		imageFond.setImage(image);
		//je remplis bien mes checkBox dans l'ArrayList 
		listCheck.add(case1);
		listCheck.add(case2);
		listCheck.add(case3);
		
		//juste.setFont((Font.loadFont("file:police/bravo.TTF", 30)));
		
	
	}
	
	public void  remplirLabel(int numQuest ){
		questCourante=main.jeu.getJeuxSpecial().get(numQuest);
		
		question.setText(questCourante.getIntitule());
		//System.out.println(questCourante.getIntitule());
		rep1.setText(questCourante.getReponse(0));
		rep2.setText(questCourante.getReponse(1));
		rep3.setText(questCourante.getReponse(2));
		//mettre une etiquette pour le numero de la question
		numero.setText("numero "+(numQuest+1));
		this.numQuest=numQuest;
		
		
	}
	
	public void check(){
		
		faux.setVisible(false);
		juste.setVisible(false);
		erreur.setVisible(false);
		
		
		if(uneCaseSelect()){ 
			if(caseSelect()==questCourante.getNumReponseJuste()==true){
				juste.setVisible(true);
				if(dejaCheck==false){
					main.jeu.Points=main.jeu.Points+5;
				}
				
			}
			else{
				faux.setVisible(true);
			}
			dejaCheck=true;
		}
		else{
			erreur.setVisible(true);;
		}
		
	}
	
	//verifie qu'on a une checkBox selectionnee
	public Boolean uneCaseSelect(){
		Boolean retour=false;
		int nbreBoxSelec=0;
		for (CheckBox box: listCheck){
			if (box.isSelected()==true){
				nbreBoxSelec++;
			}
		}
		if (nbreBoxSelec!=1){
			retour=false;
		}
		else{
			retour=true;
		}
		
		return retour;
	}
	
	//permet de retourner la case selectionnée
	public int caseSelect(){
		int numCaseSelect=-1;
		if (uneCaseSelect()){
			for (int i=0;i<3;i++){
				CheckBox box=listCheck.get(i);
				
				if (box.isSelected()==true){
					numCaseSelect=i;
				}
			}
		}
		return numCaseSelect;
		
	}
	
	public void next(){
		if (numQuest<4){
			main.changeScene(5, numQuest+1);
			
		}
		else{
			
			main.changeScene(3);
		}
		
	}
	
	//les fonctions cases "i" permettent de desactiver toutes les autres quand 
	//on clique sur une
	public void case1(){
		for (CheckBox box: listCheck){
			if (box != case1){
				box.setSelected(false);
			}
			else{
				box.setSelected(true);
			}
		}
		check();
	}
	public void case2(){
		for (CheckBox box: listCheck){
			if (box != case2){
				box.setSelected(false);
			}
			else{
				box.setSelected(true);
			}
		}
		check();
	}
	public void case3(){
		
		for (CheckBox box: listCheck){
			if (box != case3){
				box.setSelected(false);
			}
			else{
				box.setSelected(true);
			}
		}
		check();
	}
	
	public void backMenu(){
		main.changeScene(1);
	}
	
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
