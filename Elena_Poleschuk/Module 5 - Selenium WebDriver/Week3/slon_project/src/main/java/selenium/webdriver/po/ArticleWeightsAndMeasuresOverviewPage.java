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
	
	@FindBy(xpath = "id('globalSimpleSearch-partOverview')/table/tbody/tr/td/button[1]")
	private WebElement buttonQuickSearch;
	
	@FindBy(xpath = "//html//div[1]/table/tbody/tr/td[3]/div/a")
	private WebElement firstArticleNumber;	

	public ArticleWeightsAndMeasuresOverviewPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public ArticleDetailsPage startToCreateArticleViaCreateButton() {
		buttonCreateArticle.click();
		return PageFactory.initElements(driver, ArticleDetailsPage.class);
	}

	public boolean isSupplierArticleByNumber(String supplierArticleNumber) { 
		fieldQuickSearch.sendKeys(supplierArticleNumber);
		buttonQuickSearch.click();
		return driver.findElements(By.linkText(supplierArticleNumber)).size() > 0; 
	}

	public ArticleDetailsPage openDetailsSupplierArticle(String supplierArticleNumber) {
		WebElement fieldArticleNumber = driver.findElement(By.linkText(supplierArticleNumber));
		fieldArticleNumber.click();
		return PageFactory.initElements(driver, ArticleDetailsPage.class);
	}
		

}
