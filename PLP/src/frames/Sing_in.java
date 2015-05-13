package frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Sing_in extends JFrame{

	private JTextField username, password, usernameT, passwordT;
	private JButton buttonOk;
	
	public Sing_in(){
		usernameT=new JTextField("username");
		passwordT=new JTextField("password");
		username=new JTextField("                 ");
		password=new JTextField("                 ");
		buttonOk =new JButton("OK");
		
		JPanel panel=new JPanel();
		
		panel.add(usernameT);
		panel.add(passwordT);
		panel.add(username);
		panel.add(password);
		panel.add(buttonOk);
		
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
			if(e.getSource()==buttonOk){						//xriazete elegxos gia tin isodo
				
				setVisible(false);
				dispose();
				new Student_main();
			}
		}
	}
}
