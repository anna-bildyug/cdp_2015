package by.epam.cdp.framework.actions;

import java.io.IOException;

import by.epam.cdp.framework.driver.Browser;
import by.epam.cdp.framework.pages.ReviewPage;

public class TextFiledsDecorator extends ReviewDecorator{
	
	private String summary;
	private String reviewText;
	private String age;
	private String state;

	public TextFiledsDecorator(Review reviewToBeFilled) {
		super(reviewToBeFilled);
	}
	
	@Override
	public void fillReview (){
		super.fillReview();
		try{
		fillTextFields(summary, reviewText, age, state);
		}
		catch (IOException e){
			e.printStackTrace();
		};
		
	}
	
	private void fillTextFields (String summary, String reviewText, String age, String state) throws IOException{
		ReviewPage review = new ReviewPage(Browser.initBrowser());
		review.enterReviewSummary(summary);
		review.enterReviewText(reviewText);
		review.selectAge(age);
		review.selectState(state);
	}

}
