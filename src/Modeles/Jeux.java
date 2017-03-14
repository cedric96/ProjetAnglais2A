package Modeles;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Jeux {

	/*les listes questions... contienent toutes les questions contenues dans le CSV
	 * 
	 */
	Question questionChoisieSpeciale;
	/*prendra les valeurs questionEcrites,questionOrales,questionOrales,questionPhoto*/
	ArrayList<Question> questionChoisies=new ArrayList<Question>();
	public int typeDeQuestions;/*poure faire un Jeux ecrit, jeux oral ou JeuxPhoto*/
	/*1 pour ecrites;2 pour oral;3 pour photo;*/
	static ArrayList<Question> questionEcrites=new ArrayList<Question>();
	static ArrayList<Question> questionOrales=new ArrayList<Question>();
	static ArrayList<Question> questionPhotos=new ArrayList<Question>();
	static ArrayList<Question> questionSpeciales=new ArrayList<Question>();
	
	static /*les listes Jeux contiennent les questions pour une partie donc 5 questions */
	ArrayList<Question> JeuxEcrits=new ArrayList<Question>();
	static ArrayList<Question> JeuxOral=new ArrayList<Question>();
	ArrayList<Question> JeuxPhotos=new ArrayList<Question>();
	ArrayList<Question>JeuxSpecial=new ArrayList<Question>();
	
	
	ArrayList<Question> niveau1=new ArrayList<Question>();
	ArrayList<Question> niveau2=new ArrayList<Question>();
	ArrayList<Question> niveau3=new ArrayList<Question>();
	
	
	
	public int Points=0;
	
	
	public Jeux(){
		// TODO Auto-generated constructor stub
		try {
			exportQuestionsEcrites("testEcrit.csv");
			exportQuestionsOrales("testAudio1.csv");
			exportQuestionsPhotos("culture.csv");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void exportQuestionsEcrites(String nomFichier) throws IOException{
		
		BufferedReader  fichierWifi= new BufferedReader (new FileReader(nomFichier));
		String lineWifi=fichierWifi.readLine();
		while (lineWifi!=null){
			String intitule=getSsid(lineWifi,0);
			String reponse1=getSsid(lineWifi,1);
			String reponse2=getSsid(lineWifi,2);
			String reponse3=getSsid(lineWifi,3);
			
			int numBonneRep=Integer.parseInt(getSsid(lineWifi,4));
			
			Question ecrite=new Question(intitule,reponse1,reponse2,reponse3,numBonneRep);
			questionEcrites.add(ecrite);
			
			lineWifi=fichierWifi.readLine();
		}
	}
	
	public  void faireJeuxEcrit(){
		JeuxEcrits.clear();
		ArrayList<Integer> nbresGenere=new ArrayList<Integer>();
		int compteur=0;
		while (compteur<5){
			int nbreAlea;
			do{
				//il y a un 5 a modifier ici
				 nbreAlea= 0 + (int)(Math.random() * ((20 - 0) + 1));
			}while(nbresGenere.contains(nbreAlea));
			nbresGenere.add(nbreAlea);
			JeuxEcrits.add(questionEcrites.get(nbreAlea));
			
			compteur++;
		}
			
	}
	
	/*test niveau*/
	public  void faireJeux(ArrayList<Question>QuestionsChoisies,int niveau){
		ArrayList<Question> typeDeJeux=new ArrayList<Question>() ;
		int compteur=0;
		int max=0;//l'indice maximum pour un niveau
		int min=0;//l'indice minimum pour un niveau
		if(typeDeQuestions==1){
			typeDeJeux=JeuxEcrits;
			if (niveau==1){
				//pour le niveau 1 on prends les quetions de 0 à 9
				max=19;min=0;
			}else if (niveau==2){
				max=39;min=20;
			}
			else if (niveau==3){
				max=59;min=40;
			}
		}else if (typeDeQuestions==2){
			typeDeJeux=JeuxOral;
			if (niveau==1){
				//pour le niveau 1 on prends les quetions de 0 à 9
				max=0;min=9;
			}else if (niveau==2){
				max=10;min=19;
			}
			else if (niveau==3){
				
				/*Ici il choisi les questions speciles 
				 * 
				 */
				typeDeJeux=JeuxSpecial;
				int compteur1=0;
				int min1=10;int max1=12;
				int nbreAlea1=min1 + (int)(Math.random() * ((max1 - min1) + 1));
				
				questionChoisieSpeciale=questionOrales.get(nbreAlea1);
				
				try {
					exportQuestionsSpeciale("fileAudio/"+questionChoisieSpeciale.getLienFichierText());
					//System.out.println(questionSpeciale.get);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				JeuxSpecial.clear();
				while (compteur1<5){
					typeDeJeux.add(questionSpeciales.get(compteur1));
					compteur1++;
				}
				
				return;
	
			}
		}else if (typeDeQuestions==3){
			typeDeJeux=JeuxPhotos;
			if (niveau==1){
				//pour le niveau 1 on prends les quetions de 0 à 9
				max=9;min=0;
			}else if (niveau==2){
				max=19;min=10;
			}
			else if (niveau==3){
				max=29;min=20;
				
			}
		}
		typeDeJeux.clear();
		ArrayList<Integer> nbresGenere=new ArrayList<Integer>();
		
		
		while (compteur<5){
			int nbreAlea;
			do{
				//il y a un 5 a modifier ici
				 nbreAlea=min + (int)(Math.random() * ((max - min) + 1));
			}while(nbresGenere.contains(nbreAlea));
			nbresGenere.add(nbreAlea);
			typeDeJeux.add(QuestionsChoisies.get(nbreAlea));
			
			compteur++;
		}
			
	}
	
	
	
public static void exportQuestionsOrales(String nomFichier) throws IOException{
		
		BufferedReader  fichierWifi= new BufferedReader (new FileReader(nomFichier));
		String lineWifi=fichierWifi.readLine();
		int compteur=0;//pou trouver le fichier a partir duquel on a les questions biz
		while (lineWifi!=null){
			Question oral;
			/*if (compteur==10 || compteur==11||compteur ==12){
				String fichier=getSsid(lineWifi,0);
				String fichierTexte=getSsid(lineWifi,1);
				oral=new Question(fichier,fichierTexte);
			}
			else{*/
				String fichier=getSsid(lineWifi,0);
				String fichierTexte=getSsid(lineWifi,1);
				String intitule=getSsid(lineWifi,2);
				String reponse1=getSsid(lineWifi,3);
				String reponse2=getSsid(lineWifi,4);
				String reponse3=getSsid(lineWifi,5);
				//System.out.println(getSsid(lineWifi,6));
				int numBonneRep=Integer.parseInt(getSsid(lineWifi,6));
				
				 oral=new Question(fichier,fichierTexte,intitule,reponse1,reponse2,reponse3,numBonneRep);
			//}
			
			questionOrales.add(oral);
			
			lineWifi=fichierWifi.readLine();
			compteur++;
		}
	}

public static void exportQuestionsSpeciale(String nomFichier) throws IOException{
	BufferedReader  fichierWifi= new BufferedReader (new FileReader(nomFichier));
	String lineWifi=fichierWifi.readLine();
	questionSpeciales.clear();
	while (lineWifi!=null){
		String intitule=getSsid(lineWifi,0);
		String reponse1=getSsid(lineWifi,1);
		String reponse2=getSsid(lineWifi,2);
		String reponse3=getSsid(lineWifi,3);
		
		int numBonneRep=Integer.parseInt(getSsid(lineWifi,4));
		
		Question ecrite=new Question(intitule,reponse1,reponse2,reponse3,numBonneRep);
		questionSpeciales.add(ecrite);
		
		lineWifi=fichierWifi.readLine();
	}
}
	public  void faireJeuxOral(){
		JeuxOral.clear();
		ArrayList<Integer> nbresGenere=new ArrayList<Integer>();
		int compteur=0;
		//a modifier
		int min=0;
		int max=6;
		while (compteur<5){
			int nbreAlea;
			do{
				//il y a un 5 a modifier ici
				nbreAlea=min + (int)(Math.random() * ((max - min) + 1));
			}while(nbresGenere.contains(nbreAlea));
			nbresGenere.add(nbreAlea);
			JeuxOral.add(questionOrales.get(nbreAlea));
			
			compteur++;
		}
			
	}
	
public static void exportQuestionsPhotos(String nomFichier) throws IOException{
		
		BufferedReader  fichierWifi= new BufferedReader (new FileReader(nomFichier));
		String lineWifi=fichierWifi.readLine();
		while (lineWifi!=null){
			System.out.println();
			String fichier=getSsid(lineWifi,0);
			String intitule=getSsid(lineWifi,1);
			String reponse1=getSsid(lineWifi,2);
			String reponse2=getSsid(lineWifi,3);
			String reponse3=getSsid(lineWifi,4);
			//System.out.println(getSsid(lineWifi,0));
			int numBonneRep=Integer.parseInt(getSsid(lineWifi,5));
			
			Question photo=new Question(fichier,intitule,reponse1,reponse2,reponse3,numBonneRep);
			questionPhotos.add(photo);
			
			lineWifi=fichierWifi.readLine();
		}
	}


	public  void faireJeuxPhoto(){
	JeuxPhotos.clear();
	ArrayList<Integer> nbresGenere=new ArrayList<Integer>();
	int compteur=0;
	//a modifier
	int min=0;
	int max=18;
	while (compteur<5){
		int nbreAlea;
		do{
			//il y a un 5 a modifier ici
			nbreAlea=min + (int)(Math.random() * ((max - min) + 1));
		}while(nbresGenere.contains(nbreAlea));
		nbresGenere.add(nbreAlea);
		JeuxPhotos.add(questionPhotos.get(nbreAlea));
		
		compteur++;
	}
		
}


	
	public ArrayList<Question> getJeuxEcrit(){
		return JeuxEcrits;
	}
	
	public ArrayList<Question> getJeuxOral(){
		return JeuxOral;
	}
	public ArrayList<Question> getJeuxSpecial(){
		return JeuxSpecial;
	}
	
	public ArrayList<Question> getJeuxPhoto(){
		return JeuxPhotos;
	}
	
	public void setQuestionChoisies(int numero){
		if (numero==1){
			questionChoisies=questionEcrites;
		}
		else if(numero==2){
			questionChoisies= questionOrales;
		}
		else if(numero==3){
			questionChoisies= questionPhotos;
		}
		
	}
	
	
	public ArrayList<Question> getQuestionChoisies(){
		return questionChoisies;
	}
	
	public void setTypeDeQuestions(int i){
		typeDeQuestions=i;
		
	}
	
	public int getTypeDeQuestions(){
		return typeDeQuestions ;
		
	}
	
	public Question getQuestionChoisieSpecial(){
		return questionChoisieSpeciale;
	}
	 
	
	/*public static void main(String args[]){
		try {
			System.out.println("1");
			exportQuestionsOrales("testAudio.csv");
			System.out.println("2");
			faireJeuxOral();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Question q :JeuxOral){
			
			System.out.println(q.getIntitule()+"  "+q.allReponses().get(0)+"   "+q.allReponses().get(1)+"  "+q.allReponses().get(2)+"  bonneRep: "+q.getReponseJuste());
		}
	}*/
	
	
	
	private static String getSsid (String line,int positionDansLigne){
		Scanner sc = new Scanner(line);
		sc.useDelimiter(";");
		int i=0;
		while (i<positionDansLigne){
			sc.next();
			i++;
		}
		String ssid=sc.next();
		sc.close();
		return ssid;
	}
}
