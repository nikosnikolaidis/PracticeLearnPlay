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
		A= new JButton("Á");
		B= new JButton("Â");
		G= new JButton("Ã");
		D= new JButton("Ä");
		E= new JButton("Å");
		Z= new JButton("Æ");
		H= new JButton("Ç");
		TH= new JButton("È");
		I= new JButton("É");
		K= new JButton("Ê");
		L= new JButton("Ë");
		M= new JButton("Ì");
		N= new JButton("Í");
		KS= new JButton("Î");
		O= new JButton("Ï");
		P= new JButton("Ð");
		R= new JButton("Ñ");
		S= new JButton("Ó");
		T= new JButton("Ô");
		Y= new JButton("Õ");
		F= new JButton("Ö");
		X= new JButton("×");
		PS= new JButton("Ø");
		W= new JButton("Ù");
		
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
				if(le3iTixea.contains("á") ){
					String le3ixoris= le3i.getText();
					char[] le3iTixeaChar=le3iTixea.toCharArray();
					for(int i=0;i<le3iTixea.length();i++){
						if(le3iTixeaChar[i]=='á'){
							char[] tempor=le3ixoris.toCharArray();
							tempor[i]='á';
							le3ixoris=String.valueOf(tempor);
							le3i.setText(le3ixoris);
						}
					}
				}
				else{
					la8osgramata.setText(la8osgramata.getText()+"á,");
					zwes=zwes-1;
					int temp=zwes;
					lifesleft.setText(""+temp);
				}
				A.setEnabled(false);
			}
			if(e.getSource()==B){
				if(le3iTixea.contains("â") ){
					String le3ixoris= le3i.getText();
					char[] le3iTixeaChar=le3iTixea.toCharArray();
					for(int i=0;i<le3iTixea.length();i++){
						if(le3iTixeaChar[i]=='â'){
							char[] tempor=le3ixoris.toCharArray();
							tempor[i]='â';
							le3ixoris=String.valueOf(tempor);
							le3i.setText(le3ixoris);
						}
					}
				}
				else{
					la8osgramata.setText(la8osgramata.getText()+"â,");
					zwes=zwes-1;
					int temp=zwes;
					lifesleft.setText(""+temp);
				}
				B.setEnabled(false);
			}
			if(e.getSource()==G){
				if(le3iTixea.contains("ã") ){
					String le3ixoris= le3i.getText();
					char[] le3iTixeaChar=le3iTixea.toCharArray();
					for(int i=0;i<le3iTixea.length();i++){
						if(le3iTixeaChar[i]=='ã'){
							char[] tempor=le3ixoris.toCharArray();
							tempor[i]='ã';
							le3ixoris=String.valueOf(tempor);
							le3i.setText(le3ixoris);
						}
					}
				}
				else{
					la8osgramata.setText(la8osgramata.getText()+"ã,");
					zwes=zwes-1;
					int temp=zwes;
					lifesleft.setText(""+temp);
				}
				G.setEnabled(false);
			}
			if(e.getSource()==D){
				if(le3iTixea.contains("ä") ){
					String le3ixoris= le3i.getText();
					char[] le3iTixeaChar=le3iTixea.toCharArray();
					for(int i=0;i<le3iTixea.length();i++){
						if(le3iTixeaChar[i]=='ä'){
							char[] tempor=le3ixoris.toCharArray();
							tempor[i]='ä';
							le3ixoris=String.valueOf(tempor);
							le3i.setText(le3ixoris);
						}
					}
				}
				else{
					la8osgramata.setText(la8osgramata.getText()+"ä,");
					zwes=zwes-1;
					int temp=zwes;
					lifesleft.setText(""+temp);
				}
				D.setEnabled(false);
			}
			if(e.getSource()==E){
				if(le3iTixea.contains("å") ){
					String le3ixoris= le3i.getText();
					char[] le3iTixeaChar=le3iTixea.toCharArray();
					for(int i=0;i<le3iTixea.length();i++){
						if(le3iTixeaChar[i]=='å'){
							char[] tempor=le3ixoris.toCharArray();
							tempor[i]='å';
							le3ixoris=String.valueOf(tempor);
							le3i.setText(le3ixoris);
						}
					}
				}
				else{
					la8osgramata.setText(la8osgramata.getText()+"å,");
					zwes=zwes-1;
					int temp=zwes;
					lifesleft.setText(""+temp);
				}
				E.setEnabled(false);
			}
			if(e.getSource()==Z){
				if(le3iTixea.contains("æ") ){
					String le3ixoris= le3i.getText();
					char[] le3iTixeaChar=le3iTixea.toCharArray();
					for(int i=0;i<le3iTixea.length();i++){
						if(le3iTixeaChar[i]=='æ'){
							char[] tempor=le3ixoris.toCharArray();
							tempor[i]='æ';
							le3ixoris=String.valueOf(tempor);
							le3i.setText(le3ixoris);
						}
					}
				}
				else{
					la8osgramata.setText(la8osgramata.getText()+"æ,");
					zwes=zwes-1;
					int temp=zwes;
					lifesleft.setText(""+temp);
				}
				Z.setEnabled(false);
			}
			if(e.getSource()==H){
				if(le3iTixea.contains("ç") ){
					String le3ixoris= le3i.getText();
					char[] le3iTixeaChar=le3iTixea.toCharArray();
					for(int i=0;i<le3iTixea.length();i++){
						if(le3iTixeaChar[i]=='ç'){
							char[] tempor=le3ixoris.toCharArray();
							tempor[i]='ç';
							le3ixoris=String.valueOf(tempor);
							le3i.setText(le3ixoris);
						}
					}
				}
				else{
					la8osgramata.setText(la8osgramata.getText()+"ç,");
					zwes=zwes-1;
					int temp=zwes;
					lifesleft.setText(""+temp);
				}
				H.setEnabled(false);
			}
			if(e.getSource()==TH){
				if(le3iTixea.contains("è") ){
					String le3ixoris= le3i.getText();
					char[] le3iTixeaChar=le3iTixea.toCharArray();
					for(int i=0;i<le3iTixea.length();i++){
						if(le3iTixeaChar[i]=='è'){
							char[] tempor=le3ixoris.toCharArray();
							tempor[i]='è';
							le3ixoris=String.valueOf(tempor);
							le3i.setText(le3ixoris);
						}
					}
				}
				else{
					la8osgramata.setText(la8osgramata.getText()+"è,");
					zwes=zwes-1;
					int temp=zwes;
					lifesleft.setText(""+temp);
				}
				TH.setEnabled(false);
			}
			if(e.getSource()==I){
				if(le3iTixea.contains("é") ){
					String le3ixoris= le3i.getText();
					char[] le3iTixeaChar=le3iTixea.toCharArray();
					for(int i=0;i<le3iTixea.length();i++){
						if(le3iTixeaChar[i]=='é'){
							char[] tempor=le3ixoris.toCharArray();
							tempor[i]='é';
							le3ixoris=String.valueOf(tempor);
							le3i.setText(le3ixoris);
						}
					}
				}
				else{
					la8osgramata.setText(la8osgramata.getText()+"é,");
					zwes=zwes-1;
					int temp=zwes;
					lifesleft.setText(""+temp);
				}
				I.setEnabled(false);
			}
			if(e.getSource()==K){
				if(le3iTixea.contains("ê") ){
					String le3ixoris= le3i.getText();
					char[] le3iTixeaChar=le3iTixea.toCharArray();
					for(int i=0;i<le3iTixea.length();i++){
						if(le3iTixeaChar[i]=='ê'){
							char[] tempor=le3ixoris.toCharArray();
							tempor[i]='ê';
							le3ixoris=String.valueOf(tempor);
							le3i.setText(le3ixoris);
						}
					}
				}
				else{
					la8osgramata.setText(la8osgramata.getText()+"ê,");
					zwes=zwes-1;
					int temp=zwes;
					lifesleft.setText(""+temp);
				}
				K.setEnabled(false);
			}
			if(e.getSource()==L){
				if(le3iTixea.contains("ë") ){
					String le3ixoris= le3i.getText();
					char[] le3iTixeaChar=le3iTixea.toCharArray();
					for(int i=0;i<le3iTixea.length();i++){
						if(le3iTixeaChar[i]=='ë'){
							char[] tempor=le3ixoris.toCharArray();
							tempor[i]='ë';
							le3ixoris=String.valueOf(tempor);
							le3i.setText(le3ixoris);
						}
					}
				}
				else{
					la8osgramata.setText(la8osgramata.getText()+"ë,");
					zwes=zwes-1;
					int temp=zwes;
					lifesleft.setText(""+temp);
				}
				L.setEnabled(false);
			}
			if(e.getSource()==M){
				if(le3iTixea.contains("ì") ){
					String le3ixoris= le3i.getText();
					char[] le3iTixeaChar=le3iTixea.toCharArray();
					for(int i=0;i<le3iTixea.length();i++){
						if(le3iTixeaChar[i]=='ì'){
							char[] tempor=le3ixoris.toCharArray();
							tempor[i]='ì';
							le3ixoris=String.valueOf(tempor);
							le3i.setText(le3ixoris);
						}
					}
				}
				else{
					la8osgramata.setText(la8osgramata.getText()+"ì,");
					zwes=zwes-1;
					int temp=zwes;
					lifesleft.setText(""+temp);
				}
				M.setEnabled(false);
			}
			if(e.getSource()==N){
				if(le3iTixea.contains("í") ){
					String le3ixoris= le3i.getText();
					char[] le3iTixeaChar=le3iTixea.toCharArray();
					for(int i=0;i<le3iTixea.length();i++){
						if(le3iTixeaChar[i]=='í'){
							char[] tempor=le3ixoris.toCharArray();
							tempor[i]='í';
							le3ixoris=String.valueOf(tempor);
							le3i.setText(le3ixoris);
						}
					}
				}
				else{
					la8osgramata.setText(la8osgramata.getText()+"í,");
					zwes=zwes-1;
					int temp=zwes;
					lifesleft.setText(""+temp);
				}
				N.setEnabled(false);
			}
			if(e.getSource()==KS){
				if(le3iTixea.contains("î") ){
					String le3ixoris= le3i.getText();
					char[] le3iTixeaChar=le3iTixea.toCharArray();
					for(int i=0;i<le3iTixea.length();i++){
						if(le3iTixeaChar[i]=='î'){
							char[] tempor=le3ixoris.toCharArray();
							tempor[i]='î';
							le3ixoris=String.valueOf(tempor);
							le3i.setText(le3ixoris);
						}
					}
				}
				else{
					la8osgramata.setText(la8osgramata.getText()+"î,");
					zwes=zwes-1;
					int temp=zwes;
					lifesleft.setText(""+temp);
				}
				KS.setEnabled(false);
			}
			if(e.getSource()==O){
				if(le3iTixea.contains("ï") ){
					String le3ixoris= le3i.getText();
					char[] le3iTixeaChar=le3iTixea.toCharArray();
					for(int i=0;i<le3iTixea.length();i++){
						if(le3iTixeaChar[i]=='ï'){
							char[] tempor=le3ixoris.toCharArray();
							tempor[i]='ï';
							le3ixoris=String.valueOf(tempor);
							le3i.setText(le3ixoris);
						}
					}
				}
				else{
					la8osgramata.setText(la8osgramata.getText()+"ï,");
					zwes=zwes-1;
					int temp=zwes;
					lifesleft.setText(""+temp);
				}
				O.setEnabled(false);
			}
			if(e.getSource()==P){
				if(le3iTixea.contains("ð") ){
					String le3ixoris= le3i.getText();
					char[] le3iTixeaChar=le3iTixea.toCharArray();
					for(int i=0;i<le3iTixea.length();i++){
						if(le3iTixeaChar[i]=='ð'){
							char[] tempor=le3ixoris.toCharArray();
							tempor[i]='ð';
							le3ixoris=String.valueOf(tempor);
							le3i.setText(le3ixoris);
						}
					}
				}
				else{
					la8osgramata.setText(la8osgramata.getText()+"ð,");
					zwes=zwes-1;
					int temp=zwes;
					lifesleft.setText(""+temp);
				}
				P.setEnabled(false);
			}
			if(e.getSource()==R){
				if(le3iTixea.contains("ñ") ){
					String le3ixoris= le3i.getText();
					char[] le3iTixeaChar=le3iTixea.toCharArray();
					for(int i=0;i<le3iTixea.length();i++){
						if(le3iTixeaChar[i]=='ñ'){
							char[] tempor=le3ixoris.toCharArray();
							tempor[i]='ñ';
							le3ixoris=String.valueOf(tempor);
							le3i.setText(le3ixoris);
						}
					}
				}
				else{
					la8osgramata.setText(la8osgramata.getText()+"ñ,");
					zwes=zwes-1;
					int temp=zwes;
					lifesleft.setText(""+temp);
				}
				R.setEnabled(false);
			}
			if(e.getSource()==S){
				if(le3iTixea.contains("ó") ){
					String le3ixoris= le3i.getText();
					char[] le3iTixeaChar=le3iTixea.toCharArray();
					for(int i=0;i<le3iTixea.length();i++){
						if(le3iTixeaChar[i]=='ó'){
							char[] tempor=le3ixoris.toCharArray();
							tempor[i]='ó';
							le3ixoris=String.valueOf(tempor);
							le3i.setText(le3ixoris);
						}
					}
				 }
				if(le3iTixea.contains("ò") ){
					String le3ixoris= le3i.getText();
					char[] le3iTixeaChar=le3iTixea.toCharArray();
					for(int i=0;i<le3iTixea.length();i++){
						if(le3iTixeaChar[i]=='ò'){
							char[] tempor=le3ixoris.toCharArray();
							tempor[i]='ò';
							le3ixoris=String.valueOf(tempor);
							le3i.setText(le3ixoris);
						}
					}
				}
				if(!le3iTixea.contains("ò") && !le3iTixea.contains("ó")){
					la8osgramata.setText(la8osgramata.getText()+"ó,");
					zwes=zwes-1;
					int temp=zwes;
					lifesleft.setText(""+temp);
				}
				S.setEnabled(false);
			}
			if(e.getSource()==T){
				if(le3iTixea.contains("ô") ){
					String le3ixoris= le3i.getText();
					char[] le3iTixeaChar=le3iTixea.toCharArray();
					for(int i=0;i<le3iTixea.length();i++){
						if(le3iTixeaChar[i]=='ô'){
							char[] tempor=le3ixoris.toCharArray();
							tempor[i]='ô';
							le3ixoris=String.valueOf(tempor);
							le3i.setText(le3ixoris);
						}
					}
				}
				else{
					la8osgramata.setText(la8osgramata.getText()+"ô,");
					zwes=zwes-1;
					int temp=zwes;
					lifesleft.setText(""+temp);
				}
				T.setEnabled(false);
			}
			if(e.getSource()==Y){
				if(le3iTixea.contains("õ") ){
					String le3ixoris= le3i.getText();
					char[] le3iTixeaChar=le3iTixea.toCharArray();
					for(int i=0;i<le3iTixea.length();i++){
						if(le3iTixeaChar[i]=='õ'){
							char[] tempor=le3ixoris.toCharArray();
							tempor[i]='õ';
							le3ixoris=String.valueOf(tempor);
							le3i.setText(le3ixoris);
						}
					}
				}
				else{
					la8osgramata.setText(la8osgramata.getText()+"õ,");
					zwes=zwes-1;
					int temp=zwes;
					lifesleft.setText(""+temp);
				}
				Y.setEnabled(false);
			}
			if(e.getSource()==F){
				if(le3iTixea.contains("ö") ){
					String le3ixoris= le3i.getText();
					char[] le3iTixeaChar=le3iTixea.toCharArray();
					for(int i=0;i<le3iTixea.length();i++){
						if(le3iTixeaChar[i]=='ö'){
							char[] tempor=le3ixoris.toCharArray();
							tempor[i]='ö';
							le3ixoris=String.valueOf(tempor);
							le3i.setText(le3ixoris);
						}
					}
				}
				else{
					la8osgramata.setText(la8osgramata.getText()+"ö,");
					zwes=zwes-1;
					int temp=zwes;
					lifesleft.setText(""+temp);
				}
				F.setEnabled(false);
			}
			if(e.getSource()==X){
				if(le3iTixea.contains("÷") ){
					String le3ixoris= le3i.getText();
					char[] le3iTixeaChar=le3iTixea.toCharArray();
					for(int i=0;i<le3iTixea.length();i++){
						if(le3iTixeaChar[i]=='÷'){
							char[] tempor=le3ixoris.toCharArray();
							tempor[i]='÷';
							le3ixoris=String.valueOf(tempor);
							le3i.setText(le3ixoris);
						}
					}
				}
				else{
					la8osgramata.setText(la8osgramata.getText()+"÷,");
					zwes=zwes-1;
					int temp=zwes;
					lifesleft.setText(""+temp);
				}
				X.setEnabled(false);
			}
			if(e.getSource()==PS){
				if(le3iTixea.contains("ø") ){
					String le3ixoris= le3i.getText();
					char[] le3iTixeaChar=le3iTixea.toCharArray();
					for(int i=0;i<le3iTixea.length();i++){
						if(le3iTixeaChar[i]=='ø'){
							char[] tempor=le3ixoris.toCharArray();
							tempor[i]='ø';
							le3ixoris=String.valueOf(tempor);
							le3i.setText(le3ixoris);
						}
					}
				}
				else{
					la8osgramata.setText(la8osgramata.getText()+"ø,");
					zwes=zwes-1;
					int temp=zwes;
					lifesleft.setText(""+temp);
				}
				PS.setEnabled(false);
			}
			if(e.getSource()==W){
				if(le3iTixea.contains("ù") ){
					String le3ixoris= le3i.getText();
					char[] le3iTixeaChar=le3iTixea.toCharArray();
					for(int i=0;i<le3iTixea.length();i++){
						if(le3iTixeaChar[i]=='ù'){
							char[] tempor=le3ixoris.toCharArray();
							tempor[i]='ù';
							le3ixoris=String.valueOf(tempor);
							le3i.setText(le3ixoris);
						}
					}
				}
				else{
					la8osgramata.setText(la8osgramata.getText()+"ù,");
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
