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
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import ergasia.Admin;
import ergasia.Language;
import ergasia.Level;
import ergasia.Main;

public class Admin_main extends JFrame{
	
	private JButton buttonExit, buttonCreateTeacher, buttonCreateLesson, dataReset;
	private JPanel buttonsPanel, panel, createLessonPanel, createTeacherPanel;
	private JLabel backgroundLabel;
	private Admin admin=new Admin("Admin", Main.ser.getDataHolder().getPasswordAdmin());
	
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
	     this.setLayout(new FlowLayout(FlowLayout.CENTER, 5000, 50));
		 
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
		
		dataReset=new JButton();
		BufferedImage ddataReset = null;
		try {
			ddataReset = ImageIO.read(new File("reset.jpg"));
		} 
		catch (IOException e1) {
			e1.printStackTrace();
		}
		Image dataResetImage = ddataReset.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		dataReset.setIcon(new javax.swing.ImageIcon(dataResetImage));
		dataReset.setPreferredSize(new Dimension(170, 170));
		
		
		buttonsPanel=new JPanel();
		buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		buttonsPanel.add(dataReset);
		JLabel buttonslabel=new JLabel();
		BufferedImage dbuttonslabel = null;
		try {
			dbuttonslabel = ImageIO.read(new File("back.jpg"));
		} 
		catch (IOException e1) {
			e1.printStackTrace();
		}
		Image buttonslabelImage = dbuttonslabel.getScaledInstance(400,170, Image.SCALE_SMOOTH);
		buttonslabel.setIcon(new javax.swing.ImageIcon(buttonslabelImage));
		buttonsPanel.add(buttonslabel);
		buttonsPanel.add(buttonExit);
		
		this.add(buttonsPanel);		
		
		
		
		ButtonListener listener=new ButtonListener();
		buttonExit.addActionListener(listener);
		dataReset.addActionListener(listener);
		buttonCreateTeacher.addActionListener(listener);
		buttonCreateLesson.addActionListener(listener);
		
