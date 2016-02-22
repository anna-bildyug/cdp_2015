package by.epam.cdp.framework.actions;

import by.epam.cdp.framework.driver.Browser;
import by.epam.cdp.framework.pages.ReviewPage;

public class ButtonsDecorator extends ReviewDecorator {

	public ButtonsDecorator(Review reviewToBeFilled) {
		super(reviewToBeFilled);
		}
	
	@Override
	public void fillReview (){
		super.fillReview();
		chooseFromDropdowns();
	}
	
	private void chooseFromDropdowns (){
		ReviewPage review = new ReviewPage(Browser.initBrowser());
		review.rateProductWithStars();
		review.recommendProduct();
		review.agreeWithTerms();
		review.viewPreview();
	}
}
