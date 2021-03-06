package by.azhulpa.task4.autoservice.ui.action;

import by.azhulpa.task4.autoservice.facade.Facade;
import by.azhulpa.task4.autoservice.ui.IAction;

public class OngoingOrders implements IAction {

	public void execute() {
		Facade facade = Facade.getInstance();
		
		System.out.println(facade.orderService.getOngoingOrders(facade.orderManager.getAll()).toString());
	}

}
