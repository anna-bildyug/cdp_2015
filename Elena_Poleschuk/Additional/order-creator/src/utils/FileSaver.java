package utils;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileSaver {
		private String FILE_PATH = "d:/messages/";
	
	public void saveFile(String fileName, String text){
		String file = FILE_PATH + fileName;
		PrintWriter outPutStream = null;
		try {
			outPutStream = new PrintWriter(new FileWriter(file, true));
			outPutStream.println(text);
		} catch (IOException e) {
			System.out.println("File can't be created");
		} finally {
			if (outPutStream != null) {
				outPutStream.close();
			}
	}}
}
