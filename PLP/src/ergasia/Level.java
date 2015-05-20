package ergasia;

public class Level {

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
