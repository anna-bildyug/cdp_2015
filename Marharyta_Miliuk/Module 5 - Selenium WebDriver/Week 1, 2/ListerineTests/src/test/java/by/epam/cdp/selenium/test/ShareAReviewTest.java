package by.epam.cdp.selenium.test;

import java.util.ArrayList;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;
import by.epam.cdp.selenium.pages.MainPage;
import by.epam.cdp.selenium.pages.ProductPage;
import by.epam.cdp.selenium.pages.ProductsPage;
import by.epam.cdp.selenium.pages.ReviewPage;

public class ShareAReviewTest extends CommonTest {
 
	
	MainPage main;
	ProductPage product;
	ProductsPage prodlist;
	ReviewPage review;
	
	private String textToFind;
	private String summary;
	private String reviewText;
	private String age;
	private String state;
	
	@Factory(dataProvider = "dataProvider")
	   public ShareAReviewTest (String summary,String reviewText,String age,String state, String textToFind ){
		this.summary = summary;
		this.reviewText = reviewText;
		this.age = age;
		this.state = state;	  
		this.textToFind = textToFind;
	  }
	  
	@DataProvider
	public static Object [][] dataProvider(){		  
		  return new Object [][] {{"Test summary", "testreview test review testreview test review test", "18-24","Colorado","Preview your review"},
			                      {"","","","","We're sorry, but we have encountered the following issue(s):"}};	 		  
	  }
	
    @Test(groups = "Review Tests")
    public void fillReviewForm (){
    	main = new MainPage(driver);
    	prodlist = main.clickOnProductsBar();
    	product = prodlist.clickOnProductLink();
    	review = product.clickReviewButton();
    	ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
    	driver.switchTo().window(tabs2.get(1));   
    	review.rateProductWithStars();
    	review.enterReviewSummary(summary);
    	review.enterReviewText(reviewText);
    	review.recommendProduct();
    	review.selectAge(age);
    	review.selectState(state);
    	review.agreeWithTerms();
    	review = review.viewPreview();
		String bodyText = driver.findElement(By.tagName("body")).getText();
		Assert.assertTrue(bodyText.contains(textToFind), textToFind);
    	}
}
