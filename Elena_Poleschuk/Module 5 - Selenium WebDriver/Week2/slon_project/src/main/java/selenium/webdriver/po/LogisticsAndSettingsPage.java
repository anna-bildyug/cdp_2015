package selenium.webdriver.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogisticsAndSettingsPage extends AbstractPage{

	public LogisticsAndSettingsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@FindBy(xpath = "//span[contains(text()='Packing Process')]")
	private WebElement packingMenu;
	
	@FindBy(linkText = "Article Weights and Measures")
	private WebElement packingMenuArticleWeightsAndMeasures;
	
	public ArticleWeightsAndMeasuresOverviewPage openArticleWeightsAndMeasuresOverview(){
		new Actions(driver).moveToElement(packingMenu);
		new Actions(driver).click(packingMenuArticleWeightsAndMeasures);
		
		return PageFactory.initElements(driver, ArticleWeightsAndMeasuresOverviewPage.class);
	}
}
