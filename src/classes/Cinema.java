package classes;

//import the libraries
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
//create a new class cinema
public class Cinema {
	
	//create an event class arrayList which will contain the events 
	ArrayList<event> events;
	
	//public constructor with no arguments
	 public Cinema() {
			//referring to the current object of the constructor
		 this.events=new ArrayList<event>();
	 }
	 
	 //void method to display the stage
	public void display(Stage stage) throws FileNotFoundException {
			

		int temp = 0;//initialize an integer temporary to 0, which will help us reading the "event_info" file and showing it to the stage
		
		//reading from the file
		String path = "C:\\Users\\user\\eclipse-workspace\\Ticket_Seller_Official\\src\\event_info";//set the path of the file
		File file1 = new File(path);//create a new file object
		Scanner input = new Scanner(file1);//read from the file
		
		//while loop to go through the whole file, until the end
		while(input.hasNext()) {
			//create a new event object, which will take info from the file, according to the constructor
			event newEvent=new event(input.nextLine(),input.nextLine(),input.nextLine(),input.nextLine());
			events.add(newEvent);//add the new event to the arrayList
			temp++;//increase the temporary integer
		}
		
		//set the pane as a gridPane and set its properties
		Pane gridpane = new GridPane();
		((GridPane) gridpane).setHgap(5);//set horizontal gap
		((GridPane) gridpane).setVgap(5);//set vertical gap
		((GridPane) gridpane).setAlignment(Pos.CENTER);//position it to the center
		
		//for loop to show all the events from the file
		for(int i=0;i<temp;i++) {//loop will break until the temporary integer we set in the first place , which will run the loop until the events are done
			//enter the event informations
			Image poster = new Image(new FileInputStream(events.get(i).getPath()));//create a new Image object to show the poster; it reads the file of the poster
			ImageView image = new ImageView(poster);
			//create a new vertical box
			VBox details = new VBox();
			//create labels with the event informations and set them to null
			Label movieHall = new Label("");//cinema hall
			Label movieName = new Label("");//event name
			Label movieTime = new Label("");//event time
			//create a new button that can book the event and set its properties
			Button book = new Button("Book Now!");
			book.setMinWidth(100);//set the width
			book.setGraphic(image);//set an image inside the button
			//set the information of the event and read them from the arrayList
			movieName.setText(events.get(i).getMovie());//set the name of the event
			movieHall.setText(events.get(i).getCinema_hall());//set the cinema hall
			movieTime.setText(events.get(i).getTime());//set the time of the event
			details.getChildren().addAll( movieName, movieHall, movieTime);//add all the elements above in the vertical box
			//add the button and the vertical box into the pane with their coordinates
			((GridPane) gridpane).add(book, 0, i);
			((GridPane) gridpane).add(details, 1, i);
			//we initialize a new temporary integer to the event that is chosen
			int temporary = i;
			//set an action when the button is pressed
			book.setOnAction(e->{
				//create a new ticket object
				Ticket book_ticket = new Ticket(path, path, path, path, path, temporary, temporary);
				try {//try suite
					book_ticket.display(stage, events.get(temporary));//display the ticket stage
				} catch (FileNotFoundException e1) {//catch suite
					e1.printStackTrace();
				}
			});
			input.close();//close the input
		}
		
		//create the stage
		ScrollPane scroll = new ScrollPane(gridpane);//create a scroll pane with arguments of the above pane
		//create the scene with arguments the pane and the size
		Scene scene = new Scene(scroll,324,600);
		//set properties of the stage
		stage.setTitle("Events!");//set title
        stage.getIcons().add(new Image("file:src/images/ticket_logo.jpg"));//set icon
		stage.setScene(scene);//set scene
		stage.show();//show the stage
		
	}

}
