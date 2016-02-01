package com.epam.by.tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.epam.by.core.webdriver.WebDriverSingleton;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(strict = true, plugin = { "pretty", "json:target/Cucumber.json", "html:target/cucumber-html-report" },
features = "src/test/resources/com.epam.by.tests/")
//features = "src/test/resources/com.epam.by.tests/register.feature")
public class Runner {
	protected static WebDriver driver;

	@BeforeClass
	public static void initSelenium() {
		driver = WebDriverSingleton.getInstance();
	}

	@AfterClass
	public static void closeSelenium() {
		WebDriverSingleton.closeBrowser();
	}
}
