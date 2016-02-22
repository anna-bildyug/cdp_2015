package by.epam.cdp.framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import by.epam.cdp.framework.utils.TestUtils;

public class MainPage extends Page {
	
	@FindBy(partialLinkText = "Products")
	private WebElement productsBar;
	
	@FindBy (linkText = "Fresh Breath")
	private WebElement articlesBar;
	
	@FindBy (partialLinkText = "Bad Breath")
	private WebElement articleLink;

	public MainPage(WebDriver driver){ 
        super (driver);
        PageFactory.initElements(this.driver, this);
    }
	
	public ProductsPage clickOnProductsBar (){
		productsBar.click();
		return new ProductsPage(driver);	
	}
	
	public ArticlePage openArticle (){
		TestUtils utils = new TestUtils();
		utils.hoverAndClick(articlesBar, articleLink);
		return new ArticlePage(driver);		
	}
}