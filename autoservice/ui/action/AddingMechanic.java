package by.azhulpa.task4.autoservice.ui.action;

import by.azhulpa.task4.autoservice.facade.Facade;
import by.azhulpa.task4.autoservice.ui.IAction;
import by.azhulpa.task4.autoservice.utils.KeyboardInput;

public class AddingMechanic implements IAction {

	public void execute() {
		Facade facade = Facade.getInstance();
		
		System.out.println("Enter full name mechanic");
		String name = KeyboardInput.input();
		
		System.out.println("Enter age mechanic");
		Integer age = Integer.valueOf(KeyboardInput.input());
		
		System.out.println("Enter address mechanic");
		String address = KeyboardInput.input();
		
		facade.mechanicManager.add(facade.createMechanic(name, age, address));
		facade.mechanicManager.save();
		
		System.out.println("Service place added!");
	}
}
