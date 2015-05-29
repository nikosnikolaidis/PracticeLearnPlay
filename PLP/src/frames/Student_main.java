package frames;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Student_main extends JFrame {

	private JButton buttonExit, buttonTest, buttonGame;
	private JPanel TestPanel, GamePanel;
	private JLabel backgroundLabel;
	
	
	public Student_main(){
		
		
		buttonTest=new JButton();
		
		 BufferedImage background = null;
			try {
				background = ImageIO.read(new File("back.jpg"));
			} 
			catch (IOException e1) {
				e1.printStackTrace();
			}
			Image dbackground = background.getScaledInstance(1980, 1020, Image.SCALE_SMOOTH);
 		  backgroundLabel = new JLabel();
 		  backgroundLabel.setIcon(new javax.swing.ImageIcon(dbackground));
 		 this.setLayout(new BorderLayout());
 		 this.setContentPane(backgroundLabel);
	     this.setLayout(new FlowLayout(FlowLayout.CENTER, 5000, 50));
		 
		GamePanel=new JPanel();
		GamePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		
		JLabel GameLabel=new JLabel();
		BufferedImage dGameLabel = null;
		try {
			dGameLabel = ImageIO.read(new File("Gamelabel.jpg"));
		} 
		catch (IOException e1) {
			e1.printStackTrace();
		}
		Image GameLabelImage = dGameLabel.getScaledInstance(400, 150, Image.SCALE_SMOOTH);
		GameLabel.setIcon(new javax.swing.ImageIcon(GameLabelImage));
		
		buttonGame = new JButton();
		BufferedImage dGameButton = null;
		try {
			dGameButton = ImageIO.read(new File("Game.jpg"));
		} 
		catch (IOException e1) {
			e1.printStackTrace();
		}
		Image GameButtonImage = dGameButton.getScaledInstance(200, 155, Image.SCALE_SMOOTH);
		buttonGame.setIcon(new javax.swing.ImageIcon(GameButtonImage));
		buttonGame.setPreferredSize(new Dimension(190, 150));
	    
		GamePanel.add(GameLabel);
		GamePanel.add(buttonGame);
		
		this.add(GamePanel);
		
		
		TestPanel=new JPanel();
		TestPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		
		JLabel TestLabel=new JLabel();
		BufferedImage dTestLabel = null;
		try {
			dTestLabel = ImageIO.read(new File("Testlabel.jpg"));
		} 
		catch (IOException e1) {
			e1.printStackTrace();
		}
		Image TestLabelImage = dTestLabel.getScaledInstance(400, 190, Image.SCALE_SMOOTH);
		TestLabel.setIcon(new javax.swing.ImageIcon(TestLabelImage));
		
		buttonTest = new JButton();
		BufferedImage dTestButton = null;
		try {
			dTestButton = ImageIO.read(new File("Test.jpg"));
		} 
		catch (IOException e1) {
			e1.printStackTrace();
		}
		Image TestButtonImage = dTestButton.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		buttonTest.setIcon(new javax.swing.ImageIcon(TestButtonImage));
		buttonTest.setPreferredSize(new Dimension(190, 190));
	    
		TestPanel.add(TestLabel);
		TestPanel.add(buttonTest);
		
		this.add(TestPanel);
		
		buttonExit=new JButton();
		BufferedImage dbuttonExit = null;
		try {
			dbuttonExit = ImageIO.read(new File("exit.jpg"));
		} 
		catch (IOException e1) {
			e1.printStackTrace();
		}
		Image buttonExitImage = dbuttonExit.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		buttonExit.setIcon(new javax.swing.ImageIcon(buttonExitImage));
		buttonExit.setPreferredSize(new Dimension(170, 170));
		
		
		this.add(buttonExit);		
		
		
		
		ButtonListener listener=new ButtonListener();
		buttonExit.addActionListener(listener);
		gameListener listener2 = new gameListener();
		buttonGame.addActionListener(listener2);
		buttonTest.addActionListener(listener);
		
		this.setVisible(true);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setTitle("PLP");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	class gameListener implements ActionListener {
		private JButton hanging, wording;
		private JFrame games;
		public void actionPerformed(ActionEvent e){
			if(e.getSource()==buttonGame){
				games=new JFrame();
				games.setLayout(new GridLayout(2,0,0,0));
				hanging = new JButton();
				BufferedImage dGameButton = null;
				try {
					dGameButton = ImageIO.read(new File("hanging.jpg"));
				} 
				catch (IOException e1) {
					e1.printStackTrace();
				}
				Image GameButtonImage = dGameButton.getScaledInstance(350, 230, Image.SCALE_SMOOTH);
				hanging.setIcon(new javax.swing.ImageIcon(GameButtonImage));
				hanging.setPreferredSize(new Dimension(3350, 230));
				
				wording = new JButton();
				dGameButton = null;
				try {
					dGameButton = ImageIO.read(new File("wording.png"));
				} 
				catch (IOException e1) {
					e1.printStackTrace();
				}
				GameButtonImage = dGameButton.getScaledInstance(350, 230, Image.SCALE_SMOOTH);
				wording.setIcon(new javax.swing.ImageIcon(GameButtonImage));
				wording.setPreferredSize(new Dimension(350, 230));
				
				games.add(hanging);
				games.add(wording);
				games.setVisible(true);
				games.setTitle("Choose Game");
				games.setSize(360, 460);
				games.setLocationRelativeTo(null);
			}
		}
		
		
	class gamesListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(e.getSource()==buttonGame){
				
			}
		}
	}
	}
class ButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==buttonExit){
				dispose();
			}
			else if(e.getSource()==buttonTest){
				
			}
			
		}
	}
}