package by.azhulpa.task4.autoservice.ui.action;

import by.azhulpa.task4.autoservice.facade.Facade;
import by.azhulpa.task4.autoservice.ui.IAction;
import by.azhulpa.task4.autoservice.utils.DateInput;

public class CountPlacesOnAnyDateInFuture implements IAction{

	private static final String CONTEXT = "Enter date";
	
	public void execute() {
		Facade facade = Facade.getInstance();
		
		int countPlaces = facade.placeService.countPlacesOnAnyDateInFuture(
				facade.orderManager.getAll(),
				DateInput.getDate(CONTEXT),
				facade.mechanicManager.getAll(),
				facade.placeManager.getAll());
		
		System.out.println("Number of empty places: " + countPlaces);	
	}
}
