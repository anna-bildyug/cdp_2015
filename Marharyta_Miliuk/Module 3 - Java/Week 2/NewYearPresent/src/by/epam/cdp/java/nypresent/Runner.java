package by.epam.cdp.java.nypresent;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;

import by.epam.cdp.java.nypresent.beans.Bar;
import by.epam.cdp.java.nypresent.beans.ChocolateCandy;
import by.epam.cdp.java.nypresent.beans.Lollypop;
import by.epam.cdp.java.nypresent.beans.Sweets;
import by.epam.cdp.java.nypresent.storage.FileReaderWriter;
import by.epam.cdp.java.nypresent.storage.IOStreams;
import by.epam.cdp.java.nypresent.utils.PrinterScanner;
import by.epam.cdp.java.nypresent.validation.NoSuchCandyException;
import by.epam.cdp.java.nypresent.validation.PresentStorageException;
import by.epam.cdp.java.nypresent.validation.WrongTypeOfCandyException;

public class Runner {
	
	public static void main (String []args) throws NoSuchCandyException, ClassNotFoundException, IOException, PresentStorageException {
		
		int choise = Communicator.showTheMenu();
		
		Present present = null;
		switch (choise){
		
		case 1:
			
			present = new Present ();
			int number = 0;
			try{
			
				number = Communicator.askNumberOfCandies();
			}
			catch (InputMismatchException e) {
				
				PrinterScanner.printMessage("Please, enter number of candies! Try again");
				
			} catch (IllegalArgumentException e) {
				
				PrinterScanner.printMessage("Please, enter only positive numbers!");
				
			} catch (NullPointerException e) {
				
				PrinterScanner
						.printMessage("You can't leave the present empty! Please, add at least one candy to the present!");
				
			}
				    for (int i = 0; i < number; i++){
				    	
				    	String typeOfCandy = null;
						try {
						
						 typeOfCandy  = Communicator.askTypeOfCandy();
						 
						}
						
						catch (WrongTypeOfCandyException e){
							PrinterScanner.printMessage("Wrong type of candy! Please, enter Bar, Lollypop or Chocolate Candy");
						}
				    	
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
					    	 System.exit(i);
					     }  
				}
				    present.getPresentsWeight();//calling methods from Present class to define weight, sort candies and find exact candy
					
				    present.sortCollectionByName();
				    PrinterScanner.printCollection(present.getColection());
						
				    PrinterScanner.printMessage("Which candy do you want to eat?");
				        
				    String candyName = PrinterScanner.scanMessage();
				    
						try{
							List<Sweets> sweets = present.findCandyByName(candyName);
							PrinterScanner.printCollection(sweets);
							
						}
						catch (NoSuchCandyException e){
							PrinterScanner.printMessage("There is no such candy in your present!");
						}
						
				    String confirmation = Communicator.askAboutSaving();
				    switch (confirmation){
				    
				    case "y":
				    	FileReaderWriter fileExport = new FileReaderWriter();
				    	fileExport.exportPresent(present);
				    
			        case "n":
			        	System.exit(0);
				    }
		case 2:
			FileReaderWriter fileImport = new FileReaderWriter();
			
			PrinterScanner.printObject(fileImport.importPresent());
			
		case 3:
			System.exit(choise);
		
	}
  }
}