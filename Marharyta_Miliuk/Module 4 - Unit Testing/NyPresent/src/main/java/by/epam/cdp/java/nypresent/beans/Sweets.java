package by.epam.cdp.java.nypresent.beans;

public abstract class Sweets implements Comparable <Sweets> {//implementing comparable interface to make Sweets objects comparable and achieve possibility to sort them using comparator
	
	private int weight;
	private String name;
	private String mainIngredient;
	private TypeOfCandy candyType;
	
	public TypeOfCandy getCandyType() {
			return candyType;
		}
	public void setCandyType (TypeOfCandy candyType){
			this.candyType = candyType;
		}
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
		return "Type: " + candyType.getValue() + " " + "Name of candy: " + name + " " +  "Weight: " + weight + " " + "Main ingredient: " + mainIngredient;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((candyType == null) ? 0 : candyType.hashCode());
		result = prime * result + ((mainIngredient == null) ? 0 : mainIngredient.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + weight;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sweets other = (Sweets) obj;
		if (candyType != other.candyType)
			return false;
		if (mainIngredient == null) {
			if (other.mainIngredient != null)
				return false;
		} else if (!mainIngredient.equals(other.mainIngredient))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (weight != other.weight)
			return false;
		return true;
	}
}