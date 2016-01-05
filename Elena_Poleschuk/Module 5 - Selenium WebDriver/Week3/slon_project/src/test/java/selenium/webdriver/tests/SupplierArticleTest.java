package selenium.webdriver.tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import core.WebDriverSingleton;
import selenium.webdriver.po.ArticleDetailsPage;
import selenium.webdriver.po.ArticleWeightsAndMeasuresOverviewPage;
import selenium.webdriver.po.LoginPage;
import selenium.webdriver.po.LogisticsAndSettingsPage;
import selenium.webdriver.po.MainMenu;
import utils.TakeScreenShots;

public class SupplierArticleTest {

	private WebDriver driver;
	// private WebDriverSingleton webDriverSingleton =
	// WebDriverSingleton.getInstance();

	@BeforeClass
	public void prepare() throws MalformedURLException {
		// driver = webDriverSingleton.openBrowser();

		// for grid
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setBrowserName("firefox");
		capabilities.setPlatform(Platform.WINDOWS);
		driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get(LoginPage.URL);
		LoginPage loginPage = new LoginPage(driver);
		loginPage.logIn();
	}

	@BeforeMethod
	public void swithToWebediFame() {
		driver.switchTo().frame("webedi_frame");
	}

	@Test(threadPoolSize = 2)
	public void createNewSupplierArticle() {
		String supplierArticleNumber = "Article N" + System.currentTimeMillis();

		LogisticsAndSettingsPage logisticsAndSettingsPage = new LogisticsAndSettingsPage(driver);
		ArticleWeightsAndMeasuresOverviewPage articleWeightsAndMeasuresOverview = logisticsAndSettingsPage
				.openArticleWeightsAndMeasuresOverview();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("vmi_frame");
		ArticleDetailsPage articleDetailsPage = articleWeightsAndMeasuresOverview.startToCreateArticleViaCreateButton();
		articleDetailsPage.enterSupplierArticleNumber(supplierArticleNumber);
		articleDetailsPage.saveSupplierArticle();
		articleDetailsPage.backFromSupplierArticle();

		Assert.assertTrue(articleWeightsAndMeasuresOverview.isSupplierArticleByNumber(supplierArticleNumber),
				"Article is not found");
	}

	@Test(threadPoolSize = 2)
	public void saveEmptySupplierArticle() {
		LogisticsAndSettingsPage logisticsAndSettingsPage = new LogisticsAndSettingsPage(driver);
		ArticleWeightsAndMeasuresOverviewPage articleWeightsAndMeasuresOverview = logisticsAndSettingsPage
				.openArticleWeightsAndMeasuresOverview();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("vmi_frame");
		ArticleDetailsPage articleDetailsPage = articleWeightsAndMeasuresOverview.startToCreateArticleViaCreateButton();
		articleDetailsPage.saveSupplierArticle();
		TakeScreenShots.takeScreenShotWithHighlightElement(driver.findElement(By.xpath("id('statusTable')/tbody/tr")),
				driver);
		Assert.assertTrue(articleDetailsPage.getStatusMsg().contains("is not valid"), "No message or it is incorrect");
	}

	@AfterMethod
	public void returnToLogisticsAndSettingsPage() {
		driver.switchTo().defaultContent();
		MainMenu mainMenu = new MainMenu(driver);
		mainMenu.openLogisticsAndSettingsPage();
	}

	@AfterClass
	public void cleanUp() {
		MainMenu mainMenu = new MainMenu(driver);
		mainMenu.logout();
		// WebDriverSingleton.closeBrowser();
		driver.quit();
	}

}
