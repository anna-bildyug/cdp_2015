package by.epam.tat.task7.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import by.epam.tat.task7.objects.ChocolateCandy;
import by.epam.tat.task7.objects.Gift;
import by.epam.tat.task7.objects.Sweets;
import by.epam.tat.task7.utils.exceptions.OpeningSavedCollectionException;

public class XmlReaderSaver implements IReaderSaver {
	public List<Sweets> getSavedGift() throws OpeningSavedCollectionException {
		List<Sweets> sweets = new ArrayList<Sweets>();
		String sweetName;
		String producerName;
		int price;
		int weight;

		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document xmlFile = documentBuilder.parse(new File("xml.xml"));
			xmlFile.normalizeDocument();

			Element root = xmlFile.getDocumentElement(); // return <gift>
			NodeList sweet = root.getElementsByTagName("sweet"); // return
																	// <sweet>

			for (int temp = 0; temp < sweet.getLength(); temp++) {
				Element item = (Element) sweet.item(temp);
				if (item.getNodeType() == Node.ELEMENT_NODE) {
					item.getTagName();
					sweetName = ((Element) item.getElementsByTagName("sweetName").item(0)).getTextContent();
					producerName = ((Element) item.getElementsByTagName("producerName").item(0)).getTextContent();
					price = Integer.parseInt(((Element) item.getElementsByTagName("price").item(0)).getTextContent());
					weight = Integer.parseInt(((Element) item.getElementsByTagName("weight").item(0)).getTextContent());
					sweets.add(new ChocolateCandy(sweetName, producerName, price, weight));
				}
			}

		} catch (ParserConfigurationException e) {
			throw new OpeningSavedCollectionException(e);
		} catch (SAXException e) {
			throw new OpeningSavedCollectionException(e);
		} catch (IOException e) {
			throw new OpeningSavedCollectionException(e);
		}
		return sweets;
	}

	public void saveGift(Gift gift) {
		Communicator.out("The method is not implemented");

	}
}
