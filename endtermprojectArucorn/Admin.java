package endtermprojectArucorn;


public class Admin extends Employee {
	
    public Admin() {
    	super();
    }
    
    public Admin(String name, String surname) {
    	super(name, surname);
    }
    
    public void updateUser(int choice, String updateInfo, int ID) {
		switch(choice) {
		case 1: Data.users.elementAt(ID - 1).setName(updateInfo);
				break;
		case 2: Data.users.elementAt(ID - 1).setSurname(updateInfo);
				break;
		case 3: Data.users.elementAt(ID - 1).changePassword(updateInfo);
				break;
		}
	}

	@Override
	public String toString() {
		return "Admin: " +
				"name = " + getName() +
				", surname = " + getSurname();
	}

}