package by.azhulpa.task4.autoservice.service.File;

import java.util.HashSet;
import java.util.Set;

import by.azhulpa.task4.autoservice.model.ServicePlace;
import by.azhulpa.task4.autoservice.model.enums.Status;
import by.azhulpa.task4.autoservice.service.FreeServicePlaces;

public class FreeServicePlaceFile implements FreeServicePlaces {

	public Set<ServicePlace> getFreeServicePlaces(Set<ServicePlace> places) {
		Set<ServicePlace> temp = new HashSet<>();
		
		for(ServicePlace place: places) {
			if(place.getStatus() == Status.VACANT) {
				temp.add(place);
			}
		}
		return temp;
	}
}
