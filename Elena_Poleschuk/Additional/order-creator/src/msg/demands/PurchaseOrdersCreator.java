package msg.demands;

import buisnessobjects.Order;
import utils.DateUtils;
import utils.FileSaver;

public class PurchaseOrdersCreator {
	private String MAIL_PARTNER = "Trg SFR"; // to properties
	private String ORGANIZATION_CODE = "OBLE"; // to properties
	private String SELLER_NO = "SLE35BLE1";  // to properties
	private String PLANT_CODE = "PBLE1CP035";  // to properties

	public String createPurchaseOrderMin(Order orderData) {
		String currency = orderData.getCurrency();
		int countPosition = orderData.getPositionCount();
		int countScheduleLines = orderData.getScheduleLinesCount();
		int countMsgInFile = orderData.getCountMSGinFile();
		String UOM = orderData.getUOM();
		// responseNeed + deliveryNeed + invoiceNeed 
		String responseNeed = orderData.getResponseNeed();
		String deliveryNeed = orderData.getDeliveryNeed();
		String invoiceNeed = orderData.getInvoiceNeed();
		
		String customerArticleDescription = orderData.getCustomerArticleDescription();
		String customerArticle = orderData.getCustomerArticle();
		
		String deliveryType = orderData.getDeliveryType();
		String unlodingPoint = orderData.getUnlodingPoint();
		
		FileSaver saver = new FileSaver();
		String fileName =  "Order_" + DateUtils.getFullDateAndTime() + ".txt"; 
		Long curentDate102 = Long.parseLong(DateUtils.getDateFormat102());
		
		saver.saveFile(fileName, "UNA:+.? '");
		for (int countMsg = 1; countMsg<= countMsgInFile; countMsg++){
			int counter = 0;
			saver.saveFile(fileName, "UNB+UNOC:3+" + MAIL_PARTNER + ":1:OriginMessage1+OSUPPLYON+" + DateUtils.getDateFormat203() + "+0000200003'");
			counter ++;
			saver.saveFile(fileName, "UNH+" + countMsg + "+ORDERS:D:99B:UN'");
			counter ++;
			saver.saveFile(fileName, "BGM+" + orderData.getDocCodeDemand() + ":1::Purchase Orders SupplyOn+" + orderData.getDemandNumber() + "+" + orderData.getActionCode() + "'");
			counter ++;
			saver.saveFile(fileName, "DTM+137:" + curentDate102 + ":102'");
			counter ++;
			saver.saveFile(fileName, "NAD+BY+" + PLANT_CODE +  "::92+" + ORGANIZATION_CODE + ":Demo Buyer+Demo Buyer SA:Buyer Name2:Buyer Name3:Buyer Name4+Ludwigstrasse 49+Hallbergmoos+1A1+85399+DE'");
			counter ++;
			saver.saveFile(fileName, "NAD+SU+" + SELLER_NO + "::92++Demo Seller GmbH:Supplier Name2:Supplier Name3:Supplier Name4+Kastanienweg 12+Bremen+1A1+45678+DE'");
			counter ++;
			saver.saveFile(fileName, "NAD+CN+" + PLANT_CODE+ "::92+OBLE:Demo Buyer+Plant 2:Consignee Name2:Consignee Name3:Consignee Name4+Burgweg 341+Hamburg++20095+DE'");
			counter ++;
			saver.saveFile(fileName, "LOC+11+" + unlodingPoint + "'");
			counter ++;
			for (int cp = 1; cp <= countPosition; cp++){
				saver.saveFile(fileName, "LIN+" + cp + "++" + customerArticle + ":IN'");
				counter ++;	
				saver.saveFile(fileName, "IMD+F+1+:::" + customerArticleDescription + "'");
				counter ++;
				saver.saveFile(fileName, "QTY+113:" + 100 + ":PCE'");
				counter ++;
				saver.saveFile(fileName, "ALI+FR++S+" + responseNeed + "+" + deliveryNeed + "+" +  invoiceNeed + "+N'");
				counter ++;
				saver.saveFile(fileName, "ALI++S+" + deliveryType + "'");
				counter ++;
				saver.saveFile(fileName, "DTM+2:" + (curentDate102+2) + ":102'");
				counter ++;
				saver.saveFile(fileName, "MOA+203:1:" + currency + "'");
				counter ++;
				saver.saveFile(fileName, "MOA+128:2:" + currency + "'");
				counter ++;
				saver.saveFile(fileName, "PRI+AAA:120:::100:" + UOM + "'");
				counter ++;
				saver.saveFile(fileName, "CUX+2:" + currency + "'");
				counter ++;
				
				for (int cs = 1; cs <= countScheduleLines; cs++){
					saver.saveFile(fileName, "SCC+1'");
					counter ++;
					saver.saveFile(fileName, "QTY+113:" + 10 + ":" + UOM + "'");
					counter ++;
					saver.saveFile(fileName, "DTM+2:" + (curentDate102+1) + ":102'");
					counter ++;
				}
				saver.saveFile(fileName, "UNS+D'");
				counter ++;
				saver.saveFile(fileName, "MOA+79:1:" + currency + "'");
				counter ++;
				saver.saveFile(fileName, "MOA+116:2:" + currency + "'");
				counter ++;
			}
		
			saver.saveFile(fileName, "UNT+" + counter + "+1'");
		}
		saver.saveFile(fileName, "UNZ+" + countMsgInFile + "+14'");
		
		return fileName;
	}

}
