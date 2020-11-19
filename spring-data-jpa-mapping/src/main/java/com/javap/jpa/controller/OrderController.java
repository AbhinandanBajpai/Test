package com.javap.jpa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javap.jpa.dto.OrderRequest;
import com.javap.jpa.entity.Customer;
import com.javap.jpa.repository.CustomerRepository;
import com.javap.jpa.repository.ProductRepository;

@RestController
public class OrderController {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@PostMapping("/placeorder")
	public Customer createOrder(@RequestBody OrderRequest orderRequest) {
		
		return customerRepository.save(orderRequest.getCustomer());
	}
	
	@GetMapping("/findAllOrders")
	public List<Customer> findAllCust(){
		
//		 List<Customer> findAll = customerRepository.findAll();
		 List<Customer> findingAll = customerRepository.findingAll();
		System.out.println(findingAll);
		return customerRepository.findAll();
	}
	

	

}
