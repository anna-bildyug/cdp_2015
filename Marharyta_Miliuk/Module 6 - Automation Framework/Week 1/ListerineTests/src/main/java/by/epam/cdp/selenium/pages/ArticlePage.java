package by.epam.cdp.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ArticlePage extends Page{

	public ArticlePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}
	
	@FindBy (partialLinkText = "FAQ")
	private WebElement textToFind;
	
	public WebElement textToFind (){
		return textToFind;
	}
}
