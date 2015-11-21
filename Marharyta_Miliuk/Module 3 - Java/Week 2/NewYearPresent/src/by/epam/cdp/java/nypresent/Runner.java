package by.epam.cdp.java.nypresent;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import by.epam.cdp.java.nypresent.beans.Bar;
import by.epam.cdp.java.nypresent.beans.ChocolateCandy;
import by.epam.cdp.java.nypresent.beans.Lollypop;
import by.epam.cdp.java.nypresent.beans.Sweets;
import by.epam.cdp.java.nypresent.storage.DBReaderWriter;
import by.epam.cdp.java.nypresent.storage.FileReaderWriter;
import by.epam.cdp.java.nypresent.utils.PrinterScanner;
import by.epam.cdp.java.nypresent.validation.NoSuchCandyException;
import by.epam.cdp.java.nypresent.validation.PresentStorageException;
import by.epam.cdp.java.nypresent.validation.WrongTypeOfCandyException;

public class Runner {
	
	public static void main (String []args) throws NoSuchCandyException, ClassNotFoundException, IOException, PresentStorageException {
		
		boolean exit = false;
		if (exit == true){
			System.exit(0);
		}
		while (exit == false){
			
		int choise = Communicator.showTheMenu();
		
		Present present = null;
		
		switch (choise){
		case 1:
			present = PresentCollector.putCandiesIntoPresent();
		    present.getPresentsWeight();//calling methods from Present class to define weight, sort candies and find exact candy	
		    present.sortCollectionByName();
		    PrinterScanner.printCollection(present.getColection());		
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
			exit = true;
			break;
	}
  }
	}
}