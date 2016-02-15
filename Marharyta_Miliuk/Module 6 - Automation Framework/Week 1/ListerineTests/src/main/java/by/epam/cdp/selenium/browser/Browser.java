package by.epam.cdp.selenium.browser;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import by.epam.cdp.selenium.driverfactory.WebDriverFactoryManager;
import by.epam.cdp.selenium.runner.GlobalConfiguration;

public class Browser {

	private static WebDriver webDriver;

    public static WebDriver getInstance(){
        return webDriver;
    }
    public static WebDriver initBrowser() {
        BrowserType browserType = GlobalConfiguration.getInstance().getBrowserType();
        WebDriverFactoryManager driverManager = new WebDriverFactoryManager(browserType);

        webDriver = driverManager.createWedDriverForBrowser(browserType);
        webDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return webDriver;
    }

    public static void closeDriver() {
        webDriver.quit();
    }
}
