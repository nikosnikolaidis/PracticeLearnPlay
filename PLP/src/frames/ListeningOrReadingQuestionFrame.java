package frames;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import ergasia.Level;
import ergasia.Main;

public class ListeningOrReadingQuestionFrame extends JFrame {
	private JButton next=new JButton("Συνέχεια");
	private int  antikeimeno;
	private JTextArea area=new JTextArea(10, 40);
	private JTextField field=new JTextField();
	private JLabel label;
	private JComboBox<String> cbox2=new JComboBox<String>();
	
	public ListeningOrReadingQuestionFrame(int antikeimeno){
		this.antikeimeno=antikeimeno;
		
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 5000, 50));
		JPanel panel=new JPanel();
		panel.setLayout(new GridLayout(2,0,2,2));
		
		if(antikeimeno==4){
			label=new JLabel("Ονομα αρχείου ήχου.τύπος");
			panel.add(label);
			panel.add(field);
		}
		if(antikeimeno==5){
			label=new JLabel("Πληκτρολογήστε το κείμενο της άσκησης");
			panel.add(label);
			JScrollPane scroll = new JScrollPane (area, 
					   JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
			panel.add(scroll);
		}
		
		next.addActionListener(new ButtonListener());
		
		this.add(panel);
		this.add(next);
		this.setTitle("PLP");
		if(antikeimeno==4) this.setSize(300, 300);
		if(antikeimeno==5) this.setSize(600, 700);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
	}
	
	
	class ButtonListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==next){
				if(antikeimeno==4){
					String str=(String) field.getText();
					new MultipleChoiceFrame(antikeimeno, str);
					dispose();
				}
				if(antikeimeno==5){
					String str=(String) area.getText();
					new MultipleChoiceFrame(antikeimeno, str);
					dispose();
				}
			}
			
		}
	}
}
