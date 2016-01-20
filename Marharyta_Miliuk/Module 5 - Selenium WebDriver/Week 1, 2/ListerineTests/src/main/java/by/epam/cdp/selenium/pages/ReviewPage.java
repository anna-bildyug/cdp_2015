package by.epam.cdp.selenium.pages;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ReviewPage extends Page {

	@FindBy (id = "star_link_rating_5")
	private WebElement starsRating;
	
	@FindBy (name = "title")
	private WebElement reviewSummaryField;
	
	@FindBy (name = "reviewtext")
	private WebElement reviewTextField;
	
	@FindBy (id = "BVFieldRecommendYesID")
	private WebElement recommendRadioButton;
	
	@FindBy (id  = "BVFieldContextdatavalueStateID")
	private WebElement stateDropdown;
	
	@FindBy (name = "contextdatavalue_Age")
	private WebElement ageDropdown;
	
	@FindBy (name = "agreedtotermsandconditions")
	private WebElement agreeCheckBox;
	
	@FindBy (css = "#BVButtonPreviewID > button")
	private WebElement previewButton;
	
	@FindBy (css = "#BVButtonSubmitID > button")
	private WebElement submitButton;
	
	@FindBy (tagName = "body" )
	private WebElement reviewPage;
	

	public ReviewPage(WebDriver driver){ 
        super(driver);
        PageFactory.initElements(this.driver, ReviewPage.class);
    }
	
	public void rateProductWithStars (){
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView(true);",starsRating);
		starsRating.click();
	}
	public void enterReviewSummary (String summary){
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView(true);",reviewSummaryField);
		reviewSummaryField.sendKeys(summary);
	}
	public void enterReviewText (String review){
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView(true);",reviewTextField);
		reviewTextField.sendKeys(review);
		
	}
	public void recommendProduct (){
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView(true);",recommendRadioButton);
		recommendRadioButton.click();
	}
	public void selectState (String state){
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView(true);",stateDropdown);
		Select select = new Select(stateDropdown);
		select.selectByVisibleText(state);
	}
	public void selectAge (String age){
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView(true);",ageDropdown);
		Select select = new Select (ageDropdown);
		select.selectByVisibleText(age);
	}
	public void agreeWithTerms (){
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView(true);",agreeCheckBox);
		agreeCheckBox.click();
	}
	public ReviewPage viewPreview(){
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView(true);",previewButton);
		previewButton.click();
		return new ReviewPage(driver);
	}
	public WebElement getSubmitButton(){
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView(true);",submitButton);
		return submitButton;
	}
	public String getTextFromPage (){
		return reviewPage.getText();
	}
}