package by.epam.cdp.selenium.actions;
import java.util.List;

import org.openqa.selenium.WebElement;

import by.epam.cdp.selenium.driver.Driver;
import by.epam.cdp.selenium.pages.MainPage;
import by.epam.cdp.selenium.pages.ProductPage;
import by.epam.cdp.selenium.pages.ProductsPage;
import by.epam.cdp.selenium.pages.ReviewPage;
import by.epam.cdp.selenium.utils.TestUtils;

public class Actions {

	public String leaveAReview (String summary, String text, String age, String state){
		MainPage main = new MainPage(Driver.getInstance());
        ProductsPage prodlist = main.clickOnProductsBar();
        ProductPage product = prodlist.clickOnProductLink();
		ReviewPage review = product.clickReviewButton();
		TestUtils utils = new TestUtils();
		utils.switchBrowserTab();
		review.enterReviewSummary(summary);
		review.enterReviewText(text);
		review.rateProductWithStars();
		review.recommendProduct();
		review.selectAge(age);
		review.selectState(state);
		review.agreeWithTerms();
		review.viewPreview();
		return review.getTextFromPage();
	}
	
	public List<WebElement> filterProductsList(String filterID){
		MainPage main = new MainPage(Driver.getInstance());
		ProductsPage prodlist = main.clickOnProductsBar();
		prodlist.filterProductList(filterID);
		prodlist.clickFilterButton();
		return prodlist.filteredProducts();
	}
}