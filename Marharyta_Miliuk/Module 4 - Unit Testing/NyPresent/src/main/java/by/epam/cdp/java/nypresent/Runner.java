package by.epam.cdp.java.nypresent;

import by.epam.cdp.java.nypresent.storage.DBReaderWriter;
import by.epam.cdp.java.nypresent.storage.FileReaderWriter;
import by.epam.cdp.java.nypresent.storage.XMLReaderWriter;
import by.epam.cdp.java.nypresent.utils.PrinterScanner;
import by.epam.cdp.java.nypresent.validation.PresentStorageException;

public class Runner {

	public static void main(String[] args) throws PresentStorageException {

		boolean exit = false;
		
		while (exit == false) {

			int choise = Communicator.showTheMenu();

			Present present = null;

			switch (choise) {
			case 1:
				present = PresentCollector.putCandiesIntoPresent();
				present.getPresentsWeight();
				present.sortCollectionByName();
				PrinterScanner.printCollection(present.getCollection());
				PresentCollector.getCandyFromPresent(present);
				PresentCollector.getConfirmation(present);
				break;

			case 2:
				FileReaderWriter fileImport = new FileReaderWriter();
				Present savedPresent = fileImport.importPresent();
				PrinterScanner.printObject(savedPresent.toString());
				break;

			case 3:
				DBReaderWriter tableImport = new DBReaderWriter();
				PrinterScanner.printObject(tableImport.importPresent());
				break;
				
			case 4:
				XMLReaderWriter xmlImport = new XMLReaderWriter();
				PrinterScanner.printObject(xmlImport.importPresent());
				break;
				
			case 5:
				exit = true;
				break;
			}
		}
	}
}