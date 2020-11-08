/*package application;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import dao.FoodDao;
import entity.Food;

@SuppressWarnings("unused")
public class Menu {

	private FoodDao foodDao = new FoodDao();
	private Scanner scanner = new Scanner(System.in);
	private List<String> options = Arrays.asList(
			"Display Foods",
			"Display a Food",
			"Enter a Food",
			"Delete a Food");
	
	public void start() throws SQLException {
		String selection = "";
		
		do {
			printMenu();
			selection = scanner.nextLine();
			
			if (selection.equals("1")) {
				displayFoods();
			} else if (selection.equals("2")) {
				displayFood();
			} else if (selection.equals("3")) {
				enterFood();
			} else if (selection.equals("4")) {
				deleteFood();
			}
			
			System.out.println("Press enter to continue..");
			scanner.nextLine();
		} while (!selection.equals("-1"));
	}
	private void printMenu() {
		System.out.println("Select an Option:\n ---------------");
		for (int i = 0; i < options.size(); i++) {
			System.out.println(i + 1 + ") " + options.get(i));
		}
	}
	private void displayFoods() throws SQLException {
		List<Food> foods = foodDao.getFoods();
		for (Food food : foods) {
			System.out.println(food.getFoodId() + ": " + food.getFoodName());
		}
	}
	private void displayFood() throws SQLException {
		System.out.print("Enter food id: ");
		int id = Integer.parseInt(scanner.nextLine());
		Food food = foodDao.getFoodById(id);
		System.out.println(food.getFoodId() + ": " + food.getFoodName());
	}	
	private void enterFood() throws SQLException {
		System.out.print("Enter new food item:");
		String foodName = scanner.nextLine();
		foodDao.createNewFood(foodName);
	}	
	private void deleteFood() throws SQLException {
		System.out.print("Enter food id to delete:");
		int id = Integer.parseInt(scanner.nextLine());
		foodDao.deleteFoodByID(id);
		
	}
}
*/


//*****************************
//*****************************
//*****************************
//*****************************
//*****************************


/*
 * package ticket;


import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;



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
			
			if (choice.isBlank()) {
				break;
			}
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
				case"5":
					listEventInfo();
					
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
		ticketDao.deleteTicket(code);
	}
	
	//This Updates ticket info
	private void updateTicketInfo() throws SQLException {
		listTicketInfo();
		
		System.out.println("Enter Date Of The Event: ");
		Date date=formatter1.parse(scanner.nextLine());
		
		System.out.println("Enter Venue Name: ");
		String venue = scanner.nextLine();
		
		System.out.println("Enter Seat Location: ");
		String seat = scanner.nextLine();
		
		System.out.println("Enter Bar Code: ");
		int code =Integer.parseInt(scanner.nextLine());
		ticketDao.updateTicketInfo(date, venue,seat,code);
		listTicketInfo();
	}
	
	//This Displays all info about a ticket
	private void listTicketInfo() throws SQLException {
		
		List<Ticket>tickets = ticketDao.fetchTicket();
		tickets.stream().forEach(System.out::println);
	}
	
	//This Displays all Events and it's  info
private void listEventInfo() throws SQLException {
		
		List<Event>events = EventDao.fetchTicket();
		events.stream().forEach(System.out::println);
	}

	

	private void createTicket() throws SQLException {
		System.out.println("Enter The Date Of Event: ");
		String date = scanner.nextLine();
		System.out.println("Enter The Venue: ");
		String venue = scanner.nextLine();
		System.out.println("Enter The Seat: ");
		String seat = scanner.nextLine();
		System.out.println(" Enter The Bar Code: ");
		String code = scanner.nextLine();
		ticketDao.createTicket(date,venue,seat,code);
	}

	private void printInstructions() {
		System.out.println("1)Obtain A Ticket: ");
		
		//private final String CREATE_NEW_TICKET_QUERY = "INSERT INTO ticket(name) VALUES(?)"
		//adjust for fields
		
		System.out.println("2)Get Ticket Information: ");
		
		//private final String GET_TICKETS_INFO_QUERY = "SELECT * FROM tickets";
		
		System.out.println("3)Update Ticket Info: ");
		
		//private final String GET_TICKET_BY_BARCODE_QUERY = "SELECT * FROM tickets WHERE id = ?";
		
		System.out.println("4)Revoke Ticket: ");
		
		//private final String DELETE_TICKET_BY_BARCODE_QUERY = "DELETE FROM tickets WHERE id = ?";
		
		System.out.println("5)List Of Events And Dates: ");
		
		//private final String GET_FOOD_QUERY = "SELECT * FROM events";


	}


}
 */




package application;

public class Menu {

}
