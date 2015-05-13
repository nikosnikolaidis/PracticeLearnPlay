package frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Admin_createLesson extends JFrame {

	private JButton buttonMainMenu, buttonSave;
	private JTextField TitlosMa8imatos, EisagogiLe3ilogiou;
	private JPanel panel;
	
	public Admin_createLesson(){
		panel=new JPanel();
		buttonMainMenu=new JButton("Main Menu");
		buttonSave=new JButton("Αποθήκευση");
		TitlosMa8imatos=new JTextField("Τίτλος Μαθήματος");
		EisagogiLe3ilogiou=new JTextField("Το αρχείο με το λεξιλόγιο εκεί");
		
		panel.add(TitlosMa8imatos);
		panel.add(EisagogiLe3ilogiou);
		panel.add(buttonMainMenu);
		panel.add(buttonSave);
		
		this.setContentPane(panel);
		
		ButtonListener listener=new ButtonListener();
		buttonMainMenu.addActionListener(listener);
		buttonSave.addActionListener(listener);
		
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
				new Admin_main();
			}else if(e.getSource()==buttonSave){
				setVisible(false);
				dispose();
													//apo8ikeusi ma8imatos
			}
		}
	}
}
