package by.azhulpa.task4.autoservice.service;

import java.util.List;

public interface EntityManager<T>{

	void add(T item);
	
	void remove(Long id);
	
	List<T> getAll();
	
	T get(Long id);
	
	void refresh();
	
	void save();
}
