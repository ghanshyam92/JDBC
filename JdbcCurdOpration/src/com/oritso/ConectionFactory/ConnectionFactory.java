package com.oritso.ConectionFactory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	private static String DB_URL ="jdbc:sqlserver://ORI00087:1433;databaseName=ghanshyam;encrypt=true;trustServerCertificate=true";
	private static String DB_USER ="superadmin";
	private static String DB_PASS ="sapass";
   public static Connection geConnection() {
	   Connection connection = null;
	   try {
		connection=DriverManager.getConnection(DB_URL,DB_USER,DB_PASS);
	} catch (Exception e) {
		e.printStackTrace();
	}
	   return connection;
   }
   
   public static void close(Connection connection) {
	   try {
		if(connection != null) {
			connection.close();
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
   }
}
