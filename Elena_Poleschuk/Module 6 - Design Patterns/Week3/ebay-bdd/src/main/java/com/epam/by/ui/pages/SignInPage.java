package com.epam.by.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage extends AbstractPage {

	public SignInPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@FindBy(xpath = ".//*[@id='userid']")
	private WebElement userNameField;

	@FindBy(xpath = ".//*[@id='pass']")
	private WebElement passwordField;

	@FindBy(xpath = ".//*[@id='sgnBt']")
	private WebElement signInButton;

	public void setUserName(String name) {
		userNameField.clear();
		userNameField.sendKeys(name);
	}

	public void setPassword(String pass) {
		passwordField.sendKeys(pass);
	}

	public MainPage pressSignInButton() {
		signInButton.click();
		return PageFactory.initElements(driver, MainPage.class);
	}

	public MainPage logIn(String name, String pass) {
		setUserName(name);
		setPassword(pass);
		return pressSignInButton();
	}

}
