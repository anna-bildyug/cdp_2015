package sweets.newyearpresent;

public class ChocolateCandy extends Sweets{
	
	public ChocolateCandy (String colour, String name){
		super.setWrapperColour(colour);
		super.setName(name);
		super.setWeight(10);
		super.setMainIngredient("Chocolate");	
	}

}
