package frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Admin_main extends JFrame{
	
	private JButton buttonExit, buttonCreateTeacher, buttonCreateLesson;
	private JPanel panel;
	
	public Admin_main(){
		buttonExit=new JButton("Exit");
		buttonCreateTeacher=new JButton("Δημιουργία Καθηγητή");
		buttonCreateLesson=new JButton("Δημιουργία Μαθήματος");
		panel=new JPanel();
		
		panel.add(buttonCreateTeacher);
		panel.add(buttonCreateLesson);
		panel.add(buttonExit);
		
		this.setContentPane(panel);
		
		ButtonListener listener=new ButtonListener();
		buttonExit.addActionListener(listener);
		buttonCreateTeacher.addActionListener(listener);
		buttonCreateLesson.addActionListener(listener);
		
		this.setVisible(true);
		this.setSize(400,400);
		this.setTitle("Event Example");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
class ButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==buttonExit){
				setVisible(false);
				dispose();
			}else if(e.getSource()==buttonCreateTeacher){
				setVisible(false);
				dispose();
				new Admin_createTeacher();
			}else if(e.getSource()==buttonCreateLesson){
				setVisible(false);
				dispose();
				new Admin_createLesson();
			}
		}
	}
}
