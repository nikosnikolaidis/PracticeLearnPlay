package ergasia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
	

public class Student extends User {

	private String Onomateponimo;
	private Teacher teacher;
	private Level studentLevel;
	
	public Student(String Onomateponimo, String username, String password, Teacher teacher1, Level studentLevel) {
		super(username, password);
		teacher=teacher1;
		this.Onomateponimo=Onomateponimo;
		this.studentLevel= studentLevel;
	}
//set levels kalei tis language get level

	public String getOnomateponimo() {
		return Onomateponimo;
	}
	
	public ArrayList<Student> deserializing() {									//deserializing method
		ArrayList<Student> students = teacher.getStudents();
		try {
			FileInputStream fileIn = new FileInputStream("students.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			students = (ArrayList<Student>) in.readObject();
			in.close();
			fileIn.close();
		}
		catch(IOException i) {
			i.printStackTrace();
		}
		catch(ClassNotFoundException c) {
			c.printStackTrace();
		}finally {
			return students;
		}
	}
	
	public void log_In(String username, String password) {
		ArrayList<Student> StudentsFromFile = deserializing();					//deserializing students.ser
		for(Student st: StudentsFromFile) {
			if(st.getUsername().equals(username) && st.getPassword().equals(password)){	//mporei na sinde8ei o Student
				
			}
		}
		
		/*int found_Username=0; 		//arxikopiisi flag=0 -> den vre8ike
		int found_Pass=0;
		int correct_Row =0;
		try	
        {																//psaxnei sto excel gia na vrei ton ma8iti
            FileInputStream file = new FileInputStream(new File("Ma8ites.xlsx"));
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            //Get first/desired sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(0);
            //Iterate through each rows one by one
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext())
            {
                Row row = rowIterator.next();
                //For each row, iterate through all the columns
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext())
                {
                    Cell cell = cellIterator.next();
                    //Check the cell type and format accordingly
                    switch (cell.getCellType())
                    {
                        case Cell.CELL_TYPE_NUMERIC:
                        		//int i = (int)cell.getNumericCellValue();
                            break;
                        case Cell.CELL_TYPE_STRING:
                        	if(row.getRowNum() !=0){
                        		if(cell.getColumnIndex()==1){
                        			if(cell.getStringCellValue()==username){
                        				found_Username=1;
                        				correct_Row=row.getRowNum();
                        			}
                        		}if(cell.getColumnIndex()==2 && correct_Row!=0){
                        			found_Pass=1;
                        		}
                        	}
                            break;
                    }
                }
                System.out.println("");
            }
            file.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }*/
		
		
	}
	
	public void Change(){
		
	}
	
	public void Delete(){
		ArrayList<Student> StudentsFromFile = deserializing();		//deserializing students.ser
		for(Student st: StudentsFromFile){
			if(st.getUsername().equals(this.getUsername()) && st.getOnomateponimo().equals(this.getOnomateponimo())){
				StudentsFromFile.remove(st);
			}
		}
		serializing(StudentsFromFile);		//serializing students.ser
	}
	
	public void serializing(ArrayList<Student> StudentsFromFile) {			//serializing method
		try {
			FileOutputStream fileOut = new FileOutputStream("students.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(StudentsFromFile);
			out.close();
			fileOut.close();
		}
		catch(IOException i) {
			i.printStackTrace();
		}
	}
	
}
