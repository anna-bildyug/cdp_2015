package by.epam.tat.lecture2.task1.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import by.epam.tat.lecture2.task1.objects.ChocolateCandy;
import by.epam.tat.lecture2.task1.objects.Gift;
import by.epam.tat.lecture2.task1.objects.SugarCandy;
import by.epam.tat.lecture2.task1.objects.Sweets;
import by.epam.tat.lecture2.task1.utils.exceptions.OpeningSavedCollectionException;


public class FileSever implements ISaver {
	final String file = "log.txt";
	/// if no sweets
	@Override
	public void saveGift(Gift gitf) {
		List<Sweets> sweets = gitf.getSweets();
		PrintWriter outPutStream = null;
		try{
			outPutStream = new PrintWriter(new FileWriter(file));
			for (Sweets i : sweets){
				String temp = i.toString();
				outPutStream.println(temp);	
			}
		} catch (IOException e) {
			Communicator.out("File can't be created");
		} finally {
			if (outPutStream != null){
				outPutStream.close();
			}
		}
	}

	@Override
	public List<Sweets> getSavedGift() {
		List<Sweets> sweets = new ArrayList<Sweets>();
		BufferedReader inPutStream = null;
		try{
			inPutStream = new BufferedReader(new FileReader(file));
			String line;
			String[] isLineParts;
			String sweetName;
			String producerName;
			int price;
			int weight;
			while ((line = inPutStream.readLine()) != null){
				isLineParts = line.split(", ");
				sweetName = isLineParts[0].substring(6);
				producerName = isLineParts[1].substring(10);
				price = Integer.parseInt(isLineParts[2].substring(7));
				weight = Integer.parseInt(isLineParts[3].substring(8));
										
				if (isLineParts.length > 4){
					boolean lollipop = Boolean.parseBoolean(isLineParts[4].substring(10));
					String flavour = isLineParts[5].substring(9);
					sweets.add(new SugarCandy(sweetName, producerName, price, weight, lollipop, flavour));
				} else {
					sweets.add(new ChocolateCandy(sweetName, producerName, price, weight));	
				}
			}
			
		} catch (FileNotFoundException e) {
			Communicator.out("The file can't be found out");
			throw new OpeningSavedCollectionException();
		} catch (IOException e) {
			Communicator.out("Can't read file");
			throw new OpeningSavedCollectionException();
		} catch (NumberFormatException e) {
			Communicator.out("Incorrect format of saved file. Please verify that price and weight are numbers");
			throw new OpeningSavedCollectionException();
		} catch (ArrayIndexOutOfBoundsException e) {
			Communicator.out("Incorrect format of saved file. Please verify file");
			throw new OpeningSavedCollectionException();
		} catch (Throwable e) {
			Communicator.out("Can't open file");
			throw new OpeningSavedCollectionException();
		} finally {
			if (inPutStream != null){
				try {
					inPutStream.close();
				} catch (IOException e) {
					Communicator.out("Can't read file");
					throw new OpeningSavedCollectionException();
				}
			}
		}
		return sweets;
	}
}
