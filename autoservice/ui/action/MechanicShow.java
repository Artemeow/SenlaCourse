package by.azhulpa.task4.autoservice.ui.action;

import by.azhulpa.task4.autoservice.facade.Facade;
import by.azhulpa.task4.autoservice.ui.IAction;

public class MechanicShow implements IAction {

	public void execute() {
		System.out.println(Facade.getInstance().mechanicManager.getAll().toString());
	}
}
