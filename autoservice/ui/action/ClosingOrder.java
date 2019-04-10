package by.azhulpa.task4.autoservice.ui.action;

import by.azhulpa.task4.autoservice.facade.Facade;
import by.azhulpa.task4.autoservice.ui.IAction;
import by.azhulpa.task4.autoservice.utils.KeyboardInput;

public class ClosingOrder implements IAction {

	public void execute() {
		Facade facade = Facade.getInstance();
		
		System.out.println("Enter order id");
		Long idOrder = Long.valueOf(KeyboardInput.input());
		facade.orderService.close(facade.orderManager.get(idOrder));
		facade.orderManager.save();
		
		System.out.println("Order " + idOrder + " closed");
	}

}
