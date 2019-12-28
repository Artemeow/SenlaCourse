package by.senla.zartem.foodpricemonitoring.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.senla.zartem.foodpricemonitoring.dao.ProductDao;
import by.senla.zartem.foodpricemonitoring.dao.ProductDaoImpl;
import by.senla.zartem.foodpricemonitoring.model.Product;
import by.senla.zartem.foodpricemonitoring.util.EntityManagerUtil;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductDao productDao;
	
	public List<Product> getProductByCategory() {
		return productDao.findAllByCategory(EntityManagerUtil.getEntityManager(), "FFFf");
	}

	public void persist(Product product) {
		EntityManager em = null;
		try {
			em = EntityManagerUtil.getEntityManager();;
			em.getTransaction().begin();
			productDao.save(em, product);
			em.getTransaction().commit();
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	public Product find(Integer id) {
		EntityManager em = null;
		em = EntityManagerUtil.getEntityManager();
		return productDao.find(em, id);		
	}

	
	@Transactional
	public void save(Product model) {
		EntityManager em = EntityManagerUtil.getEntityManager();
		productDao.save(em, model);
		
		if (em != null) {
				em.close();
		}
		
	}

	public void update(Product model) {
		// TODO Auto-generated method stub
		
	}

	public void delete() {
		// TODO Auto-generated method stub
		
	}

	public List<Product> findAll() {
		return productDao.findAll(EntityManagerUtil.getEntityManager());
	}

	public List<Product> getProductByCategory(String productName) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Product> findAllByCategory(String categoryName) {
		// TODO Auto-generated method stub
		return null;
	}

}
