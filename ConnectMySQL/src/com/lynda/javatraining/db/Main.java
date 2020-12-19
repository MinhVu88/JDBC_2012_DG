package com.lynda.javatraining.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

	private static final String USERNAME = "dbuser";
	private static final String PASSWORD = "#dbpassword@M88*";
	private static final String CONN_STRING = "jdbc:mysql://localhost:3307/explorecalifornia";
	
	public static void main(String[] args) throws SQLException {
		//Class.forName("com.mysql.jdbc.Driver"); // available in java 6 & 7
		
		Connection connection = null;
		
		try {
			connection = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
			
			System.out.println("\nconnected");
		} catch (SQLException e) {
			System.err.println(e);
		} finally {
			if(connection != null) {
				connection.close();
			}
		}
	}

}
