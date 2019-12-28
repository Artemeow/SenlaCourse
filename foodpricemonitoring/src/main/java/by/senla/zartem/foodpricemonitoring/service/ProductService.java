package by.senla.zartem.foodpricemonitoring.service;

import java.util.List;

import by.senla.zartem.foodpricemonitoring.model.Product;

public interface ProductService {

	Product find(Integer id);

	void save(Product model);

	void update(Product model);

	void delete();

	List<Product> findAll();
	
	List<Product> getProductByCategory(String productName); 
	
	List<Product> findAllByCategory(String categoryName);
}
