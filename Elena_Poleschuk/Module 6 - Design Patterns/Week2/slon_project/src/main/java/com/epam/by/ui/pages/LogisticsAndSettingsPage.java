package com.epam.by.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.epam.by.ui.structure.Frames;

public class LogisticsAndSettingsPage extends AbstractPage {

	public LogisticsAndSettingsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	// Packing
	@FindBy(id = "packagingMenuImg")
	private WebElement packingMenu;
	@FindBy(linkText = "Article Weights and Measures")
	private WebElement packingMenuArticleWeightsAndMeasures;

	public ArticleWeightsAndMeasuresOverviewPage openArticleWeightsAndMeasuresOverview() {
		Frames.switchToWebEDIFrame(driver);
		new Actions(driver).moveToElement(packingMenu).build().perform();
		new Actions(driver).moveToElement(packingMenuArticleWeightsAndMeasures).click().build().perform();
		Frames.switchToVMIFrame(driver);
		return PageFactory.initElements(driver, ArticleWeightsAndMeasuresOverviewPage.class);
	}

}
