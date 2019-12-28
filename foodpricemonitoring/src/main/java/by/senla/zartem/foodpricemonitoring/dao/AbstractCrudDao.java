package by.senla.zartem.foodpricemonitoring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public abstract class AbstractCrudDao<T> {

	private Class<T> entityClass;

	public AbstractCrudDao(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	public T find(EntityManager em, Integer id) {
		return em.find(entityClass, id);
	}

	public void save(EntityManager em, T model) {
		em.persist(model);
	}

	public void update(EntityManager em, T model) {
		em.merge(model);
	}

	public void delete(EntityManager em, T model) {
		em.remove(model);
	}

	public List<T> findAll(EntityManager em) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<T> query = builder.createQuery(entityClass);
		Root<T> root = query.from(entityClass);
		query.select(root);
		return em.createQuery(query).getResultList();
	}

}
