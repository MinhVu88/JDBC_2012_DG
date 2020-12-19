package com.lynda.javatraining.db.beans;

/* an instance of this class represents a single row of data in the admin table 
 * 
 * each instance field represents each of the table's columns
 * 
 * the data types of the fields match the columns' data types
 * */

public class Admin {
	
	private int adminId;
	
	private String userName;
	
	private String password;
	
	public int getAdminId() {
		return adminId;
	}
	
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

}
