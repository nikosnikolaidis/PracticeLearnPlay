package ergasia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import dataAdministration.DataHolder;

public class Teacher extends User implements Serializable{

	private ArrayList<Student> Students =new ArrayList<Student>();
	private Admin admin;
	private Language teachersLanguage;
	private String Onomateponimo;
	
	public Teacher(String Onomateponimo, String username, String password, Language teachersLanguage) {
		super(username, password);
		this.teachersLanguage=teachersLanguage;
		this.Onomateponimo=Onomateponimo;
	}
	
	public void Create_Exercise(Question newQuestion, DataHolder aDataHolder){
		//Dataholder getClass kai meta taktopoihsh
	}
	
	public void Create_Student(String Onomateponimo, String user,String password, Level studentLevel){
		Students=Main.ser.getDataHolder().getStudents();		//anaktisi Students
		Student Stu = new Student(Onomateponimo,user,password,this, studentLevel);		//dimiourgia ma8iti
		Students.add(Stu);										//apo8ikeusi sti lista
		Main.ser.StudentSerializing(Students);					//serializing
		
		String filename="Ma8itess.xls" ;						//apo8ikeusi se excel
		try{
			FileInputStream file = new FileInputStream(new File(filename));
			HSSFWorkbook workbook = new HSSFWorkbook(file);
		    HSSFSheet sheet = workbook.getSheetAt(0);

	        HSSFRow row=   sheet.createRow(sheet.getLastRowNum()+1);
	        
	        row.createCell(0).setCellValue(sheet.getLastRowNum());
	        row.createCell(1).setCellValue(Onomateponimo);
	        row.createCell(2).setCellValue(user);
	       

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
		        row.createCell(2).setCellValue(user);
		        
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
	            System.out.println(ex);								//apo8ikeusi se excel
	        }
	}
	
	public ArrayList<Student> getStudents() {
		return Students;
	}

	public boolean log_In(String username, String password) {
		ArrayList<Teacher> TeacherFromFile =Main.ser.getDataHolder().getTeachers();	//anaktisi teachers		
		for(Teacher teach: TeacherFromFile) {
			if(teach.getUsername().equals(username) && teach.getPassword().equals(password)){//mporei na sinde8ei o Teacher
				return true;
			}
		}
		return false;
	}
}
