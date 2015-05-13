package frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import frames.Student_testType1.ButtonListener;

public class Student_testResults extends JFrame{

	private JButton buttonOk;
	private JTextField Text, Score;
	private JPanel panel;
	
	public Student_testResults(){
		Score=new JTextField(" /100");
		Text=new JTextField("                                                 ");
		panel=new JPanel();
		
		panel.add(Score);
		panel.add(Text);
		panel.add(buttonOk);
		
		this.setContentPane(panel);
		
		ButtonListener listener=new ButtonListener();
		buttonOk.addActionListener(listener);
		
		this.setVisible(true);
		this.setSize(400,400);
		this.setTitle("Event Example");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
class ButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==buttonOk){
				setVisible(false);
				dispose();
				
			}
		}
	}
	
}
