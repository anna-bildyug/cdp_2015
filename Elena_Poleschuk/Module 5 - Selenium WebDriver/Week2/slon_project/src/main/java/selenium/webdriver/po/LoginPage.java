package selenium.webdriver.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractPage {
	public final static String URL = "https://webedi-scmpl.application.qas.supplyon.com/general/main?loadFramePage=true&lr=true";
	private final static String LOGIN = "SLE35CP1_Admin";
	private final static String PASSWORD = "London2+";

	@FindBy(id = "j_username")
	private WebElement loginInput;

	@FindBy(id = "j_password")
	private WebElement passwordInput;

	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public LogisticsAndSettingsPage logIn() {
		loginInput.sendKeys(LOGIN);
		passwordInput.sendKeys(PASSWORD);
		passwordInput.submit();
		return PageFactory.initElements(driver, LogisticsAndSettingsPage.class);
	}

}
