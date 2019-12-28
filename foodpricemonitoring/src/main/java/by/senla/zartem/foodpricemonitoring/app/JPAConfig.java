package by.senla.zartem.foodpricemonitoring.app;
	
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class JPAConfig {

	private static final String PERSISTENCE_UNIT_NAME = "foodpricemonitoring";
	
	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
	
		return adapter;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean managerFactoryBean() {
		LocalContainerEntityManagerFactoryBean managerFactory = new LocalContainerEntityManagerFactoryBean();
		managerFactory.setJpaVendorAdapter(jpaVendorAdapter());
		managerFactory.setPersistenceUnitName(PERSISTENCE_UNIT_NAME);
		return managerFactory;
	}
	
	@Bean
	public PlatformTransactionManager transactionManager(){
	    JpaTransactionManager transactionManager = new JpaTransactionManager();
	    transactionManager.setEntityManagerFactory(managerFactoryBean().getObject());
	    return transactionManager;
	}
}
