package by.azhulpa.task4.autoservice.ui;

public class MenuOrder {

	private static MenuOrder instance;
	private static Menu rootMenu;
	
	private MenuOrder() {
		rootMenu = new Menu("Order menu");
	}

	private void buildMenu() {
		MenuItem first = new MenuItem("Manager", null, OrderManagerMenu.getInstance());
		MenuItem second = new MenuItem("Service", null, OrderServiceMenu.getInstance());
		
		MenuItem[] items = {first, second};
		
		rootMenu.setMenuItems(items);
	}

	public static Menu getInstance() {
		if(rootMenu == null) {
			instance = new MenuOrder();
			instance.buildMenu();
		}
		return rootMenu;
	}
}
