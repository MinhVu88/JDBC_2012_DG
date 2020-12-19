package com.lynda.javatraining.db;

import java.sql.SQLException;

import com.lynda.javatraining.db.beans.Admin;
import com.lynda.javatraining.db.tables.AdminManager;
import com.lynda.javatraining.util.InputHelper;

public class Main {

	public static void main(String[] args) throws SQLException {

		AdminManager.displayAllRows();
		
		int adminId = InputHelper.getIntegerInput("\nselect a row: ");
		
		Admin bean = AdminManager.getRow(adminId);
		
		if(bean == null) {
			System.err.println("\n\tno rows were found");
		}else {
			System.out.println("\n\tadmin id: " + bean.getAdminId());
			
			System.out.println("\n\tusername: " + bean.getUserName());
			
			System.out.println("\n\tpassword: " + bean.getPassword());
		}
	}

}
