package Anagrammatismos;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;


public class Letter extends JButton {
	
	private String myName;
	
	private Image myImage = null;
	
	public Letter(String lettersName){
		
		myName = lettersName.toUpperCase();
		setMyImageIcon();
	}
	
	public String getName(){
		
		return this.myName;
	}
	
	public void setMyImageIcon(){
		
		try 
		{
			myImage = ImageIO.read(new File(getImagePath()));
		} 
		catch (IOException e) 
		{
			
		}
				
		int width = myImage.getWidth(this);
		int height = myImage.getHeight(this);
		
		width = 100/myName.length();
		height = width;
		
		Image img = myImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		
		this.setIcon(new ImageIcon(img));
	}

	private String getImagePath(){
		return "Alphabet Icons/"+myName+".png";
	}
}
