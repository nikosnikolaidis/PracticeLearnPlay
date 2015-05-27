package frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Student_main extends JFrame {

	private JPanel panel;
	private JButton buttonExit, buttonTest, buttonGame, buttonGrade;
	
	public Student_main(){
		buttonTest =new JButton("Test");
		buttonGame =new JButton("Games");
		buttonGrade =new JButton("Grades");
		buttonExit =new JButton("Exit");
		panel=new JPanel();
		
		panel.add(buttonTest);
		panel.add(buttonGame);
		panel.add(buttonGrade);
		panel.add(buttonExit);
		
		this.setContentPane(panel);
		
		ButtonListener listener=new ButtonListener();
		buttonExit.addActionListener(listener);
		buttonTest.addActionListener(listener);
		buttonGame.addActionListener(listener);
		buttonGrade.addActionListener(listener);
		
		this.setVisible(true);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setTitle("Event Example");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
class ButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==buttonExit){
				setVisible(false);
				dispose();
			}else if(e.getSource()==buttonTest){
				new Student_testChoose1();
			}else if(e.getSource()==buttonGame){
				new Student_gameSelect();
			}else if(e.getSource()==buttonGrade){
				new Student_grades();
			}
		}
	}
}
