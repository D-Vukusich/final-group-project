package entity;

import java.text.SimpleDateFormat;

public class Ticket {
	
	private int barcode;
	private String venue;
	private String date;
	private String seat;
	
	public Ticket(String date, String venue, String seat, int barcode) {		
		this.date = date;
		this.venue = venue;
		this.seat = seat;
		this.barcode = barcode;
		
	}
	@Override
	public String toString() {
		return "Ticket =[date "+date+" venue= " + venue + " seat= " + seat + " barcode = "+barcode+"]";
	}


	public Ticket(int code, String venue2, String seat2) {
		// TODO Auto-generated constructor stub
	}

	public int getBarcode() {
		return barcode;
	}
	public void setBarcode(int barcode) {
		this.barcode = barcode;
	}
	
	public String getVenue() {
		return venue;
	}
	public void setVenue(String venue) {
		this.venue = venue;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getSeat() {
		return seat;
	}
	public void setSeat(String seat) {
		this.seat = seat;
	}
//new
	public static void add(Object ticket) {
		// TODO Auto-generated method stub
		
	}
	
}
