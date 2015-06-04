package Anagrammatismos;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;


public class WordPanel extends JPanel {

	private String currentWord;
	
	private ArrayList<Letter> availableLetters = new ArrayList<Letter>();
	
	public WordPanel(String aWord){
		super(true);
		
		currentWord = aWord;
		this.setLayout(new GridLayout(1,aWord.length()));
		
	}
	
	public void addALetterToWordPanel(Letter aLetter){
		this.availableLetters.add(aLetter);
		this.add(aLetter);
		this.updateUI();
	}
	
	public void extractALetterFromWordPanel(Letter aLetter){
		this.availableLetters.remove(aLetter);
		this.remove(aLetter);
		this.updateUI();
	}
	
	public ArrayList<Letter> getAvailableLetters(){
		return availableLetters;
	}
	
	public void setAvailableLetters(ArrayList<Letter>  aList){
		availableLetters = aList;
	}
	
	public String getShapedWord(){
		String temp = "";
		for(Letter lt : this.availableLetters){
			temp = temp + lt.getName();
		}
		
		return temp;
	}
	
	public boolean theWordShapedIsCorrect(){
		
		if(getShapedWord().equals(currentWord))
			return true;
		return false;
	}
	
	public void extractAllLettersFromWordPanel(){
		this.removeAll();
		this.availableLetters = new ArrayList<Letter>();
		this.updateUI();
	}
	
}
