package by.senla.zartem.foodpricemonitoring.dao;

import java.util.List;

import javax.persistence.EntityManager;

import by.senla.zartem.foodpricemonitoring.model.Product;

public interface ProductDao extends GenericDao<Product>{

	List<Product> findAllByProductName(EntityManager em, String productName);
	
	List<Product> findAllByCategory(EntityManager em, String categoryName);
}
