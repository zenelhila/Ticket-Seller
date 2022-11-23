package classes;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Popup;
import javafx.stage.Stage;

//create a login class
public class Login {
	//dataFields
	public String date = "";//string for the date and initialize it to null
	public final int SIZE = 100;//final integer size
	private int CheckBit = 0;//CheckBiter
	
	//getter for the CheckBit
	 public int getCheckBit() {
		return CheckBit;
	}

	 //setter for the CheckBit
	public void setCheckBit(int CheckBit) {
		this.CheckBit = CheckBit;
	}
//void method to display the login scene
	public void display(){
		//set the stage
	        Stage stage = new Stage();
	       //create the label for the username and password
	        Label usernameLabel = new Label("Username");
	        Label passwordLabel = new Label("Password");
	        //create the textFields
	        TextField usernameField = new TextField();
	        PasswordField passwordField = new PasswordField();
	        
	        //create a button for the login and set its properties
			Button loginButton = new Button("_Login");
			loginButton.setMinWidth(100);//set the width
			Tooltip loginTT = new Tooltip("login!");//toolTip to advice the customer
			loginButton.setTooltip(loginTT);
			loginButton.setMnemonicParsing(true);
			//create a new button for exiting the program
			Button exitButton = new Button("_Exit");
			exitButton.setMinWidth(100);//set its width
			Tooltip exitTT = new Tooltip("Exit!");
			exitButton.setTooltip(exitTT);
			exitButton.setMnemonicParsing(true);
			//create the pane and ste its properties
	        GridPane gridPane = new GridPane();
	        gridPane.setVgap(15);//set vertical gap
	        gridPane.setHgap(25);//set horizontal gap
	        gridPane.add(usernameLabel, 0, 1);//add the label of the username to the pane
	        gridPane.add(passwordLabel, 0, 2);//add the label of the password to the pane
	        
	        gridPane.add(usernameField, 1, 1);//add the textField of the username to the pane
	        gridPane.add(passwordField, 1, 2);//add the textField of the password to the field

	        gridPane.add(loginButton, 0, 5);//add the buttons to the pane
	        gridPane.add(exitButton, 1, 5);
	        //adjust the pane
	        gridPane.setPadding(new Insets(15));
	        gridPane.setAlignment(Pos.CENTER);//position it to the center
	        //create new scene and set its properties
	        Scene scene = new Scene(gridPane,300,600);
	        stage.setTitle("Event Ticket!");//set the name
	        stage.getIcons().add(new Image("file:src/images/ticket_logo.jpg"));//set the logo
	        stage.setScene(scene);//set the scene

	        //new label that will help us with the popUp
		    Label label = new Label("Incorrect username or password!"); 
		        //set the popUp
	        Popup popup = new Popup();
	        // set background 
	        label.setStyle("-fx-background-color: white"); 
	   
	        // add the label 
	        popup.getContent().add(label); 

	        // set size of label 
	        label.setMinWidth(80); 
	        label.setMinHeight(50); 
	        
	        
	        //set the action for the login button pressed
	        loginButton.setOnAction(e->{
	        	//create new daatFields to CheckBit the username and the password
	        	String user = usernameField.getText();
	        	String password = passwordField.getText();
	       //set the path of the file with the log in info
	        	String path = "C:\\Users\\user\\eclipse-workspace\\Ticket_Seller_Official\\src\\Log_in_info";

		        //create new file object
	        	File file1 = new File(path);
		    	Scanner input;//scan
				try {//try suite
  
					//read from file
					input = new Scanner(file1);
		    		while(input.hasNext()) {//while loop to read the whole file
		    			if(user.equals(input.next())  &&  password.equals(input.next())) {//if condition to CheckBit the inforamtion
		    				CheckBit = 1;//if true, set the CheckBit to 1
		    				}	
		    		}
		    		input.close();//close input
				} catch (FileNotFoundException e1) {//cathc suite
					e1.printStackTrace();
				}
					
	               if(CheckBit == 0) {//if CheckBit is still 0, we show the popUp message
	                popup.show(stage);
	                
	               }
	               else
	            	   stage.close();
	               if(!popup.isShowing())
	               stage.close();
	        });
	        

	        //set action for exit button
	        exitButton.setOnAction(e->{
	        	System.exit(0);//system closes
	        });
	        
	        //popUp show if the information entered is incorrect
	        stage.showAndWait();

	        if(popup.isShowing())
	        	popup.hide();
	        if(CheckBit == 0) {
	        System.exit(0);
	        }
	}

}