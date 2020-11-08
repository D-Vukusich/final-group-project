package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	private final static String URL = "jdbc:mysql://localhost:3306/ticketapp_db";
	private final static String USERNAME = "root";
	private final static String PASSWORD = "password";
	private static Connection connection;
	private static DBConnection instance;
	
	//private DBConnection(Connection connection) {
		//DBConnection.connection = connection;
		
	//}
	
	/*private DBConnection() {
		
	}
	public Connection getConnection() throws SQLException{
		instance.connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
		System.out.println("Connection Successful");
		
		return connection;
	}


	*/
	public static Connection getConnection() {
		if (instance == null) {
			try {
				connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				instance = new DBConnection();
				System.out.println("Connection successful.");
			} catch (SQLException e) {
				System.out.println("Unable to connect to database.");
				e.printStackTrace();
			}
		}
		return DBConnection.connection;
	}
	
	public static DBConnection getInstance() {
		return instance;
	}


}
