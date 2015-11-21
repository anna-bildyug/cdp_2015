package by.epam.cdp.java.nypresent.beans;

public class Bar extends Sweets {
	
	public Bar(String name){
		super.setName(name);
		super.setWeight(15);
		super.setMainIngredient("Nougat");	
		super.setCandyType(TypeOfCandy.BAR);
	}
	public Bar (String name, int weight, String mainIngredient){
		
		super.setName(name);
		super.setWeight(weight);
		super.setMainIngredient(mainIngredient);	
		super.setCandyType(TypeOfCandy.BAR);
	}

}