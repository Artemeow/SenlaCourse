package by.azhulpa.task4.autoservice.ui.action;

import java.util.Date;

import by.azhulpa.task4.autoservice.facade.Facade;
import by.azhulpa.task4.autoservice.ui.IAction;

public class NearestFreeDate implements IAction {

	public void execute() {
		Facade facade = Facade.getInstance();
		
		Date result = facade.orderService.getNearestFreeDate(
				facade.orderManager.getAll(),
				facade.mechanicManager.getAll(),
				facade.placeManager.getAll());
		System.out.println("Nearest free date -> " + result);
	}
}
