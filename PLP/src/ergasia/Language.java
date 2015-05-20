package ergasia;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Language {

	private String Name;
	private ArrayList<String> Dictionary = new ArrayList<String>();
	private ArrayList<Level> Levels = new ArrayList<Level>();
																		
	
	public Language(String name, ArrayList<String> dictionary, ArrayList<Level> levels) {
		super();
		Name = name;
		Dictionary = dictionary;
		Levels = levels;
	}
	
	public ArrayList<String> getDictionary() {
		return Dictionary;
	}

	public ArrayList<Level> getLevels() {
		return Levels;
	}
	
	public void Create_Level(String levelName){			//dimiougria Level gia auto to Language
		Level L=new Level(this,levelName);
		Levels.add(L);
		//serializing
		
	}

	public void Create_Dictionary(){					//dimiougia tou le3ikou apo arxeio kimenou
		HashSet<String> le3eis=new HashSet<String>();
		Scanner s = null;
		try {
			s = new Scanner(new BufferedReader(new FileReader("le3iko.txt")));
			while(s.hasNextLine()){
				String line = s.nextLine();
				StringTokenizer st = new StringTokenizer(line," ");
				String k="";
					while(st.hasMoreTokens()){
						k=st.nextToken();
						if(k.contains("."))			//vgazei tous xaraktires pou mporei na iparxoun
							k.replace(".", "");
						if(k.contains(","))
							k.replace(",", "");
						
						
						le3eis.add(k);
					}
			}
		}catch (FileNotFoundException e) {
			System.out.println("File not found !");
		}s.close();
	}
}
