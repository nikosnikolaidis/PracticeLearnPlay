package frames;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import ergasia.Language;
import ergasia.Level;
import ergasia.ListeningQuestion;
import ergasia.Main;
import ergasia.Matching;
import ergasia.MultipleChoice;
import ergasia.Question;
import ergasia.ReadingQuestion;

public class Askhseologio_Frame extends JFrame implements ActionListener{

	private int testSize, initialTestSize;
	private String antikeimeno;
	private HashMap<ReadingQuestion, Level> map1 = new HashMap<ReadingQuestion, Level>();
	private HashMap<ListeningQuestion, Level> map2 = new HashMap<ListeningQuestion, Level>();
	private HashMap<Question,Level> map = new HashMap<Question, Level>();

	//utility
	//************************************************
	private JPanel utilityPanel = new JPanel();
	private JButton saveAndNextButton = new JButton("Save and next");
	private ArrayList<Question> reviewableQuestions = new ArrayList<Question>();
	//************************************************

	private JLabel readingTextLabel = new JLabel();
	
	private JLabel left1, left2, left3, left4, left5, right1, right2, right3, right4, right5,leftCount1, leftCount2, leftCount3, leftCount4, leftCount5;
	private JComboBox<String> cbox1, cbox2, cbox3, cbox4, cbox5;
	private JPanel leftColumnPanel, rightColumnPanel, answerColumnPanel; 

	private JRadioButton answer1, answer2, answer3, answer4;
	private ButtonGroup radio;
	private JPanel innerPanel, innerPanelHolderPanel,multipleChoiceTextPanel;
	private JPanel outerPanel = new JPanel();
	private JLabel multipleChoiceTextLabel;

	private Language myLanguage;
	private Level myLevel;
	private ArrayList<Question> myTest = new ArrayList<Question>();
	private Question currentInstanceOfQuestion;
	private int score = 0;

	public Askhseologio_Frame(String antikeimeno){

		this.getContentPane();
		this.antikeimeno = antikeimeno;
		this.setLayout(new BorderLayout(10,10));//8a doume gia BorderLayout


		myLanguage = Main.ser.getDataHolder().getStudentNow().getTeacher().getLanguage();
		myLevel = Main.ser.getDataHolder().getStudentNow().getStudentLevel();
		ArrayList<Question> myList = new ArrayList<Question>();
		ArrayList<ReadingQuestion> myList1 = new ArrayList<ReadingQuestion>();
		ArrayList<ListeningQuestion> myList2 = new ArrayList<ListeningQuestion>();

		//antlhsh olwn twn erwthsewn tou idiou epipedou, antikeimenou kai glwssas
		//****************************************************************************************************************
		if(antikeimeno.equals("Vocabulary"))
		{
			map = Main.ser.getDataHolder().getListOfAllVocabularyQuestions();
			myList = getAllQuestions_GV_SameLevel(new ArrayList<Question>(map.keySet()));
		}
		else if(antikeimeno.equals("Grammar"))
		{
			map = Main.ser.getDataHolder().getListOfAllGrammarQuestions();
			myList = getAllQuestions_GV_SameLevel(new ArrayList<Question>(map.keySet()));
		}
		else if(antikeimeno.equals("Reading"))
		{
			map1 = Main.ser.getDataHolder().getListOfAllReadingQuestions();
			myList1 = getAllQuestions_Reading_SameLevel(new ArrayList<ReadingQuestion>(map1.keySet()));
		}
		else if(antikeimeno.equals("Listening"))
		{
			map2 = Main.ser.getDataHolder().getListOfAllListeningQuestions();
			myList2 = getAllQuestions_Listening_SameLevel(new ArrayList<ListeningQuestion>(map2.keySet()));
		}
		//****************************************************************************************************************


		ReadingQuestion readQuest;
		if(antikeimeno.equals("Vocabulary")||antikeimeno.equals("Grammar"))
		{
			createGVTest(myList);
			runtest();
		}
		else if(antikeimeno.equals("Reading"))
		{
			readQuest = createReadingTest(myList1);
			this.readingTextLabel.setText(readQuest.getReadingText());//pros8etoume prin apo th dhmiourgia tou test, to keimeno pou 8a fainetai diarkws san epikefalida
			this.add(this.readingTextLabel,BorderLayout.NORTH);
			runtest();
		}
		else if(antikeimeno.equals("Listening"))
		{
			createListeningTest(myList2);
			runtest();
		}

		saveAndNextButton.addActionListener(this);

		utilityPanel.add(saveAndNextButton);
		this.add(utilityPanel,BorderLayout.SOUTH);


		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
		this.setTitle(antikeimeno);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}


