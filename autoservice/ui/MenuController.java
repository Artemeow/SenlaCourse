package by.azhulpa.task4.autoservice.ui;

import by.azhulpa.task4.autoservice.utils.KeyboardInput;

public class MenuController {

	public static void run() {
		Navigator navigator = new Navigator(RootMenu.getInstance());
		
		int i = 1;
		while(i != 0) {
			navigator.printMenu();
			
			i = Integer.valueOf(KeyboardInput.input());
			
			if(i == 0) {
				continue;
			}
			
			navigator.navigate(i);
		}
	}
} 