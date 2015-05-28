package frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;



public class Teacher_main extends JFrame {

	private JButton buttonExit, buttonElegxosEpidosis, buttonEisagogiAskisis, buttonAddStudents;
	private JPanel panel;
	
	public Teacher_main(){
		buttonExit=new JButton("Exit");
		buttonElegxosEpidosis=new JButton("Έλεγχος Επίδοσης Μαθητών");
		buttonEisagogiAskisis=new JButton("Εισαγωγή ’σκησης");
		buttonAddStudents=new JButton("Δημιουργία Μαθητών");
		panel=new JPanel();
		
		panel.add(buttonElegxosEpidosis);
		panel.add(buttonEisagogiAskisis);
		panel.add(buttonAddStudents);
		panel.add(buttonExit);
		
		this.setContentPane(panel);
		
		ButtonListener listener=new ButtonListener();
		buttonExit.addActionListener(listener);
		buttonElegxosEpidosis.addActionListener(listener);
		buttonEisagogiAskisis.addActionListener(listener);
		buttonAddStudents.addActionListener(listener);
		
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
			}else if(e.getSource()==buttonElegxosEpidosis){
				setVisible(false);
				dispose();
				
			}else if(e.getSource()==buttonEisagogiAskisis){
				setVisible(false);
				dispose();
				
			}else if(e.getSource()==buttonAddStudents){
				setVisible(false);
				dispose();
				
			}
		}
	}
}
