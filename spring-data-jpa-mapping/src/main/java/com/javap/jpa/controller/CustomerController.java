package com.javap.jpa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javap.jpa.dto.OrderRequest;
import com.javap.jpa.entity.Customer;
import com.javap.jpa.exception.ResourceNotFoundException;
import com.javap.jpa.repository.CustomerRepository;
import com.javap.jpa.repository.ProductRepository;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@PostMapping("/customers")
	public Customer createOrder(@RequestBody Customer customer) {
		
		System.out.println(customer);
		
		return customerRepository.save(customer);
	}
	
	@GetMapping("/customers")
	public List<Customer> getAllCust(){
		
//		 List<Customer> findAll = customerRepository.findAll();
		 List<Customer> findingAll = customerRepository.findingAll();
		System.out.println(findingAll);
		return customerRepository.findAll();
	}	
	
	//finding By Id
	
	@GetMapping("customers/{id}")
	public Customer getCustomersById(@PathVariable int id) {
		return customerRepository.findingById(id);
	}
	
	//Updating the data
	
	@PutMapping("/customers/{custId}")
	public Customer updateCustomers(@PathVariable int custId , @RequestBody Customer customer ) {

	 return	customerRepository.findById(custId).map(cust -> {
			cust.setName(customer.getName());
			cust.setEmail(customer.getEmail());
			cust.setGender(customer.getGender());
			cust.setProducts(customer.getProducts());
			return customerRepository.save(cust);	
		}).orElseThrow(()-> new ResourceNotFoundException("id"+custId+"not found"));
	}
//	
	//deleting the data
	@DeleteMapping("/customers/{custId}")
	public Customer deleteCustomerById(@PathVariable int id) {
		
		 return customerRepository.deleteByID(id);
		
	}

}
