package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Tickets;

public class TicketsDao {

		
	private Connection connection;
	private final String GET_TICKETS_BY_VENUE_QUERY = "SELECT * FROM tickets WHERE venue = ?";
	
	private TicketsDao() {
		connection = TicketAppDbConnect.getConnection();
	}

	public List<Tickets> getTicketsByVenue(String venue) throws SQLException {
	PreparedStatement ps = connection.prepareStatement(GET_TICKETS_BY_VENUE_QUERY);
	ps.setString(1,  venue);
	ResultSet rs = ps.executeQuery();
	List<Tickets> tickets = new ArrayList<Tickets>();
	
	while (rs.next()) {
		tickets.add(new Tickets(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
	}
	
	return tickets;
}

		

	} 
