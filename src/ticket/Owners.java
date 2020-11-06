package ticket;


	public class Owners {

			private String first_name;
			private String last_name;
			private int barcode;
			
			public Owners(String first_name, String last_name, int barcode) {		//5
				this.first_name = first_name;
				this.last_name = last_name;
				this.barcode = barcode;
			}

			public int getBarcode() {
				return barcode;
			}

			public void setBarcode(int barcode) {
				this.barcode = barcode;
			}

			public String getLast_name() {
				return last_name;
			}

			public void setLast_name(String last_name) {
				this.last_name = last_name;
			}

			public String getFirst_name() {
				return first_name;
			}

			public void setFirst_name(String first_name) {
				this.first_name = first_name;
			}
	}


