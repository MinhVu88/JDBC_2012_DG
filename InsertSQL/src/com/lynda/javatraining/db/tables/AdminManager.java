package com.lynda.javatraining.db.tables;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.lynda.javatraining.db.DBType;
import com.lynda.javatraining.db.DBUtil;
import com.lynda.javatraining.db.beans.Admin;

public class AdminManager {

	public static void displayAllRows() throws SQLException {
		String sql = "SELECT adminId, userName, password FROM admin";
		
		try (
				Connection conn = DBUtil.getConnection(DBType.MYSQL);
				
				Statement stmt = conn.createStatement();
				
				ResultSet rs = stmt.executeQuery(sql);
				
				){

			System.out.println("Admin Table:");
			
			while (rs.next()) {
				StringBuffer bf = new StringBuffer();
				
				bf.append(rs.getInt("adminId") + ": ");
				
				bf.append(rs.getString("userName") +", ");
				
				bf.append(rs.getString("password"));
				
				System.out.println(bf.toString());
			}
		}
	}

	public static Admin getRow(int adminId) throws SQLException {
		String sql = "SELECT * FROM admin WHERE adminId = ?";
		
		ResultSet rs = null;

		try (
				Connection conn = DBUtil.getConnection(DBType.MYSQL);
				
				PreparedStatement stmt = conn.prepareStatement(sql);
				
				){
			
			stmt.setInt(1, adminId);
			
			rs = stmt.executeQuery();

			if (rs.next()) {
				Admin bean = new Admin();
				
				bean.setAdminId(adminId);
				
				bean.setUserName(rs.getString("userName"));
				
				bean.setPassword(rs.getString("password"));
				
				return bean;
			} else {
				return null;
			}

		} catch (SQLException e) {
			System.err.println(e);
			
			return null;
		
		} finally {
			if (rs != null) {
				rs.close();
			}
		}

	}

	public static boolean insert(Admin bean) throws Exception {
		String sql = "INSERT into admin (userName, password) " + "VALUES (?, ?)";
		
		ResultSet keys = null;
		
		try (
				Connection conn = DBUtil.getConnection(DBType.MYSQL);
				
				PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				
				) {
			
			stmt.setString(1, bean.getUserName());
			
			stmt.setString(2, bean.getPassword());
			
			//stmt.executeUpdate();
			
			// executeUpdate() returns an int that represents the number of rows that are affected by INSERT in the sql statement
			// if any values were successfully inserted into the database, executeUpdate() will always return 1
			int affectedRow = stmt.executeUpdate();
			
			if (affectedRow == 1) {
				// if the database table has a column that contains auto-increment primary key values,
				// the PreparedStatement object's getGeneratedKeys() will return a ResultSet object containing a single column & a single row, 
				// in which the auto-generated key(s) is stored 
				keys = stmt.getGeneratedKeys();
				
				// as with all result sets, the cursor starts before the 1st row of data
				// if the ResultSet object's next() returns true, the cursor moves forward 1 row from its current position
				keys.next();
				
				// call the ResultSet object's getInt() with the argument of 1 to get the value of the 1st column
				int newKey = keys.getInt(1);
				
				bean.setAdminId(newKey);
			} else {
				System.err.println("\nno rows affected");
				
				return false;
			}
			
		} catch (SQLException e) {
			System.err.println(e);
			
			return false;
		
		} finally {
			if(keys != null) keys.close();
		}
		
		return true;
	}

}
