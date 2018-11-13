package by.azhulpa.task4.autoservice.service.file;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import by.azhulpa.task4.autoservice.model.Mechanic;
import by.azhulpa.task4.autoservice.model.Order;
import by.azhulpa.task4.autoservice.model.ServicePlace;
import by.azhulpa.task4.autoservice.model.enums.OrderStatus;
import by.azhulpa.task4.autoservice.model.enums.Status;
import by.azhulpa.task4.autoservice.service.ServicePlaceService;

public class ServicePlaceServiceFile implements ServicePlaceService {

	public List<ServicePlace> getFreeServicePlaces(final List<ServicePlace> places) {
		List<ServicePlace> result = new ArrayList<ServicePlace>();
		
		for(ServicePlace place: places) {
			if(place.getStatus() == Status.VACANT) {
				result.add(place);
			}
		}
		return result;
	}
	
	public int countPlacesOnAnyDateInFuture(List<Order> ordersList, Date date,  List<Mechanic> listMechanic,  List<ServicePlace> listPlace) {
		int countFreePlace = 0;
		for (Order order : ordersList) {
			if ((order.getStatus() == OrderStatus.InProcess || order.getStatus() == OrderStatus.Queue) &&
					date.after(order.getStart()) && date.before(order.getEnding())) {
				for(ServicePlace place : listPlace) {
					if(place.getId() == order.getPlace().getId()) {
						listPlace.remove(place);
						break;
					}
				}
				for(Mechanic mechanic : listMechanic) {
					if(mechanic.getId() == order.getMechanic().getId()) {
						listMechanic.remove(mechanic);
						break;
					}
				}	
			}
		}
		if(listPlace.size() > listMechanic.size()) {
			countFreePlace = listMechanic.size();
		}else {
			countFreePlace = listPlace.size();
		}
		return countFreePlace;
	}

}
