package by.epam.cdp.selenium.pages;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ProductsPage extends Page {
	
	@FindBy (partialLinkText = "ORIGINAL")
	private WebElement productLink;
	
	@FindBy (className = "fsrCloseBtn")
	private WebElement foreseeCloseButton;
	
	public ProductsPage(WebDriver driver){ 
        super (driver);
        PageFactory.initElements(this.driver, driver);
    }
	
	public void clickForeseeClose (){
		foreseeCloseButton.click();
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
	
	

	

}
