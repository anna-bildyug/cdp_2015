package by.epam.cdp.framework.driverfactory;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class FirefoxDriverFactory implements WebDriverFactory {
	
	private static String firefoxNodeUrl = "http://192.168.0.102:5555/wd/hub";
	WebDriver driver;
	
	@Override
	public WebDriver createWebDriver() {
		DesiredCapabilities firefoxNode = DesiredCapabilities.firefox();
		try {
			driver = new RemoteWebDriver(new URL(firefoxNodeUrl),firefoxNode);
		} catch (MalformedURLException e) {
			e.getStackTrace();
		}
		firefoxNode.setBrowserName("firefox");
		firefoxNode.setPlatform(Platform.WINDOWS);
		firefoxNode.setVersion("40");
		
		return driver;
	}

}
