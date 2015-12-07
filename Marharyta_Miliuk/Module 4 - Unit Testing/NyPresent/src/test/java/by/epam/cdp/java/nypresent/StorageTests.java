package by.epam.cdp.java.nypresent;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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
  public void exportPresentFile() throws PresentStorageException, IOException {
	  
    Present present = new Present();
    present.addCandy(new Bar("Candy", 10, "Nougat"));
    FileReaderWriter file = new FileReaderWriter();
	file.exportPresent(present);
	
	String expectedString = "Type: Bar Name of candy: Candy Weight: 10 Main ingredient: Nougat";
	BufferedReader br = new BufferedReader(new FileReader("src\\main\\java\\by\\epam\\cdp\\java\\nypresent\\storage\\present.txt"));
	String actualString = br.readLine();
	br.close();
	
	Assert.assertEquals(actualString, expectedString); 
  }
  
  @Test
  public void importPresentFile () throws PresentStorageException{
	  
	  Present present = new Present();
	  present.addCandy(new Bar("Candy", 10, "Nougat"));
	  FileReaderWriter file = new FileReaderWriter();
	  Present result = file.importPresent();
	  
	  Assert.assertEquals(result, present);
  }

  @Test (groups = "storage")
  public void importPresentDB() throws PresentStorageException {

	  Present present = new Present();
	  present.addCandy(new Bar("Mars", 50, "Nougat"));
	  present.addCandy(new Bar("Mars", 50, "Nougat"));
	  DBReaderWriter db = new DBReaderWriter();
	  Present result = db.importPresent();
	  
	  Assert.assertEquals(result, present);
  }
  
  @Test (groups = "storage")
  public void importPresentXML() throws PresentStorageException{
	  
	  Present present = new Present();
	  present.addCandy(new Bar("Mars", 50, "Nougat"));
	  present.addCandy(new Lollypop("Chupa-Chups", 20, "Caramel"));
	  XMLReaderWriter xml = new XMLReaderWriter();
	  Present result = xml.importPresent();
	  Assert.assertEquals(result, present);
  }
}
