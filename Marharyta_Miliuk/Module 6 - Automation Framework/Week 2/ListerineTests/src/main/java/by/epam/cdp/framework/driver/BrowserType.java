package by.epam.cdp.framework.driver;

public enum BrowserType {
	
     FIREFOX, CHROME, IE;
	
	
	public static BrowserType byName (String name){
		if ((name == null)||(name.isEmpty()))
		return null;
		
		try{
			return BrowserType.valueOf(name.toUpperCase());
		}
		catch (IllegalArgumentException e){
			return null;
		}
	}
	
	@Override 
	public String toString(){
		return name();
	}

}
