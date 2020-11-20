package com.javap.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.javap.jpa.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	@Query( value = "SELECT * FROM customer u", 
			  nativeQuery = true)
	List<Customer> findingAll();
	
	@Query(value= "SELECT * FROM customer u WHERE u.id = :id", nativeQuery = true)
	Customer findingById(@Param("id") Integer id);
	
	@Query(value="DELETE FROM customer u WHERE u.id = :id", nativeQuery = true)
	Customer deleteByID(@Param("id") Integer id);
	

}
