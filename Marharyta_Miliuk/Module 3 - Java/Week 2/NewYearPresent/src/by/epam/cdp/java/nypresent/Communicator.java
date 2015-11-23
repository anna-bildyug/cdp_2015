package by.epam.cdp.java.nypresent;

import java.util.InputMismatchException;

import by.epam.cdp.java.nypresent.utils.PrinterScanner;
import by.epam.cdp.java.nypresent.validation.WrongTypeOfCandyException;

public class Communicator {

	public static int askNumberOfCandies() {
		int number = 0;

		PrinterScanner.printObject("How many candies do you want?");
		number = PrinterScanner.scanNumbers();
		if (number < 0) {
			throw new IllegalArgumentException();
		} else if (number == 0) {
			throw new NullPointerException();
		} else {
			return number;
		}
	}

	public static String askTypeOfCandy(){

		PrinterScanner.printObject("Enter type of candy you want (Bar, Lollypop or Chocolate Candy)");	
		String typeOfCandy = PrinterScanner.scanMessage();

		return typeOfCandy;
	}

	public static String askNameOfCandy() {

		PrinterScanner.printObject("Enter candy name you want to add to your present");
		String nameOfCandy = PrinterScanner.scanMessage();

		return nameOfCandy;

	}

	public static int showTheMenu() {
		int choise = 0;
		boolean isOptionChosen = true;
		while (isOptionChosen == true) {
			try {
				PrinterScanner.printObject("What do you want to do? Type number");
				PrinterScanner.printObject("1. Create new present");
				PrinterScanner.printObject("2. Load your saved present from file");
				PrinterScanner.printObject("3. Load present from database");
				PrinterScanner.printObject("4. Load present from XML file");
				PrinterScanner.printObject("5. Exit");
				choise = PrinterScanner.scanNumbers();
				if (choise == 1 || choise == 2 || choise == 3 || choise == 4) {
					return choise;
				} else {
					isOptionChosen = false;
				}
			} catch (InputMismatchException e) {
				PrinterScanner.printObject("Please, enter only numbers!");
			}
		}

		return choise;
	}

	public static String askAboutSaving() {

		PrinterScanner.printObject("Do you want to save your present?(y/n)");
		String confirmation = PrinterScanner.scanMessage();

		return confirmation;
	}

}
