package by.azhulpa.task4.autoservice.dao.fileutils;

import java.util.List;

public interface FileUtil<T> {
	
	T[] readFromFile();

	void writeToFile(final List<T> values);

	String toLine(T entity);

	T fromLine(String line);

}
