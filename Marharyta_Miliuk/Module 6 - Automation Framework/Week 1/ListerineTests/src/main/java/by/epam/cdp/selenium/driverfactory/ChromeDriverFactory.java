package by.epam.cdp.selenium.driverfactory;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ChromeDriverFactory implements WebDriverFactory {
	
	private static String chromeNodeUrl = "http://192.168.0.102:5556/wd/hub";
	WebDriver driver;

	@Override
	public WebDriver createWebDriver() {
		DesiredCapabilities chromeNode = DesiredCapabilities.chrome();
		try {
			driver = new RemoteWebDriver(new URL(chromeNodeUrl),chromeNode);
		} catch (MalformedURLException e) {
		}
		chromeNode.setBrowserName("chrome");
		chromeNode.setPlatform(Platform.WINDOWS);
		chromeNode.setVersion("12");
		return driver;
	}

}
