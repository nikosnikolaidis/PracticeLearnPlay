package frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Teacher_addQuestion extends JFrame {

	private JTextField TextAntikimeno, TextEidos, TextEpipedo;
	private JButton buttonMainMenu, buttonNext;
	private JPanel panel;
	private JList List_Antikimeno, List_Eidos, List_Epipedo;
	private DefaultListModel modelAntikimeno, modelEidos, modelEpipedo;
	
	public Teacher_addQuestion(){
		TextAntikimeno=new JTextField("Αντικείμενο");
		TextEidos=new JTextField("Είδος ’σκησης");
		TextEpipedo=new JTextField("Επίπεδο");
		buttonMainMenu=new JButton("Main Menu");
		buttonNext=new JButton("Συνέχεια");
		List_Antikimeno=new JList();
		List_Eidos=new JList();
		List_Epipedo=new JList();
		panel=new JPanel();
		
		modelAntikimeno =new DefaultListModel();
		modelEidos =new DefaultListModel();
		modelEpipedo =new DefaultListModel();
		
		modelAntikimeno.addElement("Vocabulary");
		modelAntikimeno.addElement("Grammar");
		modelAntikimeno.addElement("Reading");
		modelAntikimeno.addElement("Listening");
		
		modelEidos.addElement("Πολλαπλης Επιλογης");
		modelEidos.addElement("Αντιστοίχιση");
		
		modelEpipedo.addElement("Junior");
		modelEpipedo.addElement("Lower");
		modelEpipedo.addElement("Proficiency");
		
		List_Antikimeno.setModel(modelAntikimeno);
		List_Eidos.setModel(modelEidos);
		List_Epipedo.setModel(modelEpipedo);
		
		panel.add(TextAntikimeno);
		panel.add(List_Antikimeno);
		panel.add(TextEidos);
		panel.add(List_Eidos);
		panel.add(TextEpipedo);
		panel.add(List_Epipedo);
		panel.add(buttonMainMenu);
		panel.add(buttonNext);
		
		this.setContentPane(panel);
		
		ButtonListener listener=new ButtonListener();
		buttonMainMenu.addActionListener(listener);
		buttonNext.addActionListener(listener);
		
		this.setVisible(true);
		this.setSize(400,400);
		this.setTitle("Event Example");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
class ButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==buttonMainMenu){
				setVisible(false);
				dispose();
				new Teacher_main();
			}else if(e.getSource()==buttonNext){
				setVisible(false);
				dispose();
											//analogos me to idos askisis
			}
		}
	}
}
