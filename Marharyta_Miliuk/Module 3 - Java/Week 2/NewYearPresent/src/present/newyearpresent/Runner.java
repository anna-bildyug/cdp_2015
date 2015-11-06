package present.newyearpresent;

import java.util.InputMismatchException;
import console.newyearpresent.InputOutputStreams;
import sweets.newyearpresent.Bar;
import sweets.newyearpresent.ChocolateCandy;
import sweets.newyearpresent.Lollypop;

public class Runner {

	public static void main (String []args){
		
	try{
		
		Present present = new Present ();
		
			int number = present.askNumberOfCandies();
			
			    for (int i = 0; i < number; i++){
			    	
				     InputOutputStreams.printMessage("Enter type of candy you want (Bar, Lollypop or Chocolate Candy)");//asking user to define object of which type to create
				     String typeOfCandy = InputOutputStreams.scanMessage();
				     
				     InputOutputStreams.printMessage("Enter" + " " + (i+1)+ " " + "candy you want to add to your present");//asking user to define Name parameter for each created object
				     String nameOfCandy = InputOutputStreams.scanMessage();
				     
				     switch(typeOfCandy){//using the switch/case to create objects of different types with the names user defined
				    
				           case "Bar":
					       Present.collection.add(new Bar(nameOfCandy));
					       break;
					       
				           case "Lollypop":
					       Present.collection.add(new Lollypop(nameOfCandy));
					       break;
					       
				           case "Chocolate Candy":
					       Present.collection.add(new ChocolateCandy(nameOfCandy));
					       break;
					       
				           default:
					       InputOutputStreams.printMessage("Please, enter Bar, Lollypop or Chocolate Candy");
					       Runner.main(args);
				  }	
			}
			    
			present.findPresentsWeight();//calling methods from Present class to define weight, sort candies and find exact candy
			present.sortCollection();
			present.findCandy();
	
	}
	catch (InputMismatchException e){//catching exception and restarting the program
		InputOutputStreams.printMessage("Please, enter number of candies! Try again");
		Runner.main(args);
	}	
}
}