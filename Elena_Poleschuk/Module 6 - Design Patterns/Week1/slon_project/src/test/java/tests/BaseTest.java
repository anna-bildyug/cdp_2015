package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import core.webdriver.WebDriverSingleton;
import runner.TestProperties;
import ui.pages.LoginPage;
import ui.pages.MainMenu;

public class BaseTest {

	protected static TestProperties testProperties;

	protected WebDriver driver;

	protected String USERNAME;
	protected String PASSWORD;
	protected String URL;

	@BeforeClass
	public void initTestProperties() {

		testProperties = TestProperties.getInstance();
		USERNAME = testProperties.getUserName();
		PASSWORD = testProperties.getUserPassword();
		URL = testProperties.getURL();
		driver.get(URL);
		LoginPage loginPage = new LoginPage(driver);
		loginPage.logIn(USERNAME, PASSWORD);
	}

	@BeforeClass
	public void initBrowser() {
		driver = WebDriverSingleton.getInstance();
	}

	@BeforeClass
	public void openLogisticsAndSettingsPage() {
		driver.switchTo().defaultContent();
		MainMenu mainMenu = new MainMenu(driver);
		mainMenu.openLogisticsAndSettingsPage();
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
	}

	@AfterClass
	public void stopBrowser() {
		WebDriverSingleton.closeBrowser();
	}
}
