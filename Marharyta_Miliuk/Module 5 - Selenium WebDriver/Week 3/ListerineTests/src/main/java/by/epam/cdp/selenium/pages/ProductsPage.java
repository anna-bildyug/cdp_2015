package by.epam.cdp.selenium.pages;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import by.epam.cdp.selenium.utils.TestUtils;

public class ProductsPage extends Page {
	
	@FindBy (partialLinkText = "ORIGINAL")
	private WebElement productLink;
	
	@FindBy (id = "edit-submit-products")
	private WebElement filterResultsButton;
	
	@FindBy (partialLinkText = "Floss")
	private List<WebElement> flossProducts;
	
	public ProductsPage(WebDriver driver){ 
        super (driver);
        PageFactory.initElements(this.driver, this);
    }	
	public ProductPage clickOnProductLink(){
		try{
			clickForeseeClose();
			productLink.click(); }
		
		catch (NoSuchElementException|ElementNotVisibleException e){
		productLink.click();
       }
		return new ProductPage(driver);
	}	
	public void filterProductList (String filterID){
		try{
		clickForeseeClose();
        driver.findElement(By.id(filterID)).click();}
		
		catch (NoSuchElementException|ElementNotVisibleException e){
			driver.findElement(By.id(filterID)).click();
		}
	}
	public ProductsPage clickFilterButton () throws IOException{
		TestUtils utils = new TestUtils();
		utils.highlightElement(filterResultsButton);
		utils.takeScreenshot();
		filterResultsButton.click();
		return new ProductsPage(driver);
	}
	public List <WebElement> filteredProducts (){
		List <WebElement> filteredProducts;
		return filteredProducts = flossProducts;	
	}	
}