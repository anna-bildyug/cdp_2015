package by.epam.tat.lecture2.task1.utils;

import java.io.File;
import java.io.FileNotFoundException;

public class Exceptions {
	
	// throw exception on trying to open not existed file
	public static void isExistFile(String fileName) throws FileNotFoundException {
	    File file = new File(fileName);
	    if (!file.exists()){
	        throw new FileNotFoundException("\"" + file.getName() + "\""+ " file does not exist");
	    }
	}
	
	
}
