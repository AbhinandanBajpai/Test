package com.javap.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.javap.jpa.entity.Product;
import com.javap.jpa.repository.ProductRepository;

@RestController
public class ProductController {

	@Autowired
	ProductRepository productRepository;
	
	@GetMapping("/customers/{custId}/products")
	public Product getAllProductByCustomerId(@PathVariable(value="custId") int custId) {
		return productRepository.findingById(custId);
	}
}
