package buisnessobjects;

import utils.DateUtils;

public class StaticFactoryOrder {
	private static Order order;
	
	public static Order createSimpleOrder(){
		String MAIL_PARTNER = "Trg SFR"; // to properties
		String ORGANIZATION_CODE = "OBLE"; // to properties
		String SELLER_NO = "SLE35BLE1";  // to properties
		String PLANT_CODE = "PBLE1CP035";  // to properties
		
		order = new Order(MAIL_PARTNER, ORGANIZATION_CODE, SELLER_NO, PLANT_CODE);
		String demandNo = "O"+DateUtils.getShortDateAndTime();
		order.setDemandNumber(demandNo);
		order.setCustomerArticle(demandNo + "_Article");
		order.setCustomerArticleDescription(demandNo + "_Article Description");
		order.setUnlodingPoint(demandNo + "_UnlP");
		order.setCountMSGinFile(1);
		order.setPositionCount(1);
		order.setScheduleLinesCount(1);
		order.setUOM("PCE");
		order.setDocCodeDemand(220);
		order.setCurrency("EUR");
		order.setActionCode(9);
		order.setResponseNeed("Y");
		order.setDeliveryNeed("Y");
		order.setDeliveryType("BK");
		order.setInvoiceNeed("Y");
		return order;
	};
}
