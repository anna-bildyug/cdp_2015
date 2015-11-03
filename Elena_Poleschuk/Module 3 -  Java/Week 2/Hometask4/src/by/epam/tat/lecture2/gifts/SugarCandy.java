package by.epam.tat.lecture2.gifts;

public class SugarCandy extends Sweets{
	boolean lollipop;

	public SugarCandy(String sweetName, String producerName, int price, int weight, boolean lollipop) {
		super(sweetName, producerName, price, weight);
		this.lollipop = lollipop;
	}
		
	private boolean isLollipop(){
		return lollipop;
	}
	private void setLollipop (boolean lollipop){
		this.lollipop = lollipop;
	}

	public String getInfo(){
		return super.getInfo()
				+", lollipop: " + this.lollipop;
	}
}