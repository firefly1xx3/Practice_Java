package dto;

public class Customer {
	private int id;
	private String name;
	private String address;
	private String phoneNumber;
	private int userId;

	// Accessor
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public int getUserId() {
		return userId;
	}
	// Mutator
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
}
