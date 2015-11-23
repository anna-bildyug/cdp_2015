package by.epam.cdp.java.nypresent.storage;


import java.io.IOException;
import java.io.StringReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import by.epam.cdp.java.nypresent.Present;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.CharacterData;
import by.epam.cdp.java.nypresent.beans.Bar;
import by.epam.cdp.java.nypresent.beans.ChocolateCandy;
import by.epam.cdp.java.nypresent.beans.Lollypop;
import by.epam.cdp.java.nypresent.validation.PresentStorageException;



public class XMLReaderWriter implements IOStreams{
	
	private static final String FILEPATH = "src\\by\\epam\\cdp\\java\\nypresent\\storage\\present.xml";

	private static String getCharacterDataFromElement(Element e) {
	    Node child = e.getFirstChild();
	    if (child instanceof CharacterData) {
	      CharacterData cd = (CharacterData) child;
	      return cd.getData();
	    }
	    return "";
	  }
	
	@Override
	public Present importPresent() throws PresentStorageException {
	Present present = new Present ();
		try {
		DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		
	    InputSource is = new InputSource();
	    is.setCharacterStream(new StringReader(FILEPATH));
		
	    Document doc = db.parse(is);
	    NodeList nodes = doc.getElementsByTagName("candy");
	    
	    for (int i = 0; i < nodes.getLength(); i++) {
	        Element element = (Element) nodes.item(i);
	        
	        NodeList type = element.getElementsByTagName("candyType");
	        Element line = (Element) type.item(0);
	        String candyType = getCharacterDataFromElement(line);
	      
	        NodeList name = element.getElementsByTagName("candyName");
	        line = (Element) name.item(0);
	        String candyName = getCharacterDataFromElement(line);
	        
	        NodeList weight = element.getElementsByTagName("candyWeight");
	        line = (Element) weight.item(0);
	        int candyWeight = Integer.parseInt(getCharacterDataFromElement(line));
	        
	        NodeList ingredient = element.getElementsByTagName("mainIngredient");
	        line = (Element) ingredient.item(0);
	        String mainIngredient = getCharacterDataFromElement(line);
	        
	        switch (candyType){
			case "Bar":
				present.getCollection().add(new Bar(candyName, candyWeight, mainIngredient));
			break;
			
			case "Lollypop":
				present.getCollection().add(new Lollypop(candyName, candyWeight, mainIngredient));
			break;
			
			case "Chocolate Candy":
				present.getCollection().add(new ChocolateCandy(candyName, candyWeight, mainIngredient));
				break;	
			}			
	    
	} }
		catch (ParserConfigurationException | SAXException | IOException e) {
		throw new PresentStorageException("Something went wrong");
	}
		return present;
	}
	
	
	@Override
	public void exportPresent(Present present) throws PresentStorageException {
		
		
	}
	
	
}
