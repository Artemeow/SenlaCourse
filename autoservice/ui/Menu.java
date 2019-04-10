package by.azhulpa.task4.autoservice.ui;

public class Menu {

	private String name;
	private MenuItem[] menuItems;
			
	public Menu(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public MenuItem[] getMenuItems() {
		return menuItems;
	}
	public void setMenuItems(MenuItem[] menuItems) {
		this.menuItems = menuItems;
	}
	
}
