package ergasia;

import dataAdministration.Serializator;
import frames.Sign_in;


public class Main {

	public static Serializator ser=null;
	public static Admin admin=new Admin("Admin", ser.getDataHolder().getPasswordAdmin(), null);
	
	public static void main(String[] args) {
		Serializator S=new Serializator();
		ser=S;
		new Sign_in();
	}

}
