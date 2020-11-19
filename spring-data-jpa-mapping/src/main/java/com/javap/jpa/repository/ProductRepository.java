package com.javap.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javap.jpa.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
