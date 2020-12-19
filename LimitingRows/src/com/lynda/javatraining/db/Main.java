package com.lynda.javatraining.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.lynda.javatraining.db.tables.Tours;

public class Main {

	public static void main(String[] args) throws Exception {
		//ResultSet rs = null;
		
		try (
				Connection conn = DBUtil.getConnection(DBType.HSQLDB);
				
				Statement stmt = conn.createStatement();
				
				//stmt.setMaxRows(7);
				
				/*
				 * LIMIT(value 1, value 2)
				 * 
				 * value 1: the row position in the database, plus 1 when displayed (ex: 9 -> 10th row)
				 * 
				 *  value 2: the number of rows, counting from value 1, to be displayed (ex: 7 -> 9 + 7 = 16th row)
				 * */
				ResultSet rs = stmt.executeQuery("SELECT tourId, tourName, price FROM tours " + "LIMIT 9, 7");
				) {
			
			//stmt.setMaxRows(7);
			
			//rs = stmt.executeQuery("SELECT tourId, tourName, price FROM tours");
			
			Tours.displayData(rs);
		
		} catch (SQLException e) {
			System.err.println(e);
		
		}/*finally {
			rs.close();
		}*/
	}

}
