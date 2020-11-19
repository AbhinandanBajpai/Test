package com.javap.jpa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javap.jpa.entity.Library;
import com.javap.jpa.service.BService;

@RestController
public class BController {
	@Autowired
	BService bservice;

	@PostMapping("/create")
		public Library creation(@RequestBody Library library){
		return bservice.create(library);
	}
	}

