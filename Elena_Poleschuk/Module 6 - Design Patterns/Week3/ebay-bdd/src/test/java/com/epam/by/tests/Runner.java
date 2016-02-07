package com.epam.by.tests;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import com.epam.by.core.webdriver.WebDriverSingleton;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(strict = true, plugin = { "pretty", "json:target/Cucumber.json",
		"html:target/cucumber-html-report" }, features = "src/test/resources/com.epam.by.tests/")
public class Runner {

	@AfterClass
	public static void closeSelenium() {
		WebDriverSingleton.closeBrowser();
	}
}
