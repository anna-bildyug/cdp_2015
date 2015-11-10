package by.epam.cdp.java.nypresent;
import java.util.InputMismatchException;

import by.epam.cdp.java.nypresent.beans.Bar;
import by.epam.cdp.java.nypresent.beans.ChocolateCandy;
import by.epam.cdp.java.nypresent.beans.Lollypop;
import by.epam.cdp.java.nypresent.utils.InputOutputStreams;

public class Runner {
	
public static int askNumberOfCandies (){//creating method do define number of candies to put into present
		
		System.out.println("How many candies do you want?");
		
		return InputOutputStreams.scanNumbers();
	}

	public static void main (String []args){
		
	try{
		
		Present present = new Present ();
		
			int number = askNumberOfCandies();
			
			    for (int i = 0; i < number; i++){
			    	
				     InputOutputStreams.printMessage("Enter type of candy you want (Bar, Lollypop or Chocolate Candy)");//asking user to define object of which type to create
				     String typeOfCandy = InputOutputStreams.scanMessage();
				     
				     InputOutputStreams.printMessage("Enter" + " " + (i+1)+ " " + "candy you want to add to your present");//asking user to define Name parameter for each created object
				     String nameOfCandy = InputOutputStreams.scanMessage();
				     
				     switch(typeOfCandy){//using the switch/case to create objects of different types with the names user defined
				    
				           case "Bar":
					       present.collection.add(new Bar(nameOfCandy));
					       break;
					       
				           case "Lollypop":
					       present.collection.add(new Lollypop(nameOfCandy));
					       break;
					       
				           case "Chocolate Candy":
					       present.collection.add(new ChocolateCandy(nameOfCandy));
					       break;
					       
				           default:
					       InputOutputStreams.printMessage("Wrong type of candy! Please, enter Bar, Lollypop or Chocolate Candy. Try again!");
					    
				  }	
			}
			    
			present.getPresentsWeight();//calling methods from Present class to define weight, sort candies and find exact candy
			present.sortCollectionByName();
			InputOutputStreams.printMessage("Which candy do you want to eat?");
	        String candyName = InputOutputStreams.scanMessage();
			present.findCandyByName(candyName);
	
	}
	catch (InputMismatchException e){//catching exception and restarting the program
		InputOutputStreams.printMessage("Please, enter number of candies! Try again");
		Runner.main(args);
	}	
}
}