package com.ghanshyam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTableEx {

	private static String DB_URL = "jdbc:sqlserver://ORI00087:1433;databaseName=ghanshyam;encrypt=true;trustServerCertificate=true";
	private static String DB_USER = "superadmin";
	private static String DB_PASS = "sapass";

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

	public CreateTableEx() {
		Connection connection = null;
		Statement statement = null;

		try {
			connection = geConnection();
			String sql = "CREATE TABLE emp11 (" + "ID INT IDENTITY(1,1) PRIMARY KEY, "
					+ "USERNAME VARCHAR(30) NOT NULL UNIQUE, " + "PASSWORD VARCHAR(16), " + "FULLNAME VARCHAR(100), "
					+ "ADDRESS VARCHAR(100), " + "SALARY INT)";

			statement = connection.createStatement();
			statement.executeUpdate(sql);
			System.out.println("Table Create:");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
				statement.close();
			} catch (SQLException e) {

				e.printStackTrace();
			} finally {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		CreateTableEx createTableEx = new CreateTableEx();
		createTableEx.geConnection();
	}
}
