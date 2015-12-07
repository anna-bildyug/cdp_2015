package by.epam.cdp.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends Page{
	
	@FindBy (linkText = "Write a review")
	private WebElement writeReviewButton;
	

	public ProductPage(WebDriver driver){ 
        super(driver);
        PageFactory.initElements(this.driver, driver);
    }
	
	public ReviewPage clickReviewButton (){
		writeReviewButton.click();
		return new ReviewPage(driver);
	}

}
