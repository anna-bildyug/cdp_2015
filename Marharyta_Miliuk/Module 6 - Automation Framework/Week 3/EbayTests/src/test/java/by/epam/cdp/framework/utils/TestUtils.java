package by.epam.cdp.framework.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestUtils {

		public void takeScreenshot(WebDriver driver){
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(Calendar.getInstance().getTime());
		String location = "D:\\Automation\\Workspace\\EbayTests\\src\\test\\resources\\";
		try {
			FileUtils.copyFile(file, new File( location + timeStamp + ".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}		
        }
        public void highlightElement (WebDriver driver, WebElement element){
        	for (int i = 0; i < 2; i++) {
    			JavascriptExecutor js = (JavascriptExecutor) driver;
    			js.executeScript(
    					"arguments[0].setAttribute('style', arguments[1]);",
    					element, "color: red; border: 3px solid red;");
    		}				
		}
}