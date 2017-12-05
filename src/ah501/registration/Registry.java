package ah501.registration;

import java.util.ArrayList;
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

/*
* Author: ah501
* Registry class storing users in a map, where the key is their ID and the value is their username.
* Handles adding new users by writing them to the UserData file.
* When initialised, it fetches the user information from the file by deserializing it and adds each user to the map.
 */

public class Registry {
	
	private ArrayList register;

	//constructor
	public Registry( ) {
		register = new ArrayList<User>();
		fetchUserInformation(register);
		User.receiveLatestId();

	}
	
	public String toString() {
		return register.toString();
	}
	
	// adds new user to map and to file, granted their input matches register(User) criteria
	public void addUser(User newUser) {
	
	if(register(newUser)) {
		this.getRegister().add(newUser);
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
	private void fetchUserInformation(ArrayList<User> users) {
		boolean proceed = true;
		InputStream fileInput = null;
        ObjectInputStream objInStream = null;
        
        try {
            fileInput = new FileInputStream(".\\src\\files\\UserData.data");
				objInStream = new ObjectInputStream(fileInput);
          
           // as long as there are objects left in the file, read them
          while(proceed){
        	  User u = null;
        	 try {
        		 u = (User) objInStream.readObject();
        		 if(u != null) {
            		users.add(u);
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
	public boolean register(User newUser) {
		
		if(newUser.getName() == "" || newUser.getEmail() == "") {
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
	
	public ArrayList<User> getRegister() {
		return register;
	}


	public void setRegister(ArrayList<User> register) {
		this.register = register;
	}

	
	

}
