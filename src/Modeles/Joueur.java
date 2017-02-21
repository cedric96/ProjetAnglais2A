package Modeles;

public class Joueur {

	
	String name= "Joueur";
	int point=0;
	
	public Joueur() {
		// TODO Auto-generated constructor stub
	}
	
	public void setName(String s){
		name=s;	
	}
	
	public String getName(){
		return name;
	}
	
	public void setPoint(int i){
		point=i;	
	}
	
	public int getPoint(){
		return point;
	}
	
	public void augPoint(){
		point=point+5;
	}
}
