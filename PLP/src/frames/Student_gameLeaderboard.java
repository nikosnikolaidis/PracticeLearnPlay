package frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import javax.swing.*;

public class Student_gameLeaderboard extends JFrame {

	private JButton buttonMainMenu, buttonGame1, buttonGame2;
	private JPanel panel;
	private ArrayList<String> Game1=new ArrayList<>();
	private ArrayList<String> Game2=new ArrayList<>();
	private JList List_game1, List_game2;
	private DefaultListModel modelGame1, modelGame2;
	
	public Student_gameLeaderboard(){
		buttonGame1=new JButton("Game1");
		buttonGame2=new JButton("Game2");
		buttonMainMenu =new JButton("Main Menu");
		List_game1= new JList();
		List_game2= new JList();
		panel =new JPanel();
		
		modelGame1 =new DefaultListModel();
		modelGame2 =new DefaultListModel();
		
		List_game1.setModel(modelGame1);
		List_game2.setModel(modelGame2);
		
		panel.add(buttonGame1);
		panel.add(buttonGame2);
		panel.add(buttonMainMenu);
		
		this.setContentPane(panel);
		
		ButtonListener listener=new ButtonListener();
		buttonMainMenu.addActionListener(listener);
		buttonGame1.addActionListener(listener);
		buttonGame2.addActionListener(listener);
		
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
			}else if(e.getSource()==buttonGame1){
				List_game2.setVisible(false);
				List_game1.setVisible(true);
				panel.add(List_game1);
				
				int sum=0;
				try{													//isagogi twn onomatwn sti lista
					BufferedReader in=new BufferedReader(new FileReader("leaderboard_names_game1.txt"));
					String line =in.readLine();
					
					while(line!=null){
						modelGame1.addElement(line);
						line=in.readLine();
						sum=sum+1;
					}
					in.close();
				}
				catch(Exception ex){
					System.out.println(ex);
				}
				for(int i=1;i<=10-sum;i++){
					modelGame1.addElement("None");
				}
				
			}else if(e.getSource()==buttonGame2){
				List_game1.setVisible(false);
				List_game2.setVisible(true);
				panel.add(List_game2);
				
				int sum=0;
				try{													//isagogi twn onomatwn sti lista
					BufferedReader in=new BufferedReader(new FileReader("leaderboard_names_game2.txt"));
					String line =in.readLine();
					
					while(line!=null){
						modelGame2.addElement(line);
						line=in.readLine();
						sum=sum+1;
					}
					in.close();
				}
				catch(Exception ex){
					System.out.println(ex);
				}
				for(int i=1;i<=10-sum;i++){
					modelGame2.addElement("None");
				}
			}
		}
	}
}
