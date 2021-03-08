package endtermprojectArucorn;

public class NewUser {
	
	public User getUser(String user, String name, String surname) {
		if(user == null) {
			return null;
		}
		
		if(user.equals("Student")) {
			return new Student(name, surname);
		}
		
		if(user.equals("Teacher")) {
			return new Teacher(name, surname);
		}
		
		if(user.equals("Manager")) {
			return new Manager(name, surname);
		}
		return null;
	}
}

	
