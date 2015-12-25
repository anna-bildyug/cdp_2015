package selenium.webdriver.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import selenium.webdriver.po.ArticleDetailsPage;
import selenium.webdriver.po.ArticleWeightsAndMeasuresOverviewPage;
import selenium.webdriver.po.LoginPage;
import selenium.webdriver.po.LogisticsAndSettingsPage;
import selenium.webdriver.po.MainMenu;

public class SupplierArticleTest {

	private WebDriver driver;

	@BeforeMethod
	public void prepare() {
		driver = new FirefoxDriver();
		driver.get(LoginPage.URL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void createNewSupplierArticle() {
		String supplierArticleNumber = "Article N" + System.currentTimeMillis();

		LoginPage loginPage = new LoginPage(driver);
		loginPage.logIn();

		LogisticsAndSettingsPage logisticsAndSettingsPage = new LogisticsAndSettingsPage(driver);
		logisticsAndSettingsPage.openArticleWeightsAndMeasuresOverview();

		ArticleWeightsAndMeasuresOverviewPage articleWeightsAndMeasuresOverview = new ArticleWeightsAndMeasuresOverviewPage(
				driver);
		articleWeightsAndMeasuresOverview.startToCreateArticleViaCreateButton();

		ArticleDetailsPage articleDetailsPage = new ArticleDetailsPage(driver);
		articleDetailsPage.enterSupplierArticleNumber(supplierArticleNumber);
		articleDetailsPage.saveSupplierArticle();
		driver.navigate().back();

		Assert.assertTrue(
				articleWeightsAndMeasuresOverview.findSupplierArticleByNumberViaSearch(supplierArticleNumber));

		articleWeightsAndMeasuresOverview.openDetailsSupplierArticle(supplierArticleNumber);

		Assert.assertEquals(articleDetailsPage.getArticalValueInDetailsPage(), supplierArticleNumber);

		MainMenu mainMenu = new MainMenu(driver);
		mainMenu.logout();
	}

	@AfterMethod
	public void cleanUp() {
		driver.quit();
	}

}
