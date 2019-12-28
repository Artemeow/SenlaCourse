package by.senla.zartem.foodpricemonitoring.app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import by.senla.zartem.foodpricemonitoring.dao.AddressImpl;
import by.senla.zartem.foodpricemonitoring.dao.ProductDao;
import by.senla.zartem.foodpricemonitoring.dao.ProductDaoImpl;
import by.senla.zartem.foodpricemonitoring.model.Address;
import by.senla.zartem.foodpricemonitoring.model.Product;
import by.senla.zartem.foodpricemonitoring.util.EntityManagerUtil;

public class Main {

	public static void main(String[] args) {
		
		AnnotationConfigWebApplicationContext ac = new AnnotationConfigWebApplicationContext();
		ac.register(DbConfig.class);
		ac.refresh();
		EntityManagerFactory factory = ac.getBean(EntityManagerFactory.class);
		AddressImpl gg = new AddressImpl();
		EntityManager em = factory.createEntityManager();
		Address address = new Address("Dermany", "Derlin");
		gg.save(address);
		System.out.println("!");
		/*EntityManager em = EntityManagerUtil.getEntityManager();
		ProductDao dao = new ProductDaoImpl();
		List<Product> list = dao.findAll(em);
		System.out.println(dao.find(em, 4));
		for (Product product : list) {
			System.out.println(product.toString());
		}*/
	}

}
