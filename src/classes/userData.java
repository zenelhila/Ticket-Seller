package classes;
//superclass that contains all the user data
public abstract class userData {
	private String ticket_name;//string for the name of the customer
	private String ticket_username;//string for the userName of the customer
	private String ticket_email;//string for the email of the customer
	private String ticket_phone;//string for the phone of the customer
	private String ticket_date;//string for the date of the event
	private int ticket_row;//integer for the row of the seat
	private int ticket_column;//integer for the seat

	//generate getters and setters
	public String getTicket_name() {
		return ticket_name;
	}


	public void setTicket_name(String ticket_name) {
		this.ticket_name = ticket_name;
	}


	public String getTicket_username() {
		return ticket_username;
	}


	public void setTicket_username(String ticket_username) {
		this.ticket_username = ticket_username;
	}


	public String getTicket_email() {
		return ticket_email;
	}


	public void setTicket_email(String ticket_email) {
		this.ticket_email = ticket_email;
	}


	public String getTicket_phone() {
		return ticket_phone;
	}


	public void setTicket_phone(String ticket_phone) {
		this.ticket_phone = ticket_phone;
	}


	public String getTicket_date() {
		return ticket_date;
	}


	public void setTicket_date(String ticket_date) {
		this.ticket_date = ticket_date;
	}


	public int getTicket_row() {
		return ticket_row;
	}


	public void setTicket_row(int ticket_row) {
		this.ticket_row = ticket_row;
	}


	public int getTicket_column() {
		return ticket_column;
	}


	public void setTicket_column(int ticket_column) {
		this.ticket_column = ticket_column;
	}
	

	//constructor with arguments
	public userData(String ticket_name, String ticket_username, String ticket_email, String ticket_phone,
			String ticket_date, int ticket_row, int ticket_column) {
		this.ticket_name = ticket_name;
		this.ticket_username = ticket_username;
		this.ticket_email = ticket_email;
		this.ticket_phone = ticket_phone;
		this.ticket_date = ticket_date;
		this.ticket_row = ticket_row;
		this.ticket_column = ticket_column;
	}

	
}
