package com.oritso.ConectionFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.oritso.dto.DtoEx;

public class OprationMethod {
	public OprationMethod() {
		CreatTable();
	}

	public void CreatTable() {
		Connection connection = null;
		try {

			connection = ConnectionFactory.geConnection();
			String sql = "CREATE TABLE stude(" + "ID INT IDENTITY(1,1) PRIMARY KEY, " + "DEPARTMENT VARCHAR(50), "
					+ "NAME VARCHAR(100), " + "ROLLNO INT, " + "SECTION VARCHAR(20))";

			Statement statement = connection.createStatement();
			statement.executeUpdate(sql);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(connection);
		}
	}

	public void Insert(DtoEx dt) {
		Connection connection = null;
		try {
			String sql = "INSERT INTO stude " + "(DEPARTMENT, NAME, ROLLNO, SECTION) " + "VALUES ('"
					+ dt.getDepartment() + "', " + "'" + dt.getName() + "', " + dt.getRollno() + ", " + "'"
					+ dt.getSection() + "')";
			connection = ConnectionFactory.geConnection();
			Statement statement = connection.createStatement();
			statement.executeUpdate(sql);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(connection);
		}

	}

	public void update(int roll, String name) {
		Connection connection = null;

		try {

			String sql = "UPDATE stude SET ROLLNO = " + roll + " WHERE NAME = '" + name + "'";

			connection = ConnectionFactory.geConnection();

			Statement statement = connection.createStatement();

			int result = statement.executeUpdate(sql);

			System.out.println(result + " record updated.");

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			ConnectionFactory.close(connection);
		}

	}

// public void Read(String name , int rollno) {
	public void Read() {
		Connection connection = null;

		try {
//		 String sql = "SELECT * FROM stude " + "WHERE NAME = '"+name+"' AND ROLLNO = '"+rollno+"'";
			String sql = "SELECT * FROM stude " + "WHERE NAME = 'ghanshyam' AND ROLLNO = '201'";
			connection = ConnectionFactory.geConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);

			if (resultSet.next()) {
				int id = resultSet.getInt("ID");
				String getName = resultSet.getString("NAME");
				String getdepartment = resultSet.getString("DEPARTMENT");
				int roll = resultSet.getInt("ROLLNO");
				String section = resultSet.getString("SECTION");

				System.out.println("ID:" + id);
				System.out.println("Name:" + getName);
				System.out.println("Department:" + getdepartment);
				System.out.println("Roll Number:" + roll);
				System.out.println("Section:" + section);

			} else
				System.out.println("DATA NOT FOUND:");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(connection);
		}

	}

	public void Delete(String name) {
		Connection connection = null;
		try {

			String sql = "DELETE FROM stude WHERE NAME = '"+name+"'";

			connection = ConnectionFactory.geConnection();
			Statement statement = connection.createStatement();
			int execut = statement.executeUpdate(sql);
            if(execut>0)
            	System.out.println("Data deleted");
            else {
				System.out.println("User not found:");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(connection);
		}
	
	}

}
