package com.epam.by.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.epam.by.utils.LogSaver;

public class LoginPage extends AbstractPage{

	@FindBy(id = "j_username")
	private WebElement loginInput;

	@FindBy(id = "j_password")
	private WebElement passwordInput;

	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public LogisticsAndSettingsPage logIn(String userName, String userPassword) {
		loginInput.sendKeys(userName);
		passwordInput.sendKeys(userPassword);
		passwordInput.submit();
		LogSaver.getLogger().info("LogIn in application");
		return PageFactory.initElements(driver, LogisticsAndSettingsPage.class);
	}

}
