package by.senla.zartem.foodpricemonitoring.dao;

import java.util.List;

import by.senla.zartem.foodpricemonitoring.model.Order;

 
public interface OrderRepository {
 
    void save(Order order);
   
    void delete(Order order);
   
    List<Order> getAll();
   
    Order getById(Integer id);
}
