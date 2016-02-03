package com.epam.by.tests.steps;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;
import com.epam.by.tests.Runner;
import com.epam.by.ui.pages.MainPage;
import com.epam.by.ui.pages.SignInPage;
import com.epam.by.ui.pages.TopMenu;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStepsDef extends Runner {
	// login
	private MainPage mainPage;
	private SignInPage signInPage;
	private TopMenu topMenu;

	protected final static String URL_LOGIN_PAGE = "https://signin.ebay.com";

	@Given("^I enter userName \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void iEnterLoginData(String userName, String password) {
		driver.get(URL_LOGIN_PAGE);
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
		topMenu.getURL();
		String url = topMenu.getURL();
		assertThat(url, containsString(URL_MAIN_PAGE));
	}

	// logout

	@Given("^I login with userName \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void iLogin(String userName, String password) {
		driver.get(URL_LOGIN_PAGE);
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
