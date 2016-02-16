package by.epam.cdp.selenium.actions;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import by.epam.cdp.selenium.browser.Browser;
import by.epam.cdp.selenium.pages.ArticlePage;
import by.epam.cdp.selenium.pages.MainPage;
import by.epam.cdp.selenium.pages.ProductPage;
import by.epam.cdp.selenium.pages.ProductsPage;
import by.epam.cdp.selenium.pages.ReviewPage;
import by.epam.cdp.selenium.utils.TestUtils;

public class BusinessActions {

	public String leaveAReview (String summary, String text, String age, String state) throws IOException{
		MainPage main = new MainPage(Browser.initBrowser());
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
	
	public List<WebElement> filterProductsList(String filterID) throws IOException{
		MainPage main = new MainPage(Browser.initBrowser());
		ProductsPage prodlist = main.clickOnProductsBar();
		prodlist.filterProductList(filterID);
		prodlist.clickFilterButton();
		prodlist.clickForeseeClose();
		return prodlist.filteredProducts();
	}
	
	public void findLinkOnArticlePage (){
		MainPage main = new MainPage(Browser.initBrowser());
		ArticlePage article = main.openArticle();
		try{
			main.clickForeseeClose();	}
			catch (NoSuchElementException e){
				
			}
		TestUtils utils = new TestUtils();
		utils.highlightElement(article.textToFind());
		utils.takeScreenshot();		
	}
}