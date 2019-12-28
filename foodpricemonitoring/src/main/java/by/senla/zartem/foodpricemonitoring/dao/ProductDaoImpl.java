package by.senla.zartem.foodpricemonitoring.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import by.senla.zartem.foodpricemonitoring.model.Product;

@Repository
public class ProductDaoImpl extends AbstractCrudDao<Product> implements ProductDao{

	public ProductDaoImpl() {
		super(Product.class);
	}

	public List<Product> findAllByProductName(EntityManager em, String productName) {
		return em.createQuery("select p from Product as p where p.name = ?1", Product.class)
				.setParameter(1, productName).getResultList();
	}

	public List<Product> findAllByCategory(EntityManager em, String categoryName) {
		return em.createQuery("select p from Product as p, IN(p.category) as c where c.name = :name", Product.class)
				.setParameter("name", categoryName).getResultList();
	}
}
