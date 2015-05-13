package frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import frames.Student_testChoose1.ButtonListener;

public class Student_testType1 extends JFrame {

	private JButton buttonOk;
	private JTextField Text, AText, BText, CText, DText, A,B,C,D;
	private JPanel panel;
	
	public Student_testType1(){
		Text=new  JTextField("                                                          ");
		A=new JTextField("A");
		AText=new JTextField("              ");
		B=new JTextField("B");
		BText=new JTextField("              ");
		C=new JTextField("C");
		CText=new JTextField("              ");
		D=new JTextField("D");
		DText=new JTextField("              ");
		panel=new JPanel();
		
		panel.add(Text);
		panel.add(A);
		panel.add(AText);
		panel.add(B);
		panel.add(BText);
		panel.add(C);
		panel.add(CText);
		panel.add(D);
		panel.add(DText);
		
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
