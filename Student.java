package com.model;

public class Student {
	private String rollNumber;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String email;
	private String branchName;
	private String password;

	public Student(String rollNumber, String firstName, String lastName, String phoneNumber, String email,
			String branchName) {
		this.rollNumber = rollNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.branchName = branchName;
	}

	public Student(String rollNumber, String firstName, String lastName, String phoneNumber, String email,
			String password, String branchName) {
		this(rollNumber, firstName, lastName, phoneNumber, email, branchName); 
		this.password = password;
	}

	public String getRollNumber() {
		return rollNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public String getBranchName() {
		return branchName;
	}

	public String getPassword() {
		return password;
	}
}