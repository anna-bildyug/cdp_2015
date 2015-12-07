package by.epam.cdp.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class Page {

	protected final WebDriver driver;
	
    public Page(WebDriver driver){
    	this.driver = driver;
    	PageFactory.initElements(this.driver, this);
    }
    
    public WebDriver getDriver(){
    	return this.driver;
    }
    public Boolean isElementPresent (By locator){
    	return driver.findElements(locator).size() > 0;
    }
}
