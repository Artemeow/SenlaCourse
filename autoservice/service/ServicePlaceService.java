package by.azhulpa.task4.autoservice.service;

import java.util.Date;
import java.util.List;

import by.azhulpa.task4.autoservice.model.Mechanic;
import by.azhulpa.task4.autoservice.model.Order;
import by.azhulpa.task4.autoservice.model.ServicePlace;

public interface ServicePlaceService {
	
	List<ServicePlace> getFreeServicePlaces(List<ServicePlace> places);
	
	int countPlacesOnAnyDateInFuture(List<Order> ordersList, Date date,  List<Mechanic> listMechanic,  List<ServicePlace> listPlace);
}
