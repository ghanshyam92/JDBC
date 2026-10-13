package com.ghanshyam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class IsertDataEx2 {

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
        public void insert() {
        	Connection connection = null;
        	PreparedStatement preparedStatement = null;
        	
        	try {
        		String sql ="INSERT INTO emp11" + "(USERNAME, PASSWORD, FULLNAME, ADDRESS, SALARY) "
    					+ "VALUES (?,?,?,?,?)";
        		connection = geConnection();
				 preparedStatement = connection.prepareStatement(sql);
				
				System.out.println("Enter User Name :");
				String user = sc.nextLine();
				
//				sc.nextLine();
				System.out.println("Enter Passwoar:");
				String  pass = sc.nextLine();
				
//				sc.nextLine();
				System.out.println("Enter Full name :");
				String full = sc.nextLine();
				
//				sc.nextLine();
				System.out.println("Enter yout Address:");
				String add = sc.nextLine();
                
				System.out.println("Enter Salary:");
				int salary = sc.nextInt();
				
				preparedStatement.setString(1, user);
				preparedStatement.setString(2, pass);
				preparedStatement.setString(3, full);
				preparedStatement.setString(4, add);
				preparedStatement.setInt(5, salary);
				
			int rows =	preparedStatement.executeUpdate();
				if (rows > 0) {
		            System.out.println("Data Inserted Successfully!");
		        } else {
		            System.out.println("Data Not Inserted!");
		        }
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
        	finally {
				try {
					connection.close();
					preparedStatement.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
        }

	public static void main(String[] args) {
		IsertDataEx2 createTableEx = new IsertDataEx2();
	//	createTableEx.geConnection();
		createTableEx.insert();
	}
}
