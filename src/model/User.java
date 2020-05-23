package model;

import java.io.Serializable;

final public class User extends Person implements Serializable {
	private static final long serialVersionUID = -2226197306790714013L;

	private String userEmail;

	public User(String userEmail, String fname, String lname, String tel, Address add) {
		super(fname, lname, tel, add);
		this.userEmail = userEmail;
	}

	public String getUserEmail() {
		return userEmail;
	}

	@Override
	public String toString() {
		return "Member Info: " + "Email: " + userEmail + ", name: " + getFirstName() + " " + getLastName() + ", "
				+ getTelephone() + " " + getAddress();
	}

}