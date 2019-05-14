package com.registration;

public class TutorRegInfo {

	private String Username;
	private String Password;
	private String Email;
	private String FirstName;
	private String LastName;
	private String School;
	
	public TutorRegInfo() {
	}
	
	public TutorRegInfo(
			String Username,
			String Password,
			String Email,
			String FirstName,
			String LastName,
			String School) {
		
		this.Username = Username;
		this.Password = Password;
		this.Email = Email;
		this.FirstName = FirstName;
		this.LastName = LastName;
		this.School = School;
		
	}
	
	public String getUsername() {
		return Username;
	}
	public void setUsername(String Username) {
		this.Username = Username;
	}
	
	public String getPassword() {
		return Password;
	}
	public void setPassword(String Password) {
		this.Password = Password;
	}
	
	public String getEmail() {
		return Email;
	}
	public void setEmail(String Email) {
		this.Email = Email;
	}
	
	public String getFristName() {
		return FirstName;
	}
	public void setFirstName(String FirstName) {
		this.FirstName = FirstName;
	}
	
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String LastName) {
		this.LastName = LastName;
	}
	
	public String getSchool() {
		return School;
	}
	public void setSchool(String School) {
		this.School = School;
	}
	
}
