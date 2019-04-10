package by.azhulpa.task4.autoservice.ui;

import by.azhulpa.task4.autoservice.ui.action.AddingOrder;
import by.azhulpa.task4.autoservice.ui.action.OrderRemoval;

public class OrderManagerMenu {

	private static OrderManagerMenu instance;
	private static Menu rootMenu;
	
	private OrderManagerMenu() {
		rootMenu = new Menu("Manager");
	}

	private void buildMenu() {
		MenuItem first = new MenuItem("Add order", new AddingOrder(), null);
		MenuItem second = new MenuItem("Remove order", new OrderRemoval(), null);
		
		MenuItem[] items = {first, second};
		
		rootMenu.setMenuItems(items);
	}

	public static Menu getInstance() {
		if(rootMenu == null) {
			instance = new OrderManagerMenu();
			instance.buildMenu();
		}
		return rootMenu;
	}
}
