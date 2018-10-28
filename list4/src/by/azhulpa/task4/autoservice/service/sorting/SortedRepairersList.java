package by.azhulpa.task4.autoservice.service.sorting;

import java.util.List;

import by.azhulpa.task4.autoservice.model.Repairer;

public interface SortedRepairersList {

	List<Repairer> getAlphabetically(List<Repairer> listRepairer);
	
	List<Repairer> getByStatus(List<Repairer> listRepairer);
}
