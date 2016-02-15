package by.epam.cdp.selenium.utils;

public class ForeseeEnabledException extends Exception {

	private static final long serialVersionUID = -8027877730516686478L;

	public ForeseeEnabledException() { 
		
		 super();
		 
		 }
	
	  public ForeseeEnabledException(String message) { 
		  
		  super(message); 
		  
		  }
	  
	  public ForeseeEnabledException(String message, Throwable cause) { 
		  
		  super(message, cause);
		  
		  }
	  
	  public ForeseeEnabledException(Throwable cause) {
		  
		  super(cause);
		  
		  }
}
