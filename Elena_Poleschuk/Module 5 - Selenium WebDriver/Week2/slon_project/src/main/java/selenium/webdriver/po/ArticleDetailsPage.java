package selenium.webdriver.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ArticleDetailsPage extends AbstractPage {

	public ArticleDetailsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@FindBy(id = "ext-comp-1111")
	private WebElement fieldSupplierArticleNumber;

	@FindBy(id = "ext-gen183")
	private WebElement buttonSave;

	public ArticleDetailsPage enterSupplierArticleNumber(String supplierArticleNumber) {
		fieldSupplierArticleNumber.sendKeys(supplierArticleNumber);
		return this;
	}

	public ArticleDetailsPage saveSupplierArticle() {
		buttonSave.click();
		return this;
	}

	public String getArticalValueInDetailsPage() {
		return fieldSupplierArticleNumber.toString();
	}
}
