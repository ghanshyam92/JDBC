package com.oritso;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Arrays;
import java.util.Scanner;

public class GetMetaDataEx {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Connection con = null;

		try {
			// Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			String url = "jdbc:sqlserver://ORI00087:1433;databaseName=ghanshyam;encrypt=true;trustServerCertificate=true";
			String username = "superadmin";
			String password = "sapass";

			con = DriverManager.getConnection(url, username, password);// bydefult autocommit
			System.out.println(con);

			String sql = "SELECT * FROM employee2 ";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();

			ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

			int count = resultSetMetaData.getColumnCount();
			System.out.println(count);
            
			
			
			String count1 = resultSetMetaData.getColumnName(1);
			System.out.println(count1);
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
