package model;

public class Manager extends User {

	private String access_level; 
	
	public Manager(String firstName, String lastName, String username, String password ,String phone, String profession, String salary) {
		super(firstName, lastName, username, password ,phone , profession,salary);
	
	}
	public String getAccess_level() {
		return access_level;
	}

	public void setAccess_level(String access_level) {
		this.access_level = access_level;
	}

	@Override
	public String toString() {
		return "Manager [access_level=" + access_level + "]";
	}
	
}
