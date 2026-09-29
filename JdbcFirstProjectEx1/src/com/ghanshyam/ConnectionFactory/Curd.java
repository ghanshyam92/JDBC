package com.ghanshyam.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ghanshyam.dto.DTO;

public class Curd {

	public Curd() {
		CreateTable();
	}

	public void CreateTable() {
		Connection connection = null;
		Statement statement = null;

		try {
			connection = ConnectionCurd.geConnection();
			String sql = "CREATE TABLE employee2 (" + "ID INT IDENTITY(1,1) PRIMARY KEY, "
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
			}
		}

	}

//	public void insert(DTO dt) {
//		Connection connection = null;
//		Statement statement = null;
//
//		try {
//			String sql = "INSERT INTO employee2" + "(USERNAME, PASSWORD, FULLNAME, ADDRESS, SALARY) " + "VALUES ('"
//					+ dt.getUser() + "', " + "'" + dt.getPassword() + "', " + "'" + dt.getFullname() + "', " + "'"
//					+ dt.getAddress() + "', " + dt.getSalary() + ")";
//			connection = ConnectionCurd.geConnection();
//			statement = connection.createStatement();
//			int execute = statement.executeUpdate(sql);
//			System.out.println("insert Data:");
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			ConnectionCurd.close(connection);
//		}
//	}

	// PreparedStatment
	public void insert(DTO dt) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {

			String sql = "INSERT INTO employee2" + "(USERNAME, PASSWORD, FULLNAME, ADDRESS, SALARY) "
					+ "VALUES (?,?,?,?,?)";
			connection = ConnectionCurd.geConnection();
			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, dt.getUser());
			preparedStatement.setString(2, dt.getPassword());
			preparedStatement.setString(3, dt.getFullname());
			preparedStatement.setString(4, dt.getAddress());
			preparedStatement.setInt(5, dt.getSalary());

			preparedStatement.executeUpdate();

			System.out.println("insert Data:");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionCurd.close(connection);
			ConnectionCurd.close(preparedStatement);
		}
	}

//	public void read() {
//		Connection connection = null;
//		try {
//
//			String sql = "SELECT * FROM employee2 " + "WHERE USERNAME = 'GHa' AND PASSWORD = 'ndn'";
//
//			connection = ConnectionCurd.geConnection();
//			Statement statement = connection.createStatement();
//			ResultSet resultSet = statement.executeQuery(sql);
//			if (resultSet.next()) {
//				int id = resultSet.getInt("ID");
//				String user = resultSet.getString("USERNAME");
//				String pass = resultSet.getString("PASSWORD");
//				String ful = resultSet.getString("FULLNAME");
//				String add = resultSet.getString("ADDRESS");
//				int salary = resultSet.getInt("SALARY");
//				System.out.println(user + "  " + pass);
//			} else {
//				System.out.println("User Not Found:");
//			}
	// Prepared Statement
	public void read(String user1, String pass1) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {

			String sql = "SELECT * FROM employee2 " + "WHERE USERNAME = ? AND PASSWORD =?";

			connection = ConnectionCurd.geConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user1);
			preparedStatement.setString(2, pass1);

			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				int id = resultSet.getInt("ID");
				String user = resultSet.getString("USERNAME");
				String pass = resultSet.getString("PASSWORD");
				String ful = resultSet.getString("FULLNAME");
				String add = resultSet.getString("ADDRESS");
				int salary = resultSet.getInt("SALARY");
				System.out.println(user + "  " + pass);
			} else {
				System.out.println("User Not Found:");
			}

			// boolean next =
//                
//                String user = resultSet.getString("USERNAME");
//                String pass = resultSet.getString("PASSWORD");
//                String ful = resultSet.getString("FULLNAME");
//                String add = resultSet.getString("ADDRESS");
//                int salary = resultSet.getInt("SALARY");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionCurd.close(connection);
		}
	}

//	public void update(String user, int salary) {
//		Connection connection = null;
//		try {
//
//			String sql = "UPDATE employee2 SET SALARY = '" + salary + "' WHERE USERNAME ='" + user +"'";
//
//			connection = ConnectionCurd.geConnection();
//			Statement statement = connection.createStatement();
//			statement.executeUpdate(sql);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			ConnectionCurd.close(connection);
//		}
//
//	}

	public void update(String user, int salary) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {

			String sql = "UPDATE employee2 SET SALARY = ? WHERE USERNAME =?";

			connection = ConnectionCurd.geConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, salary);
			preparedStatement.setString(2, user);

			int execut = preparedStatement.executeUpdate();
			if (execut > 0) {
				System.out.println("Data Update");
			} else {
				System.out.println("Not found:");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionCurd.close(connection);
			ConnectionCurd.close(preparedStatement);
		}

	}

//	public void delete(String user) {
//		Connection connection = null;
//		try {
//
//			String sql = "DELETE FROM employee2 WHERE USERNAME = '"+user+"'";
//
//			connection = ConnectionCurd.geConnection();
//			Statement statement = connection.createStatement();
//			int execut = statement.executeUpdate(sql);
//            if(execut>0)
//            	System.out.println("Data deleted");
//            else {
//				System.out.println("User not found:");
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			ConnectionCurd.close(connection);
//		}
//	}
	public void delete(String user) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {

			String sql = "DELETE FROM employee2 WHERE USERNAME = ?";

			connection = ConnectionCurd.geConnection();
			preparedStatement = connection.prepareStatement(sql);
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
			ConnectionCurd.close(connection);
			ConnectionCurd.close(preparedStatement);
		}
	}

	public void test(String sql) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = ConnectionCurd.geConnection();
			preparedStatement = connection.prepareStatement(sql);

			boolean exwcut = preparedStatement.execute();

			if (exwcut) {
				ResultSet resultSet = preparedStatement.getResultSet();
				if (resultSet.next()) {
					int id = resultSet.getInt("ID");
					String user = resultSet.getString("USERNAME");
					String pass = resultSet.getString("PASSWORD");
					String ful = resultSet.getString("FULLNAME");
					String add = resultSet.getString("ADDRESS");
					int salary = resultSet.getInt("SALARY");
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
			ConnectionCurd.close(connection);
			ConnectionCurd.close(preparedStatement);
		}
	}

}
