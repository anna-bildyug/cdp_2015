package by.epam.cdp.java.nypresent;
import java.util.ArrayList;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import by.epam.cdp.java.nypresent.Present;
import by.epam.cdp.java.nypresent.beans.Bar;
import by.epam.cdp.java.nypresent.beans.Sweets;
import by.epam.cdp.java.nypresent.validation.NoSuchCandyException;

public class PresentTest {
	
  @BeforeTest
  public Present createTestPresent(){
	  
  Present present = new Present();
  return present;
  
  }	
  
  @Test(groups = "present")
  public void findCandyByName() throws NoSuchCandyException {
	Present present = createTestPresent();  
	String candyName = "candy";
	Bar firstCandy = new Bar(candyName);
	createTestPresent().addCandy(firstCandy);
	List <Sweets> expectedList = new ArrayList<Sweets>();
	expectedList.add(firstCandy);
	present.addCandy(firstCandy);
	List <Sweets> foundCandy = present.findCandyByName(candyName);
	
	Assert.assertEquals(foundCandy, expectedList);	
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
	
	present.addCandy(firstCandy);
	present.addCandy(secondCandy);
	
	int totalWeight = present.getPresentsWeight();
	Assert.assertEquals(totalWeight, 30);
	     
  }

  @Test (groups = "present")
  public void sortCollectionByName() {
	  
	  Present present = new Present();
	  
	  Bar firstCandy = new Bar("A");
	  Bar secondCandy = new Bar("B");
	  Bar thirdCandy = new Bar("C");
	  
	  present.addCandy(secondCandy);
	  present.addCandy(thirdCandy);
	  present.addCandy(firstCandy);
	  
	  present.sortCollectionByName();
	  
	  List <Sweets> expectedList = new ArrayList<Sweets>();
	  expectedList.add(firstCandy);
	  expectedList.add(secondCandy);
	  expectedList.add(thirdCandy);
	  
	  Assert.assertEquals(present, "Present: " + expectedList);  
  }
}
