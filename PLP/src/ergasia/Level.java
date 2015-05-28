package ergasia;

import java.io.Serializable;

public class Level implements Serializable {

	private Language language;
	private String nameOfLevel;
	
	public Level(Language language, String name) {
		super();
		this.language = language;
		this.nameOfLevel = name;
	}

	public Language getLanguage() {
		return language;
	}

	public String getNameOfLevel() {
		return nameOfLevel;
	}
}
