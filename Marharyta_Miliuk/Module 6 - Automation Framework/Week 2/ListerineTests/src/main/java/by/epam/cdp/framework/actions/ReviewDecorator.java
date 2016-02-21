package by.epam.cdp.framework.actions;

abstract class ReviewDecorator implements Review{
	
	protected Review reviewToBeFilled;
	
	public ReviewDecorator (Review reviewToBeFilled){
		this.reviewToBeFilled = reviewToBeFilled;
	}
	
	public void fillReview(){
		reviewToBeFilled.fillReview();
	}

}
