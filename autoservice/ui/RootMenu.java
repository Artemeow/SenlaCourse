package by.azhulpa.task4.autoservice.ui;

public class RootMenu {

	private static RootMenu instance;
	
	private static Menu rootMenu;
	
	private RootMenu() {
		rootMenu = new Menu("Root menu");
	}

	private void buildMenu() {
		MenuItem mechanicMI = new MenuItem("Mechanic", null, MenuMechanic.getInstance());
		MenuItem orderMI = new MenuItem("Order", null, MenuOrder.getInstance());
		MenuItem placeMI =  new MenuItem("Place", null, MenuServicePlace.getInstance());
		
		MenuItem[] items = {mechanicMI, orderMI, placeMI};
		
		rootMenu.setMenuItems(items);
	}

	public static Menu getInstance() {
		if(instance == null) {
			instance = new RootMenu();
			instance.buildMenu();
		}
		return rootMenu;
	}
}
