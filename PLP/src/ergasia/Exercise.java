package ergasia;

import java.util.ArrayList;

public abstract class Exercise {
	
	private Language language;//h glwssa sthn opoia einai h askhsh, px english, french etc
	private String level;//the level of the examination given by the teacher
	
	//constructor
	public Exercise(Language language, String level){
		this.language = language;
		this.level = level;
		
	}
	
	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	//
	
	
	//dhmiourgia askhseologiou
	//dhmiourgeitai ena plh8os diadoxikwn erwthsewn stis opoies 8a e3etastei o student
	public abstract ArrayList<Question> createTest();
	
	public abstract int answerEvaluation();
}


