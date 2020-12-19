package com.lynda.javatraining.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.lynda.javatraining.db.tables.States;

public class Main {

	public static void main(String[] args) throws Exception {

		try (
				Connection conn = DBUtil.getConnection(DBType.HSQLDB);

				Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				
				//Statement stmt = conn.createStatement(); // unscrollable result set (HSQLDB's default type of result set)

				ResultSet rs = stmt.executeQuery("SELECT stateId, stateName FROM states");   	
				) {

			States.displayData(rs);
			
			rs.last(); // move the cursor to the last row of the result set
			
			System.out.println("\nnumbers of rows: " + rs.getRow());
			
			rs.first(); // move the cursor to the 1st row of the result set
			
			System.out.println("\nthe 1st state: " + rs.getString("stateName"));
			
			rs.last(); // move the cursor to the last row of the result set
			
			System.out.println("\nthe last state: " + rs.getString("stateName"));
			
			rs.absolute(7); // move the cursor to the 7th row of the result set
			
			System.out.println("\nthe 7th state: " + rs.getString("stateName"));
			
		} catch (SQLException e) {
			System.err.println(e);
		}
	}

}
