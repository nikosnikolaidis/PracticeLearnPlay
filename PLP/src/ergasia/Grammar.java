package ergasia;
import java.util.ArrayList;


public class Grammar extends Exercise {
	
	private ArrayList<Question> listOfAllGrammarQuestionsWithTheSameLevel;
	
	public Grammar(Language language, String level) {
		super(language,level);
	
	
}

	//dhmiourgia askhseologiou
	//dhmiourgeitai ena plh8os diadoxikwn erwthsewn typou Grammar, stis opoies 8a e3etastei o student
	public ArrayList<Question> createTest(){
		ArrayList<Question> testList = new ArrayList<Question>();
		
		return testList;
	}

	@Override
	public int answerEvaluation() {
		// TODO Auto-generated method stub
		return 0;
	}
}
