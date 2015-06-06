package ergasia;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Reading extends Exercise  implements Serializable{


	private ArrayList<ReadingQuestion> readingQuestionsList = new ArrayList<ReadingQuestion>();;
	
	
	public Reading(Language language, Level level) {
		super(language,level);
	}
	
	public ArrayList<Question> createTest() {
		Random rnd = new Random();
		int mynum = 0;
		mynum = rnd.nextInt(readingQuestionsList.size());
		ArrayList<Question> temp = new ArrayList<>();
		temp.add(readingQuestionsList.get(mynum));
		
		return temp;
}


	public void createReading(String ReadingText, ArrayList<Question> questions){
		ReadingQuestion question=new ReadingQuestion(language, level, ReadingText, questions);
		HashMap<ReadingQuestion, Level> tmpquestions=Main.ser.getDataHolder().getListOfAllReadingQuestions();
		tmpquestions.put(question, question.getLevel());
		Main.ser.ReadingQuestionsSerializing(tmpquestions);
	}

		
}
