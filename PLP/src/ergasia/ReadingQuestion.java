package ergasia;

import java.util.ArrayList;

public class ReadingQuestion extends Question{
	private String ReadingText;
	private ArrayList<Question> questions = new ArrayList<Question>();
	
	
	public ReadingQuestion(Language language, Level level, String ReadingText){
		super(language, level);
		this.ReadingText=ReadingText;
	}
	
	public ReadingQuestion(Language language, Level level, String ReadingText, ArrayList<Question> questions){
		super(language, level);
		this.questions=questions;
		this.ReadingText=ReadingText;
	}

	public String getReadingText() {
		return ReadingText;
	}

	public void setReadingText(String readingText) {
		ReadingText = readingText;
	}

	public ArrayList<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(ArrayList<Question> questions) {
		this.questions = questions;
	}
	
	
}
