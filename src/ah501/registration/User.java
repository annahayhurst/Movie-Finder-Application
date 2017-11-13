package ah501.registration;

import java.io.Serializable;

public class User implements Serializable {
	
	//attributes
	private static int lastId = 100006;
	private String username, firstName,lastName,email, password;
	private int userId;
	
	

	//constructors
	public User(String u, String f, String e, String p) {
		username = u;
		firstName = f;
		email = e;
		password = p;
		
		userId = getLastId();
		setLastId();
	}
	
	public User(String u, String f, String l, String e, String p) {
		username = u;
		firstName = f;
		lastName = l;
		email = e;
		password = p;
		
		userId = getLastId();
		setLastId();
	}
	
	
	
	
	//id management
	
	//this method looks for the last id number in the file containing the user data
	public int receiveLatestId() {
		return 0;
	}
	
	public int getLastId() {
		return lastId;
	}
	
	public void setLastId() {
		setUserId(lastId);
		lastId++;
	}
	
	
	//getters + setters
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	private int age;
	
	
	
	
}
