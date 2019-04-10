package by.azhulpa.task4.autoservice.ui;

import by.azhulpa.task4.autoservice.ui.action.CountPlacesOnAnyDateInFuture;
import by.azhulpa.task4.autoservice.ui.action.FreeServicePlaces;

public class MechanicServiceMenu {
	
	private static MechanicServiceMenu instance;
	private static Menu rootMenu;
	
	private MechanicServiceMenu() {
		rootMenu = new Menu("Services");
	}

	private void buildMenu() {
		MenuItem first = new MenuItem("Free Service Places", new FreeServicePlaces(), null);
		MenuItem second = new MenuItem("Count Places On Any Date In Future", new CountPlacesOnAnyDateInFuture(), null);
		
		MenuItem[] items = {first, second};
		
		rootMenu.setMenuItems(items);
	}

	public static Menu getInstance() {
		if(instance == null) {
			instance = new MechanicServiceMenu();
			instance.buildMenu();
		}
		return rootMenu;
	}
}
