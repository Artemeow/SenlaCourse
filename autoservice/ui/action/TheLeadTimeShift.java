package by.azhulpa.task4.autoservice.ui.action;

import by.azhulpa.task4.autoservice.facade.Facade;
import by.azhulpa.task4.autoservice.ui.IAction;
import by.azhulpa.task4.autoservice.utils.KeyboardInput;

public class TheLeadTimeShift implements IAction {

	public void execute() {
		Facade facade = Facade.getInstance();
		
		System.out.println("Enter order id");
		Long idOrder = Long.valueOf(KeyboardInput.input());
		
		System.out.println("Enter count days");
		Integer countDays = Integer.valueOf(KeyboardInput.input());
		
		facade.orderService.shiftTheLeadTime(facade.orderManager.getAll(), idOrder, countDays);
		facade.orderManager.save();
		
		System.out.println("Completed!");
	}

}
