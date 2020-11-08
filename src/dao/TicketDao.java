package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sound.sampled.DataLine.Info;

import entity.Ticket;
import entity.ticketapp_db;

@SuppressWarnings("unused")
public class TicketDao {
		
	public static List<Ticket> getTickets() throws SQLException{
		String sql = " SELECT* FROM tickets";
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs= null;
		List<Ticket> tickets = new ArrayList<>();
		
		try {
			connection = DBConnection.getConnection();
			statement = connection.prepareStatement(sql);
			rs = statement.executeQuery();
			
			while(rs.next()) {
				String date = rs.getString("date");
				String venue = rs.getString("venue");
				String seat = rs.getString("seat");
				int barcode =rs.getInt("barcode");
				Ticket ticket = new Ticket(date, venue, seat, barcode);
				tickets.add(ticket)
;				
			}
			return tickets;
		}
		//
		finally {
			if(rs!=null) {
				rs.close();
			}
			if(statement!=null) {
				statement.close();

			}
			if(connection!=null) {
				connection.close();

			}
			
		}
	}
	
		@SuppressWarnings("unused")
		private final String GET_ALL_TICKET_QUERY = 
				"SELECT tickets.*, owners.* from tickets INNER JOIN "
				+ "owners ON tickets.barcode = owners.barcode;";
		private final String GET_TICKET_INFO_QUERY = "SELECT * FROM tickets WHERE barcode = ?";
		private final static String CREATE_NEW_TICKET_QUERY = "INSERT INTO tickets (date, venue, seat, barcode) VALUES(?)";
		private final static String DELETE_TICKET_BY_BARCODE_QUERY = "DELETE FROM tickets WHERE barcode = ?";
		private final static String UPDATE_TICKET_INFO = "UPDATE tickets SET venue = ? WHERE barcode = ?";
		

		
		/*public List<Ticket> getTickets() throws SQLException{
			ResultSet rs = connection.prepareStatement(GET_TICKET_INFO_QUERY).executeQuery();
			List<Ticket> tickets = new ArrayList<Ticket>();
			while (rs.next()) {
				
				tickets.add(getTickets(
						rs.getString(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getInt(4)));
			}
			return tickets;
		}
		*/
		private Ticket getTickets(String string, String string2, String string3, int int1) {
			return null;
		}

		/*public Ticket getTicketByBarcode(int code) throws SQLException {
			PreparedStatement ps = connection.prepareCall(GET_TICKET_INFO_QUERY);
			ps.setInt(1, code);
			ResultSet rs = ps.executeQuery();
			rs.next();
			return createNewTicket(rs.getInt(1), rs.getString(2));
		}*/
		

		//ticketDao.createTicket(date,venue,seat,code);
		
		public static Ticket createNewTicket(String date, String venue, String seat, int barcode) throws SQLException {
			String sql = CREATE_NEW_TICKET_QUERY;
			Connection connection = null;
			PreparedStatement statement = null;
			ResultSet rs = null;
			
			try {
				connection = DBConnection.getConnection();
				statement = connection.prepareStatement(sql);
				
				statement.setString(1, date);
				statement.setString(2, venue);
				statement.setString(3, seat);
				statement.setInt(4, barcode);
				
				statement.executeUpdate();
				return new Ticket(date, venue, seat, barcode);
			}	
			finally {
				if(rs!=null) {
					rs.close();
				}
				if(statement!=null) {
					statement.close();

				}
				if(connection!=null) {
					connection.close();

				}
			}
			
		}
		
		public static void deleteTicketByBarcode (int barcode) throws SQLException {
			//PreparedStatement ps = connection.prepareStatement(DELETE_TICKET_BY_BARCODE_QUERY);
			//ps.setInt(4, barcode);
			//ps.executeUpdate();
		}

		public static void createTicket(String date, String venue, String seat, int code) {
			
		}
		
		/*public List<Ticket> listTicketInfo(int code) throws SQLException{
			PreparedStatement ps = connection.prepareStatement (GET_ALL_TICKET_QUERY);
			ps.setInt(4, code);
			ResultSet rs = connection.prepareStatement(GET_ALL_TICKET_QUERY).executeQuery();
			List<Ticket> ticket = new ArrayList<Ticket>();
			while (rs.next()) {
				Ticket.add(getTicket(rs.getString(1), rs.getString(2), rs.getString(3), 
						rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getString(7)));
		}
			return ticket;
		}
*/
		public static void updateTicketInfo(int barcode,String venue)throws SQLException{
			String sql ="UPDATE tickets SET venue = ? WHERE barcode = ?";
			Connection connection = null;
			PreparedStatement statement = null;
			
			try {
				DBConnection.getInstance();
				connection = DBConnection.getConnection();
				statement = connection.prepareStatement(sql);
				statement.setString(2, venue);
				statement.setInt(4, barcode);
				
				statement.executeUpdate();
			}
			finally {
				statement.close();
				connection.close();
			}
		}	

		private Object getTicket(String string, String string2, String string3, int int1, int int2, String string4,
				String string5) {
			// TODO Auto-generated method stub
			return null;
		}

}


