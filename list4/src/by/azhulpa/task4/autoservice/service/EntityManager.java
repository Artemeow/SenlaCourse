package by.azhulpa.task4.autoservice.service;

import java.util.Set;

public interface EntityManager<T>{

	void add(T item);
	
	void remove(Long id);
	
	Set<T> show();
	
	void update();
	
	void save();
}
