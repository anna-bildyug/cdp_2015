package by.epam.cdp.selenium.test;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import by.epam.cdp.selenium.driver.Driver;

public class CommonTest {
	
	WebDriver driver;
	
	 @BeforeTest
	    public void setup(){
		 driver = Driver.getInstance();
	    }
	 
	 @AfterTest
	    public void closeBrowser(){
	    	driver.close();
	    }
}
