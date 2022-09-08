package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase {
	
	public void dbconnect() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:sql3.freesqldatabase.com/" + "sql3516163", "sql3516163",
				"hPnN62TNjz");
		Statement createStatement = connection.createStatement();
		ResultSet executeQuery = createStatement.executeQuery("Select * from sql3516163.employees;");
		while (executeQuery.next()) {
			String firstName = executeQuery.getString("first_name");
			String emailId = executeQuery.getString("email");
			int jobId = executeQuery.getInt("job_id");
			
			System.out.println(firstName + " "+ emailId + " "+ jobId);
		}
		connection.close();
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		DataBase test = new DataBase();
		test.dbconnect();
	}

}
