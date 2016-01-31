package com.epam.by.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends AbstractPage {

	@FindBy(xpath = ".//*[@id='email']")
	private WebElement emailField;

	@FindBy(xpath = ".//*[@id='remail_w']")
	private WebElement emailReenterField;

	@FindBy(xpath = ".//*[@id='email']")
	private WebElement errorEmailNotification;

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
		emailField.sendKeys(email);
		return this;
	}

	/*
	 * @FindBy(xpath = ".//*[@id='PASSWORD']") private WebElement passwordField;
	 * 
	 * public RegisterPage setPassword(String password){
	 * emailField.sendKeys(password); return this; }
	 */

	// change focus
	public RegisterPage leaveField() {
		new Actions(driver).moveByOffset(1, 1).build().perform();
		return this;
	}

	public String getErrorEmailNotification() {
		return errorEmailNotification.getText();
	}

}
