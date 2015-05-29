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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import ergasia.Level;
import ergasia.Main;
import ergasia.User;



public class Teacher_main extends JFrame {
	private JLabel backgroundLabel;
	private JButton buttonExit, buttonCreateQuestion, buttonCreateStudent;
	private JPanel createStudentPanel, createQuestionPanel;
	private User teacher;
	public Teacher_main(){
		 teacher=Sign_in.getCurrUser();
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
	     
	     createStudentPanel=new JPanel();
	     createStudentPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
			
			JLabel createStudentLabel=new JLabel();
			BufferedImage dcreateStudentLabel = null;
			try {
				dcreateStudentLabel = ImageIO.read(new File("createstudentlabel.jpg"));
			} 
			catch (IOException e1) {
				e1.printStackTrace();
			}
			Image createStudentLabelImage = dcreateStudentLabel.getScaledInstance(400, 150, Image.SCALE_SMOOTH);
			createStudentLabel.setIcon(new javax.swing.ImageIcon(createStudentLabelImage));
			
			buttonCreateStudent = new JButton();
			BufferedImage dcreateStudentButton = null;
			try {
				dcreateStudentButton = ImageIO.read(new File("createstudent.jpg"));
			} 
			catch (IOException e1) {
				e1.printStackTrace();
			}
			Image createStudentButtonImage = dcreateStudentButton.getScaledInstance(200, 155, Image.SCALE_SMOOTH);
			buttonCreateStudent.setIcon(new javax.swing.ImageIcon(createStudentButtonImage));
			buttonCreateStudent.setPreferredSize(new Dimension(190, 150));
		    
			createStudentPanel.add(createStudentLabel);
			createStudentPanel.add(buttonCreateStudent);
			
			this.add(createStudentPanel);
			
			createQuestionPanel=new JPanel();
			createQuestionPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
			
			JLabel createQuestionLabel=new JLabel();
			BufferedImage dcreateQuestionLabel = null;
			try {
				dcreateQuestionLabel = ImageIO.read(new File("createquestionlabel.jpg"));
			} 
			catch (IOException e1) {
				e1.printStackTrace();
			}
			Image createQuestionLabelImage = dcreateQuestionLabel.getScaledInstance(400, 190, Image.SCALE_SMOOTH);
			createQuestionLabel.setIcon(new javax.swing.ImageIcon(createQuestionLabelImage));
			
			buttonCreateQuestion = new JButton();
			BufferedImage dcreateQuestionButton = null;
			try {
				dcreateQuestionButton = ImageIO.read(new File("createQuestion.jpg"));
			} 
			catch (IOException e1) {
				e1.printStackTrace();
			}
			Image createQuestionButtonImage = dcreateQuestionButton.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
			buttonCreateQuestion.setIcon(new javax.swing.ImageIcon(createQuestionButtonImage));
			buttonCreateQuestion.setPreferredSize(new Dimension(190, 190));
		    
			createQuestionPanel.add(createQuestionLabel);
			createQuestionPanel.add(buttonCreateQuestion);
			
			this.add(createQuestionPanel);
			
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
		
		buttonCreateQuestion.addActionListener(listener);
		buttonCreateStudent.addActionListener(listener);
		buttonExit.addActionListener(listener);
		
		this.setVisible(true);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setTitle("PLP");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
class ButtonListener implements ActionListener {
	private JButton questbutton=new JButton("Next"), savebutton, savebutton2, backbutton, backbutton2;
	private JTextField nametext = new JTextField();
	private JTextField passtext = new JTextField();
	private JTextField usertext = new JTextField(); 
	private JLabel stoixeiaLabel, stoixeiaLabel2;
	private JPanel stoixeiaPanel, stoixeiaPanel2;
	private JComboBox<String> cbox, cbox2;
	private JFrame questype;
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==buttonExit){
				dispose();
			}else if(e.getSource()==buttonCreateQuestion){
				questype=new JFrame();
				questype.setLayout(new GridLayout(2, 0, 0, 0));
				cbox2 = new JComboBox<String>();
		        
		        cbox2.addItem("Vocabulary, multiple choice");
		        cbox2.addItem("Vocabulary, matching");
		        cbox2.addItem("Grammar, multiple choice");
		        cbox2.addItem("Grammar, matching");
		        cbox2.addItem("Listening");
		        cbox2.addItem("Reading");
			    questype.add(cbox2);
			    cbox2.setSelectedIndex(0);
				 
			    JPanel buttonpanel= new JPanel();
			    buttonpanel.setLayout(new FlowLayout(FlowLayout.CENTER));
			    buttonpanel.add(questbutton);
			    questype.add(buttonpanel);
			    questype.setVisible(true);
				questype.setSize(450, 100);
				questype.setLocationRelativeTo(null);
				questListener listener=new questListener();
				questbutton.addActionListener(listener);
			    
			}else if(e.getSource()==buttonCreateStudent){
				JFrame frame = (JFrame) SwingUtilities.getRoot(getContentPane());
		    	  frame.remove(createQuestionPanel);
		    	  frame.remove(createStudentPanel);
		    	  frame.remove(buttonExit);
				
		    	  stoixeiaLabel=new JLabel();
			  		BufferedImage dstoixeiaLabel = null;
			  		try {
			  			dstoixeiaLabel = ImageIO.read(new File("stoixeialabel.jpg"));
			  		} 
			  		catch (IOException e1) {
			  			e1.printStackTrace();
			  		}
			  		Image stoixeiaLabelImage = dstoixeiaLabel.getScaledInstance(400, 70, Image.SCALE_SMOOTH);
			  		stoixeiaLabel.setIcon(new javax.swing.ImageIcon(stoixeiaLabelImage));
			    	frame.add(stoixeiaLabel); 
				
			    	stoixeiaPanel= new JPanel(new GridLayout(5,0,0,0));
			    	
			    	JPanel namePanel=new JPanel(new GridLayout());
			    	JLabel namelabel=new JLabel("Ονοματεπόνυμο");
			    	namePanel.add(namelabel);
				    namePanel.add(nametext);
				    
				    JPanel userPanel=new JPanel(new GridLayout());
			    	JLabel userlabel=new JLabel("username");
			    	userPanel.add(userlabel);
				    userPanel.add(usertext);
				    
				    JPanel passwordPanel=new JPanel(new GridLayout());
			    	JLabel passwordlabel=new JLabel("Password");
			    	passwordPanel.add(passwordlabel);
				    passwordPanel.add(passtext);
				    
				    JPanel lvlPanel=new JPanel(new GridLayout());
			    	JLabel lvllabel=new JLabel("Επίπεδα");
			    	lvlPanel.add(lvllabel);
			    	
			    	
			    	cbox = new JComboBox<String>();
			        
			        if(Main.ser.getDataHolder().getLanguageNow()!=null){
			        	for(Level templvl: Main.ser.getDataHolder().getLanguageNow().getLevels()){
			        
			    		cbox.addItem(templvl.getNameOfLevel());
			    	}
			        }
				    lvlPanel.add(cbox);
				    
				    
				    
				    savebutton=new JButton("Save");
				    
				    
				    stoixeiaPanel.add(namePanel);
				    stoixeiaPanel.add(userPanel);
				    stoixeiaPanel.add(passwordPanel);
			    	stoixeiaPanel.add(lvlPanel);
			    	stoixeiaPanel.add(savebutton);
				    
			    	frame.add(stoixeiaPanel);
			    	
			    	backbutton=new JButton();
			    	BufferedImage dbackbutton = null;
					try {
						dbackbutton = ImageIO.read(new File("backbutton.jpg"));
					} 
					catch (IOException e1) {
						e1.printStackTrace();
					}
					Image backbuttonImage = dbackbutton.getScaledInstance(250, 200, Image.SCALE_SMOOTH);
					backbutton.setIcon(new javax.swing.ImageIcon(backbuttonImage));
					backbutton.setPreferredSize(new Dimension(190, 150));
			    	
					frame.add(backbutton);
					
		//			saveListener listener=new saveListener();
		//			backbutton.addActionListener(listener);
		//			savebutton.addActionListener(listener);
					
					frame.paintAll(getGraphics());
			}
		}
		
