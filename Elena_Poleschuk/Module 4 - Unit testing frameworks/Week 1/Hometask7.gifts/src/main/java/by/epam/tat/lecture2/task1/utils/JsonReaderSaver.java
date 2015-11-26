package by.epam.tat.lecture2.task1.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import by.epam.tat.lecture2.task1.objects.Gift;
import by.epam.tat.lecture2.task1.objects.Sweets;
import by.epam.tat.lecture2.task1.utils.exceptions.OpeningSavedCollectionException;

public class JsonReaderSaver implements IReaderSaver{


	public void saveGift(Gift gift) {
		Communicator.out("The method is not implemented");
	}


	public List<Sweets> getSavedGift() throws OpeningSavedCollectionException {
		List<Sweets> sweets = new ArrayList<Sweets>();
	
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		BufferedReader temp;
		try {
			temp = new BufferedReader(new FileReader("file"));
			Gift gift = gson.fromJson(temp, Gift.class);
			
			
			Communicator.out(gson.toJson("json.json"));
			
			
			sweets	= gift.getSweets();
		} catch (FileNotFoundException e) {
			throw new OpeningSavedCollectionException(e);
		}  
		try {
			temp.close();
		} catch (IOException e) {
			Communicator.out(e.getMessage());
		}
		
		return sweets;
	}

}
