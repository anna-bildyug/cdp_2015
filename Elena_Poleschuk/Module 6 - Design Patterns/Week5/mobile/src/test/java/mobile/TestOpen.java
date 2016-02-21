package mobile;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class TestOpen {

	@Test
	public void newTestDemo(){
		PageObject pageObject = new PageObject();
		Assert.assertTrue(pageObject.checkLabel("Basecamp"));
		
	}
	
	@AfterClass
	public void afterClass(){
		DriverManager.closeDriver();
	}
}
