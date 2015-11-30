package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import pages_usage.CommonMethods;

public class BaseTests{
	private final static String URL = "https://platform-scmpl";
	private final static String LOGIN = "Admin";
	private final static String PASSWORD = "pass";
	WebDriver driver;
	
	@BeforeSuite
	public void openMainPage(){
	/*	System.setProperty("webdriver.chrome.driver",
				"C:/Users/Elena/AppData/Local/Google/Chrome/Application/chromedriver.exe");*/
		System.setProperty("webdriver.chrome.driver",
				"C:/WebDriverChrome/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		CommonMethods.openApplication(driver, URL);
		CommonMethods.login(driver, LOGIN, PASSWORD);
		CommonMethods.openMainPage(driver);
	}
	
	@AfterMethod
	public void returnToMainPage(){
		CommonMethods.openMainPage(driver);
	}
	
	@AfterSuite
	public void closeDriver(){
		driver.close();
	}
}
