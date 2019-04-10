package by.azhulpa.task4.autoservice.ui;

import by.azhulpa.task4.autoservice.ui.action.AddingMechanic;
import by.azhulpa.task4.autoservice.ui.action.MechanicRemoval;

public class MechanicManagerMenu {

	private static MechanicManagerMenu instance;
	
	private static Menu rootMenu;
	
	private MechanicManagerMenu() {
		rootMenu = new Menu("Manager");
	}

	private void buildMenu() {
		MenuItem first = new MenuItem("Add mechanic", new AddingMechanic(), null);
		MenuItem second = new MenuItem("Remove mechanic", new MechanicRemoval(), null);
		
		MenuItem[] items = {first, second};
		
		rootMenu.setMenuItems(items);
	}

	public static Menu getInstance() {
		if(instance == null) {
			instance = new MechanicManagerMenu();
			instance.buildMenu();
		}
		return rootMenu;
	}
}
