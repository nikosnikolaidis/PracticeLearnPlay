package ergasia;

import java.io.Serializable;
import java.util.ArrayList;

public class MultipleChoice extends Question  implements Serializable{
	private String ekfwnisi;
	private ArrayList<String> choices = new ArrayList<String>();
	private int correctAnswer;
	
	public MultipleChoice(Language language, Level level,String ekfwnisi, ArrayList<String> choices, int correctAnswer){
		super(language,level);
	    this.choices=choices;
	    this.ekfwnisi=ekfwnisi;
	    this.correctAnswer=correctAnswer;
	}
	
		
	public int answerEvaluation(int selectedAnswer){
		if(selectedAnswer==correctAnswer) return 1;
		return 0;
	}

	public String getEkfwnisi() {
		return ekfwnisi;
	}

	public void setEkfwnisi(String ekfwnisi) {
		this.ekfwnisi = ekfwnisi;
	}

	public ArrayList<String> getChoices() {
		return choices;
	}

	public void setChoices(ArrayList<String> choices) {
		this.choices = choices;
	}

	public int getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(int correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
	
	

}
