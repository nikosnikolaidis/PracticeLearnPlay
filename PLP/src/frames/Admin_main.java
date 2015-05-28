package frames;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import ergasia.Language;
import ergasia.Main;

public class Admin_main extends JFrame{
	
	private JButton buttonExit, buttonCreateTeacher, buttonCreateLesson;
	private JPanel panel, createLessonPanel, createTeacherPanel;
	private JLabel backgroundLabel;
	
	public Admin_main(){
		
		
		buttonCreateLesson=new JButton();
		
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
	     this.setLayout(new FlowLayout(FlowLayout.CENTER, 5000, 150));
		
	    
		createTeacherPanel=new JPanel();
		createTeacherPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		
		JLabel createTeacherLabel=new JLabel();
		BufferedImage dcreateTeacherLabel = null;
		try {
			dcreateTeacherLabel = ImageIO.read(new File("createteacherlabel.jpg"));
		} 
		catch (IOException e1) {
			e1.printStackTrace();
		}
		Image createTeacherLabelImage = dcreateTeacherLabel.getScaledInstance(400, 150, Image.SCALE_SMOOTH);
		createTeacherLabel.setIcon(new javax.swing.ImageIcon(createTeacherLabelImage));
		
		buttonCreateTeacher = new JButton();
		BufferedImage dcreateTeacherButton = null;
		try {
			dcreateTeacherButton = ImageIO.read(new File("createteacher.jpg"));
		} 
		catch (IOException e1) {
			e1.printStackTrace();
		}
		Image createTeacherButtonImage = dcreateTeacherButton.getScaledInstance(200, 155, Image.SCALE_SMOOTH);
		buttonCreateTeacher.setIcon(new javax.swing.ImageIcon(createTeacherButtonImage));
		buttonCreateTeacher.setPreferredSize(new Dimension(190, 150));
	    
		createTeacherPanel.add(createTeacherLabel);
		createTeacherPanel.add(buttonCreateTeacher);
		
		this.add(createTeacherPanel);
		
		
		createLessonPanel=new JPanel();
		createLessonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		
		JLabel createLessonLabel=new JLabel();
		BufferedImage dcreateLessonLabel = null;
		try {
			dcreateLessonLabel = ImageIO.read(new File("createlessonlabel.jpg"));
		} 
		catch (IOException e1) {
			e1.printStackTrace();
		}
		Image createLessonLabelImage = dcreateLessonLabel.getScaledInstance(400, 190, Image.SCALE_SMOOTH);
		createLessonLabel.setIcon(new javax.swing.ImageIcon(createLessonLabelImage));
		
		buttonCreateLesson = new JButton();
		BufferedImage dcreateLessonButton = null;
		try {
			dcreateLessonButton = ImageIO.read(new File("createlesson.jpg"));
		} 
		catch (IOException e1) {
			e1.printStackTrace();
		}
		Image createLessonButtonImage = dcreateLessonButton.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		buttonCreateLesson.setIcon(new javax.swing.ImageIcon(createLessonButtonImage));
		buttonCreateLesson.setPreferredSize(new Dimension(190, 190));
	    
		createLessonPanel.add(createLessonLabel);
		createLessonPanel.add(buttonCreateLesson);
		
		this.add(createLessonPanel);
		
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
		buttonCreateTeacher.addActionListener(listener);
		buttonCreateLesson.addActionListener(listener);
		
		this.setVisible(true);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setTitle("PLP");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	
	
class ButtonListener implements ActionListener {
	private JButton savebutton, savebutton2, backbutton, backbutton2, dictionary;
	private JTextField nametext = new JTextField();
	private JTextField passtext = new JTextField();
	private JTextField usertext = new JTextField();
	private JTextField lvltext = new JTextField(); 
	private JLabel stoixeiaLabel, stoixeiaLabel2;
	private JPanel stoixeiaPanel, stoixeiaPanel2;
	
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==buttonExit){
				setVisible(false);
				dispose();
			}else if(e.getSource()==buttonCreateTeacher){
				  
		    	  JFrame frame = (JFrame) SwingUtilities.getRoot(getContentPane());
		    	  frame.remove(createLessonPanel);
		    	  frame.remove(createTeacherPanel);
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
			    
			    JPanel langPanel=new JPanel(new GridLayout());
		    	JLabel langlabel=new JLabel("Γλώσσα");
		    	langPanel.add(langlabel);
		    	
		    	String[] cboxStrings = { "Combo-box: Επιλογή-1", "Combo-box: Επιλογή-2", "Combo-box: Επιλογή-3"}; // anti gia epilogi 1,2,3 tha ginete emfanisi ton glwswn pou exoun dimiourgithei
		    	JComboBox box=new JComboBox<String>(cboxStrings);	    	
			    langPanel.add(box);
			    box.setSelectedIndex(0);
			    
			    savebutton=new JButton("Save");
			    
			    
			    stoixeiaPanel.add(namePanel);
			    stoixeiaPanel.add(userPanel);
			    stoixeiaPanel.add(passwordPanel);
		    	stoixeiaPanel.add(langPanel);
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
				
				saveButtonListener listener=new saveButtonListener();
				backbutton.addActionListener(listener);
				savebutton.addActionListener(listener);
				
				frame.paintAll(getGraphics());
			
			
			}else if(e.getSource()==buttonCreateLesson){
				 
		    	  JFrame frame = (JFrame) SwingUtilities.getRoot(getContentPane());
		    	  
		    	  frame.remove(createTeacherPanel);
		    	  frame.remove(createLessonPanel);
		    	  frame.remove(buttonExit);
		    	  	    	  
		    	  
		    	
		    	stoixeiaLabel2=new JLabel();
		  		BufferedImage dstoixeiaLabel = null;
		  		try {
		  			dstoixeiaLabel = ImageIO.read(new File("stoixeialabel.jpg"));
		  		} 
		  		catch (IOException e1) {
		  			e1.printStackTrace();
		  		}
		  		Image stoixeiaLabelImage = dstoixeiaLabel.getScaledInstance(400, 70, Image.SCALE_SMOOTH);
		  		stoixeiaLabel2.setIcon(new javax.swing.ImageIcon(stoixeiaLabelImage));
		    	  
		    	
		    	stoixeiaPanel2= new JPanel(new GridLayout(4,0,0,0));
		    	
		    	
		    	
		    	JPanel namePanel=new JPanel(new GridLayout(0, 2, 0 ,0));
		    	JLabel namelabel=new JLabel("Όνομα");
		    	namePanel.add(namelabel);
			    namePanel.add(nametext);
			    
			    JPanel lvlPanel=new JPanel(new GridLayout(0, 2, 0 ,0));
		    	JLabel lvllabel=new JLabel("Αριθμός επιπέδων");
		    	lvlPanel.add(lvllabel);
			    lvlPanel.add(lvltext);
			    
			    JPanel dicPanel=new JPanel();
			    JLabel diclabel=new JLabel("Επιλογή λεξικού");
		    	dicPanel.add(diclabel);
			    dictionary= new JButton("Browse");
			    dicPanel.add(dictionary);
			    
			    
			    savebutton2=new JButton("Save");
			    
			    
			    stoixeiaPanel2.add(namePanel);
			    stoixeiaPanel2.add(lvlPanel);
			    stoixeiaPanel2.add(dicPanel);
		    	stoixeiaPanel2.add(savebutton2);
			    
		    	
		    	
		    	
		    	backbutton2=new JButton();
		    	BufferedImage dbackbutton = null;
				try {
					dbackbutton = ImageIO.read(new File("backbutton.jpg"));
				} 
				catch (IOException e1) {
					e1.printStackTrace();
				}
				Image backbuttonImage = dbackbutton.getScaledInstance(250, 200, Image.SCALE_SMOOTH);
				backbutton2.setIcon(new javax.swing.ImageIcon(backbuttonImage));
				backbutton2.setPreferredSize(new Dimension(190, 150));
				
				frame.add(stoixeiaLabel2);
				frame.add(stoixeiaPanel2);				
				frame.add(backbutton2);
				frame.paintAll(getGraphics());
				
				saveButtonListener listener=new saveButtonListener();
				backbutton2.addActionListener(listener);
				savebutton2.addActionListener(listener);
				dictionary.addActionListener(listener);
				

			}
		}
	
