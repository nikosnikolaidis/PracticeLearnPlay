package frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;



public class Teacher_addStudents extends JFrame {

	private JTextField Text;
	private JButton buttonMainMenu;
	private JPanel panel;
	
	public Teacher_addStudents(){
		Text=new JTextField("Τοποθέτισε το exel αρχείο εδώ");
		buttonMainMenu=new JButton("Main menu");
		panel=new JPanel();
		
		panel.add(Text);
		panel.add(buttonMainMenu);
		
		this.setContentPane(panel);
		
		ButtonListener listener=new ButtonListener();
		buttonMainMenu.addActionListener(listener);
		
		
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
				new Teacher_main();
			}
		}
	}
}
