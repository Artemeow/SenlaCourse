package by.azhulpa.task4.autoservice.service.file;

import java.util.Comparator;
import java.util.List;

import by.azhulpa.task4.autoservice.model.Mechanic;
import by.azhulpa.task4.autoservice.service.MechanicService;

public class MechanicServiceFile implements MechanicService {

	public List<Mechanic> sortAlphabetically(List<Mechanic> listMechanic) {
		listMechanic.sort(Comparator.comparing(Mechanic::getName));
		return listMechanic;
	}
	
	public List<Mechanic> sortByStatus(List<Mechanic> listMechanic) {
		listMechanic.sort(Comparator.comparing(Mechanic::getStatus));
		return listMechanic;
	}
}
