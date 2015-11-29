package by.epam.tat.task7.objects;

public class SugarCandy extends Sweets {
	private boolean lollipop;
	private String flavour;

	public SugarCandy(String sweetName, String producerName, int price, int weight, boolean lollipop, String flavour) {
		super(sweetName, producerName, price, weight);
		this.lollipop = lollipop;
		this.flavour = flavour;

	}

	@SuppressWarnings("unused")
	private String getflavour() {
		return flavour;
	}

	@SuppressWarnings("unused")
	private void setFlavour(String flavour) {
		this.flavour = flavour;
	}

	@SuppressWarnings("unused")
	private boolean isLollipop() {
		return lollipop;
	}

	@SuppressWarnings("unused")
	private void setLollipop(boolean lollipop) {
		this.lollipop = lollipop;
	}

	public String getInfo() {
		return super.toString() + ", lollipop: " + this.lollipop;
	}

	@Override
	public String toString() {
		return super.toString() + ", lollipop: " + this.lollipop + ", flavour: " + this.flavour;
	}
}