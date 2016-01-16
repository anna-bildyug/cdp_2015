package core.webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverSingleton {

	private static WebDriver driver;

	private WebDriverSingleton() {
	}

	public static synchronized WebDriver getInstance() {
		if (driver == null) {
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		return driver;
	}

	public static void closeBrowser() {
		driver.quit();
		driver = null;
	}
}
