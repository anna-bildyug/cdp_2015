package by.epam.tat.lecture2.task1.utils.exceptions;

@SuppressWarnings("serial")
public class OpeningSavedCollectionException extends RuntimeException{

	public String getMessage() {
		return "Gift doesn't open";
	}	
	
}
