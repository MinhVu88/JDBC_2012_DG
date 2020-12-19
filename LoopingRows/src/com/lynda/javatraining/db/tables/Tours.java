package com.lynda.javatraining.db.tables;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;

public class Tours {
	public static void displayData(ResultSet rs) throws SQLException {
		while (rs.next()) {
			StringBuffer buffer = new StringBuffer();
			
			buffer.append(rs.getInt("tourId") + ": ");
			
			buffer.append(rs.getString("tourName"));
			
			double price = rs.getDouble("price");
			
			NumberFormat nf = NumberFormat.getCurrencyInstance();
			
			String formarttedPrice = nf.format(price);
			
			buffer.append(" (" + formarttedPrice + ")");
			
			System.out.println(buffer.toString());
		}
	}
}
