package ergasia;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Question  implements Serializable {

	private Language language;
	private Level level;

	public Question(Language language, Level level){
		this.language = language;
		this.level = level;
	}
	
	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}	
	
	
}
