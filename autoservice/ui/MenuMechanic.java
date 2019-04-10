package by.azhulpa.task4.autoservice.ui;

public class MenuMechanic {
	
	private static MenuMechanic instance;
	private static Menu rootMenu;
	
	private MenuMechanic() {
		rootMenu = new Menu("Mechanic menu");
	}

	private void buildMenu() {
		MenuItem first = new MenuItem("Manager", null, MechanicManagerMenu.getInstance());
		MenuItem second = new MenuItem("Service", null, MechanicServiceMenu.getInstance());
		
		MenuItem[] items = {first, second};
		
		rootMenu.setMenuItems(items);
	}

	public static Menu getInstance() {
		if(rootMenu == null) {
			instance = new MenuMechanic();
			instance.buildMenu();
		}
		return rootMenu;
	}
}
