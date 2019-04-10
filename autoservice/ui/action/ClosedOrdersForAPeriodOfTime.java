package by.azhulpa.task4.autoservice.ui.action;

import java.util.Date;

import by.azhulpa.task4.autoservice.facade.Facade;
import by.azhulpa.task4.autoservice.ui.IAction;
import by.azhulpa.task4.autoservice.utils.DateInput;

public class ClosedOrdersForAPeriodOfTime implements IAction {
	
	private static final String MESSAGE_FOR_FIRSTDATE = "Enter start date";
	private static final String MESSAGE_FOR_LASTDATE = "Enter end date";
	
	public void execute() {
		Facade facade = Facade.getInstance();
		
		Date firstDate = DateInput.getDate(MESSAGE_FOR_FIRSTDATE);
		Date lastDate = DateInput.getDate(MESSAGE_FOR_LASTDATE);
		
		System.out.println("Closed orders: " + facade.orderService.getClosedOrdersForAPeriodOfTime(
				facade.orderManager.getAll(),
				firstDate,
				lastDate));	
	}
}
