package by.epam.cdp.selenium.test;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import by.epam.cdp.selenium.actions.BusinessActions;

public class ProductFiltersTest extends CommonTest {
	
	private String filterID;
	
	@Factory(dataProvider = "nameOfFilters")
	public ProductFiltersTest (String filterID){
		this.filterID = filterID;
	}
	
	@DataProvider
	public static Object [][] nameOfFilters(){		  
		  return new Object [][] {{"edit-field-product-symptom-tid-16"}};
		  }
	
	@Test(groups = "Product Filters Test")
	public void filterProductsList () throws IOException{
		BusinessActions action = new BusinessActions();
		List<WebElement> presence = action.filterProductsList(filterID);
		Assert.assertTrue(presence.isEmpty());
	}
}