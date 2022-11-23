package classes;
//import the libraries
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

//create a new ticket class 
public class Ticket extends userData{
	
	public Ticket(String ticket_name, String ticket_username, String ticket_email, String ticket_phone,
			String ticket_date,  int ticket_row, int ticket_column) {
		super(ticket_name, ticket_username, ticket_email, ticket_phone, ticket_date, ticket_row, ticket_column);
		
	}


	private String ticket_movieName;//string for the name of the event
	private String ticket_cinemaHall;//string for the name of the cinema hall
	private String ticket_time;//string for the time of the event

    String dateToString = "";

    //create a method to display the scene
	void display(Stage stage, event movie) throws FileNotFoundException {

		//creating comboBox with string parameters for the row and the seat of the ticket
		ComboBox<String> row = new ComboBox<String>();
		ComboBox<String> column = new ComboBox<String>();
		//set the comboBoxes editable
		row.setEditable(true);
		column.setEditable(true);
		//add the items in the comboBoxes
		row.getItems().add("1");
		row.getItems().add("2");
		row.getItems().add("3");
		
		column.getItems().add("1");
		column.getItems().add("2");
		column.getItems().add("3");
		//initialize the values of the comboBox
		column.setValue("1");
		row.setValue("1");
		//create an ImageView image to get the poster of the event
		Image poster = new Image(new FileInputStream(movie.getPath()));
		ImageView image = new ImageView(poster);
		//create a new gridPane and set its properties
		GridPane gridpane = new GridPane();
		gridpane.setVgap(5);//set the vertical gap
		gridpane.setHgap(5);//set the horizontal gap
		gridpane.setAlignment(Pos.CENTER); //position it to the center
		
		//add some textFields for the information that we will get from the customer
		TextField name_textfield = new TextField();//textField for the name of the customer
		TextField username_textfield = new TextField();//textField for the username of the customer
		TextField email_textfield = new TextField();//textField for the email
		TextField phone_textfield = new TextField();//textField for the phone
		
		//create a new vertical Box
		VBox details = new VBox();
		//create labels with the information needed
		Label name = new Label("Name:");//name of the customer
		Label username = new Label("Username:");//username of the customer
		Label email = new Label("E-Mail:");//email of the customer
		Label phone = new Label("Phone: ");//phone of the customer
		Label date = new Label("Date:");//date of the customer
		Label seat = new Label("Set your seat:");
		Label movieName = new Label(movie.getMovie());//name of the event
		Label cinemaHall = new Label(movie.getCinema_hall());//cinema of the event
		Label movieTime = new Label(movie.getTime());//time of the event
		Label row_label = new Label("Row: ");
		Label column_label = new Label("Seat: ");
		
		//set the name of the event, which we get them from the event class
		movieName.setText(movie.getMovie());
		cinemaHall.setText(movie.getCinema_hall());
		movieTime.setText(movie.getTime());
		
		//set a datePicker for date
	    DatePicker d = new DatePicker(); 
	    d.setOnAction(e->{
		    LocalDate format = d.getValue();
		    dateToString = format.toString();
	    });

	    //set two buttons
	    Button book = new Button("Book seat!");//book the seat
	    Button checkSeat = new Button("See your seat:");//see where your seat belongs
	    
	    //add the elements in the vertical box
		details.getChildren().addAll( movieName, cinemaHall, movieTime);
		
		//add the elements in the pane and their coordinates
		gridpane.add(image, 0,0);
		gridpane.add(details, 1, 0);
		gridpane.add(name, 1, 1);
		gridpane.add(name_textfield, 1,2);
		gridpane.add(username, 1,3);
		gridpane.add(username_textfield, 1,4);
		gridpane.add(email, 1,5);
		gridpane.add(email_textfield, 1,6);
		gridpane.add(phone, 1,7);
		gridpane.add(phone_textfield, 1,8);
		gridpane.add(date, 1, 9);
		gridpane.add(d, 1, 10);
		gridpane.add(seat, 1, 11);
		gridpane.add(row_label, 1, 12);
		gridpane.add(column_label, 1, 13);
		gridpane.add(row, 2, 12);
		gridpane.add(column, 2, 13);
		gridpane.add(checkSeat,2,14);
		gridpane.add(book, 3, 14);
		
		
		
		//set the action for the checkSeat button
		checkSeat.setOnAction(e->{
			//get the values of the chosen elements from the comboBox
			String row_value = row.getValue().toString();//row
			String column_value = column.getValue().toString();//seat
			
			seeYourSeat(row_value,column_value);//invoke see your seat method with two arguments
			
		});
		
		//set the scene with the grid and the size as parameters
		Scene scene = new Scene(gridpane,600,600);
		//set the stage properties
		stage.setTitle("Book the event!");//set title
        stage.getIcons().add(new Image("file:src/images/ticket_logo.jpg"));//set icon
		stage.setScene(scene);//set scene
		stage.show();//show scene
		
		
		//set action for the booking button
		book.setOnAction(e->{
			//initialize all the dataField with the information that we got
			
			setTicket_name(name_textfield.getText());
			setTicket_username(username_textfield.getText());
			setTicket_email(email_textfield.getText());
			setTicket_phone(phone_textfield.getText());
			setTicket_date(dateToString);
			setTicket_row(Integer.parseInt(row.getValue()));
			setTicket_column(Integer.parseInt(column.getValue()));
			ticket_movieName = movie.getMovie();
			ticket_cinemaHall = movie.getCinema_hall();
			ticket_time =movie.getTime();
			
		
			String path = "C:\\Users\\user\\eclipse-workspace\\Ticket_Seller_Official\\src\\booked_tickets";
			//write all the information into the booking file
			try {//try suite
				
				//fileWriter object to write in the file
				FileWriter filewriter = new FileWriter(path, true);//set the path and write without deleting
				BufferedWriter bufferedwriter = new BufferedWriter(filewriter);
				//write in the file
				bufferedwriter.write(username_textfield.getText()+"\n");
				bufferedwriter.write(name_textfield.getText()+"\n");
				bufferedwriter.write(email_textfield.getText()+"\n");
				bufferedwriter.write(phone_textfield.getText()+"\n");
				bufferedwriter.write(movie.getMovie()+"\n");
				bufferedwriter.write(movie.getCinema_hall()+"\n");
				bufferedwriter.write(movie.getTime()+"\n");
				bufferedwriter.write(dateToString+"\n");
				bufferedwriter.write(row.getValue() + " " + column.getValue()+"\n");
				bufferedwriter.close();



			} catch (IOException e1) {//catch suite
				e1.printStackTrace();
			}
			stage.close();//close the stage
			
			
			//create a book object with the same arguments as the book constructor
			Book myTicket = new Book(getTicket_name(),  getTicket_username(), getTicket_email(),  getTicket_phone(),
					 getTicket_date(),  getTicket_row(),  getTicket_column(), image,  ticket_movieName,  ticket_cinemaHall,  ticket_time);
			try {//try suite
				//display the ticket by invoking the method
				myTicket.display(stage);
			} catch (FileNotFoundException e1) {//catch suite
				e1.printStackTrace();
			}
			
		});
		
		
	}
	
	//void method to take a look at your seat
	public void seeYourSeat(String row,String column){
		
		//change the string parameters into integers
		int row_chosen = Integer.parseInt(row)-1;
		int column_chosen = Integer.parseInt(column)-1;
		//set the stage
		Stage stg1=new Stage();
		//set the pane
		GridPane pane = new GridPane();
		//for loop to check through the rows
		for (int i = 0; i < 3; i++) {
			//for loop to check through the columns
			for (int j = 0; j < 3; j++) {
				Rectangle r = new Rectangle(50, 50, 50, 50);//create rectangles with these size
				r.setFill(Color.AQUAMARINE);//set the color
				r.setStroke(Color.BLACK);//set the lines
				if(i==row_chosen && j==column_chosen) {//set the chosen seat
					r.setFill(Color.GREEN);//color it green
				}
				pane.add(r, j, i);//add to pane
			}
		}
		//set the scene with the pane and size as arguments
		Scene scene = new Scene (pane,150,150);
		//set the stage and its properties
		stg1.setTitle("See your Seat");//set the title
        stg1.getIcons().add(new Image("file:src/images/ticket_logo.jpg"));//set the icon
		stg1.setScene(scene);//set the scene
		stg1.show();//show the stage
		
		
	}




}
