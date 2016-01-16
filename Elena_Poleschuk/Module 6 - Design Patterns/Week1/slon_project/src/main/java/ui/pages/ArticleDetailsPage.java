package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import buisinessobject.supplierarticle.SupplierArticle;

public class ArticleDetailsPage extends AbstractPage {

	public ArticleDetailsPage(WebDriver driver) {
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
	
	public ArticleDetailsPage enterDataFromObject(SupplierArticle articleData){
		enterSupplierArticleNumber(articleData.getArticleName());
		enterSupplierArticleDescription(articleData.getArticleDescription());
		return this;
	}

	public ArticleDetailsPage enterSupplierArticleNumber(String supplierArticleNumber) {
		fieldSupplierArticleNumber.sendKeys(supplierArticleNumber);
		return this;
	}
	
	public ArticleDetailsPage enterSupplierArticleDescription(String supplierArticleDescription) {
		fieldSupplierArticleDescription.sendKeys(supplierArticleDescription);
		return this;
	}

	public void saveSupplierArticle() {
		new Actions(driver).moveToElement(buttonSave).build().perform();
		new Actions(driver).click(buttonSave).build().perform();
	}
	
	public void backFromSupplierArticle() {
		new Actions(driver).moveToElement(buttonBack).build().perform();
		new Actions(driver).click(buttonBack).build().perform();
	}
	
	public String getStatusMsg(){
		return statusMsg.getText();
	}

}
