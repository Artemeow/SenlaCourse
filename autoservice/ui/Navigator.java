package by.azhulpa.task4.autoservice.ui;

import java.util.ArrayDeque;
import java.util.Deque;

public class Navigator {

	private Menu currentMenu;
	private Deque<Menu> menuQueue;
	
	public Navigator(Menu currentMenu) {
		this.currentMenu = currentMenu;
		this.menuQueue = new ArrayDeque<Menu>();
	}
	
	public void printMenu() {			
		try {
			System.out.println("**" + currentMenu.getName() + "**");
			MenuItem[] items = currentMenu.getMenuItems();
			int i = 1;
			for(MenuItem menuItem : items) {
				System.out.println(i + " -> " + menuItem.getTitle());
				i++;
			}
			
			System.out.println("\n9 -> Back\n0 -> Close");
		} catch (Exception e) {
			System.out.println(currentMenu.getName() + " не содержит MenuItem");
		}
	}

	public void navigate(int index) {
		MenuItem[] menuItems = currentMenu.getMenuItems();
		
		if(index == 9 && !menuQueue.isEmpty()) {
			currentMenu = menuQueue.pop();
			return;
		}
		
		if(index == 9 && menuQueue.isEmpty()) {
			return;
		}
		
		
		if(menuItems[index - 1].getNextMenu() == null) {
			menuItems[index - 1].doAction();
		} else {
			menuQueue.push(currentMenu);
			currentMenu = menuItems[index - 1].getNextMenu();
		}
		
		
	}
}
