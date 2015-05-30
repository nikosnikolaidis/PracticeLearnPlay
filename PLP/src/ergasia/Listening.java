package ergasia;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;


public class Listening extends Exercise implements Serializable {
	

	private ArrayList<ListeningQuestion> listeningQuestionsList = new ArrayList<ListeningQuestion>();
	
	
	public Listening(Language language, Level level) {
		super(language,level);
	}


	

	public ArrayList<Question> createTest() {
		
		Random rnd = new Random();		
		int mynum = 0;
		mynum = rnd.nextInt(listeningQuestionsList.size());		
		ArrayList<Question> temp = new ArrayList<>();
		temp.add(listeningQuestionsList.get(mynum));
		
		return temp;
}
	
	public void createListening(String AudioFileName, ArrayList<Question> questions){
		ListeningQuestion question=new ListeningQuestion(language, level, AudioFileName, questions);
		HashMap<Question, Level> tmpquestions=Main.ser.getDataHolder().getListOfAllListeningQuestions();
		tmpquestions.put(question, question.getLevel());
		Main.ser.ListeningQuestionsSerializing(tmpquestions);
	}


}
