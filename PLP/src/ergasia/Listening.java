package ergasia;
import java.util.ArrayList;
import java.util.Random;


public class Listening extends Exercise {
	

	private ArrayList<ListeningQuestion> listeningQuestionsList = new ArrayList<ListeningQuestion>();
	
	
	public Listening(Language language, Level level) {
		super(language,level);
	}


	//dhmiourgia askhseologiou
	//dhmiourgeitai ena plh8os diadoxikwn erwthsewn typou Listening, stis opoies 8a eksetastei o student
	public ArrayList<Question> createTest() {
		
		Random rnd = new Random();//ena antikeimeno typou Random pou 8a mas voh8hsei na eksagoume enan tyxaio ari8mo apo afto
		
		int mynum = 0;
		
		//8a epilegetai enas tyxaios ari8mos me evros apo 0 mexri x, opou x einai to plh8os twn diaforetikwn audio files ths kathgorias Listening me to sygkekrimeno lvl kai glwssa
		mynum = rnd.nextInt(listeningQuestionsList.size());

		
		ArrayList<Question> temp = new ArrayList<>();
		temp.add(listeningQuestionsList.get(mynum));
		
		return temp;
}
	
	public void addAListeningQuestion(ListeningQuestion newListeningQuestion){
		
		listeningQuestionsList.add(newListeningQuestion);
		
	}


}
