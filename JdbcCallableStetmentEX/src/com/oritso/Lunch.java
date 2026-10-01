package com.oritso;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Lunch {
  
	public static void main(String[] args) {
		  Scanner sc = new Scanner(System.in);
		  Connection con = null;
		
     try {
		//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		
		String url = "jdbc:sqlserver://ORI00087:1433;databaseName=ghanshyam;encrypt=true;trustServerCertificate=true";
		String username = "superadmin";
		String password = "sapass";
		
		con = DriverManager.getConnection(url,username,password);//bydefult autocommit
		con.setAutoCommit(false);
		
		String sql = "UPDATE employee1 SET SALARY = ? WHERE USERNAME ='user01'";	
	     PreparedStatement preparedStatement = con.prepareStatement(sql);
		 
	     System.out.println("Enter New Salary:");
	     preparedStatement.setInt(1, sc.nextInt());
	     int ececut1 = preparedStatement.executeUpdate();     
	     System.out.println(ececut1);
	     
	     Thread.sleep(10000);
	     
	     System.out.println("Enter New Salary:");
	     preparedStatement.setInt(1, sc.nextInt());
	     int ececut12 = preparedStatement.executeUpdate();     
	     
	     
	     Thread.sleep(10000);
	     
	     System.out.println("Enter New Salary:");
	     preparedStatement.setInt(1, sc.nextInt());
	     int ececut3 = preparedStatement.executeUpdate();     
	     
	     con.commit();
	 } catch (Exception e) {
		 try {
			con.rollback();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		e.printStackTrace();
	 }
	}

}