	//ready
	public void runtest(){


		//pairnoume thn prwth erwthsh apo th lista
		Question q = myTest.get(0);

		if(q instanceof MultipleChoice)
		{
			outerPanel.setLayout(new GridLayout(2,1,0,5));
			multipleChoiceTextPanel = new JPanel();
			multipleChoiceTextPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
			multipleChoiceTextLabel = new JLabel(""+((MultipleChoice) q).getEkfwnisi());
			multipleChoiceTextPanel.add(multipleChoiceTextLabel);
			


			innerPanel = new JPanel();
			innerPanel.setLayout(new GridLayout(2,2,5,5));


			radio = new ButtonGroup();
			answer1 = new JRadioButton("1. "+((MultipleChoice) q).getChoices().get(0),  true);
			answer2 = new JRadioButton("2. "+((MultipleChoice) q).getChoices().get(1), false);
			answer3 = new JRadioButton("3. "+((MultipleChoice) q).getChoices().get(2), false);
			answer4 = new JRadioButton("4. "+((MultipleChoice) q).getChoices().get(3), false);
			radio.add(answer1);
			radio.add(answer2);
			radio.add(answer3);
			radio.add(answer4);

			innerPanel.add(answer1);
			innerPanel.add(answer2);
			innerPanel.add(answer3);
			innerPanel.add(answer4);


			innerPanelHolderPanel = new JPanel();
			innerPanelHolderPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
			innerPanelHolderPanel.add(innerPanel);
			//pros8esh twn 2 panel sto kentriko
			outerPanel.add(multipleChoiceTextPanel);
			outerPanel.add(innerPanelHolderPanel);
			
			this.setSize(300, 300);

		}
		else if(q instanceof Matching)
		{

			left1 = new JLabel("1. "+((Matching) q).getStiliA().get(0));
			left2 = new JLabel("2. "+((Matching) q).getStiliA().get(1));
			left3 = new JLabel("3. "+((Matching) q).getStiliA().get(2));
			left4 = new JLabel("4. "+((Matching) q).getStiliA().get(3));
			left5 = new JLabel("5. "+((Matching) q).getStiliA().get(4));

			right1 = new JLabel("A. "+((Matching) q).getStiliB().get(0));
			right2 = new JLabel("B. "+((Matching) q).getStiliB().get(1));
			right3 = new JLabel("C. "+((Matching) q).getStiliB().get(2));
			right4 = new JLabel("D. "+((Matching) q).getStiliB().get(3));
			right5 = new JLabel("E. "+((Matching) q).getStiliB().get(4));

			leftCount1 = new JLabel("1 to");
			leftCount2 = new JLabel("2 to");
			leftCount3 = new JLabel("3 to");
			leftCount4 = new JLabel("4 to");
			leftCount5 = new JLabel("5 to");

			cbox1 = new JComboBox<String>();cbox1.addItem("A");cbox1.addItem("B");cbox1.addItem("C");cbox1.addItem("D");cbox1.addItem("E");
			cbox2 = new JComboBox<String>();cbox2.addItem("A");cbox2.addItem("B");cbox2.addItem("C");cbox2.addItem("D");cbox2.addItem("E");
			cbox3 = new JComboBox<String>();cbox3.addItem("A");cbox3.addItem("B");cbox3.addItem("C");cbox3.addItem("D");cbox3.addItem("E");
			cbox4 = new JComboBox<String>();cbox4.addItem("A");cbox4.addItem("B");cbox4.addItem("C");cbox4.addItem("D");cbox4.addItem("E");
			cbox5 = new JComboBox<String>();cbox5.addItem("A");cbox5.addItem("B");cbox5.addItem("C");cbox5.addItem("D");cbox5.addItem("E");

			leftColumnPanel = new JPanel();rightColumnPanel = new JPanel();answerColumnPanel = new JPanel();
			leftColumnPanel.setLayout(new GridLayout(5,1,0,10));rightColumnPanel.setLayout(new GridLayout(5, 1, 0, 10));answerColumnPanel.setLayout(new GridLayout(5, 2, 2, 10));

			leftColumnPanel.add(left1);
			leftColumnPanel.add(left2);
			leftColumnPanel.add(left3);
			leftColumnPanel.add(left4);
			leftColumnPanel.add(left5);

			rightColumnPanel.add(right1);
			rightColumnPanel.add(right2);
			rightColumnPanel.add(right3);
			rightColumnPanel.add(right4);
			rightColumnPanel.add(right5);

			answerColumnPanel.add(leftCount1);answerColumnPanel.add(cbox1);
			answerColumnPanel.add(leftCount2);answerColumnPanel.add(cbox2);
			answerColumnPanel.add(leftCount3);answerColumnPanel.add(cbox3);
			answerColumnPanel.add(leftCount4);answerColumnPanel.add(cbox4);
			answerColumnPanel.add(leftCount5);answerColumnPanel.add(cbox5);

			outerPanel.setLayout(new GridLayout (1,3,0,0));
			outerPanel.add(leftColumnPanel);
			outerPanel.add(rightColumnPanel);
			outerPanel.add(answerColumnPanel);
			this.setSize(400, 400); 
		}
		//afairoume thn 1h erwthsh dioti pleon eksetasthke kai etsi thn epomenh fora pou 8a ksanaparoume thn 1h erwthsh 8a einai diaforetikh apo afthn
		this.myTest.remove(0);

		this.add(outerPanel,BorderLayout.CENTER);
		this.paintAll(getGraphics());
		this.currentInstanceOfQuestion = q;

	}

