package com.epam.by.tests.steps;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;
import org.openqa.selenium.WebDriver;
import com.epam.by.core.webdriver.WebDriverSingleton;
import com.epam.by.tests.Runner;
import com.epam.by.tests.TestProperties;
import com.epam.by.ui.pages.RegisterPage;
import com.epam.by.ui.pages.TopMenu;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegisterStepsDef extends Runner {

	private TopMenu topMenu;
	private RegisterPage registerPage;
	protected static TestProperties testProperties;
	private WebDriver driver;

	@Given("^I open register form$")
	public void iOpenRegisterForm() {
		testProperties = TestProperties.getInstance();
		driver = WebDriverSingleton.getInstance();
		driver.get(testProperties.getURLMain());
		topMenu = new TopMenu(driver);
		registerPage = topMenu.goToRegisterPage();
	}

	@When("^I set email \"([^\"]*)\"$")
	public void iSetEmail(String email) {
		registerPage.setEmail(email);
		registerPage.setReEmail(email);
		registerPage.pressSubmit();
	}

	@Then("^the error notification \"([^\"]*)\" is displayed")
	public void theErrorNotification(String msg) {
		assertThat(registerPage.getErrorEmailNotification(), containsString(msg));
	}
}
