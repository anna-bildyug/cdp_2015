package com.epam.by.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ItemDetailsPage extends AbstractPage {

	public ItemDetailsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@FindBy(xpath = ".//*[@id='itemTitle']")
	private WebElement itemName;

	@FindBy(xpath = ".//*[@id='isCartBtn_btn']")
	private WebElement cardButton;

	public String getItemName() {
		return itemName.getText();
	}

}
