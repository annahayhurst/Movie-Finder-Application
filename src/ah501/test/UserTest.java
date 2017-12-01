package ah501.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import ah501.registration.*;

/*
* Author: ah501
* Test class ensuring the different features implemented in the registration package worked as expected.
* Where methods did not function correctly, they have been debugged after being tested here.
 */

public class UserTest {
	
	public static void main(String[] args) {
		
		//String filepath = new File(".\\src\\files\\UserData.data").getAbsolutePath();
		//System.out.println(filepath);
		
		Registry reg = new Registry();
		
		User u1 = new User("aba111", "Abacus Alderly", "a@example.com", "aaaa");
		User u2 = new User("abc123", "Jon Java", "j@example.com", "jjjj");
		
		//reg.addUser(u1);
		//reg.addUser(u2);
		
		System.out.println(reg.toString());
			
		
		
	}

}
