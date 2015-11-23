package by.epam.cdp.java.nypresent.storage;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import by.epam.cdp.java.nypresent.Present;
import by.epam.cdp.java.nypresent.beans.Bar;
import by.epam.cdp.java.nypresent.beans.ChocolateCandy;
import by.epam.cdp.java.nypresent.beans.Lollypop;
import by.epam.cdp.java.nypresent.beans.Sweets;
import by.epam.cdp.java.nypresent.beans.TypeOfCandy;
import by.epam.cdp.java.nypresent.validation.PresentStorageException;
import by.epam.cdp.java.nypresent.validation.WrongTypeOfCandyException;

public class FileReaderWriter implements IOStreams {

	private static final String FILEPATH = "src\\by\\epam\\cdp\\java\\nypresent\\storage\\present.txt";

	@Override
	public void exportPresent(Present present) throws PresentStorageException {

		try {
			OutputStreamWriter fileOut = new OutputStreamWriter(new FileOutputStream(FILEPATH), "UTF-8");

			for (Sweets sweet : present.getCollection()) {
				fileOut.write(sweet.toString());
				fileOut.write("\n");
			}
			fileOut.close();
			
		} catch (IOException e) {	
			throw new PresentStorageException ("Something went wrong");
		}
	}

	@Override
	public Present importPresent() throws PresentStorageException {

		Present present = new Present();
		String line = null;
		BufferedReader br;

		try {
			br = new BufferedReader(new FileReader(FILEPATH));
			boolean isPresentParsed = true;
			while ((line = br.readLine()) != null) {

				String regExp = "(Type: )(?<candyType>.*)" + "( Name of candy: )(?<name>.*)"
						+ "( Weight: )(?<weight>[0-9]+)" + "( Main ingredient: )(?<mainIngredient>.*)";
				
				Pattern pattern = Pattern.compile(regExp);
				Matcher matcher = pattern.matcher(line);
	
				if (matcher.find()) {

					TypeOfCandy candyType = TypeOfCandy.fromValue(matcher.group("candyType"));
					String name = matcher.group("name");
					int weight = Integer.parseInt(matcher.group("weight"));
					String mainIngredient = matcher.group("mainIngredient");

					if (candyType.equals(TypeOfCandy.BAR)) {
						present.getCollection().add(new Bar(name, weight, mainIngredient));
					} else if (candyType.equals(TypeOfCandy.CHOCOLATE)) {
						present.getCollection().add(new ChocolateCandy(name, weight, mainIngredient));
					} else if (candyType.equals(TypeOfCandy.LOLLYPOP)) {
						present.getCollection().add(new Lollypop(name, weight, mainIngredient));
					} else {
						isPresentParsed = false;
					}
				}
				if (!isPresentParsed == true) {
					throw new PresentStorageException("Can't parse the file");
				}
			}
			br.close();
		}
		catch (IOException | WrongTypeOfCandyException e) {
			throw new PresentStorageException("Something went wrong");
		}

		return present;
	}

}
