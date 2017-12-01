package ah501.registration;

import java.io.*;

/*
* Author: ah501
* Object type storing information about a given user. Its information can be written to a file in binary so it
* can be retrieved for future use. Stores the username, name, email and password, as well as a unique ID.
 */

public class User implements Serializable {
	
	// Attributes
	private static int lastId = 100006;
	private String username, name, email, password;
	private int userId;



	// Constructors
	public User(){
		userId = getLastId();
		setLastId();
	}

	public User(String u, String n, String e, String p) {
		username = u;
		name = n;
		email = e;
		password = p;
		
		userId = getLastId();
		setLastId();
	}

	
	// ID management
	
	// This method looks for the last id number in the file containing the user data
	public static void receiveLatestId() {
		boolean proceed = true;
		int n = 0;
		InputStream fileInput = null;
		ObjectInputStream objInStream = null;

		try {
			fileInput = new FileInputStream(".\\src\\files\\UserData.data");
			objInStream = new ObjectInputStream(fileInput);

			while(proceed){
				User u = null;
				try {
					u = (User) objInStream.readObject();

					//if the id belonging to this user is greater than the last, n becomes the new higher value
					if(u != null) {

						if(u.getUserId() > n){
							n = u.getUserId();
						}

					} else proceed = false;

				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (EOFException e) {
					break;
				}
			}
			// end while loop

		}
			catch (FileNotFoundException e) {
				e.printStackTrace(); }
			catch (IOException e) {
				e.printStackTrace(); }

		if(n == 0){
			lastId = 100006;
		} else lastId = n;
	}
	
	public int getLastId() {
		return lastId;
	}
	
	public void setLastId() {
		setUserId(lastId);
		lastId++;
	}
	
	
	// Getters + setters
	
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
	public String getEmail() { return email; }
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	
	
}
