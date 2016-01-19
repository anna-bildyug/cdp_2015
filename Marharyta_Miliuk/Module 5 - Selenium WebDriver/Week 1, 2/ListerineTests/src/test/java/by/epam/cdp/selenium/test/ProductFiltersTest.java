package by.epam.cdp.selenium.test;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import by.epam.cdp.selenium.actions.Actions;

public class ProductFiltersTest extends CommonTest {
	
	private String filterID;
	
	@Factory(dataProvider = "nameOfFilters")
	public ProductFiltersTest (String filterID){
		this.filterID = filterID;
	}
	
	@DataProvider
	public static Object [][] nameOfFilters(){		  
		  return new Object [][] {{"edit-field-product-symptom-tid-16"},
		                          {"edit-field-product-symptom-tid-17"}};
		  }
	
	@Test(groups = "Product Filters Test")
	public void filterProductsList (){
		Actions action = new Actions();
		List<WebElement> presence = action.filterProductsList(filterID);
		Assert.assertTrue(presence.isEmpty());
	}
}