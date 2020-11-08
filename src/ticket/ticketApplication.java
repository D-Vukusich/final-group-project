package ticket;


import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import dao.EventsDao;
import dao.TicketDao;
import entity.Ticket;



public class ticketApplication {
	private Scanner scanner = new Scanner(System.in);


	public static void main(String[] args) {
		new ticketApplication().run();
	}
	private void run() {		
		while (true){			
			printInstructions();
			System.out.print("Enter a Selection: ");
			String choice = scanner.nextLine();
			
			/*if (choice.isBlank()) {
				break;
			}
			*/
			try {
				switch(choice) {
				case "1":
					createTicket();
					break;
					
				case "2":
					listTicketInfo();
					break;
					
				case "3":
					updateTicketInfo();
					break;
					
				case "4":
					deleteTicket();
					
					break;
				/*case"5":
					listEventInfo();
				*/	
					default:
						System.out.println("Invalid Option, Try Again");
				}
			}
				catch(SQLException e) {
					System.out.println("You got an error "+ e.getMessage());
				}
		}
		
			

	}
	//This Deletes a ticket
	
	private void deleteTicket() throws SQLException {
		listTicketInfo();
		System.out.println("Enter Bar Code Number");
		int code =Integer.parseInt(scanner.nextLine());	
		TicketDao.deleteTicketByBarcode(code);
	}
	
	//This Updates ticket info
	private void updateTicketInfo() throws SQLException {
		listTicketInfo();
		System.out.println("Barcode: ");
		int code =Integer.parseInt(scanner.nextLine());
		System.out.println("Please enter new venue name: ");
		String venue = scanner.nextLine();
		TicketDao.updateTicketInfo(code, venue);
		listTicketInfo();
	}
	
	//This Displays all info about a ticket
	private void listTicketInfo() throws SQLException {
		List<Ticket>tickets = TicketDao.getTickets();
		tickets.stream().forEach(System.out::println);
	}
	
	//This Displays all Events and it's  info
/*private void listEventInfo() throws SQLException {
		
		List<Event>events = EventsDao.getEvents();
		events.stream().forEach(System.out::println);
	}
*/
	

	private void createTicket() throws SQLException {
		System.out.println("Enter The Date Of Event: ");
		String date = scanner.nextLine();
		System.out.println("Enter The Venue: ");
		String venue = scanner.nextLine();
		System.out.println("Enter The Seat: ");
		String seat = scanner.nextLine();
		System.out.println(" Enter The Bar Code: ");
		int code =Integer.parseInt(scanner.nextLine());
		TicketDao.createNewTicket(date,venue,seat,code);
	}

	private void printInstructions() {
		System.out.println("1)Obtain A Ticket: ");
		System.out.println("2)Get Ticket Information: ");
		System.out.println("3)Update Ticket Info: ");
		System.out.println("4)Revoke Ticket: ");
		System.out.println("5)List Of Events And Dates: ");



	}


}