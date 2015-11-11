package by.epam.tat.lecture2.task1.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import by.epam.tat.lecture2.task1.objects.ChocolateCandy;
import by.epam.tat.lecture2.task1.objects.Gift;
import by.epam.tat.lecture2.task1.objects.SugarCandy;


public class IOFile implements IOMethods {

	@Override
	public void saveInfo(String file, String[] collection) {
		PrintWriter outPutStream = null;
		try{
			outPutStream = new PrintWriter(new FileWriter(file));
			for (String i : collection){
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
	public int countRows(String file){
		int count = 0;
		BufferedReader inPutStream = null;
		try{
			inPutStream = new BufferedReader(new FileReader(file));
			while((inPutStream.readLine()) != null){
				count++;
			}
		}catch (FileNotFoundException e) {
			Communicator.out("File doesn't exist: " + e);
		} catch (IOException e) {
			Communicator.out("Can't read the file: " + e);
		}finally {
			if (inPutStream != null){
				try {
					inPutStream.close();
				} catch (IOException e) {
					Communicator.out("Problem with closing input Stream: " + e);
				}
			}
		}
		return count;
	}
	
	@Override
	public String[][] getSavedGiftInfo(String file) {
		BufferedReader inPutStream = null;
		String[][] giftCollectionMatrix = null;
		try{
			inPutStream = new BufferedReader(new FileReader(file));
			String line;
			String[] isLineParts;
			String sweetName;
			String producerName;
			String price ;
			String weight;
			String lollipop;
			String flavour;
			int n = countRows(file);
			int s = 0;
			giftCollectionMatrix = new String[n][6];    
			while ((line = inPutStream.readLine()) != null){
				
				isLineParts = line.split(", ");
				sweetName = isLineParts[0].substring(6);
				producerName = isLineParts[1].substring(10);
				price = isLineParts[2].substring(7);
				weight = isLineParts[3].substring(8);
				if (isLineParts.length > 4){
					lollipop = isLineParts[4].substring(10);
					flavour = isLineParts[5].substring(9);
				} else {	
					lollipop = "false";
					flavour = null;
				}
				
				giftCollectionMatrix[s][0] = sweetName;
				giftCollectionMatrix[s][1] = producerName;
				giftCollectionMatrix[s][2] = price;
				giftCollectionMatrix[s][3] = weight;
				giftCollectionMatrix[s][4] = lollipop;
				giftCollectionMatrix[s][5] = flavour;
				s++;
				}
		} catch (FileNotFoundException e) {
			Communicator.out("File doesn't exist: " + e);
		} catch (NumberFormatException e) {
			Communicator.out("Wrong format of number: " + e);
		} catch (IOException e) {
			Communicator.out("Can't read the file: " + e);
		} finally {
			if (inPutStream != null){
				try {
					inPutStream.close();
				} catch (IOException e) {
					Communicator.out("Problem with closing input Stream: " + e);
				}
			}
		}
		
		return giftCollectionMatrix;
	}
}
