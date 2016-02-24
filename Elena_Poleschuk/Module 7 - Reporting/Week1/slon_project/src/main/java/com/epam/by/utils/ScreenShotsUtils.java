package com.epam.by.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;

public class ScreenShotsUtils {

	public static void takeScreenShot(WebDriver driver) {

		String path;
		String name;
		try {
			File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			name = DateUtils.getDate_Time();
			path = "./target/screenshots/" + DateUtils.getDate_Time();
			FileUtils.copyFile(screen, new File(path));
			LogSaver.getLogger().info("Screenshot " + name + " is created");
		} catch (IOException e) {
			e.printStackTrace();
			LogSaver.getLogger().warn("Screenshot is not created: " + e);
		}
	}

	public static void takeScreenShotWithHighlightElement(WebElement element, WebDriver driver) {
		String background = element.getCssValue("backgroundColor");
		JavascriptExecutor javascriptExecutor = ((JavascriptExecutor) driver);
		javascriptExecutor.executeScript("arguments[0].style.backgroundColor = 'red'", element);
		LogSaver.getLogger().info("Change Background color for element");
		takeScreenShot(driver);
		javascriptExecutor.executeScript("arguments[0].style.backgroundColor = '" + background + "'", element);
		LogSaver.getLogger().info("Return Background color for element");
	}
}
