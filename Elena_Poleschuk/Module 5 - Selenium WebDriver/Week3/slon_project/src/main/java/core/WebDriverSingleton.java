package core;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverSingleton {

	private static WebDriver driver;
	private static WebDriverSingleton instance = null;
	private WebDriver Mozilla = null;

	private WebDriverSingleton() {
	}

	public static WebDriverSingleton getInstance() {
		if (instance == null) {
			instance = new WebDriverSingleton();
		}
		return instance;
	}

	public WebDriver openBrowser() {
		if (Mozilla == null) {
			driver = new FirefoxDriver();
			Mozilla = driver;
		} else if (Mozilla != null) {
			driver = Mozilla;
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

	public static void closeBrowser() {
		driver.quit();
		instance = null;
	}
}
