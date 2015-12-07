package by.epam.cdp.java.nypresent.beans;

import by.epam.cdp.java.nypresent.validation.WrongTypeOfCandyException;

public enum TypeOfCandy {
	
	BAR("Bar"), LOLLYPOP("Lollypop"), CHOCOLATE("Chocolate Candy");
	
	
	      private final String value;
	
	      TypeOfCandy(String value) {
		  this.value = value;
		 }

		  public String getValue() {
		  return value;
		 }
		  
		 public static TypeOfCandy fromValue (String value) throws WrongTypeOfCandyException{
			 for(TypeOfCandy candyType: values()){
				 if (candyType.getValue().equals(value)){
					 return candyType;
				 }
				 
			 }
			 throw new WrongTypeOfCandyException("There are no candies with the type" + value);
			 
		 }
	
}
