package dataAdministration;

import java.util.ArrayList;
import java.util.HashMap;
import ergasia.*;

public class DataHolder {

	private Teacher teacherNow;	
	private Student studentNow;
	private String PasswordAdmin;	//o kodikos tou Admin
	private ArrayList<Language> Languages;	//lista me oles tis gloses
	private ArrayList<Teacher> Teachers;	//lista me olous tous ka8igites
	private ArrayList<Student> Students;	//lista me olous tous ma8ites
	
	private HashMap<Question,Level> listOfAllGrammarQuestions;	//ola ta Grammar Questions
	private HashMap<Question,Level> listOfAllVocabularyQuestions;	//ola ta Vocabulary Questions
	private HashMap<Question,Level> listOfAllListeningQuestions;	//ola ta Listening Questions
	private HashMap<Question,Level> listOfAllReadingQuestions;		//ola ta Reading Questions
	
	public String getPasswordAdmin() {
		return PasswordAdmin;
	}
	public void setPasswordAdmin(String passwordAdmin) {
		PasswordAdmin = passwordAdmin;
	}
	
	public Student getStudentNow() {
		return studentNow;
	}
	public void setStudentNow(Student studentNow) {
		this.studentNow = studentNow;
	}
	public Teacher getTeacherNow(){
		return teacherNow;
	}
	public void setTeacherNow(Teacher teacherNow) {
		this.teacherNow = teacherNow;
	}
	public ArrayList<Language> getLanguages() {
		return Languages;
	}
	public void setLanguages(ArrayList<Language> languages) {
		Languages = languages;
	}
	public ArrayList<Teacher> getTeachers() {
		return Teachers;
	}
	public void setTeachers(ArrayList<Teacher> teachers) {
		Teachers = teachers;
	}
	public ArrayList<Student> getStudents() {
		return Students;
	}
	public void setStudents(ArrayList<Student> students) {
		Students = students;
	}
	public HashMap<Question, Level> getListOfAllGrammarQuestions() {
		return listOfAllGrammarQuestions;
	}
	public void setListOfAllGrammarQuestions(
			HashMap<Question, Level> listOfAllGrammarQuestions) {
		this.listOfAllGrammarQuestions = listOfAllGrammarQuestions;
	}
	public HashMap<Question, Level> getListOfAllVocabularyQuestions() {
		return listOfAllVocabularyQuestions;
	}
	public void setListOfAllVocabularyQuestions(
			HashMap<Question, Level> listOfAllVocabularyQuestions) {
		this.listOfAllVocabularyQuestions = listOfAllVocabularyQuestions;
	}
	public HashMap<Question, Level> getListOfAllListeningQuestions() {
		return listOfAllListeningQuestions;
	}
	public void setListOfAllListeningQuestions(
			HashMap<Question, Level> listOfAllListeningQuestions) {
		this.listOfAllListeningQuestions = listOfAllListeningQuestions;
	}
	public HashMap<Question, Level> getListOfAllReadingQuestions() {
		return listOfAllReadingQuestions;
	}
	public void setListOfAllReadingQuestions(
			HashMap<Question, Level> listOfAllReadingQuestions) {
		this.listOfAllReadingQuestions = listOfAllReadingQuestions;
	}
	
}
