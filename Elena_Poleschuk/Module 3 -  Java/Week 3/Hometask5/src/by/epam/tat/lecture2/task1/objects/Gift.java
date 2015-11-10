package by.epam.tat.lecture2.task1.objects;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import by.epam.tat.lecture2.task1.utils.Communicator;
import by.epam.tat.lecture2.task1.utils.NameComparator;
import by.epam.tat.lecture2.task1.utils.PriceComparator;
import by.epam.tat.lecture2.task1.utils.WeightComparator;


public class Gift {	
	// collection
	private List<Sweets> sweetCollection = new ArrayList<Sweets>();
	
	
	// add sweet to gift
	public void addSweet (Sweets sweet){
		sweetCollection.add(sweet);
	}
	

	//show the collection
	
	public void printGiftInfo(){
		 if(sweetCollection.isEmpty())
		 {
			 Communicator.out("There are no sweets in the gift"); 
		 }else {
			 for (Sweets i : sweetCollection){
				 Communicator.out(i.toString());
			 }
		}
	}
	
	
	// define the gift's weight 
	public int getSumWeight(){
		int sumWeight = 0;
		 if(sweetCollection.isEmpty())
		 {
			 Communicator.out("There are no sweets in the gift"); 
		 }else {
			for (Sweets i : sweetCollection){
				sumWeight = sumWeight + i.getWeight();
			}
		 }
		return sumWeight;
	}

	//find particular sweet in gift 
	public void giveSweetByName(String sweetName){
		boolean nameExist = false;
		for (Sweets i : sweetCollection){
			if (i.getSweetName().equals(sweetName)){
				Communicator.out(i.toString());
				nameExist = true;
			}
		}
		if (nameExist == false){
			Communicator.out("There is no sweet with " + "\"" + sweetName + "\"" +" name.");
		}
		
	}	
	
	
	// sorting
	public void sortByName(){
		Collections.sort(sweetCollection, new NameComparator()); 
		printGiftInfo();
	}
	
	public void sortByWeight(){
		Collections.sort(sweetCollection, new WeightComparator()); 
		printGiftInfo();

	}	
	
	public void sortByPrice(){
		Collections.sort(sweetCollection, new PriceComparator()); 
		printGiftInfo();
	}

	//out
	public void writeFile(String file) throws IOException{
		PrintWriter outPutStream = null;
		try{
			outPutStream = new PrintWriter(new FileWriter(file));
			for (Sweets i : sweetCollection){
				String temp = i.toString();
				outPutStream.println(temp);	
			}
			
		} finally {
			if (outPutStream != null){
				outPutStream.close();
			}
		}
	}
	
	//in
	public void readFile(String file) throws IOException{
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
					addSweet(new SugarCandy(sweetName, producerName, price, weight, lollipop, flavour));
				} else {
					addSweet(new ChocolateCandy(sweetName, producerName, price, weight));	
					
				}
			}
			
		} finally {
			if (inPutStream != null){
				inPutStream.close();
			}
		}
	}
	
		
}
