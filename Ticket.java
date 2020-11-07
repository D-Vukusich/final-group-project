package ticket;

import java.text.SimpleDateFormat;

public class Ticket {
	
	private int barcode;
	private String venue;
	private String date;
	private String seat;
	
	SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
	
	
	
	public Ticket(int barcode, String venue, String date, String seat) {		
		this.barcode = barcode;
		this.venue = venue;
		this.date = formatter1.format(date);
		this.seat = seat;
		
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
	
}
