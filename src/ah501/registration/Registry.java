package ah501.registration;

import java.util.HashMap;
import java.util.Map;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

public class Registry {
	
	private Map<Integer, String> register;
	
	public Registry( ) {
		register = new HashMap<Integer, String>();
		this.initialise();
	}
	
	private void initialise() {
		
		
	}
	

	public void addUser(User newUser) {
		
		
		
	}
	
	// this adds the last created user's data to file storage
	public void saveUserInformation(User user) {
		OutputStream ops = null;
        ObjectOutputStream objOps = null;
        try {
            ops = new FileOutputStream("UserData.txt");
            objOps = new ObjectOutputStream(ops);
            objOps.writeObject(user);
            objOps.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } 
        
        finally {
            	try {
            		if(objOps != null) objOps.close();
            	} catch (Exception ex) {
                 ex.printStackTrace();
            }
        }
	}
	
	
// basic validation of user input	
	public boolean validator(User newUser) {
		
		if(newUser.getFirstName() == "" || newUser.getLastName() == "" || newUser.getEmail() == "") {
			System.out.println("Please fill in all required information.");
			return false;
		}
		
		if(!newUser.getEmail().contains("@")) {
			System.out.println("Please enter a valid email address!");
			return false;
		}
		
		if(newUser.getAge() < 0) {
			System.out.println("Please enter a valid age.");
			return false;
		}
		
		
		return true;
	}
	
	
	
	

}
