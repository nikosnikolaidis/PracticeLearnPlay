package frames;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import dataAdministration.DataHolder;

public class MultipleChoiceFrame extends JFrame{


	private JButton saveQuestion=new JButton("Save");
	private JTextArea ekfwnisi= new JTextArea(5, 30);
	private JLabel lekfwnisi=new JLabel("Ekfwnisi"), lap=new JLabel("swsti apantisi"), lap1=new JLabel("apantisi 1"), lap3=new JLabel("apantisi 3"), lap4=new JLabel("apantisi 4"), lap2=new JLabel("apantisi 2");
	private JTextField ap1=new JTextField(""), ap2=new JTextField(""), ap3=new JTextField(""), ap4=new JTextField("");
	private JComboBox<String> cbox=new JComboBox<String>();
	private JPanel questPanel=new JPanel();
	
	//data
	
	private int antikeimeno;
	private String level;
	

	public MultipleChoiceFrame(int antikeimeno, String level){
		
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 5));
		this.add(lekfwnisi);
		this.add(ekfwnisi);
		questPanel.setLayout(new GridLayout(5,2,0,0));
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
		this.add(questPanel);
		this.add(saveQuestion);
		
		

		saveQuestion.addActionListener(new saveButtonListener());

		this.setVisible(true);
		this.setSize(450, 450);
		this.setTitle("PLP");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}


	public class saveButtonListener implements ActionListener{


		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==saveQuestion)
			{
				//myDataHolder
			}
		}

	}




}
