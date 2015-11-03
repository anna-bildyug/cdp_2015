package sweets.newyearpresent;

public abstract class Sweets {
	
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
	
}
