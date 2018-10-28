package by.azhulpa.task4.autoservice.dao.fileutils;

import java.util.Iterator;
import java.util.Set;

import com.senla.training.FileWorker;
import com.senla.training.TextFileWorker;

import by.azhulpa.task4.autoservice.model.ServicePlace;
import by.azhulpa.task4.autoservice.model.enums.Status;

public class ServicePlaceFileUtil implements FileUtil<ServicePlace>{
	
	private static final String ServicePlace_FILE_PATH = "data/ServicePlaces.txt";
	private final FileWorker fileWorker;
	
	public ServicePlaceFileUtil() {
		fileWorker = new TextFileWorker(ServicePlace_FILE_PATH);
	}
	
	public ServicePlace[] readFromFile() {
		final String[] lines = fileWorker.readFromFile();
		
		if (lines == null || lines.length == 0) {
			throw new IllegalArgumentException();
		}
		
		final ServicePlace[] result = new ServicePlace[lines.length];
		
		for (int i = 0; i < lines.length; i++) {
			result[i] = fromLine(lines[i]);
		}
		
		return result;
	}
	
	public void writeToFile(final Set<ServicePlace> values) {
		if (values == null || values.size() == 0) {
			throw new IllegalArgumentException();
		}
		final String[] lines = new String[values.size()];
		
		Iterator<ServicePlace> iterator = values.iterator();
		for (int i = 0; i < values.size(); i++) {
		    lines[i] = toLine(iterator.next());
		}
		
		fileWorker.writeToFile(lines);
	}
	
	public String toLine(final ServicePlace servicePlace) {
		if (servicePlace == null) {
			throw new IllegalArgumentException();
		}

		final String[] array = new String[] { 
				String.valueOf(servicePlace.getId()), 
				String.valueOf(servicePlace.getStatus()) 
			};
		return String.join(";", array);
	}

	public ServicePlace fromLine(final String line) {
		if (line == null || line.isEmpty()) {
			throw new IllegalArgumentException();
		}
		final String[] parts = line.split(";");

		final ServicePlace result = new ServicePlace(
				Long.valueOf(parts[0]), 
				Status.valueOf(parts[1])
			);
		return result;
	}	
}
