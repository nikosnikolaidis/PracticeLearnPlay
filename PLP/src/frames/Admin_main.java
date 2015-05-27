package frames;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
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

public class Admin_main extends JFrame{
	
	private JButton buttonExit, buttonCreateTeacher, buttonCreateLesson;
	private JPanel panel;
	
	public Admin_main(){
		
		
		buttonCreateLesson=new JButton("Δημιουργία Μαθήματος");
		
		 BufferedImage background = null;
			try {
				background = ImageIO.read(new File("back.jpg"));
			} 
			catch (IOException e1) {
				e1.printStackTrace();
			}
			Image dbackground = background.getScaledInstance(1980, 1020, Image.SCALE_SMOOTH);
 		  JLabel backgroundLabel = new JLabel();
 		  backgroundLabel.setIcon(new javax.swing.ImageIcon(dbackground));
 		 this.setLayout(new BorderLayout());
 		 this.setContentPane(backgroundLabel);
	     this.setLayout(new FlowLayout(FlowLayout.CENTER, 5000, 150));
		
	    
		JPanel createTeacherPanel=new JPanel();
		createTeacherPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		
		JLabel createTeacherLabel=new JLabel();
		BufferedImage dcreateTeacherLabel = null;
		try {
			dcreateTeacherLabel = ImageIO.read(new File("createteacherlabel.png"));
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
		Image createTeacherButtonImage = dcreateTeacherButton.getScaledInstance(250, 200, Image.SCALE_SMOOTH);
		buttonCreateTeacher.setIcon(new javax.swing.ImageIcon(createTeacherButtonImage));
		buttonCreateTeacher.setPreferredSize(new Dimension(200, 150));
	    
		createTeacherPanel.add(createTeacherLabel);
		createTeacherPanel.add(buttonCreateTeacher);
		
		this.add(createTeacherPanel);
		
		
		JPanel createLessonPanel=new JPanel();
		createLessonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		
		JLabel createLessonLabel=new JLabel();
		BufferedImage dcreateLessonLabel = null;
		try {
			dcreateLessonLabel = ImageIO.read(new File("createlessonlabel.png"));
		} 
		catch (IOException e1) {
			e1.printStackTrace();
		}
		Image createLessonLabelImage = dcreateLessonLabel.getScaledInstance(400, 150, Image.SCALE_SMOOTH);
		createLessonLabel.setIcon(new javax.swing.ImageIcon(createLessonLabelImage));
		
		buttonCreateLesson = new JButton();
		BufferedImage dcreateLessonButton = null;
		try {
			dcreateLessonButton = ImageIO.read(new File("createlesson.jpg"));
		} 
		catch (IOException e1) {
			e1.printStackTrace();
		}
		Image createLessonButtonImage = dcreateLessonButton.getScaledInstance(270, 200, Image.SCALE_SMOOTH);
		buttonCreateLesson.setIcon(new javax.swing.ImageIcon(createLessonButtonImage));
		buttonCreateLesson.setPreferredSize(new Dimension(250, 150));
	    
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
		buttonExit.setPreferredSize(new Dimension(190, 190));
		
		
		
		
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
		
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==buttonExit){
				setVisible(false);
				dispose();
			}else if(e.getSource()==buttonCreateTeacher){
				 
			}else if(e.getSource()==buttonCreateLesson){
				

			}
		}
	}
}
