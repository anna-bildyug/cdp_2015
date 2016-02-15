package by.epam.cdp.selenium.driverfactory;
import org.openqa.selenium.WebDriver;

import by.epam.cdp.selenium.browser.BrowserType;

public class WebDriverFactoryManager {

    public WebDriverFactoryManager(BrowserType browserType) {
    }

    public WebDriver createWedDriverForBrowser(BrowserType browserType) {
        WebDriverFactory result = null;
        switch (browserType) {
        case CHROME:
			result = new ChromeDriverFactory();
			break;
		case IE:
			result = new InternetExplorerDriverFactory();
			break;
		case FIREFOX:
			result = new FirefoxDriverFactory();
			break;
        }
        return result.createWebDriver();
    }
}
