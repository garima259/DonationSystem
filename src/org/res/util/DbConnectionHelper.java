package org.res.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DbConnectionHelper {

	public static Connection getConnection(){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Scanner sc = new Scanner(System.in);
		//List<Employee> empList=null;
		try {
			// 1.Connect
			// 1.1 Register Driver
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			// 1.2 Connect to Database
			connection = DriverManager.getConnection(
					"jdbc:sqlserver://localhost:1433;databaseName=DonationSystem;username=sa;password=sunlife_1234");
		}
		catch(ClassNotFoundException|SQLException exception){
			exception.printStackTrace();
		}
		return connection;
	}
}
