package com.lynda.javatraining.db;

import com.lynda.javatraining.db.beans.Admin;
import com.lynda.javatraining.db.tables.AdminManager;
import com.lynda.javatraining.util.InputHelper;

public class Main {

	public static void main(String[] args) throws Exception {

		AdminManager.displayAllRows();
		
		Admin bean = new Admin();
		
		bean.setUserName(InputHelper.getInput("username: "));
		
		bean.setPassword(InputHelper.getInput("password: "));
		
		boolean result = AdminManager.insert(bean);
		
		if(result) {
			System.out.println("\nnew row with primary key " + bean.getAdminId() + " was inserted");
		}
	}

}
