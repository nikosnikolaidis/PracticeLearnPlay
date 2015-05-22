package ergasia;

import java.util.ArrayList;

public abstract class Exercise {
	
	protected Language language;//h glwssa sthn opoia einai h askhsh, px english, french etc
	protected Level level;//the level of the examination given by the teacher
	protected ArrayList<Question> currentTest;
	protected ArrayList<Integer> correctAnswer;
	
	//constructor
	public Exercise(Language language, Level level){
		this.language = language;
		this.level = level;
		currentTest = null;
		correctAnswer = null;
	}
	
	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}
	
	public ArrayList<Question> getCurrentTest() {
		return currentTest;
	}

	public void setCurrentTest(ArrayList<Question> currentTest) {
		this.currentTest = currentTest;
	}

	public ArrayList<Integer> getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(ArrayList<Integer> correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	//dhmiourgia askhseologiou
	//dhmiourgeitai ena plh8os diadoxikwn erwthsewn stis opoies 8a e3etastei o student
	public abstract ArrayList<Question> createTest();
	
	public abstract int answerEvaluation();
}


