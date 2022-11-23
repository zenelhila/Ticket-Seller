package classes;
//create a new class for the event
public class event {
	//private data fields
	private String cinema_hall;//string for the cinema hall
	private String movie;//string for the event name
	private String time;//string for the event time
	private String path;//string for the path of the poster
	
	
	//create a constructor with all the elements above as a arguments
	public event(String cinema_hall, String movie,  String time, String path) {
		//referring to the current object of the constructor

		this.cinema_hall = cinema_hall;
		this.movie = movie;
		this.time = time;
		this.path = path;
	}
	//generate getters and setter for all the data fields above
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getCinema_hall() {
		return cinema_hall;
	}

	public void setCinema_hall(String cinema_hall) {
		this.cinema_hall = cinema_hall;
	}

	public String getMovie() {
		return movie;
	}

	public void setMovie(String movie) {
		this.movie = movie;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	

	public String toString() {
		return this.cinema_hall + "\n" + this.movie + "\n" + this.time + "\n "  + this.path;
	}
}
