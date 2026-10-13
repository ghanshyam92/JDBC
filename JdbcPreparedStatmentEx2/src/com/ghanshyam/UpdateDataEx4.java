package com.ghanshyam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateDataEx4 {

	private static String DB_URL = "jdbc:sqlserver://ORI00087:1433;databaseName=ghanshyam;encrypt=true;trustServerCertificate=true";
	private static String DB_USER = "superadmin";
	private static String DB_PASS = "sapass";
	Scanner sc = new Scanner(System.in);

	public static Connection geConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
			System.out.println(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
	public void update() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {

			String sql = "UPDATE emp1 SET SALARY = ? WHERE USERNAME =?";

			connection = geConnection();
			preparedStatement = connection.prepareStatement(sql);
			
			System.out.println("Enter Salary:");
			int salary1 = sc.nextInt();
			
			System.out.println("Enter UserName:");
			String user1 = sc.next();
			
			preparedStatement.setInt(1, salary1);
			preparedStatement.setString(2, user1);

			int execut = preparedStatement.executeUpdate();
			if (execut > 0) {
				System.out.println("Data Update");
			} else {
				System.out.println("Not found:");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
				preparedStatement.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		}

	}
        

	public static void main(String[] args) {
		UpdateDataEx4 createTableEx = new UpdateDataEx4();
	//	createTableEx.geConnection();
		createTableEx.update();
	
	}
}
