package ergasia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
	

public class Student extends User implements Serializable {

	private String Onomateponimo;
	private Teacher teacher;
	private Level studentLevel;
	
	private ArrayList<String> grammarStatistics =new ArrayList<String>();
	private ArrayList<String> vocabularyStatistics =new ArrayList<String>();;
	private ArrayList<String> readingStatistics =new ArrayList<String>();;
	private ArrayList<String> listeningStatistics =new ArrayList<String>();;
	
	public Student(String Onomateponimo, String username, String password, Teacher teacher1, Level studentLevel) {
		super(username, password);
		teacher=teacher1;
		this.Onomateponimo=Onomateponimo;
		this.studentLevel= studentLevel;
		
		for(Student s: Main.ser.StudentDeserializing()){
			if(s.getUsername()==this.getUsername()){
				grammarStatistics=s.getGrammarStatistics();
				vocabularyStatistics=s.getVocabularyStatistics();
				readingStatistics=s.getReadingStatistics();
				listeningStatistics=s.getListeningStatistics();
			}
		}
	}
	
	public ArrayList<String> addNewGrammarStatistic(String vathmos){ 		//me8odoi gia add newn sttistics
		for(Student s: Main.ser.StudentDeserializing()){		//Deserializing
			if(s.getUsername()==this.getUsername()){
				grammarStatistics.add(getCurrentTimeStamp()+", "+vathmos);
			}
		}
		Main.ser.StudentSerializing(this.getTeacher().getStudents());	//Serializing
		return grammarStatistics;
	}
	public ArrayList<String> addNewVocabularyStatistic(String vathmos){
		for(Student s: Main.ser.StudentDeserializing()){
			if(s.getUsername()==this.getUsername()){
				vocabularyStatistics.add(getCurrentTimeStamp()+", "+vathmos);
			}
		}
		Main.ser.StudentSerializing(this.getTeacher().getStudents());
		return vocabularyStatistics;
	}
	public ArrayList<String> addNewReadingStatistic(String vathmos){
		for(Student s: Main.ser.StudentDeserializing()){
			if(s.getUsername()==this.getUsername()){
				readingStatistics.add(getCurrentTimeStamp()+", "+vathmos);
			}
		}
		Main.ser.StudentSerializing(this.getTeacher().getStudents());
		return readingStatistics;
	}
	public ArrayList<String> addNewListeningStatistic(String vathmos){
		for(Student s: Main.ser.StudentDeserializing()){
			if(s.getUsername()==this.getUsername()){
				listeningStatistics.add(getCurrentTimeStamp()+", "+vathmos);
			}
		}
		Main.ser.StudentSerializing(this.getTeacher().getStudents());
		return listeningStatistics;
	}																		//TimeStamp kai va8mos 
	
	public ArrayList<String> getGrammarStatistics() {
		return grammarStatistics;
	}

	public ArrayList<String> getVocabularyStatistics() {
		return vocabularyStatistics;
	}

	public ArrayList<String> getReadingStatistics() {
		return readingStatistics;
	}

	public ArrayList<String> getListeningStatistics() {
		return listeningStatistics;
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
	
	public String getCurrentTimeStamp() {
	    SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    Date now = new Date();
	    String strDate = sdfDate.format(now);
	    return strDate;
	}

	public Teacher getTeacher() {
		return teacher;
	}
	
}
