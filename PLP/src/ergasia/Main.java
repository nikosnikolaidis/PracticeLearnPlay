package ergasia;

import java.util.ArrayList;

import dataAdministration.Serializator;
import frames.Sign_in;


public class Main {

	
	public static Serializator ser=null;
	
	
	public static void main(String[] args) {
		Serializator S=new Serializator();
		ser=S;
		for(Teacher t:ser.TeachersDeserializing()){
			System.out.println(t.getUsername());
			System.out.println(t.getPassword());
		}
		new Sign_in();
	}

}
