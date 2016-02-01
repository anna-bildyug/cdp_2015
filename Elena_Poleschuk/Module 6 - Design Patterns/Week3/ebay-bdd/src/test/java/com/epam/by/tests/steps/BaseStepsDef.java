package com.epam.by.tests.steps;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;

import com.epam.by.tests.Runner;
import com.epam.by.ui.pages.ItemDetailsPage;
import com.epam.by.ui.pages.MainPage;
import com.epam.by.ui.pages.RegisterPage;
import com.epam.by.ui.pages.SearchResultPage;
import com.epam.by.ui.pages.SignInPage;
import com.epam.by.ui.pages.TopMenu;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BaseStepsDef extends Runner {
	private MainPage mainPage;
	private SearchResultPage searchResultPage;
	private SignInPage signInPage;
	private TopMenu topMenu;
	private RegisterPage registerPage;
	private ItemDetailsPage itemDetailsPage;
	
	private String nameItem;
	protected final static String URL_MAIN_PAGE = "http://www.ebay.com/";
	protected final static String URL_LOGIN_PAGE = "https://signin.ebay.com";
// search
	@Given("^I set search request \"([^\"]*)\"$")
	public void iSetSearchRequest(String searchRequest) {
		driver.get(URL_MAIN_PAGE);
		mainPage = new MainPage(driver);
		mainPage.setSearchRequest(searchRequest);
	}

	@When("^I perfom search$")
	public void iPerfomSearch() {
		searchResultPage = mainPage.perfomSearch();
	}

	@Then("^the term query \"([^\"]*)\" should be the first in the Search Result grid$")
	public void theTermQueryShouldBeTheFirstInTheSearchResultGrid(String expectPhrase) {
		String firstSnippet = searchResultPage.getFirstNameInTheSearchResultGrid();
		assertThat(firstSnippet, containsString(expectPhrase));
	}

	// open details
	@Given("^I find item \"([^\"]*)\"$")
	public void iFindItem(String searchRequest) {
		driver.get(URL_MAIN_PAGE);
		mainPage = new MainPage(driver);
		mainPage.setSearchRequest(searchRequest);
		searchResultPage = mainPage.perfomSearch();
		nameItem = searchResultPage.getFirstItemName();
	}

	@When("^I press item link$")
	public void iPressItemLink() {
		itemDetailsPage = searchResultPage.pressFirstItemName();
	}

	@When("^I press image link$")
	public void iPressImageLink() {
		itemDetailsPage = searchResultPage.pressFirstItemImage();
	}

	@Then("^the term nameItem should be in item name$")
	public void theTermNameItemShouldBeInitemName() {
		String nameItemInDetails = itemDetailsPage.getItemName();
		nameItem = nameItem.substring(0, nameItem.length() - 3);
		assertThat(nameItemInDetails, containsString(nameItem));
	}

	// login

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
