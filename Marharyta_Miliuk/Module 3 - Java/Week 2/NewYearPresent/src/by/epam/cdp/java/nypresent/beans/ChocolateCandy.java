package by.epam.cdp.java.nypresent.beans;

public class ChocolateCandy extends Sweets {
	
	public ChocolateCandy (String name){
		super.setName(name);
		super.setWeight(10);
		super.setMainIngredient("Chocolate");	
		super.setCandyType(TypeOfCandy.CHOCOLATE);
	}


	public ChocolateCandy (String name, int weight, String mainIngredient){
		super.setName(name);
		super.setWeight(weight);
		super.setMainIngredient(mainIngredient);	
		super.setCandyType(TypeOfCandy.CHOCOLATE);
	}
}