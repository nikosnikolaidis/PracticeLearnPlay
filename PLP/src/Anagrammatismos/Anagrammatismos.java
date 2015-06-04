package Anagrammatismos;
import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import ergasia.Language;
import ergasia.Main;

public class Anagrammatismos {

	private String currentWord;
	private ArrayList<String> poolOfWords = new ArrayList<String>();
	
	
	public Anagrammatismos(){
		
		createPoolOfWords();
	}

	
	
	public void createPoolOfWords(){
		ArrayList<Language> languages=Main.ser.LanguageDeserializing();   	//dimiourgia le3ikou gia xrisimopoiish
		ArrayList<String> le3iko =new ArrayList<String>();
		for(Language l:languages){
			if(l.getName().equals(Main.ser.getDataHolder().getStudentNow().getTeacher().getLanguage().getName())){
				le3iko=l.getDictionary();
			}
		}
		
		poolOfWords = le3iko;
		
	}
	
	public String getRandomWord(){
		
		int ran=new Random().nextInt(poolOfWords.size());	//kai pernei tixea le3i
		String randomLe3="";
		int i=0;
		for(String str: poolOfWords){
			if(i==ran){
				randomLe3= str;
			}
			i++;
		}
		
		
		return randomLe3;
	}
	
	public String getCurrentWord() {
		return currentWord;
	}
	public void setCurrentWord(String currentWord) {
		this.currentWord = getRandomWord();
	}
	
}
