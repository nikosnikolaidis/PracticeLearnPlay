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
	private String Admin_password="1234";
	private String Admin_username="Admin";
	private ArrayList<Teacher> Teachers=new ArrayList<Teacher>();
	
	public Admin(String username, String password, ArrayList<Teacher> teachers) {
		super(username, password);
		Teachers=teachers;
	}

	public void Create_Teacher(String username, String password, String Onomateponimo, Language teacherLanguage){
		Teachers=deserializing();									//deserializing
		Teacher Teach= new Teacher(Onomateponimo,username,password, null, teacherLanguage);		//dimiourgia ka8igiti
		Teachers.add(Teach);										//apo8ikeusi sti lista
		serializing();												//kai sirialazable

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
	
	public void serializing() {
		try {
			FileOutputStream fileOut = new FileOutputStream("teachers.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(Teachers);
			out.close();
			fileOut.close();
		}
		catch(IOException i) {
			i.printStackTrace();
		}
	}
	
	public ArrayList<Teacher> deserializing() {
		ArrayList<Teacher> emp=Teachers;
		try {
			FileInputStream fileIn = new FileInputStream("teachers.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			emp = (ArrayList<Teacher>) in.readObject();
			in.close();
			fileIn.close();
			//return employees;
		}
		catch(IOException i) {
			i.printStackTrace();
		}
		catch(ClassNotFoundException c) {
			c.printStackTrace();
		}
		finally {
			return emp;
		}
	}

	public ArrayList<Teacher> getTeachers() {
		return Teachers;
	}

	public void log_In(String username, String password) {
		if(username==Admin_username && password==Admin_password){		//tote mporei na sinde8ei o Admin
			
		}
	}

	public void create_Language(String name, ArrayList<Level> levels){
		new Language(name,null,levels);
		//serializing
	}
}
