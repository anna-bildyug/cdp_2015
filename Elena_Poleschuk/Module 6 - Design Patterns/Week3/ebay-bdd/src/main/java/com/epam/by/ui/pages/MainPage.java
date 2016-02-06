package com.epam.by.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends AbstractPage {

	public MainPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@FindBy(xpath = ".//*[@id='gh-ac']")
	private WebElement searchField;

	public MainPage setSearchRequest(String searchRequest) {
		searchField.sendKeys(searchRequest);
		return this;
	}

	@FindBy(xpath = ".//*[@id='gh-btn']")
	private WebElement searchButton;

	public SearchResultPage perfomSearch() {
		searchButton.click();
		return PageFactory.initElements(driver, SearchResultPage.class);
	}

	@FindBy(xpath = ".//*[@id='AreaTitle']//span")
	private WebElement notificationText;

	public String getNotificationText() {
		return notificationText.getText();
	}

}
