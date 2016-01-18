package runner;

import buisnessobjects.StaticFactoryOrder;
import msg.demands.PurchaseOrdersCreator;

public class Runner {
	public static void main(String[] args) {
		PurchaseOrdersCreator orderCreator = new PurchaseOrdersCreator();
		orderCreator.createPurchaseOrderMin(StaticFactoryOrder.createSimpleOrder());
	}
}
