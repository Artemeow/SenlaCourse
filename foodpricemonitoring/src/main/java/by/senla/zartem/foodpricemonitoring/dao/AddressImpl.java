package by.senla.zartem.foodpricemonitoring.dao;

import org.springframework.stereotype.Repository;

import by.senla.zartem.foodpricemonitoring.model.Address;

@Repository
public class AddressImpl extends AbstractCrudDao<Address> {

	public AddressImpl() {
		super(Address.class);
	}

}
