package com.epam.by.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage extends AbstractPage {

	public SearchResultPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@FindBy(xpath = ".//*[@id='ListViewInner']/li[1]")
	private WebElement searchField;

	@FindBy(xpath = ".//*[@id='ListViewInner']/li[1]/h3/a")
	private WebElement firstItemName;

	@FindBy(xpath = ".//*[@id='ListViewInner']/li[1]//img")
	private WebElement firstItemImage;

	public String getFirstNameInTheSearchResultGrid() {
		return searchField.getText();
	}

	public String getFirstItemName() {
		return firstItemName.getText();
	}

	public ItemDetailsPage pressFirstItemName() {
		firstItemName.click();
		return PageFactory.initElements(driver, ItemDetailsPage.class);
	}

	public ItemDetailsPage pressFirstItemImage() {
		firstItemImage.click();
		return PageFactory.initElements(driver, ItemDetailsPage.class);
	}

}
