package by.epam.cdp.java.nypresent.storage;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import by.epam.cdp.java.nypresent.Present;
import by.epam.cdp.java.nypresent.validation.PresentStorageException;

public class FileReaderWriter implements IOStreams {
	
	private static final String FILEPATH = "src\\by\\epam\\cdp\\java\\nypresent\\storage\\present.txt";
	
	@Override
    public void exportPresent (Present present) {
		
		 try {
				 OutputStreamWriter fileOut = new OutputStreamWriter(
			        	    new FileOutputStream(FILEPATH), "UTF-8");
					
						 fileOut.write (present.collection.toString());
				fileOut.close();
			} catch (IOException e) {
				e.printStackTrace();
			} 			 
} 
	@Override
	public String importPresent ()throws PresentStorageException {
		
		String line = null;
		
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(FILEPATH));
			 
			line = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
  
		return line;
	        	
	}
		
	}
	

