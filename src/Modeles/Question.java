package Modeles;

import java.util.ArrayList;

public class Question {
	
	private int reponseJuste;//la place de la reponse juste dans la liste des reponse
	private ArrayList<String> reponses=new ArrayList<String>();
	private String intitule="";
	private String fichier="";
	
	public Question() {
		// TODO Auto-generated constructor stub
	}
	
	//constructeur pour les musiques et les videos
	public Question(String fichier,String intitule,String rep1,String rep2,String rep3,int bonneRep) {
		// TODO Auto-generated constructor stub
		this.fichier=fichier;
		this.intitule=intitule;
		reponses.add(rep1);
		reponses.add(rep2);
		reponses.add(rep3);
		reponseJuste=bonneRep;
		
	}
	public Question(String intitule,String rep1,String rep2,String rep3,int bonneRep) {
		// TODO Auto-generated constructor stub
		this.intitule=intitule;
		reponses.add(rep1);
		reponses.add(rep2);
		reponses.add(rep3);
		reponseJuste=bonneRep;
	}
	
	
	public void setReponseJuste(int i){
		reponseJuste=i;
	}
	
	public int getNumReponseJuste(){
		return reponseJuste;
	}
	
	
	public String getReponseJuste(){
		return reponses.get(reponseJuste);
	}
	
	public String getReponse(int i){
		return reponses.get(i);
	}
	
	public void addReponse(String s){
		reponses.add(s);
	}
	
	public ArrayList<String> allReponses(){
		return reponses;
	}
	
	public String getIntitule(){
		return intitule;
	}
	public String getLienFichier(){
		return fichier;
	}

}
