package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import entity.Events;

public class EventsDao {

	
	private Connection connection;
	@SuppressWarnings("unused")
	private TicketDao TicketsDao;
	
	
	public EventsDao() {
		connection = DBConnection.getConnection();			
	}
	private final String GET_EVENTS_BY_VENUE_QUERY = "SELECT * FROM events";
	
	public List<Events> getEvents() throws SQLException {
			ResultSet rs = connection.prepareStatement(GET_EVENTS_BY_VENUE_QUERY).executeQuery();
			List<Events> events = new ArrayList<Events>();
			
			while (rs.next()) {
				events.add(getTicketsByVenue(rs.getString(1), rs.getString(2), rs.getString(3)));
			}
			
			return events;
		}
		private Events getTicketsByVenue(String date, String venue, String artistORteam) throws SQLException {
			
			return new Events(date, venue, artistORteam);
		}
		
}

	
	