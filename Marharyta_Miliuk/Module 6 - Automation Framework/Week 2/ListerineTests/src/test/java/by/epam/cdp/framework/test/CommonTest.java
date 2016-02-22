package by.epam.cdp.framework.test;
import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import by.epam.cdp.framework.driver.Browser;


public class CommonTest {
	
	WebDriver driver;
	
	 @BeforeTest
	    public void setup() throws MalformedURLException{
		 driver = Browser.initBrowser();
	    }	 
	 @AfterTest
	    public void closeBrowser(){
	    	driver.close();
	    }
}