package by.epam.cdp.selenium.utils;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;

import by.epam.cdp.selenium.driver.Driver;

public class TestUtils {
	
	WebDriver driver = Driver.getInstance();
	
	public void switchBrowserTab(){
    	ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
    	driver.switchTo().window(tabs2.get(1));
	}
}
