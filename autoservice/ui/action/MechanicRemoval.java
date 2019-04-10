package by.azhulpa.task4.autoservice.ui.action;

import by.azhulpa.task4.autoservice.facade.Facade;
import by.azhulpa.task4.autoservice.ui.IAction;
import by.azhulpa.task4.autoservice.utils.KeyboardInput;

public class MechanicRemoval implements IAction {

	public void execute() {
		Facade facade = Facade.getInstance();
		
		System.out.println("Enter mechanic id");
		Long idMechanic = Long.valueOf(KeyboardInput.input());
		
		
		facade.mechanicManager.remove(idMechanic);
		facade.mechanicManager.save();
		
		System.out.println("Mechanic removed!");
	}

}
