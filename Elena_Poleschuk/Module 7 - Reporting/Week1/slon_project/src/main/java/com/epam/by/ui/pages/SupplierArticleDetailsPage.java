package com.epam.by.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.epam.by.buisinessobject.SupplierArticle;
import com.epam.by.utils.LogSaver;

public class SupplierArticleDetailsPage extends AbstractPage {

	public SupplierArticleDetailsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@FindBy(id = "ext-comp-1111")
	private WebElement fieldSupplierArticleNumber;

	@FindBy(xpath = "//input[@name='description']")
	private WebElement fieldSupplierArticleDescription;

	@FindBy(xpath = "//button[text() = 'Save']")
	private WebElement buttonSave;

	@FindBy(xpath = "//div[2]/div/table//td[1]//td[1]//button[text() = 'Back']")
	private WebElement buttonBack;

	@FindBy(xpath = "id('statusTable')/tbody/tr")
	private WebElement statusMsg;

	public SupplierArticleDetailsPage enterDataFromObject(SupplierArticle articleData) {
		enterSupplierArticleNumber(articleData.getArticleName());
		enterSupplierArticleDescription(articleData.getArticleDescription());
		LogSaver.getLogger().info("Enter Data from Supplier Article Object");
		return this;
	}

	public SupplierArticleDetailsPage enterSupplierArticleNumber(String supplierArticleNumber) {
		fieldSupplierArticleNumber.sendKeys(supplierArticleNumber);
		LogSaver.getLogger().info("Enter Supplier Article Number");
		return this;
	}

	public SupplierArticleDetailsPage enterSupplierArticleDescription(String supplierArticleDescription) {
		fieldSupplierArticleDescription.sendKeys(supplierArticleDescription);
		LogSaver.getLogger().info("Enter Supplier Article Description");
		return this;
	}

	public void saveSupplierArticle() {
		new Actions(driver).moveToElement(buttonSave).build().perform();
		new Actions(driver).click(buttonSave).build().perform();
		LogSaver.getLogger().info("Click on Save Button");
	}

	public void backFromSupplierArticle() {
		new Actions(driver).moveToElement(buttonBack).build().perform();
		new Actions(driver).click(buttonBack).build().perform();
		LogSaver.getLogger().info("Click on Back Button");
	}

	public String getStatusMsg() {
		String statusMsgText = statusMsg.getText();
		LogSaver.getLogger().info("Status message is " + statusMsgText);
		return statusMsgText;
	}

}
