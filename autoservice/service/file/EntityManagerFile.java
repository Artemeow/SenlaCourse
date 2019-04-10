package by.azhulpa.task4.autoservice.service.file;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import by.azhulpa.task4.autoservice.dao.fileutils.FileUtil;
import by.azhulpa.task4.autoservice.model.*;
import by.azhulpa.task4.autoservice.service.EntityManager;

public class EntityManagerFile<T extends Identifying> implements EntityManager<T> {

	private final FileUtil<T> fileUtil;
	private Set<T> entities;
	
	public EntityManagerFile(FileUtil<T> fileUtil) {
		this.fileUtil = fileUtil;
		entities = new HashSet<T>(Arrays.asList(this.fileUtil.readFromFile()));
	}
	
	public void add(T item) {
		entities.add(item);
	}

	public void remove(Long id) {
		for(T temp: entities) {
			if(temp.getId() == id) {
				entities.remove(temp);
				break;
			}
		}		
	}
	
	public void refresh() {
			entities = new HashSet<T>(Arrays.asList(this.fileUtil.readFromFile()));
	}
	
	public List<T> getAll() {
		List<T> result = new ArrayList<T>();
		for(T temp: entities) {
			result.add(temp);
		}
		return result;
	}
	
	public T get(Long id) {
		for(T temp: entities) {
			if(temp.getId() == id) {
				return temp;
			}
		}	
		return null;
	}
	
	public void save() {
		List<T> result = new ArrayList<T>();
		for(T temp: entities) {
			result.add(temp);
		}
		fileUtil.writeToFile(result);
	}
}
