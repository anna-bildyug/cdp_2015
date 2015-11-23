package by.epam.cdp.java.nypresent;

import java.util.InputMismatchException;
import java.util.List;

import by.epam.cdp.java.nypresent.beans.Bar;
import by.epam.cdp.java.nypresent.beans.ChocolateCandy;
import by.epam.cdp.java.nypresent.beans.Lollypop;
import by.epam.cdp.java.nypresent.beans.Sweets;
import by.epam.cdp.java.nypresent.storage.FileReaderWriter;
import by.epam.cdp.java.nypresent.utils.PrinterScanner;
import by.epam.cdp.java.nypresent.validation.NoSuchCandyException;
import by.epam.cdp.java.nypresent.validation.PresentStorageException;
import by.epam.cdp.java.nypresent.validation.WrongTypeOfCandyException;

public class PresentCollector {

	public static String getTypeOfCandy() {
		boolean isTypeValid = true;
		String typeOfCandy = null;

		while (isTypeValid == true) {
			try {
				typeOfCandy = Communicator.askTypeOfCandy();
				if ("Bar".equals(typeOfCandy) || "Lollypop".equals(typeOfCandy)
						|| "Chocolate Candy".equals(typeOfCandy)) {
					return typeOfCandy;
				} else {
					isTypeValid = false;
					throw new WrongTypeOfCandyException();
				}
			} catch (WrongTypeOfCandyException e) {
				PrinterScanner.printObject("Wrong type of candy! Please, enter Bar, Lollypop or Chocolate Candy");
			}
		}
		return typeOfCandy;

	}

	public static void getCandyFromPresent(Present present) {

		PrinterScanner.printObject("Which candy do you want to eat?");
		String candyName = PrinterScanner.scanMessage();
		try {
			List<Sweets> sweets = present.findCandyByName(candyName);
			PrinterScanner.printCollection(sweets);
		} catch (NoSuchCandyException e) {
			PrinterScanner.printObject("There is no such candy in your present!");
		}
	}

	public static void getConfirmation(Present present) throws PresentStorageException {
		String confirmation = Communicator.askAboutSaving();

		if (confirmation.equals("y")) {
			FileReaderWriter fileExport = new FileReaderWriter();
			fileExport.exportPresent(present);
		}
}

	public static int getNumberOfCandies() {
		int number = 0;
		boolean isNumberValid = true;
		while (isNumberValid == true) {
			try {
				number = Communicator.askNumberOfCandies();
				return number;
			} catch (InputMismatchException e) {
				isNumberValid = false;
				PrinterScanner.printObject("Please, enter number of candies! Try again");

			} catch (IllegalArgumentException e) {
				isNumberValid = false;
				PrinterScanner.printObject("Please, enter only positive numbers!");

			} catch (NullPointerException e) {
				isNumberValid = false;
				PrinterScanner.printObject(
						"You can't leave the present empty! Please, add at least one candy to the present!");
			}
		}
		return number;
	}

	public static Present putCandiesIntoPresent() {
		Present present;
		present = new Present();

		int number = PresentCollector.getNumberOfCandies();

		for (int i = 0; i < number; i++) {

			String typeOfCandy = PresentCollector.getTypeOfCandy();

			if ("Bar".equals(typeOfCandy)) {
				String nameOfCandy = Communicator.askNameOfCandy();
				present.getCollection().add(new Bar(nameOfCandy));
			} else if ("Lollypop".equals(typeOfCandy)) {
				String nameOfCandy = Communicator.askNameOfCandy();
				present.getCollection().add(new Lollypop(nameOfCandy));
			} else if ("Chocolate Candy".equals(typeOfCandy)) {
				String nameOfCandy = Communicator.askNameOfCandy();
				present.getCollection().add(new ChocolateCandy(nameOfCandy));
			}
		}
		return present;
	}
}