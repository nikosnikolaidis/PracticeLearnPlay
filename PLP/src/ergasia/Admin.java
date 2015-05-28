package ergasia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class Admin extends User {
	private String Admin_password="Admin";
	private String Admin_username="Admin";
	private ArrayList<Teacher> Teachers=new ArrayList<Teacher>();
	private ArrayList<Language> Languages=new ArrayList<Language>();
	
	public Admin(String username, String password) {
		super(username, password);
		Main.ser.AdminSerializing(Admin_password);		//Admin Serializing
	}

	public void setAdmin_password(String admin_password) {
		Admin_password = admin_password;
	}

	public void Create_Teacher(String username, String password, String Onomateponimo, Language teacherLanguage){
		Teachers=Main.ser.getDataHolder().getTeachers();			//anaktisi teachers
		Teacher Teach= new Teacher(Onomateponimo,username,password, null, teacherLanguage);		//dimiourgia ka8igiti
		Teachers.add(Teach);								//apo8ikeusi sti lista
		Main.ser.TeachersSerializing(Teachers);				//serialazation										

		String filename="Kathigites.xls" ;							//apo8ikeusi se excel
		try{
			FileInputStream file = new FileInputStream(new File(filename));
			HSSFWorkbook workbook = new HSSFWorkbook(file);
		    HSSFSheet sheet = workbook.getSheetAt(0);

	        HSSFRow row=   sheet.createRow(sheet.getLastRowNum()+1);
	        
	        row.createCell(0).setCellValue(sheet.getLastRowNum());
	        row.createCell(1).setCellValue(Onomateponimo);
	        row.createCell(2).setCellValue(username);
	       

	        FileOutputStream fileOut =  new FileOutputStream(filename);
	        workbook.write(fileOut);
	        fileOut.close();

	        }catch (FileNotFoundException e){
	        	HSSFWorkbook workbook = new HSSFWorkbook();
	        	HSSFSheet sheet = workbook.createSheet("Sample sheet");
	        	
			    HSSFRow rowhead=   sheet.createRow((short)0);
		        rowhead.createCell(0).setCellValue("No.");
		        rowhead.createCell(1).setCellValue("Ονοματεπώνυμο");
		        rowhead.createCell(2).setCellValue("Username");
		        
		        HSSFRow row=   sheet.createRow(sheet.getLastRowNum()+1);
		        
		        row.createCell(0).setCellValue("1");
		        row.createCell(1).setCellValue(Onomateponimo);
		        row.createCell(2).setCellValue(username);
		        
		        FileOutputStream fileOut = null;
				try {
					fileOut = new FileOutputStream(filename);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		        try {
					workbook.write(fileOut);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		        try {
					fileOut.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	        }
			catch ( Exception ex ) {
	            System.out.println(ex);
	        }													//apo8ikeusi se excel
	}

	public ArrayList<Teacher> getTeachers() {
		return Teachers;
	}

	public boolean log_In(String username, String password) {
		String passDH=Main.ser.getDataHolder().getPasswordAdmin();	//Pernei ta dedomena apo Data Holder
		if(username==Admin_username && password==passDH){	//tote mporei na sinde8ei o Admin
			return true;
		}
		else
			return false;
	}

	public void create_Language(String name, ArrayList<Level> levels){
		Language L=new Language(name,null,levels);
		Languages.add(L);
		Main.ser.LanguageSerializing(Languages);
	}
	
	public void Create_Level(Language language,String levelName){		//dimiougria Level gia auto to Language
		Level L=new Level(language,levelName);
		language.getLevels().add(L);
		Main.ser.LanguageSerializing(Languages);		//Serializing Levels
		
	}
}
