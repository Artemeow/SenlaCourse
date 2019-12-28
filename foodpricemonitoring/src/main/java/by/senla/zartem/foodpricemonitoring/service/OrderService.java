package by.senla.zartem.foodpricemonitoring.service;

import java.util.List;

 
public interface OrderService {
   
    void save(by.senla.zartem.foodpricemonitoring.model.Order order);
 
    void delete(by.senla.zartem.foodpricemonitoring.model.Order order);
 
    List<by.senla.zartem.foodpricemonitoring.model.Order> getAll();
 
    by.senla.zartem.foodpricemonitoring.model.Order getById(Integer id);
}