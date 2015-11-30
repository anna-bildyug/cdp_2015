package pages_usage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CommonMethods {
	
	public static void openApplication(WebDriver driver, String url){
		driver.get(url);
	}
	
	public static void login(WebDriver driver, String login, String password){
		WebElement loginInput = driver.findElement(By.id("j_username"));
		WebElement passwordInput = driver.findElement(By.id("j_password"));
		loginInput.sendKeys(login);
		passwordInput.sendKeys(password);
		passwordInput.submit();
	}
	
	public static void logout(WebDriver driver){
		WebElement fieldArticleNumber = driver.findElement(By.linkText("Log Out"));
		fieldArticleNumber.click();	
	}	
	

	public static void openMainPage(WebDriver driver){
		// open WebEDI page via selecting value in mouse over
		WebElement menu = driver.findElement(By.xpath("//*[@id='spinnav']/li[2]/div[2]/span/div")); 

		//Initiate mouse action using Actions class
		Actions builder = new Actions(driver); 
		builder.moveToElement(menu).build().perform(); 
		WebElement menuOption = driver.findElement(By.xpath("//*[@id='spinnav']/li[2]/div[4]/ul/li[3]/a/div"));
		menuOption.click();
	}
}
