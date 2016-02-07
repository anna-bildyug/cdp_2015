package com.epam.by.tests.steps;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;
import org.openqa.selenium.WebDriver;
import com.epam.by.core.webdriver.WebDriverSingleton;
import com.epam.by.tests.Runner;
import com.epam.by.tests.TestProperties;
import com.epam.by.ui.pages.MainPage;
import com.epam.by.ui.pages.SignInPage;
import com.epam.by.ui.pages.TopMenu;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStepsDef extends Runner {
	private MainPage mainPage;
	private SignInPage signInPage;
	private TopMenu topMenu;
	private WebDriver driver;
	protected static TestProperties testProperties;

	@Given("^I enter userName \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void iEnterLoginData(String userName, String password) {
		testProperties = TestProperties.getInstance();
		driver = WebDriverSingleton.getInstance();
		driver.get(testProperties.getURLLogin());
		signInPage = new SignInPage(driver);
		signInPage.setUserName(userName);
		signInPage.setPassword(password);
	}

	@When("^I perfom submit$")
	public void iPerfomSubmit() {
		signInPage.pressSignInButton();
	}

	@Then("^drop in to the main page")
	public void dropInTheAccount() {
		topMenu = new TopMenu(driver);
		String url = topMenu.getURL();
		assertThat(url, containsString(testProperties.getURLMain()));
	}

	@Given("^I login with userName \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void iLogin(String userName, String password) {
		testProperties = TestProperties.getInstance();
		driver = WebDriverSingleton.getInstance();
		driver.get(testProperties.getURLLogin());
		signInPage = new SignInPage(driver);
		signInPage.logIn(userName, password);
	}

	@When("^I sign out$")
	public void iSignOut() {
		topMenu = new TopMenu(driver);
		mainPage = topMenu.signOut();
	}

	@Then("^message about sign out \"([^\"]*)\" is displayed")
	public void theMessageSignOut(String msg) {
		assertThat(mainPage.getNotificationText(), containsString(msg));
	}

}
