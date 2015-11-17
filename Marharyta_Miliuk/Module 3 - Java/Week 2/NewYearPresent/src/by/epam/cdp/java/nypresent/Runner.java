package by.epam.cdp.java.nypresent;

import by.epam.cdp.java.nypresent.beans.Bar;
import by.epam.cdp.java.nypresent.beans.ChocolateCandy;
import by.epam.cdp.java.nypresent.beans.Lollypop;
import by.epam.cdp.java.nypresent.utils.InputOutputStreams;
import by.epam.cdp.java.nypresent.validation.NoSuchCandyException;
import by.epam.cdp.java.nypresent.validation.WrongTypeOfCandyException;

public class Runner {
	
	public static void main (String []args) throws WrongTypeOfCandyException, NoSuchCandyException{
		
		Present present = new Present ();
		
			int number = Communicator.askNumberOfCandies();
			
			    for (int i = 0; i < number; i++){
			    	
				     String typeOfCandy  = Communicator.askTypeOfCandy();
				     
				     if ("Bar".equals(typeOfCandy)){
				    	 
				    	 String nameOfCandy = Communicator.askNameOfCandy();
				    	 present.collection.add(new Bar(nameOfCandy));	 
				     }
				     else if ("Lollypop".equals(typeOfCandy)){
				    	 
				    	 String nameOfCandy = Communicator.askNameOfCandy();
				    	 present.collection.add(new Lollypop(nameOfCandy));
				     }
				     else if ("Chocolate Candy".equals(typeOfCandy)){
				    	 
				    	 String nameOfCandy = Communicator.askNameOfCandy();
				    	 present.collection.add(new ChocolateCandy(nameOfCandy));
				     }
				     else {
				    	 
				    	 throw new WrongTypeOfCandyException("Wrong type of candy! Type Bar, Lollypop or Chocolate Candy");
				     }
			}
			    present.getPresentsWeight();//calling methods from Present class to define weight, sort candies and find exact candy
				
			    present.sortCollectionByName();
					
			    InputOutputStreams.printMessage("Which candy do you want to eat?");
			        
			    String candyName = InputOutputStreams.scanMessage();
					
			    present.findCandyByName(candyName);
			    
			
	}
	
}