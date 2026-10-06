package com.oritso;

import java.sql.Connection;
import java.sql.DriverManager;

public class Lunch {

	public static void main(String[] args) {
		
     try {
		//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		
		String url = "jdbc:sqlserver://ORI00087:1433;encrypt=true;trustServerCertificate=true";
		String username = "superadmin";
		String password = "sapass";
		
		Connection con = DriverManager.getConnection(url,username,password);
		
		System.out.println(con);
	 } catch (Exception e) {
		e.printStackTrace();
	 }
	}

}
