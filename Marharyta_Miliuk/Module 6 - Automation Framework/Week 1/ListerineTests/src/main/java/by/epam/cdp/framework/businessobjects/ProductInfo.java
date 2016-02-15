package by.epam.cdp.framework.businessobjects;

public class ProductInfo {

	private Product.Category categories;
	private String symptom;
	private String lifestage;
	
	public ProductInfo (Product.Category categories, String symptom, String lifestage ){
		this.categories = categories;
		this.symptom = symptom;
		this.lifestage = lifestage;		
	}
	
	public Product.Category getCategories (){
		return categories;
	}
	
	public void setCategory (Product.Category categories){
		this.categories = categories;
	}

	public String getSymptom() {
		return symptom;
	}

	public void setSymptom(String symptom) {
		this.symptom = symptom;
	}

	public String getLifestage() {
		return lifestage;
	}

	public void setLifestage(String lifestage) {
		this.lifestage = lifestage;
	}
	
}
