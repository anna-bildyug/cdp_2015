package by.epam.tat.lecture2.task1.utils.exceptions;

@SuppressWarnings("serial")
public class OpeningSavedCollectionException extends Exception{

	public OpeningSavedCollectionException(String message){
		super(message);
	}

	public OpeningSavedCollectionException(Throwable cause){
		super(cause);
	}
	
}
