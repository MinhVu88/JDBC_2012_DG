package com.lynda.javatraining.db;

import java.sql.Connection;

import com.lynda.javatraining.db.beans.Admin;
import com.lynda.javatraining.db.tables.AdminManager;
import com.lynda.javatraining.util.InputHelper;

public class Main {

	public static void main(String[] args) throws Exception {

		System.out.println("\nStarting application");
		
		ConnectionManager.getInstance().setDBType(DBType.MYSQL);
		
		AdminManager.displayAllRows();

		int adminId = 0;
		
		try {
			adminId = InputHelper.getIntegerInput("\nSelect a row to update: ");
		
		} catch (NumberFormatException e) {
			System.err.println("\n\tInvalid entry");
		}

		Admin bean = AdminManager.getRow(adminId);
		
		if (bean == null) {
			System.err.println("\n\tRow not found");
			
			return;
		}
		
		String password = InputHelper.getInput("\nEnter new password: ");
		
		bean.setPassword(password);
		
		// create a Connection object reference, 
		// call its setAutoCommit() & 
		// set the method's boolean argument from default true to false
		Connection conn = ConnectionManager.getInstance().getConnection();
		
		conn.setAutoCommit(false);
		
		if (AdminManager.update(bean)) {
			System.out.println("\n\tSuccess!");
		} else {
			System.err.println("\n\twhoops!");
		}
		
		/*
		// after explicitly setting the Connection instance's setAutoCommit() to false,
		// the instance's commit() must be called to commit the transactions to the database
		conn.commit();
		
		System.out.println("\n\ttransaction committed");
		*/
		
		
		// call the Connection instance's rollback() to undo the changes made & committed to the database
		conn.rollback();
		
		System.out.println("\n\ttransaction rolled back");
		
		
		ConnectionManager.getInstance().close();
	}
}
