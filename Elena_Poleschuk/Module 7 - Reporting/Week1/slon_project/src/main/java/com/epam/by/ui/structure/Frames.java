package com.epam.by.ui.structure;

import org.openqa.selenium.WebDriver;

public class Frames {

	public static void switchToMainFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	public static void switchToWebEDIFrame(WebDriver driver) {
		driver.switchTo().frame("webedi_frame");
	}

	public static void switchToVMIFrame(WebDriver driver) {
		switchToMainFrame(driver);
		driver.switchTo().frame("vmi_frame");
	}

}
