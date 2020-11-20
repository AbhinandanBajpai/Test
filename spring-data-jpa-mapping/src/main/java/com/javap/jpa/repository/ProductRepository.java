package com.javap.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.javap.jpa.entity.Customer;
import com.javap.jpa.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	@Query(value= "SELECT * FROM product u WHERE u.id = :id", nativeQuery = true)
	Product findingById(@Param("id") Integer id);

}
