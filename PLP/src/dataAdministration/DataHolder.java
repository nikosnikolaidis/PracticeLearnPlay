package dataAdministration;

import java.util.ArrayList;
import java.util.HashMap;
import ergasia.*;

public class DataHolder {

	private Language languageNow;	//i glosa pou uparxei gia auti tin isodo
	
	private String PasswordAdmin;	//o kodikos tou Admin
	private ArrayList<Language> Languages;	//lista me oles tis gloses
	private ArrayList<Level> Levels;		//lista me ola ta levels
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
	public Language getLanguageNow() {
		return languageNow;
	}
	public void setLanguageNow(Language languageNow) {
		this.languageNow = languageNow;
	}
	public ArrayList<Language> getLanguages() {
		return Languages;
	}
	public void setLanguages(ArrayList<Language> languages) {
		Languages = languages;
	}
	public ArrayList<Level> getLevels() {
		return Levels;
	}
	public void setLevels(ArrayList<Level> levels) {
		Levels = levels;
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
