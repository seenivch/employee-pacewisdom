package com.employee.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Seenivasan Chandrasekaran
 */

@Entity(name="Employee")
@Table(name="Employee")
public class Employee {
	
	@Id
	@Column(name="ID")
	private String id;
	
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Column(name="LAST_NAME")
	private String lastName;
	
	@Column(name="EMAIL_ID")
	private String emailId;
	
	@Column(name="AGE")
	private String age;
	
	// we can create enum for this field.
	@Column(name="GENDER")
	private String gender;
	
	@Column(name="ADDRESS")
	private String address;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

    public Employee(String id, String firstName, String lastName, String emailId, String age, String gender,
			String address) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.age = age;
		this.gender = gender;
		this.address = address;
	}
	public Employee() {
		this.id = getId();
		this.firstName = getFirstName();
		this.lastName = getLastName();
		this.emailId = getEmailId();
		this.age = getAge();
		this.gender = getGender();
		this.address = getAddress();
    }

}
