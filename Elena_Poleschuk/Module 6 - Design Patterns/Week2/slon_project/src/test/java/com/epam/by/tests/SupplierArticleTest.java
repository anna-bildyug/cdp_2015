package com.epam.by.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.epam.by.buisinessobject.StaticFactorySupplierArticle;
import com.epam.by.buisinessobject.SupplierArticle;
import com.epam.by.ui.pages.SupplierArticleDetailsPage;
import com.epam.by.ui.pages.ArticleWeightsAndMeasuresOverviewPage;
import com.epam.by.ui.pages.LogisticsAndSettingsPage;
import com.epam.by.utils.DateUtils;
import com.epam.by.utils.ScreenShotsUtils;

public class SupplierArticleTest extends BaseTest {

	@Test(enabled = true)
	public void createNewSupplierArticle() {
		String supplierArticleNumber = "Article N" + DateUtils.getFullDateRestrictedYear();
		SupplierArticle supplierArticle = StaticFactorySupplierArticle
				.createFullFilledDefaultSupplierArticle(supplierArticleNumber);
		LogisticsAndSettingsPage logisticsAndSettingsPage = new LogisticsAndSettingsPage(driver);
		ArticleWeightsAndMeasuresOverviewPage articleWeightsAndMeasuresOverview = logisticsAndSettingsPage
				.openArticleWeightsAndMeasuresOverview();
		SupplierArticleDetailsPage articleDetailsPage = articleWeightsAndMeasuresOverview
				.startToCreateArticleViaCreateButton();
		articleDetailsPage.enterDataFromObject(supplierArticle);
		articleDetailsPage.saveSupplierArticle();
		articleDetailsPage.backFromSupplierArticle();
		Assert.assertTrue(articleWeightsAndMeasuresOverview.isSupplierArticlePresent(supplierArticleNumber),
				"Article is not found");
	}

	@Test(enabled = false)
	public void saveEmptySupplierArticle() {
		LogisticsAndSettingsPage logisticsAndSettingsPage = new LogisticsAndSettingsPage(driver);
		ArticleWeightsAndMeasuresOverviewPage articleWeightsAndMeasuresOverview = logisticsAndSettingsPage
				.openArticleWeightsAndMeasuresOverview();
		SupplierArticleDetailsPage articleDetailsPage = articleWeightsAndMeasuresOverview
				.startToCreateArticleViaCreateButton();
		articleDetailsPage.saveSupplierArticle();
		// TakeScreenShots.takeScreenShotWithHighlightElement(driver.findElement(By.xpath("id('statusTable')/tbody/tr")),
		// driver);
		Assert.assertTrue(articleDetailsPage.getStatusMsg().contains("is not valid"), "No message or it is incorrect");
	}

}
