package dto;

public class UserInfo {
	
	private int id;
	private String name;
	private String phoneNumber;
	private String dateOfBirth;
	private String email;
	
	// Accessor
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public String getEmail() {
		return email;
	}
	
	// Mutator 
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
