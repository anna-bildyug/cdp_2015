package by.epam.cdp.java.nypresent.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import by.epam.cdp.java.nypresent.Present;
import by.epam.cdp.java.nypresent.beans.Bar;
import by.epam.cdp.java.nypresent.beans.Lollypop;
import by.epam.cdp.java.nypresent.storage.DBReaderWriter;
import by.epam.cdp.java.nypresent.storage.FileReaderWriter;
import by.epam.cdp.java.nypresent.storage.XMLReaderWriter;
import by.epam.cdp.java.nypresent.validation.PresentStorageException;

public class StorageTests {

  @Test(groups = "storage")
  public void exportImportPresentFile() throws PresentStorageException {
	  
    Present present = new Present();
    present.getCollection().add(new Bar("testCandy1"));
    present.getCollection().add(new Bar("testCandy2"));
    FileReaderWriter file = new FileReaderWriter();
	file.exportPresent(present);
	Present result = file.importPresent();
	Assert.assertEquals(result, present); 
  }

  @Test (groups = "storage")
  public void importPresentDB() throws PresentStorageException {

	  Present present = new Present();
	  present.getCollection().add(new Bar("Mars", 50, "Nougat"));
	  present.getCollection().add(new Bar("Mars", 50, "Nougat"));
	  DBReaderWriter db = new DBReaderWriter();
	  Present result = db.importPresent();
	  Assert.assertEquals(result, present);
  }
  
  @Test (groups = "storage")
  public void importPresentXML() throws PresentStorageException{
	  
	  Present present = new Present();
	  present.getCollection().add(new Bar("Mars", 50, "Nougat"));
	  present.getCollection().add(new Lollypop("Chupa-Chups", 20, "Caramel"));
	  XMLReaderWriter xml = new XMLReaderWriter();
	  Present result = xml.importPresent();
	  Assert.assertEquals(result, present);
  }
}
