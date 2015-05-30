package kremala;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.*;

import ergasia.Language;
import ergasia.Main;

public class GramLat extends JFrame {
	private JPanel panelkatw;
	private JPanel panel;
	private JPanel panelaristera;
	private JPanel panelde3ia;
	private JPanel panelmesi;
	private JButton Neo;
	
	JButton A=new JButton("A");
	JButton B=new JButton("B");
	JButton C=new JButton("C");
	JButton D=new JButton("D");
	JButton E=new JButton("E");
	JButton F=new JButton("F");
	JButton G=new JButton("G");
	JButton H=new JButton("H");
	JButton I=new JButton("I");
	JButton J=new JButton("J");
	JButton K=new JButton("K");
	JButton L=new JButton("L");
	JButton M=new JButton("M");
	JButton N=new JButton("N");
	JButton O=new JButton("O");
	JButton P=new JButton("P");
	JButton Q=new JButton("Q");
	JButton R=new JButton("R");
	JButton S=new JButton("S");
	JButton T=new JButton("T");
	JButton U=new JButton("U");
	JButton V=new JButton("V");
	JButton W=new JButton("W");
	JButton X=new JButton("X");
	JButton Y=new JButton("Y");
	JButton Z=new JButton("Z");
	
	private JTextField lifesleft;
	private JTextField lifesleft1;
	private JTextField Skor;
	private JTextField Skor1;
	private JTextField le3i;
	private JTextField la8osgramata;
	private String le3iTixea;
	
	JLabel backgroundLabel;
	
	private int zwes=5;
	private int skor;
	
	public void setSkor(int skor) {
		this.skor = skor;
	}

	GridLayout katwLayout= new GridLayout(2,1);
	
