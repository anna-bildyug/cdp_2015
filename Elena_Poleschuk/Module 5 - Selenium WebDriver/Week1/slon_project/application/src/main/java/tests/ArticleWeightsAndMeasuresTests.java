package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages_usage.ArticleWeightsAndMeasures;

public class ArticleWeightsAndMeasuresTests extends BaseTests{
	
	@Test
	public void createNewSupplierArticle() {
		String articleNumber = "Article N" + System.currentTimeMillis();
		// open Article Weights And Measures Overview
		ArticleWeightsAndMeasures.openArticleWeightsAndMeasuresOverview(driver);
		ArticleWeightsAndMeasures.startToCreateArticleViaCreateButton(driver);
		// enter article Number
		ArticleWeightsAndMeasures.enterSupplierArticleNumber(driver, articleNumber);
		// save
		ArticleWeightsAndMeasures.saveSupplierArticle(driver);
		// return to Order Overview
		driver.navigate().back();
		//find created article
		ArticleWeightsAndMeasures.findSupplierArticleByNumberViaSearch(driver, articleNumber);
		// open created article
		ArticleWeightsAndMeasures.openDetailsSupplierArticle(driver, articleNumber);
		Assert.assertEquals(ArticleWeightsAndMeasures.getArticalValueInDetailsPage(driver), articleNumber);
	}
}