	//ready
	public ArrayList<ReadingQuestion> getAllQuestions_Reading_SameLevel(ArrayList<ReadingQuestion> myArray){
		ArrayList<ReadingQuestion> temp = new ArrayList<ReadingQuestion>();

		for(ReadingQuestion q : myArray)
		{
			if(q.getLevel().getNameOfLevel().equals(myLevel.getNameOfLevel())&&q.getLanguage().getName().equals(myLanguage.getName()))
				temp.add(q);
		}

		return temp;
	}

	//ready
	public ArrayList<ListeningQuestion> getAllQuestions_Listening_SameLevel(ArrayList<ListeningQuestion> myArray){
		ArrayList<ListeningQuestion> temp = new ArrayList<ListeningQuestion>();

		for(ListeningQuestion q : myArray)
		{
			if(q.getLevel().getNameOfLevel().equals(myLevel.getNameOfLevel())&&q.getLanguage().getName().equals(myLanguage.getName()))
				temp.add(q);
		}

		return temp;
	}

	//ready
	public ArrayList<Question> getAllQuestions_GV_SameLevel(ArrayList<Question> myArray){

		ArrayList<Question> temp = new ArrayList<Question>();

		for(Question q : myArray)
		{
			if(q.getLevel().getNameOfLevel().equals(myLevel.getNameOfLevel())&&q.getLanguage().getName().equals(myLanguage.getName()))
				temp.add(q);
		}

		return temp;
	}

