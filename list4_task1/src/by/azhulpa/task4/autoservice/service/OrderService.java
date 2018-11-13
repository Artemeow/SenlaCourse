package by.azhulpa.task4.autoservice.service;

import java.util.Date;
import java.util.List;

import by.azhulpa.task4.autoservice.model.Mechanic;
import by.azhulpa.task4.autoservice.model.Order;
import by.azhulpa.task4.autoservice.model.ServicePlace;

public interface OrderService {

	void cancel(Order order);
	
	void close(Order order);
	
	List<Order> getOngoingOrders(List<Order> ordersList);
	
	Order getOrderExecutedByMechanic(List<Order> ordersList, Long idMechanic);
	
	Mechanic getMechanicPerformingTheOrder(List<Order> ordersList, Long idOrder);
	
	List<Order> getClosedOrdersForAPeriodOfTime(List<Order> ordersList, Date firstDate, Date lastDate);
	
	List<Order> getCanceledOrdersForAPeriodOfTime(List<Order> ordersList, Date firstDate, Date lastDate);
	
	Date getNearestFreeDate(List<Order> ordersList, List<Mechanic> listMechanic,  List<ServicePlace> listPlace);
	
	void shiftTheLeadTime(List<Order> ordersList, Long idOrder, Integer day);
		
	List<Order> sortByDateAdoption(List<Order> ordersList);
	
	List<Order> sortByDateStart(List<Order> ordersList);
	
	List<Order> sortByDateEnding(List<Order> ordersList);
	
	List<Order> sortByCost(List<Order> ordersList);
}
