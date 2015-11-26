package by.epam.tat.lecture2.task1.utils.exceptions;

@SuppressWarnings("serial")
public class EmptyCollectionException extends Exception {

	public EmptyCollectionException(){
	}
		
	public String getMessage() {
		return "The gift is empty";
	}
}
