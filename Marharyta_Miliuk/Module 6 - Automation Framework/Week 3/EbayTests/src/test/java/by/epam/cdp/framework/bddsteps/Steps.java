package by.epam.cdp.framework.bddsteps;

import org.apache.log4j.Logger;
import org.jbehave.core.annotations.AfterStories;
import org.jbehave.core.annotations.BeforeStories;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import by.epam.cdp.framewok.driver.Driver;
import by.epam.cdp.framework.utils.TestUtils;

public class Steps extends Driver {
	
	TestUtils utils = new TestUtils();
	
	private final static Logger LOGGER = Logger.getLogger(Steps.class);
	
	@BeforeStories
    public static void initSelenium(){
        Driver.getInstance();
    } 
	@Given("I am on the main page")
	public void iAmOnTheMainPage(){
		try{
	    driver.get("http://www.ebay.com/");
		}
		catch (NullPointerException e){
			LOGGER.error("Cannot find any driver");			
		}
	}
	@When("I open catalogue")
	public void iOpenCatalogue(){
		try{
		driver.findElement(By.linkText("Мода")).click();	
		}
		catch(ElementNotFoundException e){
			LOGGER.warn("There are no elements found by link text");
		}
	}
	@When("I open brand page with the name $brandName")
	public void iOpenProductPage (String brandName){
		try{
		driver.findElement(By.linkText(brandName)).click();
		}
		catch(ElementNotFoundException e){
			LOGGER.warn("There are no elements found by link text");
		}
	}	
	@When("I add product with the name $productName to cart")
	public void iAddProductToCart (String productName){
		try{
		driver.findElement(By.partialLinkText(productName)).click();
		driver.findElement(By.id("isCartBtn_btn")).click();
		}
		catch(ElementNotFoundException e){
			LOGGER.warn("There are no elements found by link text");
		}
	}	
	@When ("I open cart")
	public void iOpenCart (){
		try{
		driver.findElement(By.id("gh-cart")).click();
		}
		catch(ElementNotFoundException e){
			LOGGER.warn("There are no elements found by link text");
		}		
	}	
	@When ("I delete product from cart")
	public  void iDeleteProductFromCart (){
		try{
		driver.findElement(By.linkText("Удалить")).click();
		}
		catch(ElementNotFoundException e){
			LOGGER.warn("There are no elements found by link text");
		}
	}	
	@When ("I refresh the page")
	public void iRefreshThePage (){	
		LOGGER.info("Refreshing current page");
		driver.navigate().refresh();
	}	
	@When ("I move to the main page")
	public void iMoveToTheMainPage (){
		try{
		driver.findElement(By.id("gh-la")).click();
		}
		catch(ElementNotFoundException e){
			LOGGER.warn("There are no elements found by link text");
		}
	}	
	@Then("the product <productName> is in a cart")
	public void theProductIsInACart(@Named ("productName")String productName){
		String bodyText = driver.findElement(By.tagName("body")).getText();
		LOGGER.info("Taking screenshot of the page");
		utils.takeScreenshot(driver);
		Assert.assertTrue(bodyText.contains(productName));		
	}	
	@Then ("the cart isn't empty")
	public void theCartIsntEmpty () {
		WebElement body = driver.findElement(By.tagName("body"));
		String bodyText = body.getText();
		utils.highlightElement(driver, body);
		LOGGER.info("Taking screenshot of the page");
		utils.takeScreenshot(driver);
		Assert.assertFalse(bodyText.contains("Your shopping cart is empty"));		
	}	
	@Then ("the cart is empty")
	public void theCartIsEmpty () {
		String bodyText = driver.findElement(By.tagName("body")).getText();
		LOGGER.info("Taking screenshot of the page");
		utils.takeScreenshot(driver);
		Assert.assertTrue(bodyText.contains("Your shopping cart is empty"));
		
	}	
	@Then ("the cart contains $number items")
	public void theCartContainsItems(@Named("number")String number){
	    String productsInCart = (driver.findElement(By.xpath("//*[@id=\"gh-cart-n\"]")).getText());
		LOGGER.info("Taking screenshot of the page");
	    utils.takeScreenshot(driver);
		Assert.assertEquals(number, productsInCart);		
	}
	 @AfterStories
	    public static void closeSelenium(){
	        Driver.close();
	    }		
}