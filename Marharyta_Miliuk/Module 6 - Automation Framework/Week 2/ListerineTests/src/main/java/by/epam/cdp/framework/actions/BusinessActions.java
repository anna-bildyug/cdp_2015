package by.epam.cdp.framework.actions;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import by.epam.cdp.framework.driver.Browser;
import by.epam.cdp.framework.pages.ArticlePage;
import by.epam.cdp.framework.pages.MainPage;
import by.epam.cdp.framework.pages.ProductPage;
import by.epam.cdp.framework.pages.ProductsPage;
import by.epam.cdp.framework.pages.ReviewPage;
import by.epam.cdp.framework.utils.TestUtils;

public class BusinessActions {

	public String leaveAReview (String summary, String text, String age, String state) throws IOException{
		MainPage main = new MainPage(Browser.initBrowser());
        ProductsPage prodlist = main.clickOnProductsBar();
        ProductPage product = prodlist.clickOnProductLink();
		ReviewPage review = product.clickReviewButton();
		TestUtils utils = new TestUtils();
		utils.switchBrowserTab();
		Review filledReviewForm = new ButtonsDecorator(new TextFiledsDecorator(new BaseReview()));
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