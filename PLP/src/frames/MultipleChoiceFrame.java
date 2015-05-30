package frames;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import ergasia.Grammar;
import ergasia.Level;
import ergasia.Listening;
import ergasia.Main;
import ergasia.MultipleChoice;
import ergasia.Question;
import ergasia.Reading;
import ergasia.Vocabulary;

public class MultipleChoiceFrame extends JFrame{


	private JButton saveQuestion=new JButton("Save");
	private JButton exitButton=new JButton("Exit");
	private JTextArea ekfwnisi= new JTextArea(5, 35);
	private JLabel lekfwnisi=new JLabel("Ekfwnisi"), lap=new JLabel("swsti apantisi"), lap1=new JLabel("apantisi 1"), lap3=new JLabel("apantisi 3"), lap4=new JLabel("apantisi 4"), lap2=new JLabel("apantisi 2"), llvl=new JLabel("Epipedo");
	private JTextField ap1=new JTextField(""), ap2=new JTextField(""), ap3=new JTextField(""), ap4=new JTextField("");
	private JComboBox<String> cbox=new JComboBox<String>();
	private JComboBox<String> cbox2=new JComboBox<String>();
	private JPanel questPanel=new JPanel();
	private String AudioFileOrReadingText;
	private ArrayList<Question> questions=new ArrayList<Question>();
	//data
	
	private int antikeimeno;
	

	public MultipleChoiceFrame(int antikeimeno, String AudioFileOrReadingText){
		this.antikeimeno=antikeimeno;
		this.AudioFileOrReadingText=AudioFileOrReadingText;
		
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 5));
		this.add(lekfwnisi);
		JScrollPane scroll = new JScrollPane (ekfwnisi, 
				   JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		this.add(scroll);
		questPanel.setLayout(new GridLayout(6,2,0,0));
		questPanel.add(lap1);questPanel.add(ap1);
		questPanel.add(lap2);questPanel.add(ap2);
		questPanel.add(lap3);questPanel.add(ap3);
		questPanel.add(lap4);questPanel.add(ap4);
		cbox.addItem("1");
		cbox.addItem("2");
		cbox.addItem("3");
		cbox.addItem("4");
		questPanel.add(lap);questPanel.add(cbox);
		cbox.setSelectedIndex(0);
		
		for(Level alvl :Main.ser.getDataHolder().getTeacherNow().getLanguage().getLevels()){
			cbox2.addItem(alvl.getNameOfLevel());
		}
		questPanel.add(llvl);questPanel.add(cbox2);
		JPanel buttonspanel= new JPanel();
		buttonspanel.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 10));
		this.add(questPanel);
		buttonspanel.add(saveQuestion);
		buttonspanel.add(exitButton);
		this.add(buttonspanel);

		saveQuestion.addActionListener(new saveButtonListener());
        exitButton.addActionListener(new saveButtonListener());
        
		this.setVisible(true);
		this.setSize(500, 450);
		this.setTitle("PLP");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}


	public class saveButtonListener implements ActionListener{
		

		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==saveQuestion)
			{
				String ekf=(String) ekfwnisi.getText();
				
				String a1=(String) ap1.getText();
				String a2=(String) ap2.getText();
				String a3=(String) ap3.getText();
				String a4=(String) ap4.getText();
				ArrayList<String> choices=new ArrayList<String>();
				choices.add(a1);
				choices.add(a2);
				choices.add(a3);
				choices.add(a4);
				
				int swsto=cbox.getSelectedIndex();
				
				String l=(String) cbox2.getSelectedItem();
				Level lvl=null;
				for(Level alvl: Main.ser.getDataHolder().getTeacherNow().getLanguage().getLevels()){
					if(alvl.getNameOfLevel().equals(l)){
						lvl=alvl;
						break;
					}
					
				}
				if(antikeimeno==0){
					Vocabulary vocabulary=new Vocabulary(Main.ser.getDataHolder().getTeacherNow().getLanguage(), lvl);
					vocabulary.createMultipleChoice(ekf, choices, swsto);
					ekfwnisi.setText("");
					ap1.setText("");
					ap2.setText("");
					ap3.setText("");
					ap4.setText("");
					cbox2.setSelectedIndex(0);
					cbox.setSelectedIndex(0);
				}
				if(antikeimeno==2){
					Grammar grammar=new Grammar(Main.ser.getDataHolder().getTeacherNow().getLanguage(), lvl);
					grammar.createMultipleChoice(ekf, choices, swsto);
					ekfwnisi.setText("");
					ap1.setText("");
					ap2.setText("");
					ap3.setText("");
					ap4.setText("");
					cbox2.setSelectedIndex(0);
					cbox.setSelectedIndex(0);
				}
				if(antikeimeno==4||antikeimeno==5){
					MultipleChoice question= new MultipleChoice(Main.ser.getDataHolder().getTeacherNow().getLanguage(), lvl, ekf, choices, swsto);
					questions.add(question);
					ekfwnisi.setText("");
					ap1.setText("");
					ap2.setText("");
					ap3.setText("");
					ap4.setText("");
					cbox2.setSelectedIndex(0);
					cbox.setSelectedIndex(0);
				}
								
			}
			if(e.getSource()==exitButton){
				
				String l=(String) cbox2.getSelectedItem();
				Level lvl=null;
				for(Level alvl: Main.ser.getDataHolder().getTeacherNow().getLanguage().getLevels()){
					if(alvl.getNameOfLevel().equals(l)){
						lvl=alvl;
						break;
					}
				}
				if(antikeimeno==4 && questions.size()>1){
					Listening listening= new Listening(Main.ser.getDataHolder().getTeacherNow().getLanguage(), lvl);
					listening.createListening(AudioFileOrReadingText, questions);
				}
				if(antikeimeno==5 && questions.size()>1){
					Reading reading= new Reading(Main.ser.getDataHolder().getTeacherNow().getLanguage(), lvl);
					reading.createReading(AudioFileOrReadingText, questions);
				}
				
				dispose();
			}
		}

	}




}

