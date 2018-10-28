package by.azhulpa.task4.autoservice.dao.fileutils;

import java.util.Iterator;
import java.util.Set;

import com.senla.training.*;
import by.azhulpa.task4.autoservice.model.Repairer;
import by.azhulpa.task4.autoservice.model.enums.Status;

public class RepairerFileUtil implements FileUtil<Repairer>{
	
	private static final String REPAIRER_FILE_PATH = "data/Repairers.txt";
	private final FileWorker fileWorker;
	
	public RepairerFileUtil() {
		fileWorker = new TextFileWorker(REPAIRER_FILE_PATH);
	}
	
	public Repairer[] readFromFile() {
		final String[] lines = fileWorker.readFromFile();
		
		if (lines == null || lines.length == 0) {
			throw new IllegalArgumentException();
		}
		
		final Repairer[] result = new Repairer[lines.length];
		
		for (int i = 0; i < lines.length; i++) {
			result[i] = fromLine(lines[i]);
		}
		
		return result;
	}
	
	public void writeToFile(final Set<Repairer> values) {
		if (values == null || values.size() == 0) {
			throw new IllegalArgumentException();
		}
		final String[] lines = new String[values.size()];
		
		Iterator<Repairer> iterator = values.iterator();
		for (int i = 0; i < values.size(); i++) {
		    lines[i] = toLine(iterator.next());
		}
		
		fileWorker.writeToFile(lines);
	}
	
	public String toLine(final Repairer repairer) {
		if (repairer == null) {
			throw new IllegalArgumentException();
		}

		final String[] array = new String[] { 
				String.valueOf(repairer.getId()), 
				repairer.getName(), 
				String.valueOf(repairer.getAge()),
				String.valueOf(repairer.getAddress()),
				String.valueOf(repairer.getStatus()) 
			};
		return String.join(";", array);
	}

	public Repairer fromLine(final String line) {
		if (line == null || line.isEmpty()) {
			throw new IllegalArgumentException();
		}
		final String[] parts = line.split(";");

		final Repairer result = new Repairer(
				Long.valueOf(parts[0]), 
				parts[1], 
				Integer.valueOf(parts[2]),
				parts[3],
				Status.valueOf(parts[4])
			);
		return result;
	}
}
