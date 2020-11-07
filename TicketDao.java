package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Ticket;
import entity.ticketapp_db;

public class TicketDao {
		
		private Connection connection;
		private final String GET_TICKET_INFO_QUERY = "SELECT * FROM tickets WHERE barcode = ?";
		private final String CREATE_NEW_TICKET_QUERY = "INSERT INTO tickets (date, venue, seat, barcode) VALUES(?)";
		private final String DELETE_TICKET_BY_BARCODE_QUERY = "DELETE FROM tickets WHERE barcode = ?";
		
		public TicketDao() {
			connection = DBConnection.getConnection();
		}
		
		public List<Ticket> getTickets() throws SQLException{
			ResultSet rs = connection.prepareStatement(GET_TICKET_INFO_QUERY).executeQuery();
			List<Ticket> tickets = new ArrayList<Ticket>();
			while (rs.next()) {
				
				tickets.add(createNewTicket(
						rs.getString(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getInt(4)));
			}
			return tickets;
		}
		
		public Ticket getTicketByBarcode(int code) throws SQLException {
			PreparedStatement ps = connection.prepareCall(GET_TICKET_INFO_QUERY);
			ps.setInt(1, code);
			ResultSet rs = ps.executeQuery();
			rs.next();
			//**************************
			return createTicket(rs.getInt(1), rs.getString(2));
		}
		
		private Ticket createTicket(int int1, String string) {
			// TODO Auto-generated method stub
			return null;
		}

		//ticketDao.createTicket(date,venue,seat,code);
		public void createNewTicket(String date, String venue, String seat, int code) throws SQLException {
			PreparedStatement ps = connection.prepareStatement(CREATE_NEW_TICKET_QUERY);
			String createTicket = null;
			ps.setString(1,  createTicket);
			ps.executeUpdate();
		}
		
		public void deleteTicketByBarcode (int code) throws SQLException {
			PreparedStatement ps = connection.prepareStatement(DELETE_TICKET_BY_BARCODE_QUERY);
			ps.setInt(4, code);
			ps.executeUpdate();
		}
		
		private Ticket populateTicket(String date, String venue, String seat, int code) throws SQLException {
			return new Ticket (date, venue, seat, code);
		}

		public static List<ticket.Ticket> fetchTicket() {
			// TODO Auto-generated method stub
			return null;
		}

	}

