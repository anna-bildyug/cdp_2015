package by.epam.cdp.java.nypresent.beans;

public class Lollypop extends Sweets{
	
	public Lollypop (String name){
	    super.setName(name);
	    super.setWeight(5);
	    super.setMainIngredient("Caramel");	
	    super.setCandyType(TypeOfCandy.LOLLYPOP);
	}
	public Lollypop (String name, int weight, String mainIngredient){
	    super.setName(name);
	    super.setWeight(weight);
	    super.setMainIngredient(mainIngredient);	
	    super.setCandyType(TypeOfCandy.LOLLYPOP);
	}

}