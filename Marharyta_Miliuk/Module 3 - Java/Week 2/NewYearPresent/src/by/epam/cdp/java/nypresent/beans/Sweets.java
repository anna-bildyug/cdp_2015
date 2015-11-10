package by.epam.cdp.java.nypresent.beans;

public abstract class Sweets implements Comparable <Sweets> {//implementing comparable interface to make Sweets objects comparable and achieve possibility to sort them using comparator
	
	private int weight;
	private String name;
	private String mainIngredient;
	
	public int getWeight(){
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getMainIngredient(){
		return mainIngredient;
	}
	public void setMainIngredient(String mainIngredient){
		this.mainIngredient = mainIngredient;
	}
	public int compareTo(Sweets compareSweets) {//creating compare method to make objects comparable
		int compareWeight = ((Sweets) compareSweets).getWeight(); 
		return this.weight - compareWeight;
}
	@Override 
	public String toString (){//overriding toString method to print exact message to the console
		return "Name of candy: " + name + " " +  "Weight: " + weight + " " + "Main ingridient: " + mainIngredient;
	}
}