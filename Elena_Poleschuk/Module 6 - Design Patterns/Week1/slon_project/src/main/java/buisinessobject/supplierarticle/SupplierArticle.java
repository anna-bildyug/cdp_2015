package buisinessobject.supplierarticle;

public class SupplierArticle {
	
	private String articleName;
	private String articleDescription;
	
	public SupplierArticle(){
	};
	
	public SupplierArticle(String articleName, String articleDescription){
		this.articleName = articleName;
		this.articleDescription = articleDescription;
	}	
	
	public void setArticleName(String articleName){
		this.articleName = articleName;
	}
	
	public void setArticleDescription(String articleDescription){
		this.articleDescription = articleDescription;
	}
	
	public String getArticleName(){
		return articleName;
	}
	
	public String getArticleDescription(){
		return articleDescription;
	}

}
