package ergasia;

import java.util.ArrayList;

public class ReadingQuestion extends Question{
	private String ReadingText;
	private ArrayList<MultipleChoice> questions = new ArrayList<MultipleChoice>();
	
	public ReadingQuestion(Language language, Level level, String ReadingText, ArrayList<MultipleChoice> questions){
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

	public ArrayList<MultipleChoice> getQuestions() {
		return questions;
	}

	public void setQuestions(ArrayList<MultipleChoice> questions) {
		this.questions = questions;
	}
	
	
}
