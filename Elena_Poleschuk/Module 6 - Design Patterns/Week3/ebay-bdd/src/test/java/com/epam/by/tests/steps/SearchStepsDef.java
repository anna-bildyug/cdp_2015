package com.epam.by.tests.steps;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;

import com.epam.by.tests.Runner;
import com.epam.by.ui.pages.MainPage;
import com.epam.by.ui.pages.SearchResultPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SearchStepsDef extends Runner {
	private MainPage mainPage;
	private SearchResultPage searchResultPage;
	protected final static String URL_MAIN_PAGE = "http://www.ebay.com/";
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

}
