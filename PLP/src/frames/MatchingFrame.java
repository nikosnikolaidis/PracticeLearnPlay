package frames;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import ergasia.Grammar;
import ergasia.Level;
import ergasia.Main;
import ergasia.Vocabulary;

public class MatchingFrame extends JFrame {
	private JPanel questPanel=new JPanel();
	private JComboBox<String> cbox2=new JComboBox<String>();
	private JButton saveQuestion=new JButton("Save");
	private JButton exitButton=new JButton("Exit");
	private JLabel llvl=new JLabel("Epipedo"), lap5=new JLabel("                             5", SwingConstants.RIGHT), lap1=new JLabel("1", SwingConstants.RIGHT), lap3=new JLabel("3", SwingConstants.RIGHT), lap4=new JLabel("4", SwingConstants.RIGHT), lap2=new JLabel("2", SwingConstants.RIGHT);
	private JLabel lapE=new JLabel("E", SwingConstants.RIGHT), lapA=new JLabel("A", SwingConstants.RIGHT), lapC=new JLabel("C", SwingConstants.RIGHT), lapD=new JLabel("D", SwingConstants.RIGHT), lapB=new JLabel("B", SwingConstants.RIGHT);
	private JLabel lsap5=new JLabel("5 to", SwingConstants.RIGHT), lsap1=new JLabel("1 to", SwingConstants.RIGHT), lsap3=new JLabel("3 to", SwingConstants.RIGHT), lsap4=new JLabel("4 to", SwingConstants.RIGHT), lsap2=new JLabel("2 to", SwingConstants.RIGHT);
	private JTextField ap1=new JTextField(""), ap2=new JTextField(""), ap3=new JTextField(""), ap4=new JTextField(""), ap5=new JTextField("");
	private JTextField apA=new JTextField(""), apB=new JTextField(""), apC=new JTextField(""), apD=new JTextField(""), apE=new JTextField("");
	private JTextField sap1=new JTextField(""), sap2=new JTextField(""), sap3=new JTextField(""), sap4=new JTextField(""), sap5=new JTextField("");
	private int antikeimeno;
	private JPanel panel, panelb, stili1, stili2, stili3, stili4, stili5, stili6;
	public MatchingFrame(int antikeimeno){
		
		this.antikeimeno=antikeimeno;
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 5000, 10));
		panel=new JPanel();
		panel.setLayout(new GridLayout(0,6,10,10));
		
		stili1=new JPanel();
		
		stili1.setLayout(new GridLayout(5,1,0,0));
		stili1.add(lap1);
		stili1.add(lap2);
		stili1.add(lap3);
		stili1.add(lap4);
		stili1.add(lap5);
		
		stili2=new JPanel();
		stili2.setLayout(new GridLayout(5,0,0,0));
		stili2.add(ap1);
		stili2.add(ap2);
		stili2.add(ap3);
		stili2.add(ap4);
		stili2.add(ap5);
		
		stili3=new JPanel();
		stili3.setLayout(new GridLayout(5,0,0,0));
		stili3.add(lapA);
		stili3.add(lapB);
		stili3.add(lapC);
		stili3.add(lapD);
		stili3.add(lapE);
		
		stili4=new JPanel();
		stili4.setLayout(new GridLayout(5,0,0,0));
		stili4.add(apA);
		stili4.add(apB);
		stili4.add(apC);
		stili4.add(apD);
		stili4.add(apE);
		
		
		
		stili5=new JPanel();
		stili5.setLayout(new GridLayout(5,0,0,0));	
		stili5.add(lsap1);
		stili5.add(lsap2);
		stili5.add(lsap3);
		stili5.add(lsap4);
		stili5.add(lsap5);
		
		stili6=new JPanel();
		stili6.setLayout(new GridLayout(5,0,0,0));
		stili6.add(sap1);
		stili6.add(sap2);	
		stili6.add(sap3);		
		stili6.add(sap4);		
		stili6.add(sap5);
		
		for(Level alvl :Main.ser.getDataHolder().getTeacherNow().getLanguage().getLevels()){
			cbox2.addItem(alvl.getNameOfLevel());
		}
		
		questPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 150, 10));
		questPanel.add(llvl);questPanel.add(cbox2);
		
		
		panelb=new JPanel(new FlowLayout(FlowLayout.CENTER, 150, 10));
		panelb.add(saveQuestion);
		panelb.add(exitButton);
		
		
		panel.add(stili1);
		panel.add(stili2);
		panel.add(stili3);
		panel.add(stili4);
		panel.add(stili5);
		panel.add(stili6);
		this.add(panel);
		this.add(questPanel);
		this.add(panelb);
		
		
		saveQuestion.addActionListener(new saveButtonListener());
        exitButton.addActionListener(new saveButtonListener());
		
		this.setVisible(true);
		this.setSize(700, 250);
		this.setTitle("PLP");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		
		
		
	}
public class saveButtonListener implements ActionListener{
		

		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==saveQuestion)
			{
				
				
				String a1=(String) ap1.getText();
				String a2=(String) ap2.getText();
				String a3=(String) ap3.getText();
				String a4=(String) ap4.getText();
				String a5=(String) ap5.getText();
				ArrayList<String> stiliA=new ArrayList<String>();
				stiliA.add(a1);
				stiliA.add(a2);
				stiliA.add(a3);
				stiliA.add(a4);
				stiliA.add(a5);
				
				String aA=(String) apA.getText();
				String aB=(String) apB.getText();
				String aC=(String) apC.getText();
				String aD=(String) apD.getText();
				String aE=(String) apE.getText();
				ArrayList<String> stiliB=new ArrayList<String>();
				stiliB.add(a1);
				stiliB.add(a2);
				stiliB.add(a3);
				stiliB.add(a4);
				stiliB.add(a5);
				
				String sa1=(String) sap1.getText();
				String sa2=(String) sap2.getText();
				String sa3=(String) sap3.getText();
				String sa4=(String) sap4.getText();
				String sa5=(String) sap4.getText();
				ArrayList<String> stiliC=new ArrayList<String>();
				stiliC.add(a1);
				stiliC.add(a2);
				stiliC.add(a3);
				stiliC.add(a4);
				stiliC.add(a5);
				
				String l=(String) cbox2.getSelectedItem();
				Level lvl=null;
				for(Level alvl: Main.ser.getDataHolder().getTeacherNow().getLanguage().getLevels()){
					if(alvl.getNameOfLevel().equals(l)){
						lvl=alvl;
						break;
					}
					
				
				
				
					
				}
				if(antikeimeno==1){
					Vocabulary vocabulary=new Vocabulary(Main.ser.getDataHolder().getTeacherNow().getLanguage(), lvl);
					vocabulary.createMatching(stiliA, stiliB, stiliC);
					
				}
				if(antikeimeno==3){
					Grammar grammar=new Grammar(Main.ser.getDataHolder().getTeacherNow().getLanguage(), lvl);
					grammar.createMatching(stiliA, stiliB, stiliC);
					
				}		
			}
			
			if(e.getSource()==exitButton){
								
				dispose();
			}
		}

	}


	
}
