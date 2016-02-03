package com.epam.by.tests.steps;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;

import com.epam.by.tests.Runner;
import com.epam.by.ui.pages.RegisterPage;
import com.epam.by.ui.pages.TopMenu;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegisterStepsDef extends Runner {

	private TopMenu topMenu;
	private RegisterPage registerPage;

	// register

	@Given("^I open register form$")
	public void iOpenRegisterForm() {
		driver.get(URL_MAIN_PAGE);
		topMenu = new TopMenu(driver);
		registerPage = topMenu.goToRegisterPage();
	}

	@When("^I set email \"([^\"]*)\"$")
	public void iSetEmail(String email) {
		registerPage.setEmail(email);
		registerPage.pressSubmit();
	}

	@Then("^the error notification \"([^\"]*)\" is displayed")
	public void theErrorNotification(String msg) {
		assertThat(registerPage.getErrorEmailNotification(), containsString(msg));
	}
}
