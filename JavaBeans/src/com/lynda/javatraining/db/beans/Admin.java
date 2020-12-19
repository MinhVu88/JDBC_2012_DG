package com.lynda.javatraining.db.beans;

/* an instance of this class represents a single row of data in the admin table 
 * 
 * each instance field represents each of the table's columns
 * 
 * the data types of the fields match the columns' data types
 * */

import java.io.Serializable;

public class Admin implements Serializable {
	private static final long serialVersionUID = -3872771277839460828L;

	private int adminId;
	
	private String userName, password;

	/**
	 * @return the adminId
	 */
	public int getAdminId() {
		return adminId;
	}

	/**
	 * @param adminId the adminId to set
	 */
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
