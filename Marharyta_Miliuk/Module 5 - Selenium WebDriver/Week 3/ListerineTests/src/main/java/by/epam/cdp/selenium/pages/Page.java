package by.epam.cdp.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import by.epam.cdp.selenium.driver.Driver;

public abstract class Page {

	protected WebDriver driver = Driver.getInstance();
	
    public Page(WebDriver driver){
    	this.driver = driver;
    	PageFactory.initElements(this.driver, this);}
       
    @FindBy (className = "fsrDeclineButtonContainer")
	private WebElement foreseeCloseButton;
    
	public void clickForeseeClose (){
		foreseeCloseButton.click();
	}  
    public WebDriver getDriver(){
    	return this.driver;
    }
    public Boolean isElementPresent (By locator){
    	return driver.findElements(locator).size() > 0;
    }   
}