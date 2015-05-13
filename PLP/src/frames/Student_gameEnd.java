package frames;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import frames.Student_testResults.ButtonListener;

public class Student_gameEnd extends JFrame {
	
	private JButton buttonMainMenu, buttonReplay;
	private JTextField TextScore, Score, Leaderboard;
	private JPanel panel;
	private JLabel thumb;
	private ImageIcon image;
	
	public Student_gameEnd(){
		TextScore=new JTextField("Το σκορ σου");
		Score=new JTextField("         ");
		Leaderboard=new JTextField("Leaderboard");
		buttonMainMenu=new JButton("Main Menu");
		buttonReplay=new JButton("Replay");
		panel=new JPanel();
		
		image = new ImageIcon("leaderboard.png");
		Image imageiii = image.getImage(); // transform it 
		Image newimg = imageiii.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		image = new ImageIcon(newimg);
		thumb = new JLabel(image);
		
		panel.add(TextScore);
		panel.add(Score);
		panel.add(Leaderboard);
		panel.add(thumb);
		panel.add(buttonMainMenu);
		panel.add(buttonReplay);
		
		this.setContentPane(panel);
		
		ButtonListener listener=new ButtonListener();
		Listener listener2=new Listener();
		buttonMainMenu.addActionListener(listener);
		buttonReplay.addActionListener(listener);
		thumb.addMouseListener(listener2);
		
		this.setVisible(true);
		this.setSize(400,400);
		this.setTitle("Event Example");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

class Listener implements MouseListener{

	public void mouseClicked(MouseEvent e) {
		if(e.getX()==thumb.getX() && e.getY()==thumb.getY()){
	    	   														//leaderboard
	       }
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
}
	
class ButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==buttonMainMenu){
				setVisible(false);
				dispose();
				new Student_main();
			}else if(e.getSource()==buttonReplay){
				setVisible(false);
				dispose();
													//Replay Game
			}
		}
	}
}
