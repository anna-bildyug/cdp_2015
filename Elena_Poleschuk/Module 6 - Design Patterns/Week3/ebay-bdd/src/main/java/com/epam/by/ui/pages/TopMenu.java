package com.epam.by.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TopMenu extends AbstractPage{

	public TopMenu(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}
	
   /* @FindBy(xpath = ".//*[@id='gh-cart']")
	private WebElement cardButton;*/
    
    @FindBy(xpath = ".//*[@id='gh-ug']")
	private WebElement accountDropDown;  // account or Sign in
    
    @FindBy(xpath = ".//*[@id='gh-uo']/a")
	private WebElement signOut; 
    
    @FindBy(xpath = ".//*[@id='gh-uid']")
	private WebElement userAccountID; 
    
    @FindBy(xpath = ".//*[@id='gh-ug-flex']/a")
	private WebElement register; 
    
 /*   public CardPage openCard(){
    	cardButton.click();
    	return PageFactory.initElements(driver, CardPage.class);
    }*/
    
    public String getURL(){
 		return driver.getCurrentUrl();
    }
    
    public MainPage signOut(){
    	new Actions(driver).moveToElement(accountDropDown).build().perform();
    	signOut.click();
		return PageFactory.initElements(driver, MainPage.class);
    }
    
    public RegisterPage goToRegisterPage(){
    	register.click();
		return PageFactory.initElements(driver, RegisterPage.class);
    }
}
