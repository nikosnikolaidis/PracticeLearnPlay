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

import ergasia.Level;
import ergasia.Main;
import ergasia.User;



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
		private JButton questbutton=new JButton("Next"), savebutton, savebutton2, backbutton, backbutton2;
		private JTextField nametext = new JTextField();
		private JTextField passtext = new JTextField();
		private JTextField usertext = new JTextField(); 
		private JLabel stoixeiaLabel, stoixeiaLabel2;
		private JPanel stoixeiaPanel, stoixeiaPanel2;
		private JComboBox<String> cbox, cbox1, cbox2, cbox3;
		private JFrame questype;
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==buttonExit){
				dispose();
			}else if(e.getSource()==buttonCreateQuestion){
				i=1;
				questype=new JFrame();
				questype.setLayout(new GridLayout(2, 0, 0, 0));

				JPanel duoSelectionPanel = new JPanel();
				duoSelectionPanel.setLayout(new GridLayout(0, 3, 0, 0));

				cbox1 = new JComboBox<String>();
				cbox1.addItem("Vocabulary");
				cbox1.addItem("Grammar");
				cbox1.addItem("Listening");
				cbox1.addItem("Reading");


				cbox2 = new JComboBox<String>();
				cbox2.addItem("multiple choice");
				cbox2.addItem("matching");

				cbox3 = new JComboBox<String>();
				for(Level alvl: Main.ser.getDataHolder().getTeacherNow().getLanguage().getLevels()){
					cbox3.addItem(alvl.getNameOfLevel());
				}

				duoSelectionPanel.add(cbox1);
				duoSelectionPanel.add(cbox2);
				duoSelectionPanel.add(cbox3);

				questype.add(duoSelectionPanel);
				cbox1.setSelectedIndex(0);
				cbox2.setSelectedIndex(0);
				cbox3.setSelectedIndex(0);

				JPanel buttonpanel= new JPanel();
				buttonpanel.setLayout(new FlowLayout(FlowLayout.CENTER));
				buttonpanel.add(questbutton);
				questype.add(buttonpanel);
				questype.setVisible(true);
				questype.setSize(450, 100);
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

				//			saveListener listener=new saveListener();
				//			backbutton.addActionListener(listener);
				//			savebutton.addActionListener(listener);

				frame.paintAll(getGraphics());
			}
		}

		class questListener implements ActionListener{ 
			private int antikeimeno;
			private int typosAskhshs;
			private String lvl;
            
			public void actionPerformed(ActionEvent e){
				if(e.getSource()==questbutton){

					//antoistoixhsh
					antikeimeno=(int) cbox1.getSelectedIndex();
					typosAskhshs=(int) cbox2.getSelectedIndex();
					lvl=(String) (cbox3.getSelectedItem());

					questype.dispose();
			

					if(typosAskhshs==0){
                    
					if(i==1){
						new MultipleChoiceFrame(antikeimeno,lvl);
						i++;
					}
					}
					else if(typosAskhshs==1)
					{
						
					//	new MatchingFrame(antikeimeno,lvl);
						i++;
					}
					else if(typosAskhshs==2){
						//new ListeningQuestionFrame()
						i++;
					}
					else if(typosAskhshs==3){
						
						i++;
					}
					

				}




			}
		}
	}

}
