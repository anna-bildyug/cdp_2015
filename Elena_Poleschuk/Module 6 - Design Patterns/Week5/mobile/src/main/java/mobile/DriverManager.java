package mobile;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.SessionNotFoundException;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class DriverManager {
	
	private DriverManager() {}
	
	private static final String URL = "http://127.0.0.1:4747/wd/hub";
	private static final String APPLICATION = "D:/Android/com.basecamp.apk";
	private static AppiumDriver driver;		
	public static AppiumDriver getDriver() {
		if(driver == null){
			DesiredCapabilities caps = new DesiredCapabilities();

			caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "1200");
			caps.setCapability(MobileCapabilityType.DEVICE_READY_TIMEOUT, "120");
			caps.setCapability(MobileCapabilityType.LAUNCH_TIMEOUT, "120000");
			caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Selendroid");
			caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "4.2");
			caps.setCapability(MobileCapabilityType.DEVICE_NAME, "72E8406128794CAE771506C67D85BF4");
			caps.setCapability(MobileCapabilityType.APP, APPLICATION);

			try {
				driver = new AndroidDriver(new URL(URL), caps);
			} catch (MalformedURLException e) {
				System.out.println(e);
			}
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

	public static void closeDriver(){
		try{
			if (driver!= null)
				driver.quit();
		}catch(SessionNotFoundException e){}
		
	}
}

