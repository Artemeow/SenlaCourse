package by.azhulpa.task4.autoservice.ui;

import by.azhulpa.task4.autoservice.ui.action.CanceledOrdersForAPeriodOfTime;
import by.azhulpa.task4.autoservice.ui.action.ClosedOrdersForAPeriodOfTime;
import by.azhulpa.task4.autoservice.ui.action.ClosingOrder;
import by.azhulpa.task4.autoservice.ui.action.MechanicPerformingTheOrder;
import by.azhulpa.task4.autoservice.ui.action.NearestFreeDate;
import by.azhulpa.task4.autoservice.ui.action.OngoingOrders;
import by.azhulpa.task4.autoservice.ui.action.OrderCancellation;
import by.azhulpa.task4.autoservice.ui.action.OrderExecutedByMechanic;
import by.azhulpa.task4.autoservice.ui.action.SortingOrdersByCost;
import by.azhulpa.task4.autoservice.ui.action.SortingOrdersByDateAdoption;
import by.azhulpa.task4.autoservice.ui.action.SortingOrdersByDateEnding;
import by.azhulpa.task4.autoservice.ui.action.SortingOrdersByDateStart;

public class OrderServiceMenu {

	private static OrderServiceMenu instance;
	private static Menu rootMenu;
	
	private OrderServiceMenu() {
		rootMenu = new Menu("Service");
	}

	private void buildMenu() {
		MenuItem item = new MenuItem("Cancel order", new OrderCancellation(), null);
		MenuItem item2 = new MenuItem("Close order", new ClosingOrder(), null);
		MenuItem item3 = new MenuItem("Get ongoing orders", new OngoingOrders(), null);
		MenuItem item4 = new MenuItem("Get order executed by mechanic", new OrderExecutedByMechanic(), null);
		MenuItem item5 = new MenuItem("Get mechanic performing the order", new MechanicPerformingTheOrder(), null);
		MenuItem item6 = new MenuItem("Get closed orders for a period of time", new ClosedOrdersForAPeriodOfTime(), null);
		MenuItem item7 = new MenuItem("Get canceled orders for a period of time", new CanceledOrdersForAPeriodOfTime(), null);
		MenuItem item8 = new MenuItem("Get nearest free date", new NearestFreeDate(), null);
		MenuItem item9 = new MenuItem("Sort by date adoption", new SortingOrdersByDateAdoption(), null);
		MenuItem item10 = new MenuItem("Sort by date start", new SortingOrdersByDateStart(), null);
		MenuItem item11 = new MenuItem("Sort by date ending", new SortingOrdersByDateEnding(), null);
		MenuItem item12 = new MenuItem("Sort by cost", new SortingOrdersByCost(), null);
		
		MenuItem[] items = {item, item2, item3, item4,
				item5, item6, item7, item8,
				item9, item10, item11, item12};
		
		rootMenu.setMenuItems(items);
	}

	public static Menu getInstance() {
		if(rootMenu == null) {
			instance = new OrderServiceMenu();
			instance.buildMenu();
		}
		return rootMenu;
	}
}
