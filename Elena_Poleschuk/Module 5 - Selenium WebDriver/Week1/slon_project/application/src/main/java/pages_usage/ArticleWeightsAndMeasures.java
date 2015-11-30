package pages_usage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ArticleWeightsAndMeasures extends CommonMethods {
		
	public static void openArticleWeightsAndMeasuresOverview(WebDriver driver){
		// open Article Weights and Measures page via selecting value in mouse over 
		WebElement menuPacking = driver.findElement(By.xpath("//*[@id='contentcell']/div[58]/table/tbody/tr/td[2]/table[2]/tbody/tr[4]/td/span/text()"));
		Actions builder = new Actions(driver); 
		builder.moveToElement(menuPacking).build().perform(); 
		WebElement menuArticles = driver.findElement(By.xpath("//*[@id='contentcell']/div[58]/table/tbody/tr/td[2]/table[2]/tbody/tr[4]/td/span"));
		menuArticles.click();
	}
	
	public static void startToCreateArticleViaCreateButton(WebDriver driver){
		WebElement buttonCreateArticle = driver.findElement(By.id("ext-gen56"));
		buttonCreateArticle.click();
	}
	
	public static void enterSupplierArticleNumber(WebDriver driver, String supplierArticleNumber){
		WebElement fieldSupplierArticleNumber = driver.findElement(By.id("ext-comp-1111"));
		fieldSupplierArticleNumber.sendKeys(supplierArticleNumber);
	}
	
	public static void saveSupplierArticle(WebDriver driver){
		WebElement buttonSave = driver.findElement(By.id("ext-gen183"));
		buttonSave.click();
	}
	
	public static boolean findSupplierArticleByNumberViaSearch(WebDriver driver, String supplierArticleNumber){
		WebElement fieldQuickSearch = driver.findElement(By.id("searchValue-partOverview"));
		fieldQuickSearch.sendKeys(supplierArticleNumber);
		fieldQuickSearch.submit();
		return driver.findElements(By.linkText(supplierArticleNumber)).size() > 0;
	}
	
	public static void openDetailsSupplierArticle(WebDriver driver, String supplierArticleNumber){
		WebElement fieldArticleNumber = driver.findElement(By.linkText(supplierArticleNumber));
		fieldArticleNumber.click();		
	}
	
	public static String getArticalValueInDetailsPage(WebDriver driver){
		String fieldArticleNumber = driver.findElement(By.id("ext-comp-1111")).toString();
		return fieldArticleNumber;
	}
	
}
