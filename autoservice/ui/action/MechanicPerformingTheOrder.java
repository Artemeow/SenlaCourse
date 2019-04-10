package by.azhulpa.task4.autoservice.ui.action;

import by.azhulpa.task4.autoservice.facade.Facade;
import by.azhulpa.task4.autoservice.ui.IAction;
import by.azhulpa.task4.autoservice.utils.KeyboardInput;

public class MechanicPerformingTheOrder implements IAction {

	public void execute() {
		Facade facade = Facade.getInstance();
		
		System.out.println("Enter order id");
		Long idMechanic = Long.valueOf(KeyboardInput.input());
		System.out.println(facade.orderService.
				getMechanicPerformingTheOrder(facade.orderManager.getAll(), idMechanic).toString());
	}

}
