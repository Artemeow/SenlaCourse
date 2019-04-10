package by.azhulpa.task4.autoservice.ui.action;

import java.util.Date;

import by.azhulpa.task4.autoservice.facade.Facade;
import by.azhulpa.task4.autoservice.ui.IAction;
import by.azhulpa.task4.autoservice.utils.DateInput;
import by.azhulpa.task4.autoservice.utils.KeyboardInput;

public class AddingOrder implements IAction{

	public void execute() {
		Facade facade = Facade.getInstance();
		
		Date start = DateInput.getDate("Enter start date");
		
		Date ending = DateInput.getDate("Enter ending date");
		
		System.out.println("Enter cost");
		Double cost = Double.valueOf(KeyboardInput.input());
		
		System.out.println("Enter mechanic id");
		Long idMechanic = Long.valueOf(KeyboardInput.input());
		
		System.out.println("Enter place id");
		Long idPlace = Long.valueOf(KeyboardInput.input());
		
		facade.orderManager.add(facade.createOrder(start, ending, cost,
				facade.mechanicManager.get(idMechanic),
				facade.placeManager.get(idPlace)));
		facade.orderManager.save();
		
		System.out.println("Order added!");
	}

}
