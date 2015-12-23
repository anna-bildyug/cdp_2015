package selenium.webdriver.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class MainMenu extends AbstractPage{

	@FindBy(xpath = "//div[@class = 'spinspc']/div[contains(text()='SupplyOn Services')]")
	private WebElement menuServices;
	
	@FindBy(linkText = "Log Out")
	private WebElement menuLogOut;
	
	
	public MainMenu(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public LogisticsAndSettingsPage openMainPage(){
		new Select(menuServices).selectByVisibleText("WebEDI / VMI");
		return PageFactory.initElements(driver, LogisticsAndSettingsPage.class);
	}
	
	public LoginPage logout(){
		menuLogOut.click();	
		return PageFactory.initElements(driver, LoginPage.class);
	}
}
