package by.azhulpa.task4.autoservice.service.File.Sorting;

import by.azhulpa.task4.autoservice.model.Repairer;
import by.azhulpa.task4.autoservice.service.sorting.SortedRepairersList;

import java.util.List;
import java.util.Comparator;

public class SortedRepairersListFile implements SortedRepairersList{
	
	public List<Repairer> getAlphabetically(List<Repairer> listRepairer) {
		listRepairer.sort(Comparator.comparing(Repairer::getName));
		return listRepairer;
	}
	
	public List<Repairer> getByStatus(List<Repairer> listRepairer) {
		listRepairer.sort(Comparator.comparing(Repairer::getStatus));
		return listRepairer;
	}
}
