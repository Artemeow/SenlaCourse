package by.senla.zartem.foodpricemonitoring.service;

import java.util.List;

import by.senla.zartem.foodpricemonitoring.model.Address;

public interface AddressService {

	void save(Address address);
	 
    void delete(Address address);
 
    List<Address> getAll();
 
    Address getById(Integer id);
}
