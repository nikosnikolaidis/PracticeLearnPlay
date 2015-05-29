package frames;

import java.awt.Desktop;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import ergasia.Main;
import ergasia.Student;
import ergasia.Teacher;
import ergasia.User;

public class Sign_in extends JFrame{
	private JLabel usernameLabel, passwordLabel;
	private JTextField username, password;
	private JButton buttonOk, enxiridio;
	private static User  currUser;
	public Sign_in(){
		
		
		passwordLabel=new JLabel("Password");
		usernameLabel=new JLabel("Username");
		username=new JTextField("");
		password=new JTextField("");
		buttonOk =new JButton("Log In");
		enxiridio=new JButton("Help");
		
		JPanel panel=new JPanel();
		
		JPanel userpanel=new JPanel();
		userpanel.setLayout(new GridLayout(0, 2, 5, 5));
		userpanel.add(username);
		userpanel.add(usernameLabel);
		
		JPanel passwordpanel=new JPanel();
		passwordpanel.setLayout(new GridLayout(0, 2, 5, 5));
		passwordpanel.add(password);
		passwordpanel.add(passwordLabel);
		
		JPanel stpanel=new JPanel();
		stpanel.setLayout(new GridLayout(2, 0, 5, 5));
		stpanel.add(userpanel);
		stpanel.add(passwordpanel);
		
		FlowLayout flow = new FlowLayout(FlowLayout.CENTER, 2000, 25);
		panel.setLayout(flow);
		panel.add(stpanel);
		panel.add(buttonOk);
		panel.add(enxiridio);
		
		
		this.setContentPane(panel);
		
		ButtonListener listener=new ButtonListener();
		buttonOk.addActionListener(listener);
		enxiridio.addActionListener(listener);
		
		this.pack();
		this.setVisible(true);
		this.setSize(300,220);
		this.setTitle("PLP");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

	}
	


	
public static User getCurrUser(){
	return currUser;
}

class ButtonListener implements ActionListener {
		private int i=0;
		
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==buttonOk){						
				String name=(String) username.getText();
				String pass=(String) password.getText();
				
				if(name.equals("Admin") && pass.equals(Main.ser.getDataHolder().getPasswordAdmin())){
				setVisible(false);
				dispose();
				new Student_main();
				}
				else{
					boolean found=false;
					if(Main.ser.getDataHolder().getTeachers()!=null){
						ArrayList<User> temp=new ArrayList(Main.ser.getDataHolder().getTeachers());
					
					for(User user: temp){
						if(user.log_In(name, pass)){
							found= true;
							dispose();
							currUser=user;
							new Teacher_main();
							
						}
					}
					}
					if(found=false){
						if(Main.ser.getDataHolder().getStudents()!=null){
							ArrayList<User> temp2=new ArrayList(Main.ser.getDataHolder().getStudents());
						
						for(User user: temp2){
							if(user.log_In(name, pass)){
								found= true;
								dispose();
								currUser=user;
								new Student_main();
							}
						}
					}
					}
					if(found==false){
						i++;
						if(i==1){
						JFrame frame = (JFrame) SwingUtilities.getRoot(getContentPane());
						frame.setSize(300,270);
						frame.add(new JLabel("����� ��������, ����������� ����"));
						frame.paintAll(getGraphics());
						}
					}
					
				}
				
			}
			if(e.getSource()==enxiridio){				
				try {
				     if (Desktop.isDesktopSupported()) {
				       Desktop.getDesktop().open(new File("Enxiridio.docx"));
				     }
				   } catch (IOException ioe) {
				     ioe.printStackTrace();
				  }
			}
		}
	}
}
