package ah501.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import ah501.registration.*;

public class UserTest {
	
	public static void main(String[] args) {
		
		File file = new File("\\files\\Example");
		System.out.println(System.getProperty("user.dir"));
		
		Registry reg = new Registry();
		
		User u1 = new User("ah501", "A", "Hayhurst", "a@example.com", "aaaa");
		User u2 = new User("abc123", "Jon", "Java", "j@example.com", "jjjj");
		
		reg.addUser(u1);
		reg.addUser(u2);	
		
		System.out.println(reg.toString());
			
		
		
	}

}
