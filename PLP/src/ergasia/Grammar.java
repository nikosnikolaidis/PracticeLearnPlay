package ergasia;
import java.util.ArrayList;
import java.util.Random;


public class Grammar extends Exercise {
	
	private final int numberOfQuestionsToBeExamined = 30;
	private ArrayList<Question> listOfAllGrammarQuestionsWithTheSameLevel;
	
	public Grammar(Language language, Level level) {
		super(language,level);
	
	
}

	//dhmiourgia askhseologiou
	//dhmiourgeitai ena plh8os diadoxikwn erwthsewn typou Grammar, stis opoies 8a e3etastei o student
	//enhmerwnetai h idiothta currentTest
		//epistrefetai h lista me to askhseologiou
	public ArrayList<Question> createTest() {
		
		ArrayList<Integer> numbersAlreadyChosen = new ArrayList<Integer>();
		ArrayList<Question> testList = new ArrayList<Question>();
		
		Random rnd = new Random();//ena antikeimeno typou Random pou 8a mas voh8hsei na eksagoume tyxaious ari8mous apo afto
		
		int mynum = 0;
		for (int i=0; i<numberOfQuestionsToBeExamined; i++){
			
			do{
				//8a epilegetai enas tyxaios ari8mos me evros apo 0 mexri x, opou x einai to plh8os twn erwthsewn ths kathgorias grammar me to sygkekrimeno lvl kai glwssa
				mynum = rnd.nextInt(listOfAllGrammarQuestionsWithTheSameLevel.size());
				
				
			}while(numbersAlreadyChosen.contains(mynum));//o vrogxos 8a epanalamvanetai oso h lista me tous hdh epilegmenous ari8mous periexei ton kainourio ari8mo
			
			//efoson pleon vrhkame enan ari8mo pou den exei ksanaxrhsimopoih8ei, mporoume na ton 8esoume san index 
			//ths listas pou periexei oles tis erwthseis, ka8ws kai na eksagoume apo afthn, thn erwthsh me to sygkekrimeno index
			testList.add(listOfAllGrammarQuestionsWithTheSameLevel.get(mynum));
		}
		
		this.currentTest=testList;
		return testList;
	}

	
}
