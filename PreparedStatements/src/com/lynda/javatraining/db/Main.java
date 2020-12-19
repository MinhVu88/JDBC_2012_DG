package com.lynda.javatraining.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.lynda.javatraining.db.tables.Tours;
import com.lynda.javatraining.util.InputHelper;

public class Main {
	
	// a parameterized sql statement as a string
	private static final String SQL = "SELECT tourId, tourName, price FROM tours WHERE price <= ?"; // ? is a placeholder for a variable value

	public static void main(String[] args) throws Exception {
		double maxPrice;
		
		try {
			maxPrice = InputHelper.getDoubleInput("\nenter a max price: $");
		
		} catch (NumberFormatException e) {
			System.err.println(e + ": invalid input");
			
			return; // by the time the stmt instance's setDouble() method is called, it's clear that the user has entered a valid input
		}
		
		ResultSet rs = null;
		
		try (
				Connection conn = DBUtil.getConnection(DBType.MYSQL);
				
				//Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				
				PreparedStatement stmt = conn.prepareStatement(SQL, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				) {
			stmt.setDouble(1, maxPrice);
			
			// when PreparedStatement is used, you already passed in SQL when you prepared the statement
			// so you don't pass it again when you execute it, that's why the String argument SQL is removed
			// so when the executeQuery() method is called now, it works with a statement that already has SQL & set its variable values  
			//rs = stmt.executeQuery(SQL); 
			
			rs = stmt.executeQuery();
			
			Tours.displayData(rs);

		} catch (SQLException e) {
			System.err.println(e);
		}
		
		finally {
			if (rs != null) rs.close();
		}
	}

}
