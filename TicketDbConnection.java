package ticket;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TicketDbConnection {
	private final static String URL = "jdbc:mysql://localhost:3306/ticketapp_db";
	private final static String USERNAME = "root";
	private final static String PASSWORD = "root01";
	private static Connection connection;
	private static TicketDbConnection instance;
	
	
	private TicketDbConnection(Connection connection) { 
	this.connection = connection;
	
	}
	
	public static Connection getConnection() {
		if (instance == null) {
			try {
				connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				instance = new TicketDbConnection(connection);
				System.out.println("Connection successful");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return TicketDbConnection.getConnection();
	}
		
}
