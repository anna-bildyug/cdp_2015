package by.epam.cdp.selenium.driver;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import by.epam.cdp.selenium.test.CommonTest;

public class Driver {
	
	static WebDriver driver;
	
	private Driver()
	{
		
	}
	
	static final Properties properties = new Properties();

	static {
	    final InputStream inputStream =
	    CommonTest.class.getResourceAsStream("listerine_test.properties");
	    try {
			properties.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static WebDriver getInstance()
	{
		if (driver == null)
		{
			switch(properties.getProperty("driver")){
    		case "chrome":
    			driver = new ChromeDriver();
    			break;
    		case "ie":
    			driver = new InternetExplorerDriver();
    			break;
    		case "firefox":
    			driver = new FirefoxDriver();
    			break;
    	}
			driver.get(properties.getProperty("url"));
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
		return driver;
	}
}
