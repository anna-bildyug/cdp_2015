package by.epam.cdp.framework.pages;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import by.epam.cdp.framework.utils.TestUtils;

public class ReviewPage extends Page {
	
	TestUtils utils = new TestUtils();

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
		utils.scrollDown(starsRating);
		starsRating.click();
	}
	public void enterReviewSummary (String summary){
		utils.scrollDown(reviewSummaryField);
		reviewSummaryField.sendKeys(summary);
	}
	public void enterReviewText (String review){
		utils.scrollDown(reviewTextField);
		reviewTextField.sendKeys(review);
		
	}
	public void recommendProduct (){
		utils.scrollDown(recommendRadioButton);
		recommendRadioButton.click();
	}
	public void selectState (String state){
		utils.scrollDown(recommendRadioButton);
		Select select = new Select(stateDropdown);
		select.selectByVisibleText(state);
	}
	public void selectAge (String age) throws IOException{
		utils.scrollDown(ageDropdown);
		utils.highlightElement(ageDropdown);
		utils.takeScreenshot();
		Select select = new Select (ageDropdown);
		select.selectByVisibleText(age);
	}
	public void agreeWithTerms (){
		utils.scrollDown(agreeCheckBox);
		agreeCheckBox.click();
	}
	public ReviewPage viewPreview(){
		utils.scrollDown(previewButton);
		previewButton.click();
		return new ReviewPage(driver);
	}
	public WebElement getSubmitButton(){
		utils.scrollDown(submitButton);
		return submitButton;
	}
	public String getTextFromPage (){
		return reviewPage.getText();
	}
}