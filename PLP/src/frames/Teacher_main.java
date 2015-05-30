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
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import ergasia.Language;
import ergasia.Level;
import ergasia.Main;
import ergasia.User;
import frames.Admin_main.ButtonListener;



public class Teacher_main extends JFrame {
	private JLabel backgroundLabel;
	private JButton buttonExit, buttonCreateQuestion, buttonCreateStudent;
	private JPanel createStudentPanel, createQuestionPanel;
	private User teacher;
	private int i=0;

	public Teacher_main(){

		

		
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
		private JButton questbutton=new JButton("Next"), savebutton, backbutton;
		private JTextField nametext = new JTextField();
		private JTextField passtext = new JTextField();
		private JTextField usertext = new JTextField(); 
		private JLabel stoixeiaLabel;
		private JPanel stoixeiaPanel;
		private JComboBox<String> cbox, cbox1;
		private JFrame questype;
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==buttonExit){
				dispose();
				
			}
			else if(e.getSource()==buttonCreateQuestion){
				i=1;
				questype=new JFrame();
				questype.setLayout(new GridLayout(2, 0, 0, 0));

				JPanel duoSelectionPanel = new JPanel();
				duoSelectionPanel.setLayout(new GridLayout(0, 1, 0, 0));

				cbox1 = new JComboBox<String>();
				cbox1.addItem("Vocabulary, multiple choice");
				cbox1.addItem("Vocabulary, matching");
				cbox1.addItem("Grammar, multiple choice");
				cbox1.addItem("Grammar, matching");
				cbox1.addItem("Listening");
				cbox1.addItem("Reading");


				


				duoSelectionPanel.add(cbox1);
	

				questype.add(duoSelectionPanel);
				cbox1.setSelectedIndex(0);
				

				JPanel buttonpanel= new JPanel();
				buttonpanel.setLayout(new FlowLayout(FlowLayout.CENTER));
				buttonpanel.add(questbutton);
				questype.add(buttonpanel);
				questype.setVisible(true);
				questype.setSize(320, 100);
				questype.setLocationRelativeTo(null);
				questype.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
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
				JLabel namelabel=new JLabel("�������������");
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
				JLabel lvllabel=new JLabel("�������");
				lvlPanel.add(lvllabel);


				cbox = new JComboBox<String>();

				if(Main.ser.getDataHolder().getTeacherNow().getLanguage()!=null){
					for(Level templvl: Main.ser.getDataHolder().getTeacherNow().getLanguage().getLevels()){

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

							backListener listener=new backListener();
							backbutton.addActionListener(listener);
							savebutton.addActionListener(listener);

				frame.paintAll(getGraphics());
			}
		}
class backListener implements ActionListener{
	public void actionPerformed(ActionEvent e){
		
		if(e.getSource()==backbutton){
			
			JFrame frame = (JFrame) SwingUtilities.getRoot(getContentPane());
			frame.remove(backbutton);
			frame.remove(stoixeiaPanel);
			frame.remove(stoixeiaLabel);
			
			
			
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

			frame.add(createStudentPanel);

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

			frame.add(createQuestionPanel);

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

			frame.add(buttonExit);
			frame.paintAll(getGraphics());

			ButtonListener listener=new ButtonListener();

			buttonCreateQuestion.addActionListener(listener);
			buttonCreateStudent.addActionListener(listener);
			buttonExit.addActionListener(listener);

			
		}
		if(e.getSource()==savebutton){
			String name=(String) nametext.getText();
			String user=(String) usertext.getText();
			String pass=(String) passtext.getText();
			String templvl=(String) cbox.getSelectedItem();
			
			Level studentLevel=null;
			for(Level aLevel: Main.ser.getDataHolder().getTeacherNow().getLanguage().getLevels()){
				if(templvl.equals(aLevel.getNameOfLevel())){
					studentLevel=aLevel;
				break;
				}
			}
			Main.ser.getDataHolder().getTeacherNow().Create_Student(name, user, pass, studentLevel);
			nametext.setText("");
			usertext.setText("");
			passtext.setText("");
		}
	}
}
		class questListener implements ActionListener{ 
			private int antikeimeno;
			
            
			public void actionPerformed(ActionEvent e){
				if(e.getSource()==questbutton){

					//antoistoixhsh
					antikeimeno=(int) cbox1.getSelectedIndex();
					

					questype.dispose();
			

					if(antikeimeno==0){
						
					if(i==1){
						new MultipleChoiceFrame(antikeimeno, null);
						i++;
					}
					}
					else if(antikeimeno==1)
					{
						
						if(i==1){
							new MatchingFrame(antikeimeno);
							i++;
							}
						
					}
					if(antikeimeno==2){
					
						if(i==1){
							new MultipleChoiceFrame(antikeimeno, null);
							i++;
						}
						}
						else if(antikeimeno==3)
						{
						
							if(i==1){
								new MatchingFrame(antikeimeno);
								i++;
								}
						}
					else if(antikeimeno==4||antikeimeno==5){
						if(i==1){
						new ListeningOrReadingQuestionFrame(antikeimeno);
						i++;
						}
					}
					

				}




			}
		}
	}

}