	public GramLat(int skor){
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
		for(int k=1;k<=le3iLength;k++){
			arxikaKena=arxikaKena+"_";
		}
		le3i=new JTextField(arxikaKena);
		le3i.setEditable(false);
		
		la8osgramata=new JTextField("");
		la8osgramata.setEditable(false);
		panelmesi.add(le3i);
		panelmesi.add(la8osgramata);
		
		panelde3ia=new JPanel();
		Neo=new JButton("ÍÝï");
		panelde3ia.add(Neo);
		
		panelaristera=new JPanel();
		panelaristera.setLayout(katwLayout);
		Skor=new JTextField(""+skor);
		Skor.setEditable(false);
		lifesleft=new JTextField(""+zwes);
		lifesleft.setEditable(false);
		Skor1=new JTextField("Óêïñ");
		Skor1.setEditable(false);
		lifesleft1=new JTextField("Æþåò");
		lifesleft1.setEditable(false);
		
		
		panelaristera.add(Skor);
		panelaristera.add(Skor1);
		panelaristera.add(lifesleft);
		panelaristera.add(lifesleft1);
		
		panelkatw = new JPanel();
		panelkatw.setLayout(katwLayout);
		
		panelkatw.add(A);
		panelkatw.add(B);
		panelkatw.add(C);
		panelkatw.add(D);
		panelkatw.add(E);
		panelkatw.add(F);
		panelkatw.add(G);
		panelkatw.add(H);
		panelkatw.add(I);
		panelkatw.add(G);
		panelkatw.add(K);
		panelkatw.add(L);
		panelkatw.add(M);
		panelkatw.add(N);
		panelkatw.add(O);
		panelkatw.add(P);
		panelkatw.add(Q);
		panelkatw.add(R);
		panelkatw.add(S);
		panelkatw.add(T);
		panelkatw.add(U);
		panelkatw.add(V);
		panelkatw.add(W);
		panelkatw.add(X);
		panelkatw.add(Y);
		panelkatw.add(Z);
		
		
		BufferedImage background = null;
		try {
			background = ImageIO.read(new File("back.jpg"));
		} 
		catch (IOException e1) {
			e1.printStackTrace();
		}
		Image dbackground = background.getScaledInstance(800, 300, Image.SCALE_SMOOTH);
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
		C.addActionListener(listener);
		D.addActionListener(listener);
		E.addActionListener(listener);
		F.addActionListener(listener);
		G.addActionListener(listener);
		H.addActionListener(listener);
		I.addActionListener(listener);
		J.addActionListener(listener);
		K.addActionListener(listener);
		L.addActionListener(listener);
		M.addActionListener(listener);
		N.addActionListener(listener);
		O.addActionListener(listener);
		P.addActionListener(listener);
		Q.addActionListener(listener);
		R.addActionListener(listener);
		S.addActionListener(listener);
		T.addActionListener(listener);
		U.addActionListener(listener);
		V.addActionListener(listener);
		W.addActionListener(listener);
		X.addActionListener(listener);
		Y.addActionListener(listener);
		Z.addActionListener(listener);
		Neo.addActionListener(listener);
		
		this.setVisible(true);
		this.setSize(800, 300);
		this.setTitle("Kremala");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==Neo){
				setVisible(false);
				dispose();
				new GramLat(0);
			}
			if(e.getSource()==A){
				if(le3iTixea.contains("a") ){
					String le3ixoris= le3i.getText();
					char[] le3iTixeaChar=le3iTixea.toCharArray();
					for(int i=0;i<le3iTixea.length();i++){
						if(le3iTixeaChar[i]=='a'){
							char[] tempor=le3ixoris.toCharArray();
							tempor[i]='a';
							le3ixoris=String.valueOf(tempor);
							le3i.setText(le3ixoris);
						}
					}
				}
				else{
					la8osgramata.setText(la8osgramata.getText()+"a,");
					zwes=zwes-1;
					int temp=zwes;
					lifesleft.setText(""+temp);
				}
				A.setEnabled(false);
			}
			if(e.getSource()==B){
				if(le3iTixea.contains("b") ){
					String le3ixoris= le3i.getText();
					char[] le3iTixeaChar=le3iTixea.toCharArray();
					for(int i=0;i<le3iTixea.length();i++){
						if(le3iTixeaChar[i]=='b'){
							char[] tempor=le3ixoris.toCharArray();
							tempor[i]='b';
							le3ixoris=String.valueOf(tempor);
							le3i.setText(le3ixoris);
						}
					}
				}
				else{
					la8osgramata.setText(la8osgramata.getText()+"b,");
					zwes=zwes-1;
					int temp=zwes;
					lifesleft.setText(""+temp);
				}
				B.setEnabled(false);
			}
			if(e.getSource()==C){
				if(le3iTixea.contains("c") ){
					String le3ixoris= le3i.getText();
					char[] le3iTixeaChar=le3iTixea.toCharArray();
					for(int i=0;i<le3iTixea.length();i++){
						if(le3iTixeaChar[i]=='c'){
							char[] tempor=le3ixoris.toCharArray();
							tempor[i]='c';
							le3ixoris=String.valueOf(tempor);
							le3i.setText(le3ixoris);
						}
					}
				}
				else{
					la8osgramata.setText(la8osgramata.getText()+"c,");
					zwes=zwes-1;
					int temp=zwes;
					lifesleft.setText(""+temp);
				}
				C.setEnabled(false);
			}
			if(e.getSource()==D){
				if(le3iTixea.contains("d") ){
					String le3ixoris= le3i.getText();
					char[] le3iTixeaChar=le3iTixea.toCharArray();
					for(int i=0;i<le3iTixea.length();i++){
						if(le3iTixeaChar[i]=='d'){
							char[] tempor=le3ixoris.toCharArray();
							tempor[i]='d';
							le3ixoris=String.valueOf(tempor);
							le3i.setText(le3ixoris);
						}
					}
				}
				else{
					la8osgramata.setText(la8osgramata.getText()+"d,");
					zwes=zwes-1;
					int temp=zwes;
					lifesleft.setText(""+temp);
				}
				D.setEnabled(false);
			}
			if(e.getSource()==E){
				if(le3iTixea.contains("e") ){
					String le3ixoris= le3i.getText();
					char[] le3iTixeaChar=le3iTixea.toCharArray();
					for(int i=0;i<le3iTixea.length();i++){
						if(le3iTixeaChar[i]=='e'){
							char[] tempor=le3ixoris.toCharArray();
							tempor[i]='e';
							le3ixoris=String.valueOf(tempor);
							le3i.setText(le3ixoris);
						}
					}
				}
				else{
					la8osgramata.setText(la8osgramata.getText()+"e,");
					zwes=zwes-1;
					int temp=zwes;
					lifesleft.setText(""+temp);
				}
				E.setEnabled(false);
			}
			if(e.getSource()==F){
				if(le3iTixea.contains("f") ){
					String le3ixoris= le3i.getText();
					char[] le3iTixeaChar=le3iTixea.toCharArray();
					for(int i=0;i<le3iTixea.length();i++){
						if(le3iTixeaChar[i]=='f'){
							char[] tempor=le3ixoris.toCharArray();
							tempor[i]='f';
							le3ixoris=String.valueOf(tempor);
							le3i.setText(le3ixoris);
						}
					}
				}
				else{
					la8osgramata.setText(la8osgramata.getText()+"f,");
					zwes=zwes-1;
					int temp=zwes;
					lifesleft.setText(""+temp);
				}
				F.setEnabled(false);
			}
			if(e.getSource()==G){
				if(le3iTixea.contains("g") ){
					String le3ixoris= le3i.getText();
					char[] le3iTixeaChar=le3iTixea.toCharArray();
					for(int i=0;i<le3iTixea.length();i++){
						if(le3iTixeaChar[i]=='g'){
							char[] tempor=le3ixoris.toCharArray();
							tempor[i]='g';
							le3ixoris=String.valueOf(tempor);
							le3i.setText(le3ixoris);
						}
					}
				}
				else{
					la8osgramata.setText(la8osgramata.getText()+"g,");
					zwes=zwes-1;
					int temp=zwes;
					lifesleft.setText(""+temp);
				}
				G.setEnabled(false);
			}
			if(e.getSource()==H){
				if(le3iTixea.contains("h") ){
					String le3ixoris= le3i.getText();
					char[] le3iTixeaChar=le3iTixea.toCharArray();
					for(int i=0;i<le3iTixea.length();i++){
						if(le3iTixeaChar[i]=='h'){
							char[] tempor=le3ixoris.toCharArray();
							tempor[i]='h';
							le3ixoris=String.valueOf(tempor);
							le3i.setText(le3ixoris);
						}
					}
				}
				else{
					la8osgramata.setText(la8osgramata.getText()+"h,");
					zwes=zwes-1;
					int temp=zwes;
					lifesleft.setText(""+temp);
				}
				H.setEnabled(false);
			}
			if(e.getSource()==I){
				if(le3iTixea.contains("i") ){
					String le3ixoris= le3i.getText();
					char[] le3iTixeaChar=le3iTixea.toCharArray();
					for(int i=0;i<le3iTixea.length();i++){
						if(le3iTixeaChar[i]=='i'){
							char[] tempor=le3ixoris.toCharArray();
							tempor[i]='i';
							le3ixoris=String.valueOf(tempor);
							le3i.setText(le3ixoris);
						}
					}
				}
				else{
					la8osgramata.setText(la8osgramata.getText()+"i,");
					zwes=zwes-1;
					int temp=zwes;
					lifesleft.setText(""+temp);
				}
				I.setEnabled(false);
			}
			if(e.getSource()==J){
				if(le3iTixea.contains("j") ){
					String le3ixoris= le3i.getText();
					char[] le3iTixeaChar=le3iTixea.toCharArray();
					for(int i=0;i<le3iTixea.length();i++){
						if(le3iTixeaChar[i]=='j'){
							char[] tempor=le3ixoris.toCharArray();
							tempor[i]='j';
							le3ixoris=String.valueOf(tempor);
							le3i.setText(le3ixoris);
						}
					}
				}
				else{
					la8osgramata.setText(la8osgramata.getText()+"j,");
					zwes=zwes-1;
					int temp=zwes;
					lifesleft.setText(""+temp);
				}
				J.setEnabled(false);
			}
			if(e.getSource()==K){
				if(le3iTixea.contains("k") ){
					String le3ixoris= le3i.getText();
					char[] le3iTixeaChar=le3iTixea.toCharArray();
					for(int i=0;i<le3iTixea.length();i++){
						if(le3iTixeaChar[i]=='k'){
							char[] tempor=le3ixoris.toCharArray();
							tempor[i]='k';
							le3ixoris=String.valueOf(tempor);
							le3i.setText(le3ixoris);
						}
					}
				}
				else{
					la8osgramata.setText(la8osgramata.getText()+"k,");
					zwes=zwes-1;
					int temp=zwes;
					lifesleft.setText(""+temp);
				}
				K.setEnabled(false);
			}
			if(e.getSource()==L){
				if(le3iTixea.contains("l") ){
					String le3ixoris= le3i.getText();
					char[] le3iTixeaChar=le3iTixea.toCharArray();
					for(int i=0;i<le3iTixea.length();i++){
						if(le3iTixeaChar[i]=='l'){
							char[] tempor=le3ixoris.toCharArray();
							tempor[i]='l';
							le3ixoris=String.valueOf(tempor);
							le3i.setText(le3ixoris);
						}
					}
				}
				else{
					la8osgramata.setText(la8osgramata.getText()+"l,");
					zwes=zwes-1;
					int temp=zwes;
					lifesleft.setText(""+temp);
				}
				L.setEnabled(false);
			}
			if(e.getSource()==M){
				if(le3iTixea.contains("m") ){
					String le3ixoris= le3i.getText();
					char[] le3iTixeaChar=le3iTixea.toCharArray();
					for(int i=0;i<le3iTixea.length();i++){
						if(le3iTixeaChar[i]=='m'){
							char[] tempor=le3ixoris.toCharArray();
							tempor[i]='m';
							le3ixoris=String.valueOf(tempor);
							le3i.setText(le3ixoris);
						}
					}
				}
				else{
					la8osgramata.setText(la8osgramata.getText()+"m,");
					zwes=zwes-1;
					int temp=zwes;
					lifesleft.setText(""+temp);
				}
				M.setEnabled(false);
			}
			if(e.getSource()==N){
				if(le3iTixea.contains("n") ){
					String le3ixoris= le3i.getText();
					char[] le3iTixeaChar=le3iTixea.toCharArray();
					for(int i=0;i<le3iTixea.length();i++){
						if(le3iTixeaChar[i]=='n'){
							char[] tempor=le3ixoris.toCharArray();
							tempor[i]='n';
							le3ixoris=String.valueOf(tempor);
							le3i.setText(le3ixoris);
						}
					}
				}
				else{
					la8osgramata.setText(la8osgramata.getText()+"n,");
					zwes=zwes-1;
					int temp=zwes;
					lifesleft.setText(""+temp);
				}
				N.setEnabled(false);
			}
			if(e.getSource()==O){
				if(le3iTixea.contains("o") ){
					String le3ixoris= le3i.getText();
					char[] le3iTixeaChar=le3iTixea.toCharArray();
					for(int i=0;i<le3iTixea.length();i++){
						if(le3iTixeaChar[i]=='o'){
							char[] tempor=le3ixoris.toCharArray();
							tempor[i]='o';
							le3ixoris=String.valueOf(tempor);
							le3i.setText(le3ixoris);
						}
					}
				}
				else{
					la8osgramata.setText(la8osgramata.getText()+"o,");
					zwes=zwes-1;
					int temp=zwes;
					lifesleft.setText(""+temp);
				}
				O.setEnabled(false);
			}
			if(e.getSource()==P){
				if(le3iTixea.contains("p") ){
					String le3ixoris= le3i.getText();
					char[] le3iTixeaChar=le3iTixea.toCharArray();
					for(int i=0;i<le3iTixea.length();i++){
						if(le3iTixeaChar[i]=='p'){
							char[] tempor=le3ixoris.toCharArray();
							tempor[i]='p';
							le3ixoris=String.valueOf(tempor);
							le3i.setText(le3ixoris);
						}
					}
				}
				else{
					la8osgramata.setText(la8osgramata.getText()+"p,");
					zwes=zwes-1;
					int temp=zwes;
					lifesleft.setText(""+temp);
				}
				P.setEnabled(false);
			}
			if(e.getSource()==Q){
				if(le3iTixea.contains("q") ){
					String le3ixoris= le3i.getText();
					char[] le3iTixeaChar=le3iTixea.toCharArray();
					for(int i=0;i<le3iTixea.length();i++){
						if(le3iTixeaChar[i]=='q'){
							char[] tempor=le3ixoris.toCharArray();
							tempor[i]='q';
							le3ixoris=String.valueOf(tempor);
							le3i.setText(le3ixoris);
						}
					}
				}
				else{
					la8osgramata.setText(la8osgramata.getText()+"q,");
					zwes=zwes-1;
					int temp=zwes;
					lifesleft.setText(""+temp);
				}
				Q.setEnabled(false);
			}
			if(e.getSource()==R){
				if(le3iTixea.contains("r") ){
					String le3ixoris= le3i.getText();
					char[] le3iTixeaChar=le3iTixea.toCharArray();
					for(int i=0;i<le3iTixea.length();i++){
						if(le3iTixeaChar[i]=='r'){
							char[] tempor=le3ixoris.toCharArray();
							tempor[i]='r';
							le3ixoris=String.valueOf(tempor);
							le3i.setText(le3ixoris);
						}
					}
				}
				else{
					la8osgramata.setText(la8osgramata.getText()+"r,");
					zwes=zwes-1;
					int temp=zwes;
					lifesleft.setText(""+temp);
				}
				R.setEnabled(false);
			}
			if(e.getSource()==S){
				if(le3iTixea.contains("s") ){
					String le3ixoris= le3i.getText();
					char[] le3iTixeaChar=le3iTixea.toCharArray();
					for(int i=0;i<le3iTixea.length();i++){
						if(le3iTixeaChar[i]=='s'){
							char[] tempor=le3ixoris.toCharArray();
							tempor[i]='s';
							le3ixoris=String.valueOf(tempor);
							le3i.setText(le3ixoris);
						}
					}
				}
				else{
					la8osgramata.setText(la8osgramata.getText()+"s,");
					zwes=zwes-1;
					int temp=zwes;
					lifesleft.setText(""+temp);
				}
				S.setEnabled(false);
			}
			if(e.getSource()==T){
				if(le3iTixea.contains("t") ){
					String le3ixoris= le3i.getText();
					char[] le3iTixeaChar=le3iTixea.toCharArray();
					for(int i=0;i<le3iTixea.length();i++){
						if(le3iTixeaChar[i]=='t'){
							char[] tempor=le3ixoris.toCharArray();
							tempor[i]='t';
							le3ixoris=String.valueOf(tempor);
							le3i.setText(le3ixoris);
						}
					}
				}
				else{
					la8osgramata.setText(la8osgramata.getText()+"t,");
					zwes=zwes-1;
					int temp=zwes;
					lifesleft.setText(""+temp);
				}
				T.setEnabled(false);
			}
			if(e.getSource()==U){
				if(le3iTixea.contains("u") ){
					String le3ixoris= le3i.getText();
					char[] le3iTixeaChar=le3iTixea.toCharArray();
					for(int i=0;i<le3iTixea.length();i++){
						if(le3iTixeaChar[i]=='u'){
							char[] tempor=le3ixoris.toCharArray();
							tempor[i]='u';
							le3ixoris=String.valueOf(tempor);
							le3i.setText(le3ixoris);
						}
					}
				}
				else{
					la8osgramata.setText(la8osgramata.getText()+"u,");
					zwes=zwes-1;
					int temp=zwes;
					lifesleft.setText(""+temp);
				}
				U.setEnabled(false);
			}
			if(e.getSource()==V){
				if(le3iTixea.contains("v") ){
					String le3ixoris= le3i.getText();
					char[] le3iTixeaChar=le3iTixea.toCharArray();
					for(int i=0;i<le3iTixea.length();i++){
						if(le3iTixeaChar[i]=='v'){
							char[] tempor=le3ixoris.toCharArray();
							tempor[i]='v';
							le3ixoris=String.valueOf(tempor);
							le3i.setText(le3ixoris);
						}
					}
				}
				else{
					la8osgramata.setText(la8osgramata.getText()+"v,");
					zwes=zwes-1;
					int temp=zwes;
					lifesleft.setText(""+temp);
				}
				V.setEnabled(false);
			}
			if(e.getSource()==W){
				if(le3iTixea.contains("w") ){
					String le3ixoris= le3i.getText();
					char[] le3iTixeaChar=le3iTixea.toCharArray();
					for(int i=0;i<le3iTixea.length();i++){
						if(le3iTixeaChar[i]=='w'){
							char[] tempor=le3ixoris.toCharArray();
							tempor[i]='w';
							le3ixoris=String.valueOf(tempor);
							le3i.setText(le3ixoris);
						}
					}
				}
				else{
					la8osgramata.setText(la8osgramata.getText()+"w,");
					zwes=zwes-1;
					int temp=zwes;
					lifesleft.setText(""+temp);
				}
				W.setEnabled(false);
			}
			if(e.getSource()==X){
				if(le3iTixea.contains("x") ){
					String le3ixoris= le3i.getText();
					char[] le3iTixeaChar=le3iTixea.toCharArray();
					for(int i=0;i<le3iTixea.length();i++){
						if(le3iTixeaChar[i]=='x'){
							char[] tempor=le3ixoris.toCharArray();
							tempor[i]='x';
							le3ixoris=String.valueOf(tempor);
							le3i.setText(le3ixoris);
						}
					}
				}
				else{
					la8osgramata.setText(la8osgramata.getText()+"x,");
					zwes=zwes-1;
					int temp=zwes;
					lifesleft.setText(""+temp);
				}
				X.setEnabled(false);
			}
			if(e.getSource()==Y){
				if(le3iTixea.contains("y") ){
					String le3ixoris= le3i.getText();
					char[] le3iTixeaChar=le3iTixea.toCharArray();
					for(int i=0;i<le3iTixea.length();i++){
						if(le3iTixeaChar[i]=='y'){
							char[] tempor=le3ixoris.toCharArray();
							tempor[i]='y';
							le3ixoris=String.valueOf(tempor);
							le3i.setText(le3ixoris);
						}
					}
				}
				else{
					la8osgramata.setText(la8osgramata.getText()+"y,");
					zwes=zwes-1;
					int temp=zwes;
					lifesleft.setText(""+temp);
				}
				Y.setEnabled(false);
			}
			if(e.getSource()==Z){
				if(le3iTixea.contains("z") ){
					String le3ixoris= le3i.getText();
					char[] le3iTixeaChar=le3iTixea.toCharArray();
					for(int i=0;i<le3iTixea.length();i++){
						if(le3iTixeaChar[i]=='z'){
							char[] tempor=le3ixoris.toCharArray();
							tempor[i]='z';
							le3ixoris=String.valueOf(tempor);
							le3i.setText(le3ixoris);
						}
					}
				}
				else{
					la8osgramata.setText(la8osgramata.getText()+"z,");
					zwes=zwes-1;
					int temp=zwes;
					lifesleft.setText(""+temp);
				}
				Z.setEnabled(false);
			}
		if(le3i.getText().equals(le3iTixea)){
			skor=skor+1;
			int temp=skor;
			setVisible(false);
			dispose();
			GramLat E2 =new GramLat(temp);
			E2.setSkor(skor);
		}
		if(zwes==0){
			skor=skor-1;
			int temp=skor;
			setVisible(false);
			dispose();
			GramLat E2 =new GramLat(temp);
			E2.setSkor(skor);
		}
		}
	}

	public int getSkor() {
		return skor;
	}
}
