package by.epam.cdp.framework.driver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import by.epam.cdp.framework.driverfactory.WebDriverFactoryManager;
import by.epam.cdp.framework.runner.GlobalConfiguration;

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
