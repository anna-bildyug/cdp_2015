package by.epam.cdp.framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends Page{
	
	@FindBy (xpath = "//*[@id=\"content\"]/div[4]/div/div/div[2]/div/div/div/span/div/a")
	private WebElement writeReviewButton;
	

	public ProductPage(WebDriver driver){ 
        super(driver);
        PageFactory.initElements(this.driver, this);
    }
	
	public ReviewPage clickReviewButton (){
		writeReviewButton.click();
		return new ReviewPage(driver);
	}

}
