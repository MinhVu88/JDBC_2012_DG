package com.lynda.javatraining.db;

import com.lynda.javatraining.db.beans.Admin;
import com.lynda.javatraining.db.tables.AdminManager;
import com.lynda.javatraining.util.InputHelper;

public class Main {

	public static void main(String[] args) throws Exception {

		AdminManager.displayAllRows();

		int adminId = InputHelper.getIntegerInput("\nSelect a row to update: ");

		Admin bean = AdminManager.getRow(adminId);
		
		if (bean == null) {
			System.err.println("Row not found");
			
			return;
		}
		
		String password = InputHelper.getInput("\nenter a new password: ");
		
		bean.setPassword(password);
		
		if (AdminManager.update(bean)) {
			System.out.println("\n\tsuccess");
		} else {
			System.out.println("\n\tsomething's wrong");
		}
	}
}
