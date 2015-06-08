package frames;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ergasia.Main;
import ergasia.Matching;
import ergasia.MultipleChoice;
import ergasia.Question;
import ergasia.Student;

public class TestEndingFrame extends JFrame{

	private ArrayList<Question> reviewableQuestions = new ArrayList<Question>();
	private String  antikeimeno;
	private int scoreAchieved,  maximumScore;

	private JLabel scoreAchievedLabel ;

	private JPanel lvl1Panel, lvl2Panel, lvl3Panel, lvl4Panel, northPanel;

	public TestEndingFrame(int scoreAchieved, int maximumScore, ArrayList<Question> reviewableQuestions,String antikeimeno)
	{
		this.scoreAchieved = scoreAchieved;
		this.maximumScore = maximumScore;
		this.reviewableQuestions = reviewableQuestions;
		this.antikeimeno = antikeimeno;
		scoreAchievedLabel = new JLabel("You scored "+ scoreAchieved+ " out of "+maximumScore+".");

////////////////////////////***statistika
		if(antikeimeno.equals("Vocabulary"))
		{
			Main.ser.getDataHolder().getStudentNow().addNewVocabularyStatistic(scoreAchieved+"/"+maximumScore);
		}
		else if(antikeimeno.equals("Grammar"))
		{
			Main.ser.getDataHolder().getStudentNow().addNewGrammarStatistic(scoreAchieved+"/"+maximumScore);
		}
		else if(antikeimeno.equals("Reading"))
		{
			Main.ser.getDataHolder().getStudentNow().addNewReadingStatistic(scoreAchieved+"/"+maximumScore);
		}
		else if(antikeimeno.equals("Listening"))
		{
			Main.ser.getDataHolder().getStudentNow().addNewListeningStatistic(scoreAchieved+"/"+maximumScore);
		}
		
		CopyOnWriteArrayList<Student> temp= new CopyOnWriteArrayList<Student>();
		temp.addAll(Main.ser.StudentDeserializing());
		for(Student st: temp){
			if(st.getUsername().equals(Main.ser.getDataHolder().getStudentNow().getUsername())){
				temp.remove(st);
			}
		}
		temp.add(Main.ser.getDataHolder().getStudentNow());
		ArrayList<Student> array=new ArrayList<Student>();
		array.addAll(temp);
		Main.ser.StudentSerializing(array);
////////////////////////////***statistika
		
		this.setLayout(new BorderLayout(30,0));

		lvl1Panel = new JPanel();
		lvl1Panel.setLayout(new FlowLayout());

		northPanel = new JPanel();
		northPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		northPanel.add(new JLabel("You have finished your test."));
		this.add(northPanel, BorderLayout.NORTH);
		
		lvl2Panel = new JPanel();
		lvl2Panel.setLayout(new GridLayout(3,1,0,5));


		lvl2Panel.add(scoreAchievedLabel);
		if(this.reviewableQuestions.size()>0)
		{
			lvl3Panel = new JPanel();
			lvl3Panel.setLayout(new GridLayout(2, 1,0,10));
			lvl3Panel.add(new JLabel("Questions you need to review:"));

			lvl4Panel = new JPanel();
			lvl4Panel.setLayout(new GridLayout(maximumScore/5,1,3,3));

			if(!this.reviewableQuestions.isEmpty())
				for(Question q: reviewableQuestions)
				{
					lvl4Panel.add(getANewReviewableQuestionPanel(q));
				}


			this.add(lvl1Panel,BorderLayout.CENTER);
			lvl1Panel.add(lvl2Panel);
			lvl2Panel.add(lvl3Panel);
			lvl3Panel.add(lvl4Panel);
		}




		this.paintAll(getGraphics());
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);

		this.setTitle("You have finished your test");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	public JPanel getANewReviewableQuestionPanel(Question q)
	{
		JPanel myPanel = new JPanel();



		if(q instanceof MultipleChoice)
		{
			JLabel text = new JLabel();
			JLabel correctAnswer = new JLabel();

			myPanel.setLayout(new GridLayout(2,1,3,3));

			text.setText(((MultipleChoice) q).getEkfwnisi());
			correctAnswer.setText("The correct anwser is: "+((MultipleChoice) q).getChoices().get((((MultipleChoice) q).getCorrectAnswer())));

			myPanel.add(text);
			myPanel.add(correctAnswer);
		}
		else if(q instanceof Matching)
		{
			JLabel left1, left2, left3, left4, left5, right1, right2, right3, right4, right5;
			int answ =0, answ1 =0, answ2=0, answ3=0, answ4=0, answ5=0;

			ArrayList<String> answers =((Matching) q).getAntistixisi();

			for(int i = 0; i<5; i++)
			{
				if(answers.get(i).equals("A"))
					answ = 0  ;
				else if(answers.get(i).equals("B"))
					answ = 1  ;
				else if(answers.get(i).equals("C"))
					answ = 2  ;
				else if(answers.get(i).equals("D"))
					answ = 3  ;
				else
					answ = 4  ;

				if(i==0)
					answ1 = answ;
				else if(i==1)
					answ2 = answ;
				else if(i==2)
					answ3 = answ;
				else if(i==3)
					answ4 = answ;
				else if(i==4)
					answ5 = answ;
			}

			left1 = new JLabel(((Matching) q).getStiliA().get(0));
			left2 = new JLabel(((Matching) q).getStiliA().get(1));
			left3 = new JLabel(((Matching) q).getStiliA().get(2));
			left4 = new JLabel(((Matching) q).getStiliA().get(3));
			left5 = new JLabel(((Matching) q).getStiliA().get(4));

			right1 = new JLabel(((Matching) q).getStiliB().get(answ1));
			right2 = new JLabel(((Matching) q).getStiliB().get(answ2));
			right3 = new JLabel(((Matching) q).getStiliB().get(answ3));
			right4 = new JLabel(((Matching) q).getStiliB().get(answ4));
			right5 = new JLabel(((Matching) q).getStiliB().get(answ5));

			JPanel leftColumnPanel = new JPanel();JPanel rightColumnPanel = new JPanel();
			leftColumnPanel.setLayout(new GridLayout(5,1,0,10));rightColumnPanel.setLayout(new GridLayout(5, 1, 0, 10));

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

			myPanel.setLayout(new GridLayout(1,2,3,3));
			myPanel.add(leftColumnPanel);
			myPanel.add(rightColumnPanel);
		}


		return myPanel;
	}
}