	//ready
	public ReadingQuestion createReadingTest(ArrayList<ReadingQuestion> myArray){

		Random rnd = new Random();
		int mynum = 0;
		mynum = rnd.nextInt(myArray.size());//epilegetai tyxaia mia erwthsh apo th lista me tis ReadingQuestion erwthseis
		ReadingQuestion myReadingQuestion = myArray.get(mynum);

		myTest = myReadingQuestion.getQuestions();
		return myReadingQuestion;
	}

	//ready??????????????????????????????????????????????????????????????????????????
	public void createListeningTest(ArrayList<ListeningQuestion> myArray){

		Random rnd = new Random();
		int mynum = 0;
		mynum = rnd.nextInt(myArray.size());//epilegetai tyxaia mia erwthsh apo th lista me tis ListeningQuestion erwthseis
		ListeningQuestion myListeningQuestion = myArray.get(mynum);

		myTest = myListeningQuestion.getQuestions();
	}

	//ready
	public void createGVTest(ArrayList<Question> myArray){

		Random rnd = new Random();
		int mynum = 0;
		ArrayList<Question> temp = new ArrayList<>();
		
		//kalyptoume antistoixws tis periptwseis pou oi synolikes erwthseis einai ligoteres apo 30 h perissoteres apo 30
		
		if(myArray.size()>30)
			testSize = 30;
		else
			testSize = myArray.size();
		
		initialTestSize = testSize+1;
		for(int i = 0;i<testSize;i++)
		{
			
			mynum = rnd.nextInt(myArray.size());

			temp.add(myArray.get(mynum));
			myArray.remove(mynum);
		}

		myTest = temp;
	}


	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==saveAndNextButton)
		{

			if(currentInstanceOfQuestion instanceof MultipleChoice)//h erwthsh einai typou MultipleChoice
			{
				int answerNumber = 0;
				if (answer1.isSelected())
					answerNumber = 1;
				else if (answer2.isSelected())
					answerNumber = 2;
				else if (answer3.isSelected())
					answerNumber = 3;
				else if (answer4.isSelected())
					answerNumber = 4;

				if(((MultipleChoice) currentInstanceOfQuestion).answerEvaluation(answerNumber)==1)//o student apanthse swsta
				{
					this.outerPanel.removeAll();
					this.remove(outerPanel);
					this.score = score + 5;
				}
				else //o xrhsths apanthse la8os
				{
					this.outerPanel.removeAll();
					this.remove(outerPanel);
					this.reviewableQuestions.add(currentInstanceOfQuestion);
				}
			}
			else if(currentInstanceOfQuestion instanceof Matching)//h erwthsh einai typou Matching
			{
				boolean temp = false;
				ArrayList<String> correctAnswers = ((Matching) currentInstanceOfQuestion).getAntistixisi();

				if(cbox1.getSelectedItem().equals(correctAnswers.get(0)))
					score = score + 1;
				else 
					temp = true;
				
				if(cbox2.getSelectedItem().equals(correctAnswers.get(1)))
					score = score + 1;
				else 
					temp = true;	
				
				if(cbox3.getSelectedItem().equals(correctAnswers.get(2)))
					score = score + 1;
				else 
					temp = true;	
				
				if(cbox4.getSelectedItem().equals(correctAnswers.get(3)))
					score = score + 1;
				else 
					temp = true;	
				
				if(cbox5.getSelectedItem().equals(correctAnswers.get(4)))
					score = score + 1;
				else temp = true;
				
				this.outerPanel.removeAll();
				this.remove(outerPanel);
			}

			if(testSize>1)//to test synexizetai
			{
				testSize--;
				this.runtest();//Ksanatrexei to test
			}
			else//to test teleiwse
			{
				new TestEndingFrame(score,initialTestSize*5,this.reviewableQuestions,this.antikeimeno);
				dispose();

			}
		}

	}



}
