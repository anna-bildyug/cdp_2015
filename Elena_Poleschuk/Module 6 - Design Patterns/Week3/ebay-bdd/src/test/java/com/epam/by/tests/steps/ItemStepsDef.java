package com.epam.by.tests.steps;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;
import org.openqa.selenium.WebDriver;
import com.epam.by.core.webdriver.WebDriverSingleton;
import com.epam.by.tests.TestProperties;
import com.epam.by.ui.pages.ItemDetailsPage;
import com.epam.by.ui.pages.MainPage;
import com.epam.by.ui.pages.SearchResultPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ItemStepsDef {
	private MainPage mainPage;
	private SearchResultPage searchResultPage;
	private ItemDetailsPage itemDetailsPage;
	private WebDriver driver;
	protected static TestProperties testProperties;
	private String nameItem;

	@Given("^I find item \"([^\"]*)\"$")
	public void iFindItem(String searchRequest) {
		testProperties = TestProperties.getInstance();
		driver = WebDriverSingleton.getInstance();
		driver.get(testProperties.getURLMain());
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
}
