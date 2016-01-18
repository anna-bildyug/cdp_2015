package buisnessobjects;

public class Order {

	protected String MAIL_PARTNER; // to properties
	protected String ORGANIZATION_CODE; // to properties
	protected String SELLER_NO;  // to properties
	protected String PLANT_CODE;  // to properties
	
	protected String CUSTOMER_ARTICLE_DESCRIPTION; // need to follow-up 
	protected String CUSTOMER_ARTICLE; // need to follow-up 
	protected String UNLODING_POINT; // need to follow-up
	protected String DEMAND_NUMBER; // need to follow-up 
	
	protected int COUNT_MSG_IN_FILE; // need to follow-up
	protected int POSITION_COUNT; // need to follow-up
	protected int SCHEDULE_LINES_COUNT; // need to follow-up
	
	protected String UOM; // need to follow-up
	protected int DOC_CODE_DEMAND;  // need to follow-up 
	protected String CURRENCY; // need to follow-up
	protected int ACTION_CODE ;
	protected String RESPONSE_NEED; 
	protected String DELIVERY_NEED;
	protected String DELIVERY_TYPE; 
	protected String INVOICE_NEED; 
	
		
	public Order(String MAIL_PARTNER, String ORGANIZATION_CODE, String SELLER_NO, String PLANT_CODE) {
		this.MAIL_PARTNER = MAIL_PARTNER;
		this.ORGANIZATION_CODE = ORGANIZATION_CODE;
		this.SELLER_NO = SELLER_NO;
		this.PLANT_CODE = PLANT_CODE;	
	}

	public Order(String MAIL_PARTNER, String ORGANIZATION_CODE, String SELLER_NO, String PLANT_CODE,
			String DEMAND_NUMBER, String CUSTOMER_ARTICLE, String CUSTOMER_ARTICLE_DESCRIPTION, String UNLODING_POINT,
			int COUNT_MSG_IN_FILE, int POSITION_COUNT, int SCHEDULE_LINES_COUNT, String UOM,
			int DOC_CODE_DEMAND, String CURRENCY, int ACTION_CODE, String RESPONSE_NEED, String DELIVERY_NEED,
			String DELIVERY_TYPE, String INVOICE_NEED) {
		this.MAIL_PARTNER = MAIL_PARTNER;
		this.ORGANIZATION_CODE = ORGANIZATION_CODE;
		this.SELLER_NO = SELLER_NO;
		this.PLANT_CODE = PLANT_CODE;	
		
		this.DEMAND_NUMBER = DEMAND_NUMBER;
		this.CUSTOMER_ARTICLE = CUSTOMER_ARTICLE;
		this.CUSTOMER_ARTICLE_DESCRIPTION = CUSTOMER_ARTICLE_DESCRIPTION;
		this.UNLODING_POINT = UNLODING_POINT;
		this.COUNT_MSG_IN_FILE = COUNT_MSG_IN_FILE;
		this.POSITION_COUNT = POSITION_COUNT;
		this.SCHEDULE_LINES_COUNT = SCHEDULE_LINES_COUNT;
		this.UOM = UOM;
		this.DOC_CODE_DEMAND = DOC_CODE_DEMAND;
		this.CURRENCY = CURRENCY;
		this.ACTION_CODE = ACTION_CODE;
		this.RESPONSE_NEED = RESPONSE_NEED;
		this.DELIVERY_NEED = DELIVERY_NEED;
		this.DELIVERY_TYPE = DELIVERY_TYPE;
		this.INVOICE_NEED = INVOICE_NEED;
	}
	
	public void setDemandNumber(String DEMAND_NUMBER){
		this.DEMAND_NUMBER = DEMAND_NUMBER;
	}
	public String getDemandNumber(){
		return this.DEMAND_NUMBER;
	}	
	
	
	public void setCustomerArticle(String CUSTOMER_ARTICLE){
		this.CUSTOMER_ARTICLE = CUSTOMER_ARTICLE;
	}
	public String getCustomerArticle(){
		return this.CUSTOMER_ARTICLE;
	}	
	
	
	public void setCustomerArticleDescription(String CUSTOMER_ARTICLE_DESCRIPTION){
		this.CUSTOMER_ARTICLE_DESCRIPTION = CUSTOMER_ARTICLE_DESCRIPTION;
	}
	public String getCustomerArticleDescription(){
		return this.CUSTOMER_ARTICLE_DESCRIPTION;
	}
	
		
	public void setUnlodingPoint(String UNLODING_POINT){
		this.UNLODING_POINT = UNLODING_POINT;
	}
	public String getUnlodingPoint(){
		return this.UNLODING_POINT;
	}
	
	public void setCountMSGinFile(int COUNT_MSG_IN_FILE){
		this.COUNT_MSG_IN_FILE = COUNT_MSG_IN_FILE;
	}
	public int getCountMSGinFile(){
		return this.COUNT_MSG_IN_FILE;
	}
	
	public void setPositionCount(int POSITION_COUNT){
		this.POSITION_COUNT = POSITION_COUNT;
	}
	public int getPositionCount(){
		return this.POSITION_COUNT;
	}
	
	public void setScheduleLinesCount(int SCHEDULE_LINES_COUNT){
		this.SCHEDULE_LINES_COUNT = SCHEDULE_LINES_COUNT;
	}
	public int getScheduleLinesCount(){
		return this.SCHEDULE_LINES_COUNT;
	}

	public void setUOM(String UOM){
		this.UOM = UOM;
	}
	public String getUOM(){
		return this.UOM;
	}
	
	public void setDocCodeDemand(int DOC_CODE_DEMAND){
		this.DOC_CODE_DEMAND = DOC_CODE_DEMAND;
	}
	public int getDocCodeDemand(){
		return this.DOC_CODE_DEMAND;
	}
	
	public void setCurrency(String CURRENCY){
		this.CURRENCY = CURRENCY;
	}
	public String getCurrency(){
		return this.CURRENCY;
	}

	public void setActionCode(int ACTION_CODE){
		this.ACTION_CODE = ACTION_CODE;
	}
	public int getActionCode(){
		return this.ACTION_CODE;
	}
	
	public void setResponseNeed(String RESPONSE_NEED){
		this.RESPONSE_NEED = RESPONSE_NEED;
	}
	public String getResponseNeed(){
		return this.RESPONSE_NEED;
	}
	
	public void setDeliveryNeed(String DELIVERY_NEED){
		this.DELIVERY_NEED = DELIVERY_NEED;
	}
	public String getDeliveryNeed(){
		return this.DELIVERY_NEED;
	}
	
	public void setDeliveryType(String DELIVERY_TYPE){
		this.DELIVERY_TYPE = DELIVERY_TYPE;
	}
	public String getDeliveryType(){
		return this.DELIVERY_TYPE;
	}
	
	public void setInvoiceNeed(String INVOICE_NEED){
		this.INVOICE_NEED = INVOICE_NEED;
	}
	public String getInvoiceNeed(){
		return this.INVOICE_NEED;
	}
	
}
