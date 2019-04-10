package by.azhulpa.task4.autoservice.ui.action;

import by.azhulpa.task4.autoservice.facade.Facade;
import by.azhulpa.task4.autoservice.ui.IAction;
import by.azhulpa.task4.autoservice.utils.KeyboardInput;

public class PlaceRemoval implements IAction {

	public void execute() {
		Facade facade = Facade.getInstance();
		
		System.out.println("Enter service place id");
		
		facade.placeManager.remove(Long.valueOf(KeyboardInput.input()));
		facade.placeManager.save();
		
		System.out.println("Service place removed!");
	}

}
