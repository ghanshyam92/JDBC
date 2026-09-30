package com.oritso;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Arrays;
import java.util.Scanner;

public class Lunch {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Connection con = null;


		try {
			// Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			String url = "jdbc:sqlserver://ORI00087:1433;databaseName=ghanshyam;encrypt=true;trustServerCertificate=true";
			String username = "superadmin";
			String password = "sapass";

			con = DriverManager.getConnection(url, username, password);// bydefult autocommit
			con.setAutoCommit(false);
			String sql = "INSERT INTO employee2" + "(USERNAME, PASSWORD, FULLNAME, ADDRESS, SALARY) "
					+ "VALUES (?,?,?,?,?)";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			
			while (true) {
				
			
			
			System.out.println("Enter UserName:");
			String user = sc.next();

			System.out.println("Enter Password:");
			String pass = sc.next();

			sc.nextLine();
			System.out.println("Enter Full Name:");
			String fullname = sc.nextLine();

			System.out.println("Enter Address:");
			String address = sc.nextLine();

			System.out.println("Enter Salary:");
			int salary = sc.nextInt();

			preparedStatement.setString(1,user);
			
			preparedStatement.setString(2,pass);
			preparedStatement.setString(3,fullname);
			preparedStatement.setString(4,address);
			preparedStatement.setInt(5,salary);
			

			preparedStatement.addBatch();
			
			
			System.out.println("Do You Want to insert Data more... Enter(y)");
			String choise = sc.next().trim().toUpperCase();
			
			if(!choise.equals("Y")) {
				int []i = preparedStatement.executeBatch();
				Arrays.stream(i).forEach(n-> System.out.println(n));
				System.out.println("Rows" + i.length);
				con.commit();
				break;
				
			}
			

			
			
			}
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
