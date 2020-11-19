package com.javap.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javap.jpa.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
