package by.epam.cdp.selenium.test;

import org.testng.Assert;
import org.testng.annotations.*;
import by.epam.cdp.selenium.actions.Actions;

public class ShareAReviewTest extends CommonTest {
	
	private String textToFind;
	private String summary;
	private String reviewText;
	private String age;
	private String state;
	private String bodyText;
	
	@Factory(dataProvider = "reviewFormInfo")
	   public ShareAReviewTest (String summary,String reviewText,String age,String state, String textToFind ){
		this.summary = summary;
		this.reviewText = reviewText;
		this.age = age;
		this.state = state;	  
		this.textToFind = textToFind;
	  }
	  
	@DataProvider
	public static Object [][] reviewFormInfo(){		  
		  return new Object [][] {{"Test summary", "testreview test review testreview test review test", "18-24","","Your State is required"},
			                      {"Test summary", "testreview test review testreview test review test", "", "Colorado", "Age Range is required"},
		                          {"Test summary", "", "18-24", "Colorado", "You must enter review text"},
		                          {"", "testreview test review testreview test review test", "18-24", "Colorado", "You must enter a review title"}};	 		  
	  }
	
    @Test(groups = "Review Tests")
    public void fillReviewFormCorrectly (){
    	Actions action = new Actions();
		bodyText = action.leaveAReview("Test summary", "testreview test review testreview test review test", "18-24", "Colorado");
		Assert.assertTrue(bodyText.contains("Preview your review"), "Preview your review");
    	}
    
    @Test(groups = "Review Tests")
    public void fillReviewFormIncorrectly (){
    	Actions action = new Actions();
    	bodyText = action.leaveAReview(summary, reviewText, age, state);
		Assert.assertTrue(bodyText.contains(textToFind), textToFind);
    }
}