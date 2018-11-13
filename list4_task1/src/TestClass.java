
import java.util.Calendar;
import java.util.Date;


import by.azhulpa.task4.autoservice.dao.fileutils.*;
import by.azhulpa.task4.autoservice.model.*;
import by.azhulpa.task4.autoservice.service.EntityManager;
import by.azhulpa.task4.autoservice.service.MechanicService;
import by.azhulpa.task4.autoservice.service.OrderService;
import by.azhulpa.task4.autoservice.service.ServicePlaceService;
import by.azhulpa.task4.autoservice.service.file.EntityManagerFile;
import by.azhulpa.task4.autoservice.service.file.MechanicServiceFile;
import by.azhulpa.task4.autoservice.service.file.OrderServiceFile;
import by.azhulpa.task4.autoservice.service.file.ServicePlaceServiceFile;


public class TestClass {
	public static void main(String[] args) {	
		
		FileUtil<Mechanic> fuMechanic = new MechanicFileUtil();
		FileUtil<ServicePlace> fuPlace =  new ServicePlaceFileUtil();
		FileUtil<Order> fuOrder =  new OrderFileUtil();
		
		EntityManager<Mechanic> mechanicManager = new EntityManagerFile<Mechanic>(fuMechanic);
		EntityManager<ServicePlace> placeManager = new EntityManagerFile<ServicePlace>(fuPlace);		
		EntityManager<Order> orderManager =  new EntityManagerFile<Order>(fuOrder);
		
		MechanicService mechanicService = new MechanicServiceFile();
		ServicePlaceService placeService = new ServicePlaceServiceFile();
		OrderService orderService = new OrderServiceFile();
		
		System.out.println("***MechanicService BEGIN***");
		System.out.println("\n sortAlphabetically");
		System.out.println(mechanicService.sortAlphabetically(mechanicManager.getAll()));
		System.out.println("\n sortByStatus");
		System.out.println(mechanicService.sortByStatus(mechanicManager.getAll()));
		System.out.println("\n delete the mechanic (id = 2), save the changes, refresh the contents");
		mechanicManager.remove(2l);
		mechanicManager.save();
		mechanicManager.refresh();
		System.out.println(mechanicManager.getAll());
		System.out.println("\n***MechanicService END***");
		
		System.out.println("\n***ServicePlaceService BEGIN***");
		System.out.println("\n all service places");
		System.out.println(placeManager.getAll());
		System.out.println("\n getFreeServicePlaces");
		System.out.println(placeService.getFreeServicePlaces(placeManager.getAll()));
		System.out.println("");
		Calendar calen =  Calendar.getInstance();
		calen.setTime(new Date());
		System.out.println(placeService.countPlacesOnAnyDateInFuture(orderManager.getAll(), calen.getTime(), mechanicManager.getAll(), placeManager.getAll()));
		System.out.println("\n***ServicePlaceService END***");
		
		System.out.println("\n***OrderService BEGIN***");
		System.out.println(orderManager.getAll());
		System.out.println("\nget Nearest Free Date");
		System.out.println(orderService.getNearestFreeDate(orderManager.getAll(), mechanicManager.getAll(), placeManager.getAll()));
		System.out.println("\nshift The Lead Time");
		orderService.shiftTheLeadTime(orderManager.getAll(), 2l, 3);
		System.out.println(orderManager.getAll());
	}
}
