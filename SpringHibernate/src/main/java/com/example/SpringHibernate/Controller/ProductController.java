package com.example.SpringHibernate.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringHibernate.dao.Product;
import com.example.SpringHibernate.dao.ProductDao;

@RestController
public class ProductController {
	
	@Autowired
	ProductDao dao;	
	
	@GetMapping("/products")
	public List<Product> findAllProduct() {
		 return dao.getProducts();
	}
	
	@GetMapping("/product/{pid}")
	public Product getProductById(@PathVariable Integer pid) {
		return dao.findProduct(pid);
	} 
	
	@PostMapping("/save")
	public String saveProduct(@RequestBody Product p) {
		return dao.saveProduct(p);
	}
	
	@DeleteMapping("/delete/{pid}")
	public String deleteProduct(@PathVariable Integer pid) {
		return dao.deleteProduct(pid);
	}
}
