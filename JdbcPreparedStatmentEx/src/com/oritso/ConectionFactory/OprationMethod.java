package com.oritso.ConectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
		PreparedStatement preparedStatement = null;
		try {
			String sql = "INSERT INTO stude " + "(DEPARTMENT, NAME, ROLLNO, SECTION) " + "VALUES (?,?,?,?)";
			connection = ConnectionFactory.geConnection();
			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, dt.getDepartment());
			preparedStatement.setString(2, dt.getName());
			preparedStatement.setInt(3, dt.getRollno());
			preparedStatement.setString(4, dt.getSection());

			preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(connection);
			ConnectionFactory.close(preparedStatement);
		}

	}

	public void update(int roll, String name) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {

			String sql = "UPDATE stude SET ROLLNO = ? WHERE NAME =?";

			connection = ConnectionFactory.geConnection();
		 preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, roll);
			preparedStatement.setString(2, name);

			int result = preparedStatement.executeUpdate();
			if (result > 0) {
				System.out.println("Data Update");
			} else {
				System.out.println("Not found:");
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			ConnectionFactory.close(connection);
			ConnectionFactory.close(preparedStatement);
		}

	}

 public void Read(String name , int rollno) {
	 PreparedStatement preparedStatement = null;
		Connection connection = null;

		try {
			String sql = "SELECT * FROM stude " + "WHERE NAME = ? AND ROLLNO = ?";
			connection = ConnectionFactory.geConnection();
			 preparedStatement = connection.prepareStatement(sql);
			   preparedStatement.setString(1, name);
			   preparedStatement.setInt(2, rollno);
			
			ResultSet resultSet = preparedStatement.executeQuery();

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
			ConnectionFactory.close(preparedStatement);
		}

	}

	public void Delete(String name) {
		Connection connection = null;
		try {

			String sql = "DELETE FROM stude WHERE NAME = ?";

			connection = ConnectionFactory.geConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1 , name);
			
			int execut = preparedStatement.executeUpdate();
			if (execut > 0)
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
	public void test(String sql) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = ConnectionFactory.geConnection();
			 preparedStatement = connection.prepareStatement(sql);

			boolean exwcut = preparedStatement.execute();

			if (exwcut) {
				ResultSet resultSet = preparedStatement.getResultSet();
				if (resultSet.next()) {
					int id = resultSet.getInt("ID");
					String user = resultSet.getString("DEPARTMENT");
					String pass = resultSet.getString("NAME");
					String ful = resultSet.getString("ROLLNO");
					String add = resultSet.getString("SECTION");
					System.out.println(user + "  " + pass);
				}else {
					System.out.println("Data Not Found:");
				}
			} else {
                 int count = preparedStatement.getUpdateCount();
                 System.out.println(count);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(connection);
			ConnectionFactory.close(preparedStatement);
		}
	}
	

}
