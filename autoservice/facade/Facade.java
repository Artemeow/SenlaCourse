package by.azhulpa.task4.autoservice.facade;

import java.util.Date;
import java.util.Random;

import by.azhulpa.task4.autoservice.dao.fileutils.*;
import by.azhulpa.task4.autoservice.model.*;
import by.azhulpa.task4.autoservice.model.enums.OrderStatus;
import by.azhulpa.task4.autoservice.model.enums.Status;
import by.azhulpa.task4.autoservice.service.*;
import by.azhulpa.task4.autoservice.service.file.*;

public class Facade {

	private static Facade instance;
	
	private final FileUtil<Mechanic> mechanicFileUtil;
	private final FileUtil<ServicePlace> placeFileUtil;
	private final FileUtil<Order> orderFileUtil;
	
	public final EntityManager<Mechanic> mechanicManager;
	public final EntityManager<ServicePlace> placeManager;
	public final EntityManager<Order> orderManager;
	
	public final MechanicService mechanicService;
	public final ServicePlaceService placeService;
	public final OrderService orderService;
	
	private Facade() {
		mechanicFileUtil = new MechanicFileUtil();
		placeFileUtil =  new ServicePlaceFileUtil();
		orderFileUtil =  new OrderFileUtil();
		
		mechanicManager = new EntityManagerFile<Mechanic>(mechanicFileUtil);
		placeManager =  new EntityManagerFile<ServicePlace>(placeFileUtil);
		orderManager =  new EntityManagerFile<Order>(orderFileUtil);
		
		mechanicService = new MechanicServiceFile();
		placeService =  new ServicePlaceServiceFile();
		orderService =  new OrderServiceFile();
	}
	
	public static Facade getInstance() {
		if(instance == null) {
			instance = new Facade();
		}
		return instance;
	}
	
	public ServicePlace createPlace() {
		return new ServicePlace(new Random().nextLong(), Status.VACANT);
	}
	
	public Mechanic createMechanic(String name, Integer age, String address) {
		return new Mechanic(new Random().nextLong(), name, age, address, Status.VACANT);
	}
	
	public Order createOrder(Date start, Date ending, Double cost, Mechanic mechanic, ServicePlace place) {
		if(start.equals(new Date())) {
			return new Order(new Random().nextLong(), new Date(), start, ending, cost, mechanic, place, OrderStatus.InProcess);
		}else {
			return new Order(new Random().nextLong(), new Date(), start, ending, cost, mechanic, place, OrderStatus.Queue);
		}
	}
}
