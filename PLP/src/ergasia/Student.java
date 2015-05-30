package ergasia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
	

public class Student extends User implements Serializable {

	private String Onomateponimo;
	private Teacher teacher;
	private Level studentLevel;
	
	public Student(String Onomateponimo, String username, String password, Teacher teacher1, Level studentLevel) {
		super(username, password);
		teacher=teacher1;
		this.Onomateponimo=Onomateponimo;
		this.studentLevel= studentLevel;
	}
	
	public Level getStudentLevel(){
		return this.studentLevel;
	}

	public String getOnomateponimo() {
		return Onomateponimo;
	}
	
	public boolean log_In(String username, String password) {
		ArrayList<Student> StudentsFromFile = Main.ser.getDataHolder().getStudents();	//anaktis students
		for(Student st: StudentsFromFile) {
			if(st.getUsername().equals(username) && st.getPassword().equals(password)){	//mporei na sinde8ei o Student
				return true;
			}
		}
		return false;
	}
	
	public void ChangeNamePassword(String newUName, String newPassword){	//Changes the UName/Pass
		ArrayList<Student> StudentsFromFile = Main.ser.getDataHolder().getStudents();	//anaktisi students
		for(Student st: StudentsFromFile){
			if(st.getUsername().equals(this.getUsername()) && st.getOnomateponimo().equals(this.getOnomateponimo())){
				StudentsFromFile.remove(st);
				st.setUsername(newUName);
				st.setPassword(newPassword);
				StudentsFromFile.add(st);
			}
		}
		Main.ser.StudentSerializing(StudentsFromFile);	//serializing students
	}
	
	public void Delete(){
		ArrayList<Student> StudentsFromFile = Main.ser.getDataHolder().getStudents();	//anaktisi students
		for(Student st: StudentsFromFile){
			if(st.getUsername().equals(this.getUsername()) && st.getOnomateponimo().equals(this.getOnomateponimo())){
				StudentsFromFile.remove(st);
			}
		}
		Main.ser.StudentSerializing(StudentsFromFile);		//serializing students
	}
	
}
