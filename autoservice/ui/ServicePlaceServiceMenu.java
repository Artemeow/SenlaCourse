package by.azhulpa.task4.autoservice.ui;

import by.azhulpa.task4.autoservice.ui.action.SortingMechanicsAlphabetically;
import by.azhulpa.task4.autoservice.ui.action.SortingMechanicsByStatus;

public class ServicePlaceServiceMenu {

	private static ServicePlaceServiceMenu instance;
	private static Menu rootMenu;
	
	private ServicePlaceServiceMenu() {
		rootMenu = new Menu("Services");
	}

	private void buildMenu() {
		MenuItem first = new MenuItem("Sort alphabetically", new SortingMechanicsAlphabetically(), null);
		MenuItem second = new MenuItem("Sort by status", new SortingMechanicsByStatus(), null);
		
		MenuItem[] items = {first, second};
		
		rootMenu.setMenuItems(items);
	}

	public static Menu getInstance() {
		if(instance == null) {
			instance = new ServicePlaceServiceMenu();
			instance.buildMenu();
		}
		return rootMenu;
	}
}
