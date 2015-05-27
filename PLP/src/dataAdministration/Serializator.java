package dataAdministration;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

import ergasia.*;

public class Serializator {

	private DataHolder DH =new DataHolder();
	
	public ArrayList<Teacher> TeachersDeserializing(){						//Teachers Deserializing
		ArrayList<Teacher> emp=DH.getTeachers();
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
		finally {
			return emp;
		}
	}
	public void TeachersSerializing(ArrayList<Teacher> Teachers){			//Teachers Serializing
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
			i.printStackTrace();
		}
		catch(ClassNotFoundException c) {
			c.printStackTrace();
		}
		finally {
			return emp;
		}
	}
	public void StudentSerializing(ArrayList<Teacher> Students) {				//Student Serializing
		try {
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
			i.printStackTrace();
		}
		catch(ClassNotFoundException c) {
			c.printStackTrace();
		}
		finally {
			return emp;
		}
	}
	public void LanguageSerializing(ArrayList<Language> Languages) {			//Language Serializing
		try {
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
	
	public ArrayList<Level> LevelDeserializing() {						//Level Deserializing
		ArrayList<Level> emp=DH.getLevels();
		try {
			FileInputStream fileIn = new FileInputStream("level.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			emp = (ArrayList<Level>) in.readObject();
			in.close();
			fileIn.close();
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
	public void LevelSerializing(ArrayList<Level> Levels) {			//Level Serializing
		try {
			FileOutputStream fileOut = new FileOutputStream("level.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(Levels);
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
			i.printStackTrace();
		}
		catch(ClassNotFoundException c) {
			c.printStackTrace();
		}
		finally {
			return emp;
		}
	}
	public void GrammarQuestionsSerializing(HashMap<Question,Level> grammarQuestions) {	//grammarQuestions Serializing
		try {
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
			i.printStackTrace();
		}
		catch(ClassNotFoundException c) {
			c.printStackTrace();
		}
		finally {
			return emp;
		}
	}
	public void VocabularyQuestionsSerializing(HashMap<Question,Level> VocabularyQuestions) {	//VocabularyQuestions Serializing
		try {
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
			i.printStackTrace();
		}
		catch(ClassNotFoundException c) {
			c.printStackTrace();
		}
		finally {
			return emp;
		}
	}
	public void ListeningQuestionsSerializing(HashMap<Question,Level> ListeningQuestions) {	//ListeningQuestions Serializing
		try {
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
			i.printStackTrace();
		}
		catch(ClassNotFoundException c) {
			c.printStackTrace();
		}
		finally {
			return emp;
		}
	}
	public void ReadingQuestionsSerializing(HashMap<Question,Level> ReadingQuestions) {	//ReadingQuestions Serializing
		try {
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
