package ergasia;

import java.util.ArrayList;
import java.util.Random;

public class Reading extends Exercise {

	private final int numberOfQuestionsToBeExamined = 30;
	private ArrayList<ReadingQuestion> readingQuestionsList = new ArrayList<ReadingQuestion>();;
	
	
	public Reading(Language language, Level level) {
		super(language,level);
	}
	
	//epistrefetai mia ArrayList<Question> pou periexei monon ena stoixeio. Afto einai ena (tyxaia epilegmeno) antikeimeno ReadingQuestion.
	public ArrayList<Question> createTest() {
		Random rnd = new Random();//ena antikeimeno typou Random pou 8a mas voh8hsei na eksagoume enan tyxaio ari8mo apo afto
		
		int mynum = 0;
		
		//8a epilegetai enas tyxaios ari8mos me evros apo 0 mexri x, opou x einai to plh8os twn diaforetikwn reading texts ths kathgorias Reading me to sygkekrimeno lvl kai glwssa
		mynum = rnd.nextInt(readingQuestionsList.size());

		ArrayList<Question> temp = new ArrayList<>();
		temp.add(readingQuestionsList.get(mynum));
		
		return temp;
}


public void addAReadingQuestion(ReadingQuestion newReadingQuestion){
		
		readingQuestionsList.add(newReadingQuestion);
		
	}

	
}
