package endtermprojectArucorn;

import java.util.*;
import java.io.*;

public abstract class User implements Serializable {
	
    private String login;
    private String password;
    private String name;
    private String surname;
    private static int num = 0;
    private int userId;
    private String email; 
    private int phone;
    private static final long serialVersionUID = 1L;
    
    {
    	num++;
    	userId = num;
    }
    
    public User() {
    	
    }
 
    public User(String name, String surname) {
    	this.name = name;
    	this.surname = surname;
    	login = name + surname;
    	password = name + userId;
    }
   
    public String getLogin() {
        return login;
    }
    
    public void setLogin(String login) {
        this.login = login;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void changePassword(String password) {
        this.password = password;
    }
  
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getSurname() {
        return surname;
    }
   
    public void setSurname(String surname) {
        this.surname = surname;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public int getPhone() {
        return phone;
    }
  
    public void setPhone(Integer phone) {
        this.phone = phone;
    }
    
    public int getId() {
    	return userId;
    }
    /**
     * Transforms string to integer in order to contribute the function "equals" run faster                         
     */
    public int hashCode() {
    	final int prime = 31;
		int result = 1;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
    }
    /**
     *Function which compare login and password hashcode to enter the system
     */
    public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User)obj;
		return other.getLogin().equals(getLogin());
    }
    /**
     * Boolean to check if the user is logged in
     * @param login
     * @param password
     * @return
     */
    public boolean login(String login, String password) {
    	return (this.login.equals(login) && this.password.equals(password));
    }
    
    public String toString() {
		return name + " " + surname;
    }
    
    public void getInfo() {
    	System.out.println(toString());
    }

}
