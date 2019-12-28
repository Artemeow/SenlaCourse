package by.senla.zartem.foodpricemonitoring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import by.senla.zartem.foodpricemonitoring.model.Address;
import by.senla.zartem.foodpricemonitoring.service.AddressService;

@Controller
@RequestMapping(value = "/address")
public class AddressController {

	@Autowired
	private AddressService addressService;


	@GetMapping(value = "/add-new-address")
	public String addNewAddress() {
		System.out.println("in GET method");
		return "addNewAddress";
	}
	@PostMapping(value = "/add-new-address")
	public String add(@RequestParam(value="country") String country, @RequestParam(value = "city") String city) {
		Address address = new Address();
		address.setCountry(country);
		address.setCity(city);
		System.out.println(address.toString());
		System.out.println("in POST method");
		addressService.save(address);
		return "addNewAddress";
		
	}
	 
}
