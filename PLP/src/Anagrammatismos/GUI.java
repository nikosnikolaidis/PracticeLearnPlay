package Anagrammatismos;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class GUI extends JFrame implements ActionListener{

	private WordPanel wordPanel;
	private WordRepositoryPanel wordRepositoryPanel;
	
	
	private JPanel masterPanel = new JPanel();
	private JPanel northPanel = new JPanel();
	private JPanel southPanel = new JPanel();
	private JPanel eastPanel = new JPanel();
	private JPanel westPanel = new JPanel();
	private JPanel centerPanel = new JPanel();
	
	private JButton clearAndShuffleButton = new JButton("Clear & Shuffle");
	private JButton exitButton = new JButton("Exit");
	private JButton nextWordButton = new JButton("Next Word");
	
	private String myWord = "";
	
	public GUI(){
		
		setContentPane(masterPanel);
		
		Anagrammatismos anagram = new Anagrammatismos();
		
		myWord = anagram.getRandomWord();
		myWord = myWord.toUpperCase();
		
		System.out.println(myWord);
		
		masterPanel.setLayout(new BorderLayout(5,5));
		
		wordPanel = new WordPanel(myWord);
		wordRepositoryPanel = new WordRepositoryPanel(myWord,wordPanel);
		
		masterPanel.add(southPanel, BorderLayout.SOUTH);
		masterPanel.add(northPanel, BorderLayout.NORTH);
		masterPanel.add(eastPanel, BorderLayout.EAST);
		masterPanel.add(westPanel, BorderLayout.WEST);
		masterPanel.add(centerPanel, BorderLayout.CENTER);
		
		
		centerPanel.setLayout(new FlowLayout());
		centerPanel.add(wordPanel);
		
		northPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 30));
		
		
		clearAndShuffleButton.addActionListener(this);
		northPanel.add(clearAndShuffleButton);
		
		exitButton.addActionListener(this);
		northPanel.add(exitButton);

		nextWordButton.addActionListener(this);
		northPanel.add(nextWordButton);
		
		
		southPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		southPanel.add(wordRepositoryPanel);
		
		
		
		this.pack();
		this.setVisible(true);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setTitle("Find The Word");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==clearAndShuffleButton)
		{
			wordRepositoryPanel.clearLettersFromWordRepository();
		}
		else if(e.getSource()==exitButton)
		{
			dispose();
		}
		else if(e.getSource()==nextWordButton)
		{
			new GUI();
			dispose();
		}
		
	}
	

}

