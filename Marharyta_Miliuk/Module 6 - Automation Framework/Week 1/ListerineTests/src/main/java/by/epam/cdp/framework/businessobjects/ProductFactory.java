package by.epam.cdp.framework.businessobjects;

public class ProductFactory {
	
	public static Product setProductToTest (Product.Category category, String productName, String productSymptom, String lifestageToUseOn){
		Product product = new Product();
		product.addProductInfo(new ProductInfo (category, productSymptom, lifestageToUseOn));
		return product;		
	}
}
