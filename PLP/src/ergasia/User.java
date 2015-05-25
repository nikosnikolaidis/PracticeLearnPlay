package ergasia;

public abstract class User {

	private String Username;
	private String Password;
	
	public User(String username, String password) {
		Username = username;
		Password = password;
	}
	
	public abstract void log_In(String username,String password);	//gia na kanei elegxo gia egkirotita

	public String getUsername() {
		return Username;
	}

	public String getPassword() {
		return Password;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public void setPassword(String password) {
		Password = password;
	}
}
