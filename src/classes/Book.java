package classes;

//import the libraries

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Book extends userData{//create a class named Book that contains all book reservations info
	
	//create private data fields
	
	private ImageView image;//imageView for the poster of the movie
	private String ticket_movieName;//string for the name of the movie
	private String ticket_cinemaHall;//string for the cinema hall
	private String ticket_time;

	
	//constructor with all the data fields above as arguments
	public Book(String ticket_name, String ticket_username, String ticket_email, String ticket_phone,
			String ticket_date, int ticket_row, int ticket_column,ImageView image,String ticket_movieName,String ticket_cinemaHall,String ticket_time) {
		
		//referring to the current object of the constructor
		super(ticket_name,ticket_username,ticket_email,ticket_phone,ticket_date,ticket_row,ticket_column);
		this.image = image;
		this.ticket_movieName = ticket_movieName;
		this.ticket_cinemaHall = ticket_cinemaHall;
		this.ticket_time = ticket_time;
	}

	//void method to display the scene
	void display(Stage stage) throws FileNotFoundException {

		//create a gridPane and customize it
		GridPane gridpane = new GridPane();
		gridpane.setVgap(5);//set vertical gap 
		gridpane.setHgap(5);//set horizontal gap
		gridpane.setAlignment(Pos.CENTER);//position it in the center 
		
		//create the labels we need for all the informations required
		Label name = new Label("Name: " + super.getTicket_name());//name of the customer
		Label username = new Label("Username: " + super.getTicket_username());//username of the customer
		Label email = new Label("E-Mail: " + super.getTicket_email());//email of the customer
		Label phone = new Label("Phone: " + super.getTicket_phone());//phone of the customer
		Label date = new Label("Date: " + super.getTicket_date());//date of the movie
		Label movieName = new Label("Movie: " + ticket_movieName);//name of the event
		Label movieHall = new Label(ticket_cinemaHall);//cinema hall where the event will be displayed
		Label movieTime = new Label("Time: " + ticket_time);//the time of the event
		Label row_label = new Label("Row: " + super.getTicket_row());//the row of the seat where the customer will seat
		Label column_label = new Label("Seat: " + super.getTicket_column());//the seat
		
		//imageView to insert the QR code of the movie
		Image poster = new Image(new FileInputStream("C:\\Users\\user\\eclipse-workspace\\Ticket_Seller_Official\\src\\images\\qrcode.png"));
		ImageView code = new ImageView(poster);
		code.setFitHeight(124);//set the height of the poster
		code.setFitWidth(124);//set the width of the poster
		
		//create a vertical box to add some of the elements above 
		VBox details = new VBox();

		//add the name of the event, the hall , the time and the QR code in the vertical box
		details.getChildren().addAll(movieName, movieHall, movieTime,code);
		
		//add all elements above including the vertical box in the pane, according the coordinates
		gridpane.add(image, 0,0);
		gridpane.add(details, 1, 0);
		gridpane.add(name, 1,2);
		gridpane.add(username, 1,3);
		gridpane.add(email, 1,4);
		gridpane.add(phone, 1,5);
		gridpane.add(date, 1, 6);
		gridpane.add(row_label, 1, 7);
		gridpane.add(column_label, 1, 8);
		
		
		
		//create a new scene and put as an argument the pane and the size
		Scene scene = new Scene(gridpane,400,400);
		
		//set the stage properties
		stage.setTitle("Booked Ticket!");//name of the stage
        stage.getIcons().add(new Image("file:src/images/ticket_logo.jpg"));//icon of the stage
		stage.setScene(scene);//set the scene
		stage.show();//display
		
	}


}