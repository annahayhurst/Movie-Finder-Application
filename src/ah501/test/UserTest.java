package ah501.test;

import java.io.File;

import ah501.registration.*;

public class UserTest {
	
	public static void main(String[] args) {
		
		Registry reg = new Registry();
		File file = new File("UserData");
		
		User u1 = new User("ah501", "A", "Hayhurst", "a@example.com", "aaaa");
		User u2 = new User("abc123", "Jon", "Java", "j@example.com", "jjjj");
		
		reg.addUser(u1);
		reg.addUser(u2);	
		
		reg.toString();
				
			
		
		
	}

}