		class saveButtonListener implements ActionListener {
			private JFileChooser fc = new JFileChooser();
			private JButton saveframes= new JButton("Save");
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==savebutton){
					//dimiourgia kathigiti 
				}
				if(e.getSource()==savebutton2){
					String lvlnum=(String) lvltext.getText();					
				    int lvls=Integer.valueOf(lvlnum);
				    
					JFrame lvlframe=new JFrame();
					lvlframe.setLayout(new GridLayout(lvls+2, 0,0,0));
					lvlframe.add(new JLabel("Εισαγωγη ονομάτων επιπέδων"));
					for(int i=1; i<=lvls; i++){
						lvlframe.add(new JTextField(""));
					}
					lvlframe.add(saveframes);
					lvlframe.setVisible(true);
					lvlframe.setSize(400,220);
					lvlframe.setLocationRelativeTo(null);
					lvlframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					//dimiourgia mathimatos 
				}
				if(e.getSource()==dictionary){
					int returnVal = fc.showOpenDialog(panel);

					if(returnVal == JFileChooser.OPEN_DIALOG) {
						File file = fc.getSelectedFile();
						
					}
				}
				if(e.getSource()==backbutton){
					
					JFrame frame = (JFrame) SwingUtilities.getRoot(getContentPane());
					frame.remove(backbutton);
					frame.remove(stoixeiaPanel);
					frame.remove(stoixeiaLabel);
					
					
					
					
					createTeacherPanel=new JPanel();
					createTeacherPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
					
					JLabel createTeacherLabel=new JLabel();
					BufferedImage dcreateTeacherLabel = null;
					try {
						dcreateTeacherLabel = ImageIO.read(new File("createteacherlabel.jpg"));
					} 
					catch (IOException e1) {
						e1.printStackTrace();
					}
					Image createTeacherLabelImage = dcreateTeacherLabel.getScaledInstance(400, 150, Image.SCALE_SMOOTH);
					createTeacherLabel.setIcon(new javax.swing.ImageIcon(createTeacherLabelImage));
					
					buttonCreateTeacher = new JButton("");
					BufferedImage dcreateTeacherButton = null;
					try {
						dcreateTeacherButton = ImageIO.read(new File("createteacher.jpg"));
					} 
					catch (IOException e1) {
						e1.printStackTrace();
					}
					Image createTeacherButtonImage = dcreateTeacherButton.getScaledInstance(200, 155, Image.SCALE_SMOOTH);
					buttonCreateTeacher.setIcon(new javax.swing.ImageIcon(createTeacherButtonImage));
					buttonCreateTeacher.setPreferredSize(new Dimension(190, 150));
				    
					createTeacherPanel.add(createTeacherLabel);
					createTeacherPanel.add(buttonCreateTeacher);
					
					
					
					
					createLessonPanel=new JPanel();
					createLessonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
					
					JLabel createLessonLabel=new JLabel();
					BufferedImage dcreateLessonLabel = null;
					try {
						dcreateLessonLabel = ImageIO.read(new File("createlessonlabel.jpg"));
					} 
					catch (IOException e1) {
						e1.printStackTrace();
					}
					Image createLessonLabelImage = dcreateLessonLabel.getScaledInstance(400, 190, Image.SCALE_SMOOTH);
					createLessonLabel.setIcon(new javax.swing.ImageIcon(createLessonLabelImage));
					
					buttonCreateLesson = new JButton();
					BufferedImage dcreateLessonButton = null;
					try {
						dcreateLessonButton = ImageIO.read(new File("createlesson.jpg"));
					} 
					catch (IOException e1) {
						e1.printStackTrace();
					}
					Image createLessonButtonImage = dcreateLessonButton.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
					buttonCreateLesson.setIcon(new javax.swing.ImageIcon(createLessonButtonImage));
					buttonCreateLesson.setPreferredSize(new Dimension(190, 190));
				    
					createLessonPanel.add(createLessonLabel);
					createLessonPanel.add(buttonCreateLesson);
					
					
					
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
					
					
					
					
					frame.add(createTeacherPanel);
					frame.add(createLessonPanel);
					frame.add(buttonExit);
					frame.paintAll(getGraphics());
					
					
					ButtonListener listener=new ButtonListener();
					buttonExit.addActionListener(listener);
					buttonCreateTeacher.addActionListener(listener);
					buttonCreateLesson.addActionListener(listener);
				}
				if(e.getSource()==backbutton2){
					
					JFrame frame = (JFrame) SwingUtilities.getRoot(getContentPane());
					frame.remove(backbutton2);
					frame.remove(stoixeiaPanel2);
					frame.remove(stoixeiaLabel2);
					
					
					
					
					createTeacherPanel=new JPanel();
					createTeacherPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
					
					JLabel createTeacherLabel=new JLabel();
					BufferedImage dcreateTeacherLabel = null;
					try {
						dcreateTeacherLabel = ImageIO.read(new File("createteacherlabel.jpg"));
					} 
					catch (IOException e1) {
						e1.printStackTrace();
					}
					Image createTeacherLabelImage = dcreateTeacherLabel.getScaledInstance(400, 150, Image.SCALE_SMOOTH);
					createTeacherLabel.setIcon(new javax.swing.ImageIcon(createTeacherLabelImage));
					
					buttonCreateTeacher = new JButton();
					BufferedImage dcreateTeacherButton = null;
					try {
						dcreateTeacherButton = ImageIO.read(new File("createteacher.jpg"));
					} 
					catch (IOException e1) {
						e1.printStackTrace();
					}
					Image createTeacherButtonImage = dcreateTeacherButton.getScaledInstance(200, 155, Image.SCALE_SMOOTH);
					buttonCreateTeacher.setIcon(new javax.swing.ImageIcon(createTeacherButtonImage));
					buttonCreateTeacher.setPreferredSize(new Dimension(190, 150));
				    
					createTeacherPanel.add(createTeacherLabel);
					createTeacherPanel.add(buttonCreateTeacher);
					
					
					
					
					createLessonPanel=new JPanel();
					createLessonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
					
					JLabel createLessonLabel=new JLabel();
					BufferedImage dcreateLessonLabel = null;
					try {
						dcreateLessonLabel = ImageIO.read(new File("createlessonlabel.jpg"));
					} 
					catch (IOException e1) {
						e1.printStackTrace();
					}
					Image createLessonLabelImage = dcreateLessonLabel.getScaledInstance(400, 190, Image.SCALE_SMOOTH);
					createLessonLabel.setIcon(new javax.swing.ImageIcon(createLessonLabelImage));
					
					buttonCreateLesson = new JButton();
					BufferedImage dcreateLessonButton = null;
					try {
						dcreateLessonButton = ImageIO.read(new File("createlesson.jpg"));
					} 
					catch (IOException e1) {
						e1.printStackTrace();
					}
					Image createLessonButtonImage = dcreateLessonButton.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
					buttonCreateLesson.setIcon(new javax.swing.ImageIcon(createLessonButtonImage));
					buttonCreateLesson.setPreferredSize(new Dimension(190, 190));
				    
					createLessonPanel.add(createLessonLabel);
					createLessonPanel.add(buttonCreateLesson);
					
					
					
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
					
					
					
					
					frame.add(createTeacherPanel);
					frame.add(createLessonPanel);
					frame.add(buttonExit);
					frame.paintAll(getGraphics());
					
					
					ButtonListener listener=new ButtonListener();
					buttonExit.addActionListener(listener);
					buttonCreateTeacher.addActionListener(listener);
					buttonCreateLesson.addActionListener(listener);
				}
				
			}
		}
}
}