		class questListener implements ActionListener{ 
			private int i;
			private JButton saveQuestion=new JButton("Save");
			private JTextArea ekfwnisi= new JTextArea(5, 30);
			private JLabel lekfwnisi=new JLabel("Ekfwnisi"), lap=new JLabel("swsti apantisi"), lap1=new JLabel("apantisi 1"), lap3=new JLabel("apantisi 3"), lap4=new JLabel("apantisi 4"), lap2=new JLabel("apantisi 2");
			private JTextField ap1=new JTextField(""), ap2=new JTextField(""), ap3=new JTextField(""), ap4=new JTextField("");
			private JComboBox<String> cbox3=new JComboBox<String>();
			private JPanel questPanel=new JPanel();
			public void actionPerformed(ActionEvent e){
				if(e.getSource()==questbutton){
				i=cbox2.getSelectedIndex();
				questype.dispose();
				JFrame frame = (JFrame) SwingUtilities.getRoot(getContentPane());
		    	  frame.remove(createQuestionPanel);
		    	  frame.remove(createStudentPanel);
		    	  frame.remove(buttonExit);
				
		    	  if(i==0){
		    		  frame.setLayout(new FlowLayout(FlowLayout.CENTER, 5000, 200));
		    		  questPanel.setLayout(new GridLayout(7,2,0,0));
		    		  questPanel.add(lekfwnisi);
		    		  questPanel.add(ekfwnisi);
		    		  questPanel.add(lap1);questPanel.add(ap1);
		    		  questPanel.add(lap2);questPanel.add(ap2);
		    		  questPanel.add(lap3);questPanel.add(ap3);
		    		  questPanel.add(lap4);questPanel.add(ap4);
					  cbox3.addItem("1");
					  cbox3.addItem("2");
					  cbox3.addItem("3");
					  cbox3.addItem("4");
					  questPanel.add(lap);questPanel.add(cbox3);
					  cbox3.setSelectedIndex(0);
					  questPanel.add(saveQuestion);
					  frame.add(questPanel);
					  frame.paintAll(getGraphics());
		    	  }
					  if(i==2){
			    		  frame.setLayout(new FlowLayout(FlowLayout.CENTER, 5000, 200));
			    		  questPanel.setLayout(new GridLayout(7,2,0,0));
			    		  questPanel.add(lekfwnisi);
			    		  questPanel.add(ekfwnisi);
			    		  questPanel.add(lap1);questPanel.add(ap1);
			    		  questPanel.add(lap2);questPanel.add(ap2);
			    		  questPanel.add(lap3);questPanel.add(ap3);
			    		  questPanel.add(lap4);questPanel.add(ap4);
						  cbox3.addItem("1");
						  cbox3.addItem("2");
						  cbox3.addItem("3");
						  cbox3.addItem("4");
						  questPanel.add(lap);questPanel.add(cbox3);
						  cbox3.setSelectedIndex(0);
						  questPanel.add(saveQuestion);
						  frame.add(questPanel);
						  frame.paintAll(getGraphics());
					  
		    		  
				}
					
				}
								
				
				
				
			}
		}
	}

}
