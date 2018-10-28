package by.azhulpa.task4.autoservice.service.File;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import by.azhulpa.task4.autoservice.dao.fileutils.FileUtil;
import by.azhulpa.task4.autoservice.model.*;
import by.azhulpa.task4.autoservice.service.EntityManager;
import by.azhulpa.task4.autoservice.service.OrderManager;

public class EntityManagerFile<T extends Identifying> implements EntityManager<T>, OrderManager<T> {

	private final FileUtil<T> fileUtil;
	private Set<T> entity;
	
	public EntityManagerFile(FileUtil<T> fileUtil) {
		this.fileUtil = fileUtil;
		entity = new HashSet<T>(Arrays.asList(this.fileUtil.readFromFile()));
	}
	
	public void add(T item) {
		entity.add(item);
	}

	public void remove(Long id) {
		for(T temp: entity) {
			if(temp.getId() == id) {
				entity.remove(temp);
				break;
			}
		}		
	}
	
	public void update() {
		entity = new HashSet<T>(Arrays.asList(fileUtil.readFromFile()));
	}
	
	public Set<T> show() {
		return entity;
	}
	
	public void save() {
		fileUtil.writeToFile(entity);
	}

	public void toCancel() {//дописать
		System.out.println("IN ORDERMANAGER.TOCANCEL");
	}
}
