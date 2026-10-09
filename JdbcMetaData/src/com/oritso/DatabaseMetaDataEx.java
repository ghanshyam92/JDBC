package com.oritso;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.util.Scanner;

public class DatabaseMetaDataEx {
  public static void main(String[] args) {
	  Scanner sc=new Scanner(System.in);
	  Connection con = null;
	  try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String url = "jdbc:sqlserver://ORI00087:1433;databaseName=ghanshyam;encrypt=true;trustServerCertificate=true";
		String username = "superadmin";
		String password = "sapass";
		
		con  = DriverManager.getConnection(url,username,password);
		
		DatabaseMetaData db = con.getMetaData();
		
		System.out.println(db);
		
		String url1 = db.getURL();
		System.out.println(url1);
		
		String username1 = db.getUserName();
		System.out.println(username1);
		
		String databsename = db.getDatabaseProductName();
		System.out.println("getDatabaseProductName();"+databsename);
		
		 String databaseProduct1 = db.getDatabaseProductVersion();
		   System.out.println("getDatabaseProductVersion();"+databaseProduct1);
		   int  databaseProductMiner = db.getDatabaseMajorVersion();
		   System.out.println("getDatabaseMajorVersion();"+databaseProductMiner);
		   
		   int databaseMajor =  db.getDatabaseMajorVersion();
		   System.out.println("getDatabaseMajorVersion();"+databaseMajor);
		   
		   int databaseTable =  db.getMaxTableNameLength();
		   System.out.println("getMaxTableNameLength();"+databaseTable);
		   
		
		
	  } catch (Exception e) {
		
		e.printStackTrace();
	  }

		
}
}
