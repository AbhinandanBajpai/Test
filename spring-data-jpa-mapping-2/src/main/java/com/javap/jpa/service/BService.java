package com.javap.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.javap.jpa.entity.Library;
import com.javap.jpa.repository.BookRepository;
import com.javap.jpa.repository.LibraryRepository;

@Service
public class BService {

	@Autowired
  private LibraryRepository libraryRepository;
	
	@Autowired
	private BookRepository bookRepository;
	
	public Library create(Library library) {
		
		return libraryRepository.save(library);
	}
}
