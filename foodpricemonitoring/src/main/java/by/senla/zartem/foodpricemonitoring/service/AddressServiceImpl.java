package by.senla.zartem.foodpricemonitoring.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.senla.zartem.foodpricemonitoring.dao.AddressImpl;
import by.senla.zartem.foodpricemonitoring.model.Address;

@Service
public class AddressServiceImpl implements AddressService{

	@Autowired
	AddressImpl addressDao;
	
	@PersistenceContext
	EntityManager em;
	
	@Transactional
	public void save(Address address) {
		addressDao.save(em, address);
	}

	public void delete(Address address) {
		// TODO Auto-generated method stub
		
	}

	public List<Address> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Address getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
