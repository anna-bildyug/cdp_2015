package by.epam.cdp.framewok.driver;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Driver {
	
public static WebDriver driver;
	
	public static void getInstance(){
        driver = new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}	
	 public static void close(){
	        try {
	            driver.close();
	        }
	        catch (Exception ex){
	            ex.printStackTrace();
	        }
	    }
}