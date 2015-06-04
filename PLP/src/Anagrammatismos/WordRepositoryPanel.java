package Anagrammatismos;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JPanel;


public class WordRepositoryPanel extends JPanel implements ActionListener{

	private String currentWord;
	private WordPanel myWordPanel;
	private ArrayList<Letter> availableLetters = new ArrayList<Letter>();
	private ArrayList<Letter> startingList = new ArrayList<Letter>();

	public WordRepositoryPanel(String aWord, WordPanel myWordPanel){
		super(true);

		this.setLayout(new GridLayout(1,aWord.length()));
		this.currentWord = aWord;
		this.myWordPanel = myWordPanel;

		createAllLetters();
		shuffleTheLetters();
		startingList = availableLetters;

		for(Letter lt : availableLetters)
		{
			this.add(lt);
		}
	}

	public void setCurrentWord(String aWord){
		currentWord = aWord;
	}

	public void addALetterToRepository(Letter aLetter){
		this.availableLetters.add(aLetter);
		this.add(aLetter);
		this.updateUI();
	}

	public void extractALetterFromRepository(Letter aLetter){
		this.availableLetters.remove(aLetter);
		this.remove(aLetter);
		this.updateUI();
	}


	private void createAllLetters(){

		char[] cArr = this.currentWord.toCharArray();

		for(int i=0; i < cArr.length ; i++)
		{
			Letter aLetter = new Letter(Character.toString(cArr[i]));	
			aLetter.addActionListener(this);
			this.availableLetters.add(aLetter);
		}
	}

	public void extractAllLettersFromRepositoryPanel(){
		this.removeAll();
		this.availableLetters = new ArrayList<Letter>();
		this.updateUI();
	}

	private void shuffleTheLetters(){

		//randomness
		long seed = System.nanoTime();
		Collections.shuffle(availableLetters, new Random(seed));
	}

	public void actionPerformed(ActionEvent e) {
		if(this.availableLetters.contains(e.getSource()))
		{
			int pos = availableLetters.indexOf(e.getSource());
			myWordPanel.addALetterToWordPanel(availableLetters.get(pos));
			extractALetterFromRepository(availableLetters.get(pos));


			System.out.println(myWordPanel.getShapedWord());
			System.out.println(this.myWordPanel.theWordShapedIsCorrect());
			if(this.myWordPanel.theWordShapedIsCorrect())
			{
				extractAllLettersFromRepositoryPanel();
				this.myWordPanel.extractAllLettersFromWordPanel();

				this.myWordPanel.add(new JLabel("CONGRATULATIONS! YOU HAVE FOUND THE WORD!"));
				this.updateUI();
				this.myWordPanel.updateUI();
			}

		}
		else
		{
			int pos = myWordPanel.getAvailableLetters().indexOf(e.getSource());
			this.addALetterToRepository(myWordPanel.getAvailableLetters().get(pos));
			myWordPanel.extractALetterFromWordPanel(myWordPanel.getAvailableLetters().get(pos));
		}
	}

	public void clearLettersFromWordRepository(){
		this.extractAllLettersFromRepositoryPanel();
		this.myWordPanel.extractAllLettersFromWordPanel();
		
		char[] cArr = this.currentWord.toCharArray();

		for(int i=0; i < cArr.length ; i++)
		{
			Letter aLetter = new Letter(Character.toString(cArr[i]));	
			aLetter.addActionListener(this);
			this.availableLetters.add(aLetter);
		}
		
		this.shuffleTheLetters();
		
		for(Letter lt : availableLetters)
		{
			this.add(lt);
		}
		this.updateUI();
	}

}
