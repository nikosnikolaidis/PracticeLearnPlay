package kremala;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.*;

import ergasia.Language;
import ergasia.Main;


public class GramEl extends JFrame {
	private JPanel panelkatw;
	private JPanel panel;
	private JPanel panelaristera;
	private JPanel panelde3ia;
	private JPanel panelmesi;
	private JButton Neo;
	private JButton A;
	private JButton B;
	private JButton G;
	private JButton D;
	private JButton E;
	private JButton Z;
	private JButton H;
	private JButton TH;
	private JButton I;
	private JButton K;
	private JButton L;
	private JButton M;
	private JButton N;
	private JButton KS;
	private JButton O;
	private JButton P;
	private JButton R;
	private JButton S;
	private JButton T;
	private JButton Y;
	private JButton F;
	private JButton X;
	private JButton PS;
	private JButton W;
	private JTextField lifesleft;
	private JTextField lifesleft1;
	private JTextField Skor;
	private JTextField Skor1;
	private JTextField le3i;
	private JTextField la8osgramata;
	private String le3iTixea;
	
	private int zwes=5;
	private int skor;
	
	public void setSkor(int skor) {
		this.skor = skor;
	}

	public int getSkor() {
		return skor;
	}

	GridLayout katwLayout= new GridLayout(2,1);
	
