package by.epam.cdp.java.nypresent.validation;

public class NoSuchCandyException extends Exception {

	private static final long serialVersionUID = 3852436899018464372L;

	public NoSuchCandyException() { 
		
		 super();
		 
		 }
	
	  public NoSuchCandyException(String message) { 
		  
		  super(message); 
		  
		  }
	  
	  public NoSuchCandyException(String message, Throwable cause) { 
		  
		  super(message, cause);
		  
		  }
	  
	  public NoSuchCandyException(Throwable cause) {
		  
		  super(cause);
		  
		  }
	  
}