		this.setVisible(true);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setTitle("PLP");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	
	
class ButtonListener implements ActionListener {
	private JButton savebutton, savebutton2, backbutton, backbutton2, dictionary, yesbutton;
	private JTextField nametext = new JTextField();
	private JTextField passtext = new JTextField();
	private JTextField usertext = new JTextField();
	private JTextField lvltext = new JTextField(); 
	private JLabel stoixeiaLabel, stoixeiaLabel2;
	private JPanel stoixeiaPanel, stoixeiaPanel2;
	private JComboBox<String> cbox;
	private JFrame dataframe;
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==buttonExit){
				setVisible(false);
				dispose();
			}
			else if(e.getSource()==dataReset){
				dataframe=new JFrame();
				dataframe.setLayout(new GridLayout(2,0,0,0));
				dataframe.add(new JLabel("Διαγραφή όλων των αποθυκευμένων δεδομένων. Είσται σίγουρος;"));
				yesbutton=new JButton("Ναι");
				
				dataframe.add(yesbutton);
				
				dataframe.setVisible(true);
				dataframe.setSize(450, 100);
				dataframe.setLocationRelativeTo(null);
				resetListener listener=new resetListener();
				yesbutton.addActionListener(listener);
				
			}
			else if(e.getSource()==buttonCreateTeacher){
				  
		    	  JFrame frame = (JFrame) SwingUtilities.getRoot(getContentPane());
		    	  frame.remove(createLessonPanel);
		    	  frame.remove(createTeacherPanel);
		    	  frame.remove(buttonsPanel);
		    	  	    	
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
		    	JLabel namelabel=new JLabel("Ονοματεπώνυμο");
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
		    	
		    	
		    	cbox = new JComboBox<String>();
		        
		        if(Main.ser.getDataHolder().getLanguages()!=null){
		        	for(Language templanguage: Main.ser.getDataHolder().getLanguages()){
		        
		    		cbox.addItem(templanguage.getName());
		    	}
		        }
		        
			    langPanel.add(cbox);
			    
			    
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
		    	  frame.remove(buttonsPanel);
		    	      	  
		    	  
		    	
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
			private int lvls;
			private File file;
			private JTextField lvltext1 = new JTextField(), lvltext2= new JTextField(), lvltext3= new JTextField(), lvltext4= new JTextField(), lvltext5= new JTextField(), lvltext6= new JTextField(), lvltext7= new JTextField(), lvltext8= new JTextField(), lvltext9= new JTextField(), lvltext10= new JTextField();
			private String name;
			private JButton saveframes= new JButton("Save");
			private JFrame lvlframe;
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==savebutton){
					String name=(String) nametext.getText();
					String user=(String) usertext.getText();
					String pass=(String) passtext.getText();
					String templang=(String) cbox.getSelectedItem();
					
					Language teacherLanguage=null;
					for(Language aLanguage: Main.ser.getDataHolder().getLanguages()){
						if(templang.equals(aLanguage.getName())){
							teacherLanguage=aLanguage;
						break;
						}
					}
					admin.Create_Teacher(name, user, pass, teacherLanguage);
					nametext.setText("");
					usertext.setText("");
					passtext.setText("");
				}
				if(e.getSource()==savebutton2){
					String lvlnum=(String) lvltext.getText();
					lvls=Integer.valueOf(lvlnum);
					
				    if(lvls>10) lvls=10;
				    name=(String) nametext.getText();
				    
					lvlframe=new JFrame();
					lvlframe.setLayout(new GridLayout(lvls+2, 0,0,0));
					lvlframe.add(new JLabel("Εισαγωγη ονομάτων επιπέδων"));
					if(lvls==1){lvlframe.add(lvltext1); }
					if(lvls==2){lvlframe.add(lvltext1);lvlframe.add(lvltext2); }
					if(lvls==3){lvlframe.add(lvltext1);lvlframe.add(lvltext2);lvlframe.add(lvltext3); }
					if(lvls==4){lvlframe.add(lvltext1);lvlframe.add(lvltext2);lvlframe.add(lvltext3);lvlframe.add(lvltext4); }
					if(lvls==5){lvlframe.add(lvltext1);lvlframe.add(lvltext2);lvlframe.add(lvltext3);lvlframe.add(lvltext4);lvlframe.add(lvltext5); }
					if(lvls==6){lvlframe.add(lvltext1);lvlframe.add(lvltext2);lvlframe.add(lvltext3);lvlframe.add(lvltext4);lvlframe.add(lvltext5);lvlframe.add(lvltext6); }
					if(lvls==7){lvlframe.add(lvltext1);lvlframe.add(lvltext2);lvlframe.add(lvltext3);lvlframe.add(lvltext4);lvlframe.add(lvltext5);lvlframe.add(lvltext6);lvlframe.add(lvltext7); }
					if(lvls==8){lvlframe.add(lvltext1);lvlframe.add(lvltext2);lvlframe.add(lvltext3);lvlframe.add(lvltext4);lvlframe.add(lvltext5);lvlframe.add(lvltext6);lvlframe.add(lvltext7);lvlframe.add(lvltext8); }
					if(lvls==9){lvlframe.add(lvltext1);lvlframe.add(lvltext2);lvlframe.add(lvltext3);lvlframe.add(lvltext4);lvlframe.add(lvltext5);lvlframe.add(lvltext6);lvlframe.add(lvltext7);lvlframe.add(lvltext8);lvlframe.add(lvltext9); }
					if(lvls==10){lvlframe.add(lvltext1);lvlframe.add(lvltext2);lvlframe.add(lvltext3);lvlframe.add(lvltext4);lvlframe.add(lvltext5);lvlframe.add(lvltext6);lvlframe.add(lvltext7);lvlframe.add(lvltext8);lvlframe.add(lvltext9);lvlframe.add(lvltext10);}
					
					lvlframe.add(saveframes);
					lvlframe.setVisible(true);
					lvlListener listener=new lvlListener();
					saveframes.addActionListener(listener);
					lvlframe.setSize(400,220);
					lvlframe.setLocationRelativeTo(null);
					
				}
				if(e.getSource()==dictionary){
					int returnVal = fc.showOpenDialog(panel);

					if(returnVal == JFileChooser.OPEN_DIALOG) {
						 file = fc.getSelectedFile();						
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
					
					dataReset=new JButton();
					BufferedImage ddataReset = null;
					try {
						ddataReset = ImageIO.read(new File("reset.jpg"));
					} 
					catch (IOException e1) {
						e1.printStackTrace();
					}
					Image dataResetImage = ddataReset.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
					dataReset.setIcon(new javax.swing.ImageIcon(dataResetImage));
					dataReset.setPreferredSize(new Dimension(170, 170));
					
					buttonsPanel=new JPanel();
					buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
					buttonsPanel.add(dataReset);
					JLabel buttonslabel=new JLabel();
					BufferedImage dbuttonslabel = null;
					try {
						dbuttonslabel = ImageIO.read(new File("back.jpg"));
					} 
					catch (IOException e1) {
						e1.printStackTrace();
					}
					Image buttonslabelImage = dbuttonslabel.getScaledInstance(400,170, Image.SCALE_SMOOTH);
					buttonslabel.setIcon(new javax.swing.ImageIcon(buttonslabelImage));
					buttonsPanel.add(buttonslabel);
					buttonsPanel.add(buttonExit);
					
							
										
					
					frame.add(createTeacherPanel);
					frame.add(createLessonPanel);
					frame.add(buttonsPanel);
					frame.paintAll(getGraphics());
					
					
					ButtonListener listener=new ButtonListener();
					buttonExit.addActionListener(listener);
					dataReset.addActionListener(listener);
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
					
					dataReset=new JButton();
					BufferedImage ddataReset = null;
					try {
						ddataReset = ImageIO.read(new File("reset.jpg"));
					} 
					catch (IOException e1) {
						e1.printStackTrace();
					}
					Image dataResetImage = ddataReset.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
					dataReset.setIcon(new javax.swing.ImageIcon(dataResetImage));
					dataReset.setPreferredSize(new Dimension(170, 170));
					
					buttonsPanel=new JPanel();
					buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
					buttonsPanel.add(dataReset);
					JLabel buttonslabel=new JLabel();
					BufferedImage dbuttonslabel = null;
					try {
						dbuttonslabel = ImageIO.read(new File("back.jpg"));
					} 
					catch (IOException e1) {
						e1.printStackTrace();
					}
					Image buttonslabelImage = dbuttonslabel.getScaledInstance(400,170, Image.SCALE_SMOOTH);
					buttonslabel.setIcon(new javax.swing.ImageIcon(buttonslabelImage));
					buttonsPanel.add(buttonslabel);
					buttonsPanel.add(buttonExit);
					
				
					
					frame.add(createTeacherPanel);
					frame.add(createLessonPanel);
					frame.add(buttonsPanel);
					frame.paintAll(getGraphics());
					
					
					ButtonListener listener=new ButtonListener();
					buttonExit.addActionListener(listener);
					dataReset.addActionListener(listener);
					buttonCreateTeacher.addActionListener(listener);
					buttonCreateLesson.addActionListener(listener);
				}
				
			}
			class lvlListener implements ActionListener {
				public void actionPerformed(ActionEvent e){
					if(e.getSource()==saveframes){
						String text1,text2,text3,text4,text5,text6,text7,text8,text9,text10;
						text1=lvltext1.getText();text2=lvltext2.getText();text3=lvltext3.getText();text4=lvltext4.getText();text5=lvltext5.getText();text6=lvltext6.getText();text7=lvltext7.getText();text8=lvltext8.getText();text9=lvltext9.getText();text10=lvltext10.getText();
						
						ArrayList<Level> tlvls=new ArrayList<Level>();
						admin.create_Language(name, file,tlvls);		//vale to File 
						Language templang=null;
						for(Language language: Main.ser.getDataHolder().getLanguages()){
							;
							if(language.getName().equals(name)){
								templang=language;
								break;
							}
						}
						if(lvls==1){
							admin.Create_Level(templang, text1);
						}
						if(lvls==2){
							admin.Create_Level(templang, text1);admin.Create_Level(templang, text2);
						}
						if(lvls==3){
							admin.Create_Level(templang, text1);admin.Create_Level(templang, text2);admin.Create_Level(templang, text3);
						}
						if(lvls==4){
							admin.Create_Level(templang, text1);admin.Create_Level(templang, text2);admin.Create_Level(templang, text3);admin.Create_Level(templang, text4);
						}
						if(lvls==5){
							admin.Create_Level(templang, text1);admin.Create_Level(templang, text2);admin.Create_Level(templang, text3);admin.Create_Level(templang, text4);admin.Create_Level(templang, text5);
						}
						if(lvls==6){
							admin.Create_Level(templang, text1);admin.Create_Level(templang, text2);admin.Create_Level(templang, text3);admin.Create_Level(templang, text4);admin.Create_Level(templang, text5);admin.Create_Level(templang, text6);
						}
						if(lvls==7){
							admin.Create_Level(templang, text1);admin.Create_Level(templang, text2);admin.Create_Level(templang, text3);admin.Create_Level(templang, text4);admin.Create_Level(templang, text5);admin.Create_Level(templang, text6);admin.Create_Level(templang, text7);
						}
						if(lvls==8){
							admin.Create_Level(templang, text1);admin.Create_Level(templang, text2);admin.Create_Level(templang, text3);admin.Create_Level(templang, text4);admin.Create_Level(templang, text5);admin.Create_Level(templang, text6);admin.Create_Level(templang, text7);admin.Create_Level(templang, text8);
						}
						if(lvls==9){
							admin.Create_Level(templang, text1);admin.Create_Level(templang, text2);admin.Create_Level(templang, text3);admin.Create_Level(templang, text4);admin.Create_Level(templang, text5);admin.Create_Level(templang, text6);admin.Create_Level(templang, text7);admin.Create_Level(templang, text8);admin.Create_Level(templang, text9);
						}
						if(lvls==10){
							admin.Create_Level(templang, text1);admin.Create_Level(templang, text2);admin.Create_Level(templang, text3);admin.Create_Level(templang, text4);admin.Create_Level(templang, text5);admin.Create_Level(templang, text6);admin.Create_Level(templang, text7);admin.Create_Level(templang, text8);admin.Create_Level(templang, text9);admin.Create_Level(templang, text10);
						}
						lvlframe.dispose();
						lvltext1.setText("");lvltext2.setText("");lvltext3.setText("");lvltext4.setText("");lvltext5.setText("");lvltext6.setText("");lvltext7.setText("");lvltext8.setText("");lvltext9.setText("");lvltext10.setText("");
					    lvltext.setText("");nametext.setText("");
					}
				}
				
				
			}
			
		}
		class resetListener implements ActionListener {
			public void actionPerformed(ActionEvent e){
				if(e.getSource()==yesbutton){
					Main.ser.LanguageSerializing(null);
					Main.ser.ListeningQuestionsSerializing(null);
					Main.ser.ReadingQuestionsSerializing(null);
					Main.ser.StudentSerializing(null);
					Main.ser.TeachersSerializing(null);
					Main.ser.VocabularyQuestionsSerializing(null);
					Main.ser.GrammarQuestionsSerializing(null);
					
					String filename="Ma8itess.xls";						//apo8ikeusi se excel
					
						
						
						HSSFWorkbook workbook = new HSSFWorkbook();
			        	HSSFSheet sheet = workbook.createSheet("Sample sheet");
			        	
					    HSSFRow rowhead=   sheet.createRow((short)0);
				        rowhead.createCell(0).setCellValue("No.");
				        rowhead.createCell(1).setCellValue("Ονοματεπώνυμο");
				        rowhead.createCell(2).setCellValue("Username");

				        FileOutputStream fileOut = null;
						try {
							fileOut = new FileOutputStream(filename);
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				        try {
							workbook.write(fileOut);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				        try {
							fileOut.close();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				        
				        
				        
				        filename="Kathigites.xls" ;	
				        
				        fileOut = null;
						try {
							fileOut = new FileOutputStream(filename);
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				        try {
							workbook.write(fileOut);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				        try {
							fileOut.close();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					
					dataframe.dispose();
					dispose();
				}
			}
			
			
		}
		
}
}
