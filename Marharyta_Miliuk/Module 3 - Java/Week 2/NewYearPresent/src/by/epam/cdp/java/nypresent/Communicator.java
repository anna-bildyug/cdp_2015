package by.epam.cdp.java.nypresent;

import java.util.InputMismatchException;

import by.epam.cdp.java.nypresent.utils.InputOutputStreams;

public class Communicator {

	 public static int askNumberOfCandies () throws IllegalArgumentException {//creating method do define number of candies to put into present
	    	int number = 0;
			   try {
			       System.out.println("How many candies do you want?");
			       number = InputOutputStreams.scanNumbers();
			           if (number < 0){
				
				          throw new IllegalArgumentException("Please, enter only positive numbers!");
			           }
			           else if (number == 0){
			        	   
			        	   throw new NullPointerException("You can't leave the present empty! Please, add at least one candy to the present!");
			           }
			        }
			   catch (InputMismatchException e){//catching exception and restarting the program
				   InputOutputStreams.printMessage("Please, enter number of candies! Try again");
			        }	
		return number;
		}
	    
	    public static String askTypeOfCandy(){

	    	InputOutputStreams.printMessage("Enter type of candy you want (Bar, Lollypop or Chocolate Candy)");//asking user to define object of which type to create
	        String typeOfCandy = InputOutputStreams.scanMessage();
	    
	    return typeOfCandy;
	    
	    }
	    
	    public static String askNameOfCandy (){
		
	    	InputOutputStreams.printMessage("Enter candy name you want to add to your present");//asking user to define Name parameter for each created object
	        String nameOfCandy = InputOutputStreams.scanMessage();
	    
	    return nameOfCandy;
	    
	    }

}
