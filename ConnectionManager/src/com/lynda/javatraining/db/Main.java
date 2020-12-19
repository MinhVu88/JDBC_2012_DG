package com.lynda.javatraining.db;

import com.lynda.javatraining.db.beans.Admin;
import com.lynda.javatraining.db.tables.AdminManager;
import com.lynda.javatraining.util.InputHelper;

public class Main {

	public static void main(String[] args) throws Exception {

		System.out.println("\nStarting application");
		
		/*
		 * ConnectionManager.getInstance(): get a reference to the 1 & only ConnectionManager object
		 * 
		 * ConnectionManager.getInstance().setDBType(DBType.MYSQL): call the object's setDBType() to choose a database type
		 * */
		ConnectionManager.getInstance().setDBType(DBType.MYSQL);
		
		AdminManager.displayAllRows();

		int adminId = InputHelper.getIntegerInput("\nSelect a row to update: ");

		Admin bean = AdminManager.getRow(adminId);
		
		if (bean == null) {
			System.err.println("\n\tRow not found");
			
			return;
		}
		
		String password = InputHelper.getInput("\nEnter new password: ");
		
		bean.setPassword(password);
		
		if (AdminManager.update(bean)) {
			System.out.println("\n\tSuccess!");
		} else {
			System.err.println("\n\twhoops!");
		}
		
		// call the ConnectionManager object's close() to close the connection
		ConnectionManager.getInstance().close();
	}
}
