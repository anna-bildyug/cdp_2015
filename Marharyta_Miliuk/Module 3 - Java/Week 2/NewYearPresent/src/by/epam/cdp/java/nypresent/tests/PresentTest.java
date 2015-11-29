package by.epam.cdp.java.nypresent.tests;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;
import by.epam.cdp.java.nypresent.Present;
import by.epam.cdp.java.nypresent.beans.Bar;
import by.epam.cdp.java.nypresent.beans.Sweets;
import by.epam.cdp.java.nypresent.validation.NoSuchCandyException;

public class PresentTest {
	
  @Test(groups = "present")
  public void findCandyByName() throws NoSuchCandyException {
	Present present = new Present();
	
	String candyName = "candy";
	Bar firstCandy = new Bar(candyName);
	Bar secondCandy = new Bar ("It's not the candy we're loooking for");
	
	present.getCollection().add(firstCandy);
	present.getCollection().add(secondCandy);
	List <Sweets> foundCandy = present.findCandyByName(candyName);
	Assert.assertEquals(foundCandy, firstCandy);	
  }
  
  @Test (expectedExceptions = NoSuchCandyException.class, groups = "present")
  public void findInvalidCandyName () throws NoSuchCandyException{
	  Present present = new Present();
	  String invalidName = "test";
	  String candyName = "candy";
	  Bar firstCandy = new Bar(candyName);
	  present.getCollection().add(firstCandy);
	  present.findCandyByName(invalidName);
  }

  @Test (groups = "present")
  public void getPresentsWeight() {
	  
	Present present = new Present();
	
	int firstCandyWeight = 10;
	int secondCandyWeight = 20;
	
	Bar firstCandy = new Bar("testName", firstCandyWeight, "testIngredient");
	Bar secondCandy = new Bar("testName", secondCandyWeight, "testIngredient");
	
	present.getCollection().add(firstCandy);
	present.getCollection().add(secondCandy);
	
	int totalWeight = present.getPresentsWeight();
	Assert.assertEquals(totalWeight, 30);
	     
  }

  @Test (groups = "present")
  public void sortCollectionByName() {
	  
	  Present present = new Present();
	  
	  Bar firstCandy = new Bar("A");
	  Bar secondCandy = new Bar("B");
	  Bar thirdCandy = new Bar("C");
	  
	  present.getCollection().add(secondCandy);
	  present.getCollection().add(thirdCandy);
	  present.getCollection().add(firstCandy);
	  
	  present.sortCollectionByName();
	  
	  Assert.assertEquals(present.getCollection().get(0), firstCandy);
	  Assert.assertEquals(present.getCollection().get(1), secondCandy);
	  Assert.assertEquals(present.getCollection().get(2), thirdCandy);
	  
  }
}
