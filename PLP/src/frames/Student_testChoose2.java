package frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import frames.Student_testChoose1.ButtonListener;

public class Student_testChoose2 extends JFrame{
	
	private JButton buttonMainMenu, buttonAll, buttonVoca, buttonGram, buttonRead, buttonLis;
	private JPanel panel;
	
	public Student_testChoose2(){
		buttonMainMenu =new JButton("Main Menu");
		buttonAll =new JButton("All");
		buttonVoca =new JButton("Vocabulary");
		buttonGram =new JButton("Grammar");
		buttonRead =new JButton("Reading");
		buttonLis =new JButton("Listening");
		
		panel=new JPanel();
		
		panel.add(buttonVoca);
		panel.add(buttonGram);
		panel.add(buttonRead);
		panel.add(buttonLis);
		panel.add(buttonAll);
		panel.add(buttonMainMenu);
		
		this.setContentPane(panel);
		
		ButtonListener listener=new ButtonListener();
		buttonMainMenu.addActionListener(listener);
		buttonVoca.addActionListener(listener);
		buttonGram.addActionListener(listener);
		buttonRead.addActionListener(listener);
		buttonLis.addActionListener(listener);
		buttonAll.addActionListener(listener);
		
		this.setVisible(true);
		this.setSize(400,400);
		this.setTitle("Event Example");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
class ButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==buttonMainMenu){
				setVisible(false);
				dispose();
				new Student_main();
			}else if(e.getSource()==buttonVoca){
				setVisible(false);
				dispose();
				
			}else if(e.getSource()==buttonGram){
				setVisible(false);
				dispose();
				
			}else if(e.getSource()==buttonRead){
				setVisible(false);
				dispose();
				
			}else if(e.getSource()==buttonLis){
				setVisible(false);
				dispose();
				
			}else if(e.getSource()==buttonAll){
				setVisible(false);
				dispose();
				
			}
		}
	}
}
