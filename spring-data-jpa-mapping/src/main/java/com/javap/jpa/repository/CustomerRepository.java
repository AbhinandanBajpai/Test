package com.javap.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.javap.jpa.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	@Query(
			  value = "SELECT * FROM customer u", 
			  nativeQuery = true)
	List<Customer> findingAll();

}
