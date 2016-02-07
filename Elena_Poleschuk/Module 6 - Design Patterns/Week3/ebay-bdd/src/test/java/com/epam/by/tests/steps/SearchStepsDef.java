package com.epam.by.tests.steps;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;
import org.openqa.selenium.WebDriver;
import com.epam.by.core.webdriver.WebDriverSingleton;
import com.epam.by.tests.Runner;
import com.epam.by.tests.TestProperties;
import com.epam.by.ui.pages.MainPage;
import com.epam.by.ui.pages.SearchResultPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SearchStepsDef extends Runner {
	private MainPage mainPage;
	private SearchResultPage searchResultPage;
	private WebDriver driver;
	protected static TestProperties testProperties;

	@Given("^I set search request \"([^\"]*)\"$")
	public void iSetSearchRequest(String searchRequest) {
		testProperties = TestProperties.getInstance();
		driver = WebDriverSingleton.getInstance();
		driver.get(testProperties.getURLMain());
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

}
