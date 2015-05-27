package ergasia;

import java.util.ArrayList;

public class Matching extends Question {
	
	private ArrayList<String> stiliA = new ArrayList<String>();
	private ArrayList<String> stiliB = new ArrayList<String>();
	private ArrayList<String> antistixisi = new ArrayList<String>();
	
	public Matching(Language language, Level level, ArrayList<String> stiliA, ArrayList<String> stiliB, ArrayList<String> antistixisi){
		super(language, level);
		this.stiliA=stiliA;
		this.stiliB=stiliB;
		this.antistixisi=antistixisi;
	}
	public int answerEvaluation(ArrayList<String> answer){
		int NumOfCorrect=0;
		int i=0;
		for(String j : answer){
			if(antistixisi.get(i).equals(j)) NumOfCorrect++;
			i++;
		}
		return NumOfCorrect;
	}
	public ArrayList<String> getStiliA() {
		return stiliA;
	}
	public void setStiliA(ArrayList<String> stiliA) {
		this.stiliA = stiliA;
	}
	public ArrayList<String> getStiliB() {
		return stiliB;
	}
	public void setStiliB(ArrayList<String> stiliB) {
		this.stiliB = stiliB;
	}
	public ArrayList<String> getAntistixisi() {
		return antistixisi;
	}
	public void setAntistixisi(ArrayList<String> antistixisi) {
		this.antistixisi = antistixisi;
	}
	
	
}
