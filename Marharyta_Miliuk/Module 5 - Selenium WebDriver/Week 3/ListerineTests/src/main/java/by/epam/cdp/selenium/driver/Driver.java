package by.epam.cdp.selenium.driver;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import by.epam.cdp.selenium.test.CommonTest;

public class Driver {
	
	static WebDriver driver;
	
	private Driver()
	{			
		
	}
	
	static final Properties properties = new Properties();
	private static String firefoxNodeUrl = "http://192.168.0.102:5555/wd/hub";
	private static String chromeNodeUrl = "http://192.168.0.102:5556/wd/hub";

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
    			DesiredCapabilities chromeNode = DesiredCapabilities.chrome();
    			try {
					driver = new RemoteWebDriver(new URL(chromeNodeUrl),chromeNode);
				} catch (MalformedURLException e) {
				}
    			chromeNode.setBrowserName("chrome");
    			chromeNode.setPlatform(Platform.WINDOWS);
    			chromeNode.setVersion("12");
    			break;
    		case "ie":
    			driver = new InternetExplorerDriver();
    			break;
    		case "firefox":
    			DesiredCapabilities firefoxNode = DesiredCapabilities.firefox();
    			try {
					driver = new RemoteWebDriver(new URL(firefoxNodeUrl),firefoxNode);
				} catch (MalformedURLException e) {
					e.getStackTrace();
				}
    			firefoxNode.setBrowserName("firefox");
    			firefoxNode.setPlatform(Platform.WINDOWS);
    			firefoxNode.setVersion("40");
    			break;
    	}
			driver.get(properties.getProperty("url"));
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			driver.manage().window().maximize();			
		}
		return driver;
	}
}