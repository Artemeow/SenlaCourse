package by.senla.zartem.foodpricemonitoring.dao;

import java.util.List;

import javax.persistence.EntityManager;

public interface GenericDao<T> {
	
	T find(EntityManager em, Integer id);

	void save(EntityManager em, T model);

	public void update(EntityManager em, T model);

	public void delete(EntityManager em, T model);

	public List<T> findAll(EntityManager em);
}
