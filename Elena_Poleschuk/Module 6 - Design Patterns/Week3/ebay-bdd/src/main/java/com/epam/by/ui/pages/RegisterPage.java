package com.epam.by.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends AbstractPage {

	@FindBy(xpath = ".//*[@id='email']")
	private WebElement emailField;

	@FindBy(xpath = ".//*[@id='remail']")
	private WebElement emailReenterField;

	@FindBy(xpath = ".//*[@id='email_w']")
	private WebElement errorEmailNotification;
	
	@FindBy(xpath = ".//*[@id='sbtBtn']")
	private WebElement submitButton;

	public RegisterPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
		driver.switchTo().frame("regFrame");
		
	}

	public RegisterPage setEmail(String email) {
		emailField.sendKeys(email);
		return this;
	}

	public RegisterPage setReEmail(String email) {
		emailReenterField.sendKeys(email);
		return this;
	}

	public  RegisterPage pressSubmit (){
		submitButton.click();
		return this;
	}
	/*
	 * @FindBy(xpath = ".//*[@id='PASSWORD']") private WebElement passwordField;
	 * 
	 * public RegisterPage setPassword(String password){
	 * emailField.sendKeys(password); return this; }
	 */

	// change focus

	public String getErrorEmailNotification() {
		return errorEmailNotification.getText();
	}

}