	public GramEl(int skor){
		this.skor=skor;
		ArrayList<Language> languages=Main.ser.LanguageDeserializing();
		ArrayList<String> le3iko =new ArrayList<String>();
		for(Language l:languages){
			if(l==Main.ser.getDataHolder().getStudentNow().getStudentLevel().getLanguage()){
				le3iko=l.getDictionary();
			}
		}
		int ran=new Random().nextInt(le3iko.size());
		String randomLe3="";
		int i=0;
		for(String str: le3iko){
			if(i==ran){
				randomLe3= str;
			}
			i++;
		}
		le3iTixea= randomLe3;
		int le3iLength= le3iTixea.length();
		System.out.println(le3iTixea);
		
		panel = new JPanel();
		
		panelmesi=new JPanel();
		panelmesi.setLayout(katwLayout);
		String arxikaKena="";
		for(int i=1;i<=le3iLength;i++){
			arxikaKena=arxikaKena+"_";
		}
		le3i=new JTextField(arxikaKena);
		le3i.setEditable(false);
		
		la8osgramata=new JTextField("");
		la8osgramata.setEditable(false);
		panelmesi.add(le3i);
		panelmesi.add(la8osgramata);
		
		panelde3ia=new JPanel();
		Neo=new JButton("���");
		panelde3ia.add(Neo);
		
		panelaristera=new JPanel();
		panelaristera.setLayout(katwLayout);
		Skor=new JTextField(""+skor);
		Skor.setEditable(false);
		lifesleft=new JTextField(""+zwes);
		lifesleft.setEditable(false);
		Skor1=new JTextField("����");
		Skor1.setEditable(false);
		lifesleft1=new JTextField("����");
		lifesleft1.setEditable(false);
		panelaristera.add(Skor);
		panelaristera.add(Skor1);
		panelaristera.add(lifesleft);
		panelaristera.add(lifesleft1);
		
		panelkatw = new JPanel();
		panelkatw.setLayout(katwLayout);
		A= new JButton("�");
		B= new JButton("�");
		G= new JButton("�");
		D= new JButton("�");
		E= new JButton("�");
		Z= new JButton("�");
		H= new JButton("�");
		TH= new JButton("�");
		I= new JButton("�");
		K= new JButton("�");
		L= new JButton("�");
		M= new JButton("�");
		N= new JButton("�");
		KS= new JButton("�");
		O= new JButton("�");
		P= new JButton("�");
		R= new JButton("�");
		S= new JButton("�");
		T= new JButton("�");
		Y= new JButton("�");
		F= new JButton("�");
		X= new JButton("�");
		PS= new JButton("�");
		W= new JButton("�");
		
		panelkatw.add(A);
		panelkatw.add(B);
		panelkatw.add(G);
		panelkatw.add(D);
		panelkatw.add(E);
		panelkatw.add(Z);
		panelkatw.add(H);
		panelkatw.add(TH);
		panelkatw.add(I);
		panelkatw.add(K);
		panelkatw.add(L);
		panelkatw.add(M);
		panelkatw.add(N);
		panelkatw.add(KS);
		panelkatw.add(O);
		panelkatw.add(P);
		panelkatw.add(R);
		panelkatw.add(S);
		panelkatw.add(T);
		panelkatw.add(Y);
		panelkatw.add(F);
		panelkatw.add(X);
		panelkatw.add(PS);
		panelkatw.add(W);
		
		JLabel backgroundLabel;
		BufferedImage background = null;
		try {
			background = ImageIO.read(new File("back.jpg"));
		} 
		catch (IOException e1) {
			e1.printStackTrace();
		}
		Image dbackground = background.getScaledInstance(600, 300, Image.SCALE_SMOOTH);
		  backgroundLabel = new JLabel();
		  backgroundLabel.setIcon(new javax.swing.ImageIcon(dbackground));
		 this.setLayout(new BorderLayout());
		 this.setContentPane(backgroundLabel);
		 this.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 50));
		
		
		 this.add(panelaristera);
		 this.add(panelmesi);
		 this.add(panelde3ia);
		 this.add(panelkatw);
		
		ButtonListener listener=new ButtonListener();
		A.addActionListener(listener);
		B.addActionListener(listener);
		G.addActionListener(listener);
		D.addActionListener(listener);
		E.addActionListener(listener);
		Z.addActionListener(listener);
		H.addActionListener(listener);
		TH.addActionListener(listener);
		I.addActionListener(listener);
		K.addActionListener(listener);
		L.addActionListener(listener);
		M.addActionListener(listener);
		N.addActionListener(listener);
		KS.addActionListener(listener);
		O.addActionListener(listener);
		P.addActionListener(listener);
		R.addActionListener(listener);
		S.addActionListener(listener);
		T.addActionListener(listener);
		Y.addActionListener(listener);
		F.addActionListener(listener);
		X.addActionListener(listener);
		PS.addActionListener(listener);
		W.addActionListener(listener);
		Neo.addActionListener(listener);
		
		this.setVisible(true);
		this.setSize(600, 300);
		this.setTitle("Kremala");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==Neo){
				setVisible(false);
				dispose();
				new GramEl(0);
			}
			if(e.getSource()==A){
				if(le3iTixea.contains("�") ){
					String le3ixoris= le3i.getText();
					char[] le3iTixeaChar=le3iTixea.toCharArray();
					for(int i=0;i<le3iTixea.length();i++){
						if(le3iTixeaChar[i]=='�'){
							char[] tempor=le3ixoris.toCharArray();
							tempor[i]='�';
							le3ixoris=String.valueOf(tempor);
							le3i.setText(le3ixoris);
						}
					}
				}
				else{
					la8osgramata.setText(la8osgramata.getText()+"�,");
					zwes=zwes-1;
					int temp=zwes;
					lifesleft.setText(""+temp);
				}
				A.setEnabled(false);
			}
			if(e.getSource()==B){
				if(le3iTixea.contains("�") ){
					String le3ixoris= le3i.getText();
					char[] le3iTixeaChar=le3iTixea.toCharArray();
					for(int i=0;i<le3iTixea.length();i++){
						if(le3iTixeaChar[i]=='�'){
							char[] tempor=le3ixoris.toCharArray();
							tempor[i]='�';
							le3ixoris=String.valueOf(tempor);
							le3i.setText(le3ixoris);
						}
					}
				}
				else{
					la8osgramata.setText(la8osgramata.getText()+"�,");
					zwes=zwes-1;
					int temp=zwes;
					lifesleft.setText(""+temp);
				}
				B.setEnabled(false);
			}
			if(e.getSource()==G){
				if(le3iTixea.contains("�") ){
					String le3ixoris= le3i.getText();
					char[] le3iTixeaChar=le3iTixea.toCharArray();
					for(int i=0;i<le3iTixea.length();i++){
						if(le3iTixeaChar[i]=='�'){
							char[] tempor=le3ixoris.toCharArray();
							tempor[i]='�';
							le3ixoris=String.valueOf(tempor);
							le3i.setText(le3ixoris);
						}
					}
				}
				else{
					la8osgramata.setText(la8osgramata.getText()+"�,");
					zwes=zwes-1;
					int temp=zwes;
					lifesleft.setText(""+temp);
				}
				G.setEnabled(false);
			}
			if(e.getSource()==D){
				if(le3iTixea.contains("�") ){
					String le3ixoris= le3i.getText();
					char[] le3iTixeaChar=le3iTixea.toCharArray();
					for(int i=0;i<le3iTixea.length();i++){
						if(le3iTixeaChar[i]=='�'){
							char[] tempor=le3ixoris.toCharArray();
							tempor[i]='�';
							le3ixoris=String.valueOf(tempor);
							le3i.setText(le3ixoris);
						}
					}
				}
				else{
					la8osgramata.setText(la8osgramata.getText()+"�,");
					zwes=zwes-1;
					int temp=zwes;
					lifesleft.setText(""+temp);
				}
				D.setEnabled(false);
			}
			if(e.getSource()==E){
				if(le3iTixea.contains("�") ){
					String le3ixoris= le3i.getText();
					char[] le3iTixeaChar=le3iTixea.toCharArray();
					for(int i=0;i<le3iTixea.length();i++){
						if(le3iTixeaChar[i]=='�'){
							char[] tempor=le3ixoris.toCharArray();
							tempor[i]='�';
							le3ixoris=String.valueOf(tempor);
							le3i.setText(le3ixoris);
						}
					}
				}
				else{
					la8osgramata.setText(la8osgramata.getText()+"�,");
					zwes=zwes-1;
					int temp=zwes;
					lifesleft.setText(""+temp);
				}
				E.setEnabled(false);
			}
			if(e.getSource()==Z){
				if(le3iTixea.contains("�") ){
					String le3ixoris= le3i.getText();
					char[] le3iTixeaChar=le3iTixea.toCharArray();
					for(int i=0;i<le3iTixea.length();i++){
						if(le3iTixeaChar[i]=='�'){
							char[] tempor=le3ixoris.toCharArray();
							tempor[i]='�';
							le3ixoris=String.valueOf(tempor);
							le3i.setText(le3ixoris);
						}
					}
				}
				else{
					la8osgramata.setText(la8osgramata.getText()+"�,");
					zwes=zwes-1;
					int temp=zwes;
					lifesleft.setText(""+temp);
				}
				Z.setEnabled(false);
			}
			if(e.getSource()==H){
				if(le3iTixea.contains("�") ){
					String le3ixoris= le3i.getText();
					char[] le3iTixeaChar=le3iTixea.toCharArray();
					for(int i=0;i<le3iTixea.length();i++){
						if(le3iTixeaChar[i]=='�'){
							char[] tempor=le3ixoris.toCharArray();
							tempor[i]='�';
							le3ixoris=String.valueOf(tempor);
							le3i.setText(le3ixoris);
						}
					}
				}
				else{
					la8osgramata.setText(la8osgramata.getText()+"�,");
					zwes=zwes-1;
					int temp=zwes;
					lifesleft.setText(""+temp);
				}
				H.setEnabled(false);
			}
			if(e.getSource()==TH){
				if(le3iTixea.contains("�") ){
					String le3ixoris= le3i.getText();
					char[] le3iTixeaChar=le3iTixea.toCharArray();
					for(int i=0;i<le3iTixea.length();i++){
						if(le3iTixeaChar[i]=='�'){
							char[] tempor=le3ixoris.toCharArray();
							tempor[i]='�';
							le3ixoris=String.valueOf(tempor);
							le3i.setText(le3ixoris);
						}
					}
				}
				else{
					la8osgramata.setText(la8osgramata.getText()+"�,");
					zwes=zwes-1;
					int temp=zwes;
					lifesleft.setText(""+temp);
				}
				TH.setEnabled(false);
			}
			if(e.getSource()==I){
				if(le3iTixea.contains("�") ){
					String le3ixoris= le3i.getText();
					char[] le3iTixeaChar=le3iTixea.toCharArray();
					for(int i=0;i<le3iTixea.length();i++){
						if(le3iTixeaChar[i]=='�'){
							char[] tempor=le3ixoris.toCharArray();
							tempor[i]='�';
							le3ixoris=String.valueOf(tempor);
							le3i.setText(le3ixoris);
						}
					}
				}
				else{
					la8osgramata.setText(la8osgramata.getText()+"�,");
					zwes=zwes-1;
					int temp=zwes;
					lifesleft.setText(""+temp);
				}
				I.setEnabled(false);
			}
			if(e.getSource()==K){
				if(le3iTixea.contains("�") ){
					String le3ixoris= le3i.getText();
					char[] le3iTixeaChar=le3iTixea.toCharArray();
					for(int i=0;i<le3iTixea.length();i++){
						if(le3iTixeaChar[i]=='�'){
							char[] tempor=le3ixoris.toCharArray();
							tempor[i]='�';
							le3ixoris=String.valueOf(tempor);
							le3i.setText(le3ixoris);
						}
					}
				}
				else{
					la8osgramata.setText(la8osgramata.getText()+"�,");
					zwes=zwes-1;
					int temp=zwes;
					lifesleft.setText(""+temp);
				}
				K.setEnabled(false);
			}
			if(e.getSource()==L){
				if(le3iTixea.contains("�") ){
					String le3ixoris= le3i.getText();
					char[] le3iTixeaChar=le3iTixea.toCharArray();
					for(int i=0;i<le3iTixea.length();i++){
						if(le3iTixeaChar[i]=='�'){
							char[] tempor=le3ixoris.toCharArray();
							tempor[i]='�';
							le3ixoris=String.valueOf(tempor);
							le3i.setText(le3ixoris);
						}
					}
				}
				else{
					la8osgramata.setText(la8osgramata.getText()+"�,");
					zwes=zwes-1;
					int temp=zwes;
					lifesleft.setText(""+temp);
				}
				L.setEnabled(false);
			}
			if(e.getSource()==M){
				if(le3iTixea.contains("�") ){
					String le3ixoris= le3i.getText();
					char[] le3iTixeaChar=le3iTixea.toCharArray();
					for(int i=0;i<le3iTixea.length();i++){
						if(le3iTixeaChar[i]=='�'){
							char[] tempor=le3ixoris.toCharArray();
							tempor[i]='�';
							le3ixoris=String.valueOf(tempor);
							le3i.setText(le3ixoris);
						}
					}
				}
				else{
					la8osgramata.setText(la8osgramata.getText()+"�,");
					zwes=zwes-1;
					int temp=zwes;
					lifesleft.setText(""+temp);
				}
				M.setEnabled(false);
			}
			if(e.getSource()==N){
				if(le3iTixea.contains("�") ){
					String le3ixoris= le3i.getText();
					char[] le3iTixeaChar=le3iTixea.toCharArray();
					for(int i=0;i<le3iTixea.length();i++){
						if(le3iTixeaChar[i]=='�'){
							char[] tempor=le3ixoris.toCharArray();
							tempor[i]='�';
							le3ixoris=String.valueOf(tempor);
							le3i.setText(le3ixoris);
						}
					}
				}
				else{
					la8osgramata.setText(la8osgramata.getText()+"�,");
					zwes=zwes-1;
					int temp=zwes;
					lifesleft.setText(""+temp);
				}
				N.setEnabled(false);
			}
			if(e.getSource()==KS){
				if(le3iTixea.contains("�") ){
					String le3ixoris= le3i.getText();
					char[] le3iTixeaChar=le3iTixea.toCharArray();
					for(int i=0;i<le3iTixea.length();i++){
						if(le3iTixeaChar[i]=='�'){
							char[] tempor=le3ixoris.toCharArray();
							tempor[i]='�';
							le3ixoris=String.valueOf(tempor);
							le3i.setText(le3ixoris);
						}
					}
				}
				else{
					la8osgramata.setText(la8osgramata.getText()+"�,");
					zwes=zwes-1;
					int temp=zwes;
					lifesleft.setText(""+temp);
				}
				KS.setEnabled(false);
			}
			if(e.getSource()==O){
				if(le3iTixea.contains("�") ){
					String le3ixoris= le3i.getText();
					char[] le3iTixeaChar=le3iTixea.toCharArray();
					for(int i=0;i<le3iTixea.length();i++){
						if(le3iTixeaChar[i]=='�'){
							char[] tempor=le3ixoris.toCharArray();
							tempor[i]='�';
							le3ixoris=String.valueOf(tempor);
							le3i.setText(le3ixoris);
						}
					}
				}
				else{
					la8osgramata.setText(la8osgramata.getText()+"�,");
					zwes=zwes-1;
					int temp=zwes;
					lifesleft.setText(""+temp);
				}
				O.setEnabled(false);
			}
			if(e.getSource()==P){
				if(le3iTixea.contains("�") ){
					String le3ixoris= le3i.getText();
					char[] le3iTixeaChar=le3iTixea.toCharArray();
					for(int i=0;i<le3iTixea.length();i++){
						if(le3iTixeaChar[i]=='�'){
							char[] tempor=le3ixoris.toCharArray();
							tempor[i]='�';
							le3ixoris=String.valueOf(tempor);
							le3i.setText(le3ixoris);
						}
					}
				}
				else{
					la8osgramata.setText(la8osgramata.getText()+"�,");
					zwes=zwes-1;
					int temp=zwes;
					lifesleft.setText(""+temp);
				}
				P.setEnabled(false);
			}
			if(e.getSource()==R){
				if(le3iTixea.contains("�") ){
					String le3ixoris= le3i.getText();
					char[] le3iTixeaChar=le3iTixea.toCharArray();
					for(int i=0;i<le3iTixea.length();i++){
						if(le3iTixeaChar[i]=='�'){
							char[] tempor=le3ixoris.toCharArray();
							tempor[i]='�';
							le3ixoris=String.valueOf(tempor);
							le3i.setText(le3ixoris);
						}
					}
				}
				else{
					la8osgramata.setText(la8osgramata.getText()+"�,");
					zwes=zwes-1;
					int temp=zwes;
					lifesleft.setText(""+temp);
				}
				R.setEnabled(false);
			}
			if(e.getSource()==S){
				if(le3iTixea.contains("�") ){
					String le3ixoris= le3i.getText();
					char[] le3iTixeaChar=le3iTixea.toCharArray();
					for(int i=0;i<le3iTixea.length();i++){
						if(le3iTixeaChar[i]=='�'){
							char[] tempor=le3ixoris.toCharArray();
							tempor[i]='�';
							le3ixoris=String.valueOf(tempor);
							le3i.setText(le3ixoris);
						}
					}
				 }
				if(le3iTixea.contains("�") ){
					String le3ixoris= le3i.getText();
					char[] le3iTixeaChar=le3iTixea.toCharArray();
					for(int i=0;i<le3iTixea.length();i++){
						if(le3iTixeaChar[i]=='�'){
							char[] tempor=le3ixoris.toCharArray();
							tempor[i]='�';
							le3ixoris=String.valueOf(tempor);
							le3i.setText(le3ixoris);
						}
					}
				}
				if(!le3iTixea.contains("�") && !le3iTixea.contains("�")){
					la8osgramata.setText(la8osgramata.getText()+"�,");
					zwes=zwes-1;
					int temp=zwes;
					lifesleft.setText(""+temp);
				}
				S.setEnabled(false);
			}
			if(e.getSource()==T){
				if(le3iTixea.contains("�") ){
					String le3ixoris= le3i.getText();
					char[] le3iTixeaChar=le3iTixea.toCharArray();
					for(int i=0;i<le3iTixea.length();i++){
						if(le3iTixeaChar[i]=='�'){
							char[] tempor=le3ixoris.toCharArray();
							tempor[i]='�';
							le3ixoris=String.valueOf(tempor);
							le3i.setText(le3ixoris);
						}
					}
				}
				else{
					la8osgramata.setText(la8osgramata.getText()+"�,");
					zwes=zwes-1;
					int temp=zwes;
					lifesleft.setText(""+temp);
				}
				T.setEnabled(false);
			}
			if(e.getSource()==Y){
				if(le3iTixea.contains("�") ){
					String le3ixoris= le3i.getText();
					char[] le3iTixeaChar=le3iTixea.toCharArray();
					for(int i=0;i<le3iTixea.length();i++){
						if(le3iTixeaChar[i]=='�'){
							char[] tempor=le3ixoris.toCharArray();
							tempor[i]='�';
							le3ixoris=String.valueOf(tempor);
							le3i.setText(le3ixoris);
						}
					}
				}
				else{
					la8osgramata.setText(la8osgramata.getText()+"�,");
					zwes=zwes-1;
					int temp=zwes;
					lifesleft.setText(""+temp);
				}
				Y.setEnabled(false);
			}
			if(e.getSource()==F){
				if(le3iTixea.contains("�") ){
					String le3ixoris= le3i.getText();
					char[] le3iTixeaChar=le3iTixea.toCharArray();
					for(int i=0;i<le3iTixea.length();i++){
						if(le3iTixeaChar[i]=='�'){
							char[] tempor=le3ixoris.toCharArray();
							tempor[i]='�';
							le3ixoris=String.valueOf(tempor);
							le3i.setText(le3ixoris);
						}
					}
				}
				else{
					la8osgramata.setText(la8osgramata.getText()+"�,");
					zwes=zwes-1;
					int temp=zwes;
					lifesleft.setText(""+temp);
				}
				F.setEnabled(false);
			}
			if(e.getSource()==X){
				if(le3iTixea.contains("�") ){
					String le3ixoris= le3i.getText();
					char[] le3iTixeaChar=le3iTixea.toCharArray();
					for(int i=0;i<le3iTixea.length();i++){
						if(le3iTixeaChar[i]=='�'){
							char[] tempor=le3ixoris.toCharArray();
							tempor[i]='�';
							le3ixoris=String.valueOf(tempor);
							le3i.setText(le3ixoris);
						}
					}
				}
				else{
					la8osgramata.setText(la8osgramata.getText()+"�,");
					zwes=zwes-1;
					int temp=zwes;
					lifesleft.setText(""+temp);
				}
				X.setEnabled(false);
			}
			if(e.getSource()==PS){
				if(le3iTixea.contains("�") ){
					String le3ixoris= le3i.getText();
					char[] le3iTixeaChar=le3iTixea.toCharArray();
					for(int i=0;i<le3iTixea.length();i++){
						if(le3iTixeaChar[i]=='�'){
							char[] tempor=le3ixoris.toCharArray();
							tempor[i]='�';
							le3ixoris=String.valueOf(tempor);
							le3i.setText(le3ixoris);
						}
					}
				}
				else{
					la8osgramata.setText(la8osgramata.getText()+"�,");
					zwes=zwes-1;
					int temp=zwes;
					lifesleft.setText(""+temp);
				}
				PS.setEnabled(false);
			}
			if(e.getSource()==W){
				if(le3iTixea.contains("�") ){
					String le3ixoris= le3i.getText();
					char[] le3iTixeaChar=le3iTixea.toCharArray();
					for(int i=0;i<le3iTixea.length();i++){
						if(le3iTixeaChar[i]=='�'){
							char[] tempor=le3ixoris.toCharArray();
							tempor[i]='�';
							le3ixoris=String.valueOf(tempor);
							le3i.setText(le3ixoris);
						}
					}
				}
				else{
					la8osgramata.setText(la8osgramata.getText()+"�,");
					zwes=zwes-1;
					int temp=zwes;
					lifesleft.setText(""+temp);
				}
				W.setEnabled(false);
			}
		if(le3i.getText().equals(le3iTixea)){
			skor=skor+1;
			int temp=skor;
			setVisible(false);
			dispose();
			GramEl E1 =new GramEl(temp);
			E1.setSkor(skor);
		}
		if(zwes==0){
			skor=skor-1;
			int temp=skor;
			setVisible(false);
			dispose();
			GramEl E1 =new GramEl(temp);
			E1.setSkor(skor);
		}
		}
	}
	
}
