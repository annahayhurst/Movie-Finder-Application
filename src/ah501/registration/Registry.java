package ah501.registration;

import java.util.HashMap;
import java.util.Map;
import java.io.EOFException;
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

	//constructor
	public Registry( ) {
		register = new HashMap<Integer, String>();
		fetchUserInformation(register);
	}
	
	public String toString() {
		return register.toString();
	}
	
	// adds new user to map and to file, granted their input matches validator() criteria
	public void addUser(User newUser) {
	
	if(validator(newUser)) {
		this.getRegister().put(newUser.getUserId(), newUser.getUsername());
		saveUserInformation(newUser);
		System.out.println("User registered successfully.");
	}
		
	}
	
	// this adds the last created user's data to file storage
	private void saveUserInformation(User user) {
		OutputStream output = null;
        ObjectOutputStream objOut = null;
        try {
            output = new FileOutputStream(System.getProperty("user.dir")+"\\src\\files\\UserData.data");
            objOut = new ObjectOutputStream(output);
            objOut.writeObject(user);
            
            objOut.flush();
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } 
        
        finally {
            	try {
            		if(objOut != null) objOut.close();
            	} catch (Exception ex) {
                 ex.printStackTrace();
            }
        }
	}
	
	// this loads the current data from the user data file into the map
	private void fetchUserInformation(Map<Integer, String> map) {
		boolean proceed = true;
		InputStream fileInput = null;
        ObjectInputStream objInStream = null;
        
        try {
            fileInput = new FileInputStream(System.getProperty("user.dir")+"\\src\\files\\UserData.data");
				objInStream = new ObjectInputStream(fileInput);
          
           // as long as there are objects left in the file, read them
          while(proceed){
        	  User u = null;
        	 try {
        		 u = (User) objInStream.readObject();
        		 if(u != null) {
            		 map.put(u.getUserId(), u.getUsername());
            		// System.out.println(u == null);
            	 } else proceed = false;
        		 
        	 } catch (ClassNotFoundException e) {
                 e.printStackTrace();
             } catch (EOFException e) {
            	 break;
             }
        	 
        	 // if the user is not null, add it to the map
          }    
          // end while loop
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();

        }

        finally {
            try {
                if(objInStream != null) objInStream.close();
            } catch (Exception ex){
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
		
		return true;
	}
	
	// getters + setters
	
	public Map<Integer, String> getRegister() {
		return register;
	}


	public void setRegister(Map<Integer, String> register) {
		this.register = register;
	}

	
	

}
