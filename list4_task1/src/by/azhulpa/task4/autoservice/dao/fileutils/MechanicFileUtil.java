package by.azhulpa.task4.autoservice.dao.fileutils;

import java.util.Iterator;
import java.util.List;

import com.senla.training.*;
import by.azhulpa.task4.autoservice.model.Mechanic;
import by.azhulpa.task4.autoservice.model.enums.Status;

public class MechanicFileUtil implements FileUtil<Mechanic>{
	
	private static final String MECHANIC_FILE_PATH = "data/Mechanics.txt";
	private final FileWorker fileWorker;
	
	public MechanicFileUtil() {
		fileWorker = new TextFileWorker(MECHANIC_FILE_PATH);
	}
	
	public Mechanic[] readFromFile() {
		final String[] lines = fileWorker.readFromFile();
		
		if (lines == null) {
			throw new IllegalArgumentException();
		}
		
		final Mechanic[] result = new Mechanic[lines.length];
		
		for (int i = 0; i < lines.length; i++) {
			result[i] = fromLine(lines[i]);
		}
		
		return result;
	}
	
	public void writeToFile(final List<Mechanic> values) {
		if (values == null || values.size() == 0) {
			throw new IllegalArgumentException();
		}
		final String[] lines = new String[values.size()];
		
		Iterator<Mechanic> iterator = values.iterator();
		for (int i = 0; i < values.size(); i++) {
		    lines[i] = toLine(iterator.next());
		}
		
		fileWorker.writeToFile(lines);
	}
	
	public String toLine(final Mechanic mechanic) {
		if (mechanic == null) {
			throw new IllegalArgumentException();
		}

		final String[] array = new String[] { 
				String.valueOf(mechanic.getId()), 
				mechanic.getName(), 
				String.valueOf(mechanic.getAge()),
				String.valueOf(mechanic.getAddress()),
				String.valueOf(mechanic.getStatus()) 
			};
		return String.join(";", array);
	}

	public Mechanic fromLine(final String line) {
		if (line == null || line.isEmpty()) {
			throw new IllegalArgumentException();
		}
		final String[] parts = line.split(";");

		final Mechanic result = new Mechanic(
				Long.valueOf(parts[0]), 
				parts[1], 
				Integer.valueOf(parts[2]),
				parts[3],
				Status.valueOf(parts[4])
			);
		return result;
	}
}
