package by.epam.cdp.framework.businessobjects;

import java.util.ArrayList;
import java.util.List;

public class Product {
	
	public enum Category {Toothpaste, Floss, OnTheGo}
	private List <ProductInfo> info;
	
	public Product (){
		info = new ArrayList<>();
	}
	
	public void addProductInfo (ProductInfo productInfo){
		info.add(productInfo);
	}
	
	public List <ProductInfo> getInfo (){
		return info;
	}
	
}
