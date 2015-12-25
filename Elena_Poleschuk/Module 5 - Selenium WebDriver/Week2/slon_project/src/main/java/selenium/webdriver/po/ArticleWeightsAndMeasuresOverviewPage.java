package selenium.webdriver.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ArticleWeightsAndMeasuresOverviewPage extends AbstractPage {

	@FindBy(id = "ext-gen56")
	private WebElement buttonCreateArticle;

	@FindBy(id = "searchValue-partOverview")
	private WebElement fieldQuickSearch;

	public ArticleWeightsAndMeasuresOverviewPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public ArticleDetailsPage startToCreateArticleViaCreateButton() {
		buttonCreateArticle.click();
		return PageFactory.initElements(driver, ArticleDetailsPage.class);
	}

	public boolean findSupplierArticleByNumberViaSearch(String supplierArticleNumber) { 
		return driver.findElements(By.linkText(supplierArticleNumber)).size() > 0;  //?
	}

	public ArticleDetailsPage openDetailsSupplierArticle(String supplierArticleNumber) {
		WebElement fieldArticleNumber = driver.findElement(By.linkText(supplierArticleNumber));
		fieldArticleNumber.click();
		return PageFactory.initElements(driver, ArticleDetailsPage.class);
	}

}
