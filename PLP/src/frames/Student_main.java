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
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import kremala.Kremala;
import ergasia.Main;


public class Student_main extends JFrame {

	private JButton buttonExit, buttonTest, buttonGame, buttonStatistics;
	private JPanel TestPanel, GamePanel, StatisticsPanel;
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
		Image GameLabelImage = dGameLabel.getScaledInstance(400, 130, Image.SCALE_SMOOTH);
		GameLabel.setIcon(new javax.swing.ImageIcon(GameLabelImage));
		
		buttonGame = new JButton();
		BufferedImage dGameButton = null;
		try {
			dGameButton = ImageIO.read(new File("Game.jpg"));
		} 
		catch (IOException e1) {
			e1.printStackTrace();
		}
		Image GameButtonImage = dGameButton.getScaledInstance(200, 135, Image.SCALE_SMOOTH);
		buttonGame.setIcon(new javax.swing.ImageIcon(GameButtonImage));
		buttonGame.setPreferredSize(new Dimension(190, 130));
	    
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
		Image TestLabelImage = dTestLabel.getScaledInstance(400, 130, Image.SCALE_SMOOTH);
		TestLabel.setIcon(new javax.swing.ImageIcon(TestLabelImage));
		
		buttonTest = new JButton();
		BufferedImage dTestButton = null;
		try {
			dTestButton = ImageIO.read(new File("Test.jpg"));
		} 
		catch (IOException e1) {
			e1.printStackTrace();
		}
		Image TestButtonImage = dTestButton.getScaledInstance(200, 135, Image.SCALE_SMOOTH);
		buttonTest.setIcon(new javax.swing.ImageIcon(TestButtonImage));
		buttonTest.setPreferredSize(new Dimension(190, 130));
	    
		TestPanel.add(TestLabel);
		TestPanel.add(buttonTest);
		
		this.add(TestPanel);
		
		
		StatisticsPanel=new JPanel();
		StatisticsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		
		JLabel StatisticsLabel=new JLabel();
		BufferedImage dStatisticsLabel = null;
		try {
			dStatisticsLabel = ImageIO.read(new File("statisticlabel.jpg"));
		} 
		catch (IOException e1) {
			e1.printStackTrace();
		}
		Image StatisticsLabelImage = dStatisticsLabel.getScaledInstance(400, 130, Image.SCALE_SMOOTH);
		StatisticsLabel.setIcon(new javax.swing.ImageIcon(StatisticsLabelImage));
		
		buttonStatistics = new JButton();
		BufferedImage dStatisticsButton = null;
		try {
			dStatisticsButton = ImageIO.read(new File("statistic.jpg"));
		} 
		catch (IOException e1) {
			e1.printStackTrace();
		}
		Image StatisticsButtonImage = dStatisticsButton.getScaledInstance(200, 135, Image.SCALE_SMOOTH);
		buttonStatistics.setIcon(new javax.swing.ImageIcon(StatisticsButtonImage));
		buttonStatistics.setPreferredSize(new Dimension(190, 130));
	    
		StatisticsPanel.add(StatisticsLabel);
		StatisticsPanel.add(buttonStatistics);
		
		this.add(StatisticsPanel);
		
		
		buttonExit=new JButton();
		BufferedImage dbuttonExit = null;
		try {
			dbuttonExit = ImageIO.read(new File("exit.jpg"));
		} 
		catch (IOException e1) {
			e1.printStackTrace();
		}
		Image buttonExitImage = dbuttonExit.getScaledInstance(170, 110, Image.SCALE_SMOOTH);
		buttonExit.setIcon(new javax.swing.ImageIcon(buttonExitImage));
		buttonExit.setPreferredSize(new Dimension(120, 110));
		
		this.add(buttonExit);
		
		ButtonListener listener=new ButtonListener();
		buttonExit.addActionListener(listener);
		buttonTest.addActionListener(listener);
		buttonStatistics.addActionListener(listener);
		
		GameListener listener2 = new GameListener();
		buttonGame.addActionListener(listener2);
		
		this.setVisible(true);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setTitle("PLP");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	class GameListener implements ActionListener {
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
				GamesButtonChoiceListener listener =new GamesButtonChoiceListener();
				hanging.addActionListener(listener);
				
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
				wording.addActionListener(listener);
				
				games.add(hanging);
				games.add(wording);
				games.setVisible(true);
				games.setTitle("Choose Game");
				games.setSize(360, 460);
				games.setLocationRelativeTo(null);
			}
		}
		
		
	class GamesButtonChoiceListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(e.getSource()==hanging){
				games.dispose();
				new Kremala(0);
			}
			else if(e.getSource()==wording){
				
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
				
			}else if(e.getSource()==buttonStatistics){					//an epilex8oun ta statistika
				JFrame frame = (JFrame) SwingUtilities.getRoot(getContentPane());
				frame.remove(GamePanel);
				frame.remove(TestPanel);
				frame.remove(StatisticsPanel);
				frame.remove(buttonExit);
				
				JLabel StatisticsLabel=new JLabel();
				BufferedImage dStatisticsLabel = null;
				try {
					dStatisticsLabel = ImageIO.read(new File("statisticlabelWithIcon.jpg"));
				} 
				catch (IOException e1) {
					e1.printStackTrace();
				}
				Image StatisticsLabelImage = dStatisticsLabel.getScaledInstance(400, 130, Image.SCALE_SMOOTH);
				StatisticsLabel.setIcon(new javax.swing.ImageIcon(StatisticsLabelImage));
				frame.add(StatisticsLabel);
				
				
				JPanel textsPanel = new JPanel();
				
				JTextArea GrammartextArea = new JTextArea();
				GrammartextArea.setText("Grammar Statistic                          ");
				for(String s: Main.ser.getDataHolder().getStudentNow().getGrammarStatistics()){
					GrammartextArea.setText(GrammartextArea.getText()+"\n"+ s);
				}
				GrammartextArea.setEditable(false);
				textsPanel.add(GrammartextArea);
				
				JTextArea VocabularytextArea = new JTextArea();
				VocabularytextArea.setText("Vocabulary Statistic                    ");
				for(String s: Main.ser.getDataHolder().getStudentNow().getVocabularyStatistics()){
					VocabularytextArea.setText(VocabularytextArea.getText()+"\n"+ s);
				}
				VocabularytextArea.setEditable(false);
				textsPanel.add(VocabularytextArea);
				
				JTextArea ReadingtextArea = new JTextArea();
				ReadingtextArea.setText("Reading Statistic                          ");
				for(String s: Main.ser.getDataHolder().getStudentNow().getReadingStatistics()){
					ReadingtextArea.setText(ReadingtextArea.getText()+"\n"+ s);
				}
				ReadingtextArea.setEditable(false);
				textsPanel.add(ReadingtextArea);
				
				JTextArea ListeningtextArea = new JTextArea();
				ListeningtextArea.setText("Listening Statistic                      ");
				for(String s: Main.ser.getDataHolder().getStudentNow().getListeningStatistics()){
					ListeningtextArea.setText(ListeningtextArea.getText()+"\n"+ s);
				}
				ListeningtextArea.setEditable(false);
				textsPanel.add(ListeningtextArea);
				
				frame.add(textsPanel);
				frame.add(buttonExit);
				frame.paintAll(getGraphics());
			}
			
		}
	}
}