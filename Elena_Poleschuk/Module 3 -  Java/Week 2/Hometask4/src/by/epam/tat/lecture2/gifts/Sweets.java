package by.epam.tat.lecture2.gifts;

public abstract class Sweets {
	protected String sweetName;
	protected String producerName;
	protected int price;
	protected int weight;
	
	public Sweets (String sweetName, String producerName, int price, int weight){
		this.sweetName = sweetName;
		this.producerName = producerName;
		this.price = price;
		this.weight = weight;
	}
	
	public String getSweetName(){
		return sweetName;
	}
	
	public String getProducerName(){
		return producerName;
	}
	
	public int getPrice(){
		return price;
	}

	public int getWeight(){
		return weight;
	}
	
	public void setSweetName(String sweetName){
		this.sweetName = sweetName;
	}
	
	public void producerName(String producerName){
		this.producerName = producerName;
	}
	
	public void setPrice(int price){
		this.price = price;
	}

	public void setWeight(int weight){
		this.weight = weight;
	}
	
	public String getInfo(){
		return "Name: " + this.sweetName + ", Producer: " + this.producerName + ", Price: " + this.price + ", Weight: " + this.weight;
	}
}




