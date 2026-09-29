package com.ghanshyam.ConnectionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionCurd {
	
	private static String DB_URL ="jdbc:sqlserver://ORI00087:1433;databaseName=ghanshyam;encrypt=true;trustServerCertificate=true";
	private static String DB_USER ="superadmin";
	private static String DB_PASS ="sapass";
	
   public static Connection geConnection() {
	   Connection connection = null;
	    try {
			connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PASS);
		} catch (Exception e) {
			e.printStackTrace();
		}
	    return connection;
   }
   
   public static void close(Connection connection) {
	   if(connection!= null) {
		   try {
			connection.close();
		   } catch (SQLException e) {
			
			e.printStackTrace();
		   }
	   }
   }

   public static void close(PreparedStatement preparedStatement) {
	   if(preparedStatement!=null)
		   try {
			   preparedStatement.close();
		   } catch (SQLException e) {
			
			e.printStackTrace();
		   }
	   }
	
   
}
