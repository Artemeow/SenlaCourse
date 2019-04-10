package by.azhulpa.task4.autoservice.ui;

public class MenuItem {

	private String title;
	private IAction action;
	private Menu nextMenu;
	
	public MenuItem(String title, IAction action, Menu nextMenu) {
		this.title = title;
		this.action = action;
		this.nextMenu = nextMenu;
	}
	
	public Menu getNextMenu() {
		return nextMenu;
	}

	public String getTitle() {
		return title;
	}

	public void doAction() {
		action.execute();
	}

}
