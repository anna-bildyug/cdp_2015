package com.epam.by.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import com.epam.by.core.webdriver.WebDriverSingleton;
import com.epam.by.runner.TestProperties;
import com.epam.by.ui.pages.LoginPage;
import com.epam.by.ui.pages.MainMenu;
import com.epam.by.ui.structure.Frames;

public class BaseTest {
	protected static TestProperties testProperties;
	protected WebDriver driver;

	protected String USERNAME;
	protected String PASSWORD;
	protected String URL;

	@BeforeClass
	public void initBrowser() {
		driver = WebDriverSingleton.getInstance();
	}

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
	public void openLogisticsAndSettingsPage() {
		Frames.switchToMainFrame(driver);
		MainMenu mainMenu = new MainMenu(driver);
		mainMenu.openLogisticsAndSettingsPage();
	}

	@AfterMethod
	public void returnToLogisticsAndSettingsPage() {
		Frames.switchToMainFrame(driver);
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
		driver.close();
		WebDriverSingleton.closeBrowser();

	}
}
