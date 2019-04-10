package by.azhulpa.task4.autoservice.dao.fileutils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import com.senla.training.FileWorker;
import com.senla.training.TextFileWorker;

import by.azhulpa.task4.autoservice.model.Order;
import by.azhulpa.task4.autoservice.model.Mechanic;
import by.azhulpa.task4.autoservice.model.ServicePlace;
import by.azhulpa.task4.autoservice.model.enums.OrderStatus;

public class OrderFileUtil implements FileUtil<Order> {

	private final static String ORDER_FILE_PATH = "data/Orders.txt";
	private final static DateFormat FORMATTER = new SimpleDateFormat("yyyy- MM- dd");
	
	private final FileWorker fileWorker;
	
	public OrderFileUtil() {
		fileWorker = new TextFileWorker(ORDER_FILE_PATH);
	}
	
	public Order[] readFromFile() {
		final String[] lines = fileWorker.readFromFile();
		
		if (lines == null) {
			throw new IllegalArgumentException();
		}
		
		final Order[] result = new Order[lines.length];
		
		for (int i = 0; i < lines.length; i++) {
			result[i] = fromLine(lines[i]);
		}
		
		return result;
	}

	public void writeToFile(final List<Order> values) {
		if (values == null || values.size() == 0) {
			throw new IllegalArgumentException();
		}
		final String[] lines = new String[values.size()];

		Iterator<Order> iterator = values.iterator();
		
		for (int i = 0; i < values.size(); i++) {
		    lines[i] = toLine(iterator.next());
		}
		
		fileWorker.writeToFile(lines);
	}

	public String toLine(Order order) {
		if (order == null) {
			throw new IllegalArgumentException();
		}
				
		final String[] array = new String[] { 
				String.valueOf(order.getId()), 
				FORMATTER.format(order.getAdoption()),
				FORMATTER.format(order.getStart()),
				FORMATTER.format(order.getEnding()),
				String.valueOf(order.getCost()),
				String.valueOf(order.getMechanic().getId()),
				String.valueOf(order.getPlace().getId()),
				String.valueOf(order.getStatus())
			};
		return String.join(";", array);
	}

	@Override
	public Order fromLine(String line) {
		if (line == null || line.isEmpty()) {
			throw new IllegalArgumentException();
		}
		final String[] parts = line.split(";");
		
		Mechanic mechanic = null;
		Long mechanicId = Long.valueOf(parts[5]);
		Mechanic[] mechanics = new MechanicFileUtil().readFromFile();
		for(Mechanic temp: mechanics) {
			if(temp.getId() == mechanicId) {
				mechanic = temp;
				break;
			}
		}
		
		ServicePlace place = null;
		Long placeId = Long.valueOf(parts[6]);
		ServicePlace[] places = new ServicePlaceFileUtil().readFromFile();
		for(ServicePlace temp: places) {
			if(temp.getId() == placeId) {
				place = temp;
				break;
			}
		}
			
		Order result = new Order();
			result.setId(Long.valueOf(parts[0]));
				
			try {
			result.setAdoption(FORMATTER.parse(parts[1]));
			result.setStart(FORMATTER.parse(parts[2]));
			result.setEnding(FORMATTER.parse(parts[3]));
			} catch (NumberFormatException | ParseException e) {
				e.printStackTrace();
			}
				
			result.setCost(Double.valueOf(parts[4]));
			result.setMechanic(mechanic);
			result.setPlace(place);
			result.setStatus(OrderStatus.valueOf(parts[7]));
			
		
		return result;
	}

}
