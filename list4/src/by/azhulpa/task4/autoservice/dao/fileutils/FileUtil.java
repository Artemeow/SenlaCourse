package by.azhulpa.task4.autoservice.dao.fileutils;

import java.util.Set;

public interface FileUtil<T> {
	
	T[] readFromFile();

	void writeToFile(final Set<T> values);

	String toLine(T entity);

	T fromLine(String line);

}
