package ticket;

import java.text.SimpleDateFormat;

public class Events {

		private String date;
		private String venue;
		private String artistORteam;
		
		SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
		
		
		
		public Events(String date, String venue, String artistORteam) {		//5
			this.date = formatter1.format(date);
			this.venue = venue;
			this.artistORteam = artistORteam;
		}
			
				
		public String getDate() {
			return date;
		}

		public void setDate(String date) {
			this.date = date;
		}

		public String getArtistORteam() {
			return artistORteam;
		}

		public void setArtistORteam(String artistORteam) {
			this.artistORteam = artistORteam;
		}

		public String getVenue() {
			return venue;
		}

		public void setVenue(String venue) {
			this.venue = venue;
		}
		}
