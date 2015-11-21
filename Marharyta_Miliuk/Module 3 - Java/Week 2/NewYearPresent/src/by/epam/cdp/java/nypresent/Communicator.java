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
		
	      PrinterScanner.printMessage("Enter type of candy you want (Bar, Lollypop or Chocolate Candy)");//asking user to define object of which type to create
	      String typeOfCandy = PrinterScanner.scanMessage();
	       
		return typeOfCandy;  
	  }

	public static String askNameOfCandy() {

		PrinterScanner.printMessage("Enter candy name you want to add to your present");
		String nameOfCandy = PrinterScanner.scanMessage();

		return nameOfCandy;

	}

	public static int showTheMenu() {
		int choise = 0;
		boolean isOptionChosen = true;
		while(isOptionChosen == true){
		try{
		PrinterScanner.printMessage("What do you want to do? Type number");
		PrinterScanner.printMessage("1. Create new present");
		PrinterScanner.printMessage("2. Load your saved present from file");
		PrinterScanner.printMessage("3. Load present from database");
		PrinterScanner.printMessage("4. Exit");
		choise = PrinterScanner.scanNumbers();
		if (choise == 1 || choise ==2 || choise ==3|| choise == 4){
			return choise;
		}
		else{
			isOptionChosen = false;
		}
		}
		catch (InputMismatchException e){
			PrinterScanner.printMessage("Please, enter only numbers!");
		}
		}

		return choise;
	}

	public static String askAboutSaving() {
		
			PrinterScanner.printMessage("Do you want to save your present?(y/n)");
			String confirmation = PrinterScanner.scanMessage();

		return confirmation;
	}

}
