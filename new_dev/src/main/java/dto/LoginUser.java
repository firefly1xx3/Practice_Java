package dto;

import java.time.LocalDate;

public class LoginUser {

	private int id;
	private String name;
	private String password;
	private LocalDate dateOfBirth;
	private String email;
	private String phoneNumber;

	// Accessor
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getPassword() {
		return password;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public String getEmail() {
		return email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	// Mutator
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setDateOfBirth(LocalDate dateOfBrith) {
		this.dateOfBirth = dateOfBrith;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}