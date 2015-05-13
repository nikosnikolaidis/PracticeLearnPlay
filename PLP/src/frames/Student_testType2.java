package frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import frames.Student_testType1.ButtonListener;

public class Student_testType2 extends JFrame {

	private JButton buttonOk;
	
	private JPanel panel;
	
	public Student_testType2(){
		buttonOk=new JButton("Ok");
		
		JTextField A=new JTextField("A");
		JTextField AText=new JTextField("              ");
		JTextField B=new JTextField("B");
		JTextField BText=new JTextField("              ");
		JTextField C=new JTextField("C");
		JTextField CText=new JTextField("              ");
		JTextField D=new JTextField("D");
		JTextField DText=new JTextField("              ");
		JTextField E=new JTextField("E");
		JTextField EText=new JTextField("              ");
		JTextField F=new JTextField("F");
		JTextField FText=new JTextField("              ");
		JTextField G=new JTextField("G");
		JTextField GText=new JTextField("              ");
		JTextField H=new JTextField("H");
		JTextField HText=new JTextField("              ");
		JTextField I=new JTextField("I");
		JTextField IText=new JTextField("              ");
		JTextField J=new JTextField("J");
		JTextField JText=new JTextField("              ");
		
		JTextField W_1=new JTextField("1");
		JTextField W_1Text=new JTextField("              ");
		JTextField W_2=new JTextField("2");
		JTextField W_2Text=new JTextField("              ");
		JTextField W_3=new JTextField("3");
		JTextField W_3Text=new JTextField("              ");
		JTextField W_4=new JTextField("4");
		JTextField W_4Text=new JTextField("              ");
		JTextField W_5=new JTextField("5");
		JTextField W_5Text=new JTextField("              ");
		JTextField W_6=new JTextField("6");
		JTextField W_6Text=new JTextField("              ");
		JTextField W_7=new JTextField("7");
		JTextField W_7Text=new JTextField("              ");
		JTextField W_8=new JTextField("8");
		JTextField W_8Text=new JTextField("              ");
		JTextField W_9=new JTextField("9");
		JTextField W_9Text=new JTextField("              ");
		JTextField W_10=new JTextField("10");
		JTextField W_10Text=new JTextField("              ");
		
		JTextField A_1=new JTextField("A");
		JTextField A_1Text=new JTextField("    ?    ");
		JTextField B_1=new JTextField("B");
		JTextField B_1Text=new JTextField("    ?    ");
		JTextField C_1=new JTextField("C");
		JTextField C_1Text=new JTextField("    ?    ");
		JTextField D_1=new JTextField("D");
		JTextField D_1Text=new JTextField("    ?    ");
		JTextField E_1=new JTextField("E");
		JTextField E_1Text=new JTextField("    ?    ");
		JTextField F_1=new JTextField("F");
		JTextField F_1Text=new JTextField("    ?    ");
		JTextField G_1=new JTextField("G");
		JTextField G_1Text=new JTextField("    ?    ");
		JTextField H_1=new JTextField("H");
		JTextField H_1Text=new JTextField("    ?    ");
		JTextField I_1=new JTextField("I");
		JTextField I_1Text=new JTextField("    ?    ");
		JTextField J_1=new JTextField("J");
		JTextField J_1Text=new JTextField("    ?    ");
		
		
		
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
