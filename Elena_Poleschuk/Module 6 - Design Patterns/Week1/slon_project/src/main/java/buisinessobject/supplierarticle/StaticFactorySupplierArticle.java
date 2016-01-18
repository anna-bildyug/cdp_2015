package buisinessobject.supplierarticle;

public class StaticFactorySupplierArticle {
	private static SupplierArticle supplierArticle;
	
	public static SupplierArticle createSimpleSupplierArticle(String supplierArticleNumber){
		supplierArticle = new SupplierArticle();
		supplierArticle.setArticleName(supplierArticleNumber);
		return supplierArticle;
	};
	
	public static SupplierArticle createFullFilledDefaultSupplierArticle(String supplierArticleNumber){
		supplierArticle = new SupplierArticle();
		supplierArticle.setArticleName(supplierArticleNumber);
		supplierArticle.setArticleDescription("Article Description");
		return supplierArticle;
	};
	
}
