package com.registration;

public class StudentRegInfo {
	
	private String Username;
	private String Password;
	private String Email;
	private String FirstName;
	private String LastName;
	private String School;
	private String City;
	private String Province;
	
	public StudentRegInfo() {
	}
	
	public StudentRegInfo(
			String Username,
			String Password,
			String Email,
			String FirstName,
			String LastName,
			String School,
			String City,
			String Province) {
		
		this.Username = Username;
		this.Password = Password;
		this.Email = Email;
		this.FirstName = FirstName;
		this.LastName = LastName;
		this.School = School;
		this.City = City;
		this.Province = Province;
		
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
	
	public String getCity() {
		return City;
	}
	public void setCity(String City) {
		this.City = City;
	}
	
	public String getProvince() {
		return Province;
	}
	public void setProvince(String Province) {
		this.Province = Province;
	}

}
