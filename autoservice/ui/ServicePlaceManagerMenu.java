package by.azhulpa.task4.autoservice.ui;

import by.azhulpa.task4.autoservice.ui.action.AddingPlace;
import by.azhulpa.task4.autoservice.ui.action.PlaceRemoval;

public class ServicePlaceManagerMenu {

	private static ServicePlaceManagerMenu instance;
	
	private static Menu rootMenu;
	
	private ServicePlaceManagerMenu() {
		rootMenu = new Menu("Manager");
	}

	private void buildMenu() {
		MenuItem first = new MenuItem("Add service place", new AddingPlace(), null);
		MenuItem second = new MenuItem("Remove service place", new PlaceRemoval(), null);
		
		MenuItem[] items = {first, second};
		
		rootMenu.setMenuItems(items);
	}

	public static Menu getInstance() {
		if(instance == null) {
			instance = new ServicePlaceManagerMenu();
			instance.buildMenu();
		}
		return rootMenu;
	}
}
