package by.epam.cdp.selenium.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class CommonTest {
	
	WebDriver driver;
	
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
	
	 @BeforeMethod
	    public void setup(){
	    	driver = new ChromeDriver();
	    	driver.get(properties.getProperty("url"));
	    	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	    	driver.manage().window().maximize();  	
	    }
	 
	 @AfterMethod
	    public void closeBrowser(){
	    	driver.close();
	    }

}
