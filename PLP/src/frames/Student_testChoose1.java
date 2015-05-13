package frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import frames.Student_main.ButtonListener;

public class Student_testChoose1 extends JFrame {

	private ArrayList<String> Lessons=new ArrayList<>();
	private ArrayList<String> Epipeda=new ArrayList<>();
	private JList lessonList, EpipedoList;
	private JButton buttonMainMenu, buttonOk;
	private JTextField LessonT, EpipedoT;
	private JPanel panel;
	
	public Student_testChoose1() {
		LessonT =new JTextField("Μάθημα");
		EpipedoT =new JTextField("Επίπεδο");
		buttonMainMenu =new JButton("Main Menu");
		buttonOk =new JButton("OK");
		lessonList= new JList();
		EpipedoList= new JList();
		panel=new JPanel();
		
		DefaultListModel modelL =new DefaultListModel();
		DefaultListModel modelE =new DefaultListModel();
		modelL.addElement("germanika");
		modelL.addElement("agglika");							//ta onomata gia ta ma8imata
		modelE.addElement("junior");							//ta omomata gia ta epipeda
		lessonList.setModel(modelL);
		EpipedoList.setModel(modelE);
		
		panel.add(LessonT);
		panel.add(lessonList);
		panel.add(EpipedoList);
		panel.add(EpipedoT);
		panel.add(buttonMainMenu);
		panel.add(buttonOk);
		
		this.setContentPane(panel);
		
		ButtonListener listener=new ButtonListener();
		buttonMainMenu.addActionListener(listener);
		buttonOk.addActionListener(listener);
		
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
			}else if(e.getSource()==buttonOk){
				setVisible(false);
				dispose();
				new Student_testChoose2();
			}
		}
	}
}
