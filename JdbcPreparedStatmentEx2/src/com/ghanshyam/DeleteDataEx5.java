package com.ghanshyam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DeleteDataEx5 {

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
	public void Delete() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {

			String sql = "DELETE FROM emp1 WHERE USERNAME = ?";

			connection = geConnection();
			preparedStatement = connection.prepareStatement(sql);
			
			System.out.println("Enter User:");
			String user = sc.nextLine();
			
			preparedStatement.setString(1, user);

			int execut = preparedStatement.executeUpdate();
			if (execut > 0)
				System.out.println("Data deleted");
			else {
				System.out.println("User not found:");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
				preparedStatement.close();
			} catch (Exception e2) {
				
			}
		}

	}
        

	public static void main(String[] args) {
		DeleteDataEx5 createTableEx = new DeleteDataEx5();
	//	createTableEx.geConnection();
		createTableEx.Delete();
	
	}
}
