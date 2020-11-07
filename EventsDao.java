package dao;




import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Events;
//import entity.Tickets;

public class EventsDao {

	
	private Connection connection;
	private TicketsDao ticketsDao;
	private final String GET_EVENTS_BY_VENUE_QUERY = "SELECT * FROM events";
	
	public EventsDao() {
		connection = TicketAppDbConnect.getConnection();			//Events will use the DB connection
	}
		public List<Events> getEvents() throws SQLException {
			ResultSet rs = connection.prepareStatement(GET_EVENTS_BY_VENUE_QUERY).executeQuery();
			List<Events> events = new ArrayList<Events>();
			
			while (rs.next()) {
				events.add(populateEvents(rs.getString(1), rs.getString(2), rs.getString(3)));
			}
			
			return events;
		}
		private Events populateEvents(String date, String venue, String artistORteam) throws SQLException {
			
			return new Events(date, venue, artistORteam, ticketsDao.getTicketsByVenue(venue));
		}
		
		} 

	
	
	
	
	
	
	
	
	
	
	
	
	
	