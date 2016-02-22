package by.epam.cdp.framework.runner;

import java.io.IOException;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import org.testng.TestNG;
import org.testng.xml.Parser;
import org.testng.xml.XmlSuite;
import org.xml.sax.SAXException;

public class Runner {

	  public static void main(String[] args) {

	        TestNG testng = new TestNG();

	        try {
	            List<XmlSuite> suite = (List <XmlSuite>) (new Parser().parse());
	            testng.setXmlSuites(suite);
	            testng.run();
	        } catch (ParserConfigurationException e) {
	            e.printStackTrace();
	        } catch (SAXException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
}
