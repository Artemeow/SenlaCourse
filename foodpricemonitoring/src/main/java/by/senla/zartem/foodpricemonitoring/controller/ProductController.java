package by.senla.zartem.foodpricemonitoring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import by.senla.zartem.foodpricemonitoring.model.Product;
import by.senla.zartem.foodpricemonitoring.service.ProductService;
import by.senla.zartem.foodpricemonitoring.service.ProductServiceImpl;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping(value = "/{id}", produces = "application/json;charset=UTF-8")
	public ResponseEntity<Product> getOne(@PathVariable("id") Integer id) {
		return ResponseEntity.ok(productService.find(id));
	}

//	@PostMapping(produces = "application/json;charset=UTF-8")
//	public ResponseEntity<Product> add(@RequestParam(value = "kind") String kind,
//			@RequestParam(value = "quantity") Integer quantity) {
//		Product product = new Product();
//		product.setKind(kind);
//		product.setQuantity(quantity);
//		productService.save(product);
//		return ResponseEntity.ok().build();
//	}

	@GetMapping(value = "/", produces = "html;charset=UTF-8")
//	@ResponseBody
	public String getAllProducts(Model model) {
		List<Product> products = productService.findAll();
//		model.addAttribute("productList", products);
		return "welcome";
	}

	
	/*
	 * @GetMapping(produces = "application/json;charset=UTF-8") public
	 * ResponseEntity<List<Product>> getAll() { return
	 * ResponseEntity.ok(productService.findAll()); }
	 */

}
