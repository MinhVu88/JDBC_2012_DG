package com.lynda.javatraining.db;

import com.lynda.javatraining.db.tables.AdminManager;
import com.lynda.javatraining.util.InputHelper;

public class Main {

	public static void main(String[] args) throws Exception {

		AdminManager.displayAllRows();

		int adminId = InputHelper.getIntegerInput("\nSelect a row to delete: ");
		
		if (AdminManager.delete(adminId)) {
			System.out.println("\n\tsuccess");
		} else {
			System.err.println("\n\tnothing to delete");
		}

	}
}
