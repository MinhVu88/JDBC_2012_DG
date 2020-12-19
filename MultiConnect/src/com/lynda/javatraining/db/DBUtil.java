package com.lynda.javatraining.db;

// the class's purpose: receive a database type & return a reference to a Connection object

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	private static final String USERNAME = "dbuser";
	
	private static final String PASSWORD = "#dbpassword@M88*";
	
	private static final String H_CONN_STRING = "jdbc:hsqldb:data/explorecalifornia";
	
	private static final String M_CONN_STRING = "jdbc:mysql://localhost:3307/explorecalifornia";
	
	public static Connection getConnection(DBType dbType) throws SQLException {
		switch (dbType) {
			case MYSQL:
				return DriverManager.getConnection(M_CONN_STRING, USERNAME, PASSWORD);
			case HSQLDB:
				return DriverManager.getConnection(H_CONN_STRING, USERNAME, PASSWORD);
			default:
				return null;
		}
	}

}
