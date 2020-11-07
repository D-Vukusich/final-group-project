package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Ticket;

//This Displays all info about a ticket
//join tables for ticket info, event, and owner

public class OwnersDao {
	
	private final String GET_ALL_TICKET_QUERY = 
			"SELECT tickets.*, owners.* from tickets INNER JOIN "
			+ "owners ON tickets.barcode = owners.barcode;";
	
	private final String GET_OWNERS_INFO_QUERY = "SELECT * FROM owners WHERE barcode = ?";
	
	private Connection connection;
	
	public OwnersDao() {
		connection = DBConnection.getConnection();
	}
	
	public List<Ticket> getTickets() throws SQLException{
		ResultSet rs = connection.prepareStatement(GET_OWNERS_INFO_QUERY).executeQuery();
		List<Ticket> tickets = new ArrayList<Ticket>();
		while (rs.next()) {
			
			//references the data types in the SQL Ticket table
			tickets.add(findOwner(
					rs.getInt(1), 
					rs.getString(2), 
					rs.getString(3), 
					rs.getInt(4)));
		}
		return tickets;
	}
	
	private Ticket findOwner(String date, String venue, String seat, int code) throws SQLException {
		return new Ticket (date, venue, seat, code);
}
