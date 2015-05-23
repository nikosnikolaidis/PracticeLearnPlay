package ergasia;

import java.util.ArrayList;

public class ListeningQuestion extends Question{
	private String AudioFileName;
	private ArrayList<MultipleChoice> questions;
	
	public ListeningQuestion(Language language, Level level, String ReadingText, ArrayList<MultipleChoice> questions){
		super(language, level);
		this.questions=questions;
		this.AudioFileName=ReadingText;
	}

	public String getAudioFileName() {
		return AudioFileName;
	}

	public void setAudioFileName(String audioFileName) {
		AudioFileName = audioFileName;
	}

	public ArrayList<MultipleChoice> getQuestions() {
		return questions;
	}

	public void setQuestions(ArrayList<MultipleChoice> questions) {
		this.questions = questions;
	}

}
