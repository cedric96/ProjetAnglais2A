package Vues;

import java.io.IOException;






import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import Modeles.Jeux;
import Modeles.Joueur;
import Vues.MainWindow;
import Controler.*;

public class MainWindow extends Application {

	public MainWindow() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Stage primaryStage;
	private BorderPane RacineAnglais;
	private AnchorPane view;
	private mainControler controller;
	public Jeux jeu=new Jeux();
	public Joueur joueur=new Joueur();
	

	@Override
    public void start(Stage primaryStage){
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("English & Culture");

        initRootLayout();

        showScene();
    }

    private void showScene() {
    	try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainWindow.class.getResource("WelcomeView.fxml"));
            view = (AnchorPane) loader.load();
            RacineAnglais.setCenter(view);
            controller = loader.getController();
            controller.initialize(this);

        } catch (IOException e) {
            	e.printStackTrace();
		}
	}

	/**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainWindow.class.getResource("RacineAnglais.fxml"));
           RacineAnglais = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(RacineAnglais);
            primaryStage.setScene(scene);
           
            primaryStage.show();
            primaryStage.setResizable(false);
            controller = loader.getController();
            controller.initialize(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void changeScene(int x){
    	if(x==1){
    		RacineAnglais.setCenter(null);
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainWindow.class.getResource("ChoiceView.fxml"));
            try {
				view = (AnchorPane) loader.load();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            RacineAnglais.setCenter(view);
            controller = loader.getController();
            controller.initialize(this);
    	}
    	else if (x==2){
    		RacineAnglais.setCenter(null);
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainWindow.class.getResource("ChoiceNiveauView.fxml"));
            try {
				view = (AnchorPane) loader.load();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            RacineAnglais.setCenter(view);
            controller = loader.getController();
            controller.initialize(this);
           
    	}
    	else if (x==3){
    		RacineAnglais.setCenter(null);
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainWindow.class.getResource("VueResume.fxml"));
            try {
				view = (AnchorPane) loader.load();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            RacineAnglais.setCenter(view);
            controller = loader.getController();
            controller.initialize(this);
           
    	}
    }
    
    public void changeScene(int x,int numQuestion){
    	if (x==1){//pour question ecrit
    		RacineAnglais.setCenter(null);
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainWindow.class.getResource("questionEcritView.fxml"));
            try {
				view = (AnchorPane) loader.load();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            RacineAnglais.setCenter(view);
            controller = loader.getController();
            controller.initialize(this);
           ((questionEcritControler) controller).remplirLabel(numQuestion);
    	
    	}
    	if (x==2){//pour question audio
    		RacineAnglais.setCenter(null);
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainWindow.class.getResource("questionOraleView.fxml"));
            try {
				view = (AnchorPane) loader.load();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            RacineAnglais.setCenter(view);
            controller = loader.getController();
            controller.initialize(this);
           ((questionOraleControler) controller).remplirLabel(numQuestion);
    	
    	}
    	if (x==3){//pour question audio
    		RacineAnglais.setCenter(null);
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainWindow.class.getResource("questionPhotoView.fxml"));
            try {
				view = (AnchorPane) loader.load();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            RacineAnglais.setCenter(view);
            controller = loader.getController();
            controller.initialize(this);
           ((questionPhotoControler) controller).remplirLabel(numQuestion);
    	
    	}
    }
    


    public static void main(String[] args){
    	
    	launch(args);
    }

}
