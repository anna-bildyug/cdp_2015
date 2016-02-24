package com.epam.by.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.epam.by.utils.LogSaver;

public class ArticleWeightsAndMeasuresOverviewPage extends AbstractPage {

	@FindBy(id = "ext-gen56")
	private WebElement buttonCreateArticle;

	@FindBy(id = "searchValue-partOverview")
	private WebElement fieldQuickSearch;

	@FindBy(xpath = "id('globalSimpleSearch-partOverview')/table/tbody/tr/td/button[1]")
	private WebElement buttonQuickSearch;

	@FindBy(xpath = "//html//div[1]/table/tbody/tr/td[3]/div/a")
	private WebElement firstArticleNumber;

	public ArticleWeightsAndMeasuresOverviewPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public SupplierArticleDetailsPage startToCreateArticleViaCreateButton() {
		buttonCreateArticle.click();
		LogSaver.getLogger().info("Open Article Weights And Measures Overview Page");
		return PageFactory.initElements(driver, SupplierArticleDetailsPage.class);
	}

	public boolean isSupplierArticlePresent(String supplierArticleNumber) {
		fieldQuickSearch.sendKeys(supplierArticleNumber);
		buttonQuickSearch.click();
		LogSaver.getLogger().info("Start Quick Search using Supplier Article Number" + supplierArticleNumber);
		return driver.findElements(By.linkText(supplierArticleNumber)).size() > 0;
	}

	public SupplierArticleDetailsPage openDetailsSupplierArticle(String supplierArticleNumber) {
		WebElement fieldArticleNumber = driver.findElement(By.linkText(supplierArticleNumber));
		fieldArticleNumber.click();
		LogSaver.getLogger().info("Open Supplier Article Details page");
		return PageFactory.initElements(driver, SupplierArticleDetailsPage.class);
	}

}
