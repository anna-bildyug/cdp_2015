package com.epam.by.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.epam.by.ui.pages.login.LoginPage;

public class MainMenu extends AbstractPage {

	@FindBy(xpath = "//*[@id='spinnav']/li[2]/div[2]/span/div")
	private WebElement menuServices;

	@FindBy(linkText = "Log Out")
	private WebElement menuLogOut;

	public MainMenu(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public LogisticsAndSettingsPage openLogisticsAndSettingsPage() {
		new Actions(driver).moveToElement(menuServices).build().perform();
		WebElement menuOption = driver.findElement(By.xpath("//*[@id='spinnav']/li[2]/div[4]/ul/li[3]/a/div"));
		menuOption.click();
		return PageFactory.initElements(driver, LogisticsAndSettingsPage.class);
	}

	public LoginPage logout() {
		menuLogOut.click();
		return PageFactory.initElements(driver, LoginPage.class);
	}
}
