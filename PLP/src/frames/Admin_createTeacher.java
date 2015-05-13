package frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import frames.Admin_createLesson.ButtonListener;

public class Admin_createTeacher extends JFrame {
	
	private JButton buttonMainMenu, buttonSave;
	private JTextField TextOnoma, Onoma, TextUserName, UserName, TextEponimo, Eponimo, TextPass, Pass, TextLista;
	private JPanel panel;
	private JList lessonList;
	
	public Admin_createTeacher(){
		TextOnoma=new JTextField("Όνομα");
		TextUserName=new JTextField("Username");
		Onoma=new JTextField("             ");
		UserName=new JTextField("             ");
		TextEponimo=new JTextField("Επώνυμο");
		TextPass=new JTextField("Password");
		Eponimo=new JTextField("             ");
		Pass=new JTextField("             ");
		TextLista=new JTextField("Λίστα Μαθημάτων");
		buttonMainMenu=new JButton("Main menu");
		buttonSave=new JButton("Αποθήκευση");
		lessonList=new JList();
		panel=new JPanel();
		
		DefaultListModel modelL =new DefaultListModel();
		modelL.addElement("germanika");						//onomata ma8imatwn
		lessonList.setModel(modelL);
		
		panel.add(TextOnoma);
		panel.add(TextUserName);
		panel.add(Onoma);
		panel.add(UserName);
		panel.add(TextEponimo);
		panel.add(TextPass);
		panel.add(Eponimo);
		panel.add(Pass);
		panel.add(TextLista);
		panel.add(lessonList);
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
													//apo8ikeusi ka8igiti
			}
		}
	}
}
