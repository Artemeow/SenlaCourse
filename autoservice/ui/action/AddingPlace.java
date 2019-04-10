package by.azhulpa.task4.autoservice.ui.action;

import by.azhulpa.task4.autoservice.facade.Facade;
import by.azhulpa.task4.autoservice.ui.IAction;

public class AddingPlace implements IAction {

	public void execute() {
		Facade facade = Facade.getInstance();
		
		facade.placeManager.add(facade.createPlace());
		facade.placeManager.save();
		
		System.out.println("Service place added!");
	}
}
