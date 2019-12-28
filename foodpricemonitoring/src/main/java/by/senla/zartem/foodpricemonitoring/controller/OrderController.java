package by.senla.zartem.foodpricemonitoring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.senla.zartem.foodpricemonitoring.model.Order;
import by.senla.zartem.foodpricemonitoring.service.OrderService;
 
@Controller
public class OrderController {
   
	@Autowired
    private OrderService orderService;
 
    @RequestMapping(value="/", method=RequestMethod.GET)
    public String getOrderPage(Model model) {
        List<Order> orders = orderService.getAll();
        model.addAttribute("orderList", orders);
        return "order";
    }
}	