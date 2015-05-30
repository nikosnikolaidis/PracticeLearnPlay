package ergasia;

import java.io.Serializable;
import java.util.ArrayList;

public class ListeningQuestion extends Question  implements Serializable{
	private String AudioFileName;
	private ArrayList<Question> questions = new ArrayList<Question>();
	
	public ListeningQuestion(Language language, Level level, String ReadingText, ArrayList<Question> questions){
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

	public ArrayList<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(ArrayList<Question> questions) {
		this.questions = questions;
	}

}
