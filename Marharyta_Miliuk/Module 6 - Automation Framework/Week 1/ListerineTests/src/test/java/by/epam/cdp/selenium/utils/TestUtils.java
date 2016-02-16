package by.epam.cdp.selenium.utils;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import by.epam.cdp.selenium.browser.Browser;


public class TestUtils {
	
	WebDriver driver = Browser.initBrowser();
	
	public void switchBrowserTab(){
    	ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
    	driver.switchTo().window(tabs2.get(1));
	}
	public void scrollDown (WebElement element){
    	JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView(true);",element);
    }
	public void takeScreenshot(){
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File("D:\\screenshot.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void highlightElement (WebElement element){//highlits selected element with red colour
		for (int i = 0; i < 2; i++) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(
					"arguments[0].setAttribute('style', arguments[1]);",
					element, "color: red; border: 3px solid red;");
			js.executeScript(
					"arguments[0].setAttribute('style', arguments[1]);",
					element, "");
		}	
	}
	public void hoverAndClick (WebElement hoverElement, WebElement clickElement){//hovers over a web element and then clicks on expanded element
		Actions action = new Actions(driver);
		action.moveToElement(hoverElement).perform();
		action.moveToElement(clickElement).click().perform();	
	}
}