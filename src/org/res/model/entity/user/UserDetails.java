package org.res.model.entity.user;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserDetails {
	@Id
	private String userId;
	private String password;
	private String firstName;
	private String lastName;
	private String emailId;
	private String address;
	public UserDetails() {

	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public UserDetails(String userId, String password, String firstName, String lastName, String emailId, String address) {
		super();
		this.userId = userId;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.address = address;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	@Override
	public String toString() {
		return "UserDetails [userId=" + userId + ", password=" + password + ", firstName=" + firstName + ", lastName="
				+ lastName + ", emailId=" + emailId + "]";
	}

}
