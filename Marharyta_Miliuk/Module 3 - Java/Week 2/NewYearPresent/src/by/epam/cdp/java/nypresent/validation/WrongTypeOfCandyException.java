package by.epam.cdp.java.nypresent.validation;

public class WrongTypeOfCandyException extends Exception{
	
	private static final long serialVersionUID = -2460928136752159174L;

	public WrongTypeOfCandyException() { 
		
		 super();
		 
		 }
	  public WrongTypeOfCandyException(String message) { 
		  
		  super(message); 
		  
		  }
	  
	  public WrongTypeOfCandyException(String message, Throwable cause) { 
		  
		  super(message, cause);
		  
		  }
	  
	  public WrongTypeOfCandyException(Throwable cause) {
		  
		  super(cause);
		  
		  }
	  
}
