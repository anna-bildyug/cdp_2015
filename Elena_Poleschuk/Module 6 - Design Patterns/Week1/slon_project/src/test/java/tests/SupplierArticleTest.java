package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import buisinessobject.supplierarticle.StaticFactorySupplierArticle;
import buisinessobject.supplierarticle.SupplierArticle;
import ui.pages.ArticleDetailsPage;
import ui.pages.ArticleWeightsAndMeasuresOverviewPage;
import ui.pages.LogisticsAndSettingsPage;
import utils.DateUtils;
import utils.TakeScreenShots;

public class SupplierArticleTest extends BaseTest {

	@Test(enabled = true)
	public void createNewSupplierArticle() {
		String supplierArticleNumber = "Article N" + DateUtils.getFullDateRestrictedYear();
		SupplierArticle supplierArticle = StaticFactorySupplierArticle.createFullFilledDefaultSupplierArticle(supplierArticleNumber);
		LogisticsAndSettingsPage logisticsAndSettingsPage = new LogisticsAndSettingsPage(driver);
		ArticleWeightsAndMeasuresOverviewPage articleWeightsAndMeasuresOverview = logisticsAndSettingsPage
				.openArticleWeightsAndMeasuresOverview();
		ArticleDetailsPage articleDetailsPage = articleWeightsAndMeasuresOverview.startToCreateArticleViaCreateButton();
		articleDetailsPage.enterDataFromObject(supplierArticle);
		articleDetailsPage.saveSupplierArticle();
		articleDetailsPage.backFromSupplierArticle();
		Assert.assertTrue(articleWeightsAndMeasuresOverview.isSupplierArticleByNumber(supplierArticleNumber),
				"Article is not found");
	}

	@Test(enabled = false)
	public void saveEmptySupplierArticle() {
		LogisticsAndSettingsPage logisticsAndSettingsPage = new LogisticsAndSettingsPage(driver);
		ArticleWeightsAndMeasuresOverviewPage articleWeightsAndMeasuresOverview = logisticsAndSettingsPage
				.openArticleWeightsAndMeasuresOverview();
		ArticleDetailsPage articleDetailsPage = articleWeightsAndMeasuresOverview.startToCreateArticleViaCreateButton();
		articleDetailsPage.saveSupplierArticle();
		// TakeScreenShots.takeScreenShotWithHighlightElement(driver.findElement(By.xpath("id('statusTable')/tbody/tr")),
		// driver);
		Assert.assertTrue(articleDetailsPage.getStatusMsg().contains("is not valid"), "No message or it is incorrect");
	}

}
