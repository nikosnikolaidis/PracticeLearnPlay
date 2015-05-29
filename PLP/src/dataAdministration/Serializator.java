package dataAdministration;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import ergasia.*;

public class Serializator {//implements Serializable{

	private DataHolder DH;
	public Serializator() {
		DH =new DataHolder();
		DH.setPasswordAdmin(this.AdminDeserializing());
		DH.setLanguages(this.LanguageDeserializing());
		DH.setTeachers(this.TeachersDeserializing());
		DH.setStudents(this.StudentDeserializing());
		DH.setListOfAllGrammarQuestions(this.GrammarQuestionsDeserializing());
		DH.setListOfAllListeningQuestions(this.ListeningQuestionsDeserializing());
		DH.setListOfAllReadingQuestions(this.ReadingQuestionsDeserializing());
		DH.setListOfAllVocabularyQuestions(this.VocabularyQuestionsDeserializing());
	}
 
	public  DataHolder getDataHolder() {		//arki mono ston constructor i arxikopiiseis :/
		return DH;
	}
	
	public void AdminSerializing(String password){			//Admin Pass Serializing
		try {
			DH.setPasswordAdmin(password);
			FileOutputStream fileOut = new FileOutputStream("adminPassword.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(password);
			out.close();
			fileOut.close();
		}
		catch(IOException i) {
			i.printStackTrace();
		}
	}
	public String AdminDeserializing(){						//Admin Pass Deserializing
		String emp=DH.getPasswordAdmin();
		try {
			FileInputStream fileIn = new FileInputStream("adminPassword.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			emp = (String) in.readObject();
			in.close();
			fileIn.close();
		}
		catch(IOException i) {
		
			AdminSerializing("Admin");
		}
		catch(ClassNotFoundException c) {
			AdminSerializing("Admin");
		}
		try {
			FileInputStream fileIn = new FileInputStream("adminPassword.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			emp = (String) in.readObject();
			in.close();
			fileIn.close();
		}
		catch(IOException i) {
			i.printStackTrace();
		}
		catch(ClassNotFoundException c) {
			c.printStackTrace();
		}
		
			return emp;
		
		
	}
	
	public ArrayList<Language> LanguageDeserializing() {						//Language Deserializing
		ArrayList<Language> emp=DH.getLanguages();
		try {
			FileInputStream fileIn = new FileInputStream("languages.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			emp = (ArrayList<Language>) in.readObject();
			in.close();
			fileIn.close();
		}
		catch(IOException i) {
			LanguageSerializing(emp);
		}
		catch(ClassNotFoundException c) {
			LanguageSerializing(emp);
		}
		try {
			FileInputStream fileIn = new FileInputStream("languages.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			emp = (ArrayList<Language>) in.readObject();
			in.close();
			fileIn.close();
		}
		catch(IOException i) {
			i.printStackTrace();
		}
		catch(ClassNotFoundException c) {
			c.printStackTrace();
		}
		if(emp==null){
			emp=new ArrayList<Language>();
		}
		
			return emp;
		
	}
	public void LanguageSerializing(ArrayList<Language> Languages) {			//Language Serializing
		try {
			DH.setLanguages(Languages);
			FileOutputStream fileOut = new FileOutputStream("languages.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(Languages);
			out.close();
			fileOut.close();
		}
		catch(IOException i) {
			i.printStackTrace();
		}
	}
	
	public ArrayList<Teacher> TeachersDeserializing(){			//Teachers Deserializing
		ArrayList<Teacher> emp=DH.getTeachers();
		/*try {
			FileInputStream fileIn = new FileInputStream("teachers.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			emp = (ArrayList<Teacher>) in.readObject();
			in.close();
			fileIn.close();
		}
		catch(IOException i) {
			TeachersSerializing(emp);
		}
		catch(ClassNotFoundException c) {
			TeachersSerializing(emp);
		}*/
		try {
			FileInputStream fileIn = new FileInputStream("teachers.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			emp = (ArrayList<Teacher>) in.readObject();
			in.close();
			fileIn.close();
		}
		catch(IOException i) {
			i.printStackTrace();
		}
		catch(ClassNotFoundException c) {
			c.printStackTrace();
		}
		if(emp==null){
			emp=new ArrayList<Teacher>();
		}
			return emp;
		
	}
	public void TeachersSerializing(ArrayList<Teacher> Teachers){			//Teachers Serializing
		try {
			DH.setTeachers(Teachers);
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
	
	public ArrayList<Student> StudentDeserializing() {						//Student Deserializing
		ArrayList<Student> emp=DH.getStudents();
		try {
			FileInputStream fileIn = new FileInputStream("students.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			emp = (ArrayList<Student>) in.readObject();
			in.close();
			fileIn.close();
		}
		catch(IOException i) {
			StudentSerializing(emp);
		}
		catch(ClassNotFoundException c) {
			StudentSerializing(emp);
		}
		try {
			FileInputStream fileIn = new FileInputStream("students.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			emp = (ArrayList<Student>) in.readObject();
			in.close();
			fileIn.close();
		}
		catch(IOException i) {
			i.printStackTrace();
		}
		catch(ClassNotFoundException c) {
			c.printStackTrace();
		}
		if(emp==null){
			emp=new ArrayList<Student>();
		}
		
			return emp;
		
	}
	public void StudentSerializing(ArrayList<Student> Students) {				//Student Serializing
		try {
			DH.setStudents(Students);
			FileOutputStream fileOut = new FileOutputStream("students.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(Students);
			out.close();
			fileOut.close();
		}
		catch(IOException i) {
			i.printStackTrace();
		}
	}
	
	public HashMap<Question,Level> GrammarQuestionsDeserializing() {			//GrammarQuestions Deserializing
		HashMap<Question,Level> emp=DH.getListOfAllGrammarQuestions();
		try {
			FileInputStream fileIn = new FileInputStream("grammarQuestions.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			emp = (HashMap<Question,Level>) in.readObject();
			in.close();
			fileIn.close();
		}
		catch(IOException i) {
			GrammarQuestionsSerializing(emp);
		}
		catch(ClassNotFoundException c) {
			GrammarQuestionsSerializing(emp);
		}
		try {
			FileInputStream fileIn = new FileInputStream("grammarQuestions.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			emp = (HashMap<Question,Level>) in.readObject();
			in.close();
			fileIn.close();
		}
		catch(IOException i) {
			i.printStackTrace();
		}
		catch(ClassNotFoundException c) {
			c.printStackTrace();
		}
		if(emp==null){
			emp=new HashMap<Question,Level>();
		}
		
			return emp;
		
	}
	public void GrammarQuestionsSerializing(HashMap<Question,Level> grammarQuestions) {	//grammarQuestions Serializing
		try {
			DH.getListOfAllGrammarQuestions();
			FileOutputStream fileOut = new FileOutputStream("grammarQuestions.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(grammarQuestions);
			out.close();
			fileOut.close();
		}
		catch(IOException i) {
			i.printStackTrace();
		}
	}
	
	public HashMap<Question,Level> VocabularyQuestionsDeserializing() {			//VocabularyQuestions Deserializing
		HashMap<Question,Level> emp=DH.getListOfAllVocabularyQuestions();
		try {
			FileInputStream fileIn = new FileInputStream("vocabularyQuestions.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			emp = (HashMap<Question,Level>) in.readObject();
			in.close();
			fileIn.close();
		}
		catch(IOException i) {
			VocabularyQuestionsSerializing(emp);
		}
		catch(ClassNotFoundException c) {
			VocabularyQuestionsSerializing(emp);
		}
		try {
			FileInputStream fileIn = new FileInputStream("vocabularyQuestions.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			emp = (HashMap<Question,Level>) in.readObject();
			in.close();
			fileIn.close();
		}
		catch(IOException i) {
			i.printStackTrace();
		}
		catch(ClassNotFoundException c) {
			c.printStackTrace();
		}
		if(emp==null){
			emp=new HashMap<Question,Level>();
		}
		
		
			return emp;
		
	}
	public void VocabularyQuestionsSerializing(HashMap<Question,Level> VocabularyQuestions) {	//VocabularyQuestions Serializing
		try {
			DH.setListOfAllVocabularyQuestions(VocabularyQuestions);
			FileOutputStream fileOut = new FileOutputStream("vocabularyQuestions.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(VocabularyQuestions);
			out.close();
			fileOut.close();
		}
		catch(IOException i) {
			i.printStackTrace();
		}
	}
	
	public HashMap<Question,Level> ListeningQuestionsDeserializing() {			//ListeningQuestions Deserializing
		HashMap<Question,Level> emp=DH.getListOfAllListeningQuestions();
		try {
			FileInputStream fileIn = new FileInputStream("listeningQuestions.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			emp = (HashMap<Question,Level>) in.readObject();
			in.close();
			fileIn.close();
		}
		catch(IOException i) {
			ListeningQuestionsSerializing(emp);
		}
		catch(ClassNotFoundException c) {
			ListeningQuestionsSerializing(emp);
		}
		try {
			FileInputStream fileIn = new FileInputStream("listeningQuestions.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			emp = (HashMap<Question,Level>) in.readObject();
			in.close();
			fileIn.close();
		}
		catch(IOException i) {
			i.printStackTrace();
		}
		catch(ClassNotFoundException c) {
			c.printStackTrace();
		}
		if(emp==null){
			emp=new HashMap<Question,Level>();
		}
		
		
			return emp;
		
	}
	public void ListeningQuestionsSerializing(HashMap<Question,Level> ListeningQuestions) {	//ListeningQuestions Serializing
		try {
			DH.setListOfAllListeningQuestions(ListeningQuestions);
			FileOutputStream fileOut = new FileOutputStream("listeningQuestions.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(ListeningQuestions);
			out.close();
			fileOut.close();
		}
		catch(IOException i) {
			i.printStackTrace();
		}
	}
	
	public HashMap<Question,Level> ReadingQuestionsDeserializing() {			//ReadingQuestions Deserializing
		HashMap<Question,Level> emp=DH.getListOfAllReadingQuestions();
		try {
			FileInputStream fileIn = new FileInputStream("readingQuestions.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			emp = (HashMap<Question,Level>) in.readObject();
			in.close();
			fileIn.close();
		}
		catch(IOException i) {
			ReadingQuestionsSerializing(emp);
		}
		catch(ClassNotFoundException c) {
			ReadingQuestionsSerializing(emp);
		}
		try {
			FileInputStream fileIn = new FileInputStream("readingQuestions.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			emp = (HashMap<Question,Level>) in.readObject();
			in.close();
			fileIn.close();
		}
		catch(IOException i) {
			i.printStackTrace();
		}
		catch(ClassNotFoundException c) {
			c.printStackTrace();
		}
		if(emp==null){
			emp=new HashMap<Question,Level>();
		}

			return emp;
		
	}
	public void ReadingQuestionsSerializing(HashMap<Question,Level> ReadingQuestions) {	//ReadingQuestions Serializing
		try {
			DH.setListOfAllReadingQuestions(ReadingQuestions);
			FileOutputStream fileOut = new FileOutputStream("readingQuestions.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(ReadingQuestions);
			out.close();
			fileOut.close();
		}
		catch(IOException i) {
			i.printStackTrace();
		}
	}
	
}
