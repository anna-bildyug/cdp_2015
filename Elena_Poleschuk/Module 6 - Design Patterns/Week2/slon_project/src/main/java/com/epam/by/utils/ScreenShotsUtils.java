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
		File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFileToDirectory(screen, new File("screenshots"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void takeScreenShotWithHighlightElement(WebElement element, WebDriver driver) {
		String background = element.getCssValue("backgroundColor");
		JavascriptExecutor javascriptExecutor = ((JavascriptExecutor) driver);
		javascriptExecutor.executeScript("arguments[0].style.backgroundColor = 'red'", element);
		takeScreenShot(driver);
		javascriptExecutor.executeScript("arguments[0].style.backgroundColor = '" + background + "'", element);
	}
}
