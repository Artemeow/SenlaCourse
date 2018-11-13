package by.azhulpa.task4.autoservice.service.file;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import by.azhulpa.task4.autoservice.model.Mechanic;
import by.azhulpa.task4.autoservice.model.Order;
import by.azhulpa.task4.autoservice.model.ServicePlace;
import by.azhulpa.task4.autoservice.model.enums.OrderStatus;
import by.azhulpa.task4.autoservice.model.enums.Status;
import by.azhulpa.task4.autoservice.service.OrderService;

public class OrderServiceFile implements OrderService {

	public void cancel(Order order) {
		order.setStatus(OrderStatus.Canceled);
	}

	public void close(Order order) {
		order.setStatus(OrderStatus.Closed);
	}

	public List<Order> sortByDateAdoption(List<Order> ordersList) {
		ordersList.sort(Comparator.comparing(Order::getAdoption));
		return ordersList;
	}

	public List<Order> sortByDateStart(List<Order> ordersList) {
		ordersList.sort(Comparator.comparing(Order::getStart));
		return ordersList;
	}

	public List<Order> sortByDateEnding(List<Order> ordersList) {
		ordersList.sort(Comparator.comparing(Order::getEnding));
		return ordersList;
	}

	public List<Order> sortByCost(List<Order> ordersList) {
		ordersList.sort(Comparator.comparing(Order::getCost));
		return ordersList;
	}

	public List<Order> getOngoingOrders(List<Order> ordersList) {
		List<Order> result = new ArrayList<Order>();
		for (Order temp : ordersList) {
			if (temp.getStatus() == OrderStatus.InProcess) {
				result.add(temp);
			}
		}
		return result;
	}

	public Order getOrderExecutedByMechanic(List<Order> ordersList, Long idMechanic) {
		Order result = null;
		for (Order temp : ordersList) {
			if (temp.getMechanic().getId() == idMechanic) {
				result = temp;
				break;
			}
		}
		return result;
	}

	public Mechanic getMechanicPerformingTheOrder(List<Order> ordersList, Long idOrder) {
		Mechanic result = null;
		for (Order temp : ordersList) {
			if (temp.getId() == idOrder) {
				result = temp.getMechanic();
				break;
			}
		}
		return result;
	}

	private List<Order> getOrdersForAPeriodOfTime(List<Order> ordersList, Date firstDate, Date lastDate,
			OrderStatus orderStatus) {
		List<Order> result = new ArrayList<Order>();

		for (Order temp : ordersList) {
			if (temp.getStart().after(firstDate) && temp.getEnding().before(lastDate)
					&& temp.getStatus() == orderStatus) {
				result.add(temp);
			}
		}
		return result;
	}

	public List<Order> getClosedOrdersForAPeriodOfTime(List<Order> ordersList, Date firstDate, Date lastDate) {
		return getOrdersForAPeriodOfTime(ordersList, firstDate, lastDate, OrderStatus.Closed);
	}

	public List<Order> getCanceledOrdersForAPeriodOfTime(List<Order> ordersList, Date firstDate, Date lastDate) {
		return getOrdersForAPeriodOfTime(ordersList, firstDate, lastDate, OrderStatus.Canceled);
	}

	public Date getNearestFreeDate(List<Order> ordersList, List<Mechanic> listMechanic, List<ServicePlace> listPlace) {
		for (ServicePlace place : listPlace) {
			if (place.getStatus() == Status.VACANT) {
				for (Mechanic mechanic : listMechanic) {
					if (mechanic.getStatus() == Status.VACANT) {
						return new Date();
					}
				}
			}
		}

		Map<Long, Date> map = new HashMap<Long, Date>();
		Date marker;
 outer: for (Order order : ordersList) {
			if (order.getStatus() == OrderStatus.InProcess || order.getStatus() == OrderStatus.Queue) {
				marker = map.putIfAbsent(order.getMechanic().getId(), order.getEnding());
				if(marker == null) {
					continue outer;
				}
				map.computeIfPresent(order.getMechanic().getId(),
						(key, value) -> {
							if(order.getEnding().after(value)) {
								return order.getEnding();
							}
							return value; 
						});
			}
		}
		
		Collection<Date> colDate = map.values();
		Date[] arrDate = colDate.toArray(new Date[colDate.size()]);
		Date nearestFreeDate = arrDate[0];		
		for(Date date: arrDate) {
			if(date.before(nearestFreeDate)) {
				nearestFreeDate = date;
			}
		}
		
		return nearestFreeDate;
	}

	public void shiftTheLeadTime(List<Order> ordersList, Long idOrder, Integer countDays) {
		Long mechanicId = null;
		Long placeId = null;
		Long dayInMilliseconds = countDays * 86400000L;
		for (Order order : ordersList) {
			if (order.getId() == idOrder && order.getStatus() == OrderStatus.InProcess) {
				mechanicId = order.getMechanic().getId();
				placeId = order.getPlace().getId();
				Long mil = order.getEnding().getTime() + dayInMilliseconds;
				order.setEnding(new Date(mil));
			}
			if (order.getMechanic().getId() == mechanicId && order.getPlace().getId() == placeId
					&& order.getStatus() == OrderStatus.Queue) {

				Long mil = order.getStart().getTime() + dayInMilliseconds;
				order.setStart(new Date(mil));
				mil = order.getEnding().getTime() + dayInMilliseconds;
				order.setEnding(new Date(mil));
			}
		}
	}
}
