package by.epam.cdp.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends Page {	
	
	@FindBy(linkText = "Products")
	private WebElement productsBar;

	public MainPage(WebDriver driver){ 
        super (driver);
        PageFactory.initElements(this.driver, driver);
    }
	
	public ProductsPage clickOnProductsBar (){
		productsBar.click();
		return new ProductsPage(driver);
		
	}
}
