package by.senla.zartem.foodpricemonitoring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import by.senla.zartem.foodpricemonitoring.dao.OrderRepository;
import by.senla.zartem.foodpricemonitoring.model.Order;

@Service
public class OrderServiceImpl implements OrderService {
   
	@Autowired
    private OrderRepository orderRepository;
 
    public void save(Order order) {
        if(order!=null) {
            List<Order> orders = orderRepository.getAll();
            if(!orders.isEmpty()) {
                Order lastOrder = orders.get(orders.size() - 1);
                order.setId(lastOrder.getId()+1);
                orderRepository.save(order);
            }
        }
    }
 
    public void delete(Order order) {
        if(order!=null) {
            orderRepository.delete(order);
        }  
    }
 
    public List<Order> getAll() {
        return orderRepository.getAll();
    }
 
    public Order getById(Integer id) {
        if(id!=null) {
            return orderRepository.getById(id);
        }
        return null;
    }

 
}