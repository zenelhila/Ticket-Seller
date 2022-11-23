import classes.Cinema;//import cinema class
import classes.Login;//import login class
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {//inheritance where the main extends the application

	@Override
	public void start(Stage primarystage) throws Exception {//start method 
		
	// login scene

		int temp = 0;//initialize a temporary integer to 0
		while (temp != 1) {//while that temporary integer is not 1, the loop executes
			Login User = new Login();//create a new object class for login
			User.display();//invoke the method display from that class
			temp = ((Login) User).getCheckBit();//temp value is assigned from the getCheckBit method from the user object(login class)
		}
		  
	 //view events scene
		  
		Cinema c = new Cinema();//create a new cinema object
		c.display(primarystage);//invoke the display method with one argument from the cinema object(cinema class)
	}

	public static void main(String[] args) {//main method
		launch(args);//start the application
	}

}
