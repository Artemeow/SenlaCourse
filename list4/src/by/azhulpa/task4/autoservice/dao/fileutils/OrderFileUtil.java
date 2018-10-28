package by.azhulpa.task4.autoservice.dao.fileutils;

import java.sql.Date;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.Set;

import com.senla.training.FileWorker;
import com.senla.training.TextFileWorker;

import by.azhulpa.task4.autoservice.model.Order;
import by.azhulpa.task4.autoservice.model.enums.OrderStatus;

public class OrderFileUtil implements FileUtil<Order> {

	private static final String ORDER_FILE_PATH = "data/Orders.txt";
	private final FileWorker fileWorker;
	
	public OrderFileUtil() {
		fileWorker = new TextFileWorker(ORDER_FILE_PATH);
	}
	
	public Order[] readFromFile() {
		final String[] lines = fileWorker.readFromFile();
		
		if (lines == null || lines.length == 0) {
			throw new IllegalArgumentException();
		}
		
		final Order[] result = new Order[lines.length];
		
		for (int i = 0; i < lines.length; i++) {
			result[i] = fromLine(lines[i]);
		}
		
		return result;
	}

	public void writeToFile(final Set<Order> values) {
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
		
		Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		final String[] array = new String[] { 
				String.valueOf(order.getId()), 
				formatter.format(order.getAdoption()),
				formatter.format(order.getPlannedStart()),
				formatter.format(order.getEnding()),
				String.valueOf(order.getCost()),
				String.valueOf(order.getIdRepairer()),
				String.valueOf(order.getIdPlace()),
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
		final Order result = new Order(
				Long.valueOf(parts[0]), 
				Date.valueOf(parts[1]), 
				Date.valueOf(parts[2]),
				Date.valueOf(parts[3]),
				Double.valueOf(parts[4]),
				Long.valueOf(parts[5]),
				Long.valueOf(parts[6]),
				OrderStatus.valueOf(parts[7])
			);
		return result;
	}

}
