package com.lunch;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class Lunch {
	public static void main(String[] args) {
  HikariDataSource hikariDataSource = null;
  
  
		try {

			
				FileInputStream fl = new FileInputStream("configuration.properties");
				Properties pr = new Properties();// Key value Load
				pr.load(fl);
			   
				HikariConfig hikariConfig = new HikariConfig();
				  hikariConfig .setJdbcUrl((String) pr.get("DB_URL"));
				  hikariConfig.setUsername((String) pr.get("DB_USER"));
				  hikariConfig.setPassword((String) pr.get("DB_PASS"));
				  hikariConfig.setMinimumIdle(20);
				 hikariConfig.setMaximumPoolSize(100);

               hikariDataSource =  new HikariDataSource(hikariConfig);//POOL ready
               Connection connection  = hikariDataSource.getConnection();//get connection from pool
               System.out.println(connection);
               connection.close();//back to poll
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			hikariDataSource.close();//close from pool
		}
	}
}
