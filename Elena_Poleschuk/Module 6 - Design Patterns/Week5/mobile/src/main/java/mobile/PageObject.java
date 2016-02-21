package mobile;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PageObject {
	                
	public PageObject() {
		PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()), this);
	}
	
	@AndroidFindBy(className = "android.widget.TextView")
	private MobileElement label;
	
	public boolean checkLabel(String name){
		return name.equals(label.getText());
	}
}
