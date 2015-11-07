package by.epam.tat.lecture2.task1.objects;

public class SugarCandy extends Sweets{
	private boolean lollipop;
	private String flavour;

	public SugarCandy(String sweetName, String producerName, int price, int weight, boolean lollipop, String flavour) {
		super(sweetName, producerName, price, weight);
		this.lollipop = lollipop;
		this.flavour = flavour;
		
	}
		
	private String getflavour(){
		return flavour;
	}
	private void setFlavour (String flavour){
		this.flavour = flavour;
	}

	
	private boolean isLollipop(){
		return lollipop;
	}
	private void setLollipop (boolean lollipop){
		this.lollipop = lollipop;
	}

	public String getInfo(){
		return super.toString()
				+", lollipop: " + this.lollipop;
	}
	public String toString(){
		return super.toString() + ", lollipop: " + this.lollipop;
	}
}