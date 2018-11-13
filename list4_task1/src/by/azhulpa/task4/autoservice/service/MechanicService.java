package by.azhulpa.task4.autoservice.service;

import java.util.List;

import by.azhulpa.task4.autoservice.model.Mechanic;

public interface MechanicService {

	List<Mechanic> sortAlphabetically(List<Mechanic> listMechanic);
	
	List<Mechanic> sortByStatus(List<Mechanic> listMechanic);
}
