package com.ghanshyam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ReadDataEx3 {

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
        		String sql ="SELECT * FROM emp11 " + "WHERE USERNAME = ? AND PASSWORD =?";
        		connection = geConnection();
				 preparedStatement = connection.prepareStatement(sql);
				
				System.out.println("Enter User Name :");
				String user = sc.nextLine();
				
			
				System.out.println("Enter Passwoar:");
				String  pass = sc.nextLine();
				
				
				
				preparedStatement.setString(1, user);
				preparedStatement.setString(2, pass);
			
				
			ResultSet resultSet =	preparedStatement.executeQuery();
			
				if (resultSet.next()) {
					int id = resultSet.getInt("ID");
					String user1 = resultSet.getString("USERNAME");
					String pass1 = resultSet.getString("PASSWORD");
					String ful = resultSet.getString("FULLNAME");
					String add = resultSet.getString("ADDRESS");
					int salary = resultSet.getInt("SALARY");
					
					System.out.println("Username:" + user1);
					System.out.println("passward:"+pass1);
					System.out.println("FullName:"+ful);
					System.out.println("Address:"+ add);
					System.out.println("salary"+salary);
		        } else {
		            System.out.println("Data Not Found");
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
		ReadDataEx3 createTableEx = new ReadDataEx3();
	//	createTableEx.geConnection();
		createTableEx.insert();
	}
}
