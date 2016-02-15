package by.epam.cdp.selenium.test;
import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import by.epam.cdp.selenium.browser.Browser;


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