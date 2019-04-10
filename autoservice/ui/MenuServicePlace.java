package by.azhulpa.task4.autoservice.ui;

public class MenuServicePlace {
	
	private static MenuServicePlace instance;
	private static Menu rootMenu;
	
	private MenuServicePlace() {
		rootMenu = new Menu("Service place menu");
	}
	
	private void buildMenu() {
		MenuItem first = new MenuItem("Manager", null, ServicePlaceManagerMenu.getInstance());
		MenuItem second = new MenuItem("Service", null, ServicePlaceServiceMenu.getInstance());
		
		MenuItem[] items = {first, second};
		
		rootMenu.setMenuItems(items);
	}

	public static Menu getInstance() {
		if(rootMenu == null) {
			instance = new MenuServicePlace();
			instance.buildMenu();
		}
		return rootMenu;
	}
}
