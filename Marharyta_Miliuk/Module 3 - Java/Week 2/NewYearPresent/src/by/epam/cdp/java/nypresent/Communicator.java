package by.epam.cdp.java.nypresent;

import java.util.InputMismatchException;
import by.epam.cdp.java.nypresent.utils.PrinterScanner;
import by.epam.cdp.java.nypresent.validation.WrongTypeOfCandyException;

public class Communicator {

	public static int askNumberOfCandies() throws IllegalArgumentException {
		
		int number = 0;
			System.out.println("How many candies do you want?");
			number = PrinterScanner.scanNumbers();
			if (number < 0) {

				throw new IllegalArgumentException();
				
			} else if (number == 0) {

				throw new NullPointerException();
			}
			else {
				return number;
		} 
		
	}

	public static String askTypeOfCandy() throws WrongTypeOfCandyException{
	      String typeOfCandy = null;
	      
	      PrinterScanner.printMessage("Enter type of candy you want (Bar, Lollypop or Chocolate Candy)");//asking user to define object of which type to create
	         typeOfCandy = PrinterScanner.scanMessage();
	         
	         if ("Bar".equals(typeOfCandy)|| "Lollypop".equals(typeOfCandy) || "Chocolate Candy".equals(typeOfCandy)){
	          return typeOfCandy;
	             }
	      
	         else {
	          throw new WrongTypeOfCandyException();
	        }
	         
	  }

	public static String askNameOfCandy() {

		PrinterScanner.printMessage("Enter candy name you want to add to your present");
		String nameOfCandy = PrinterScanner.scanMessage();

		return nameOfCandy;

	}

	public static int showTheMenu() {
		
		PrinterScanner.printMessage("Hello! What do you want to do? Type number");
		PrinterScanner.printMessage("1. Create new present");
		PrinterScanner.printMessage("2. Load your saved present");
		PrinterScanner.printMessage("3. Exit the program");
		int choise = PrinterScanner.scanNumbers();
		return choise;

	}

	public static String askAboutSaving() {
		
			PrinterScanner.printMessage("Do you want to save your present?(y/n)");
			String confirmation = PrinterScanner.scanMessage();

		return confirmation;
	}

}
