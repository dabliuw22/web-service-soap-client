package com.leysoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leysoft.client.AutorClient;
import com.leysoft.ws.autor.GetAllAutorResponse;
import com.leysoft.ws.autor.GetAutorResponse;

@RequestMapping(value = {"/autor"})
@RestController
public class ApiAutorController {
	
	@Autowired
	private AutorClient autorClient;
	
	@GetMapping(value = {""})
	public ResponseEntity<GetAllAutorResponse> all() {
		GetAllAutorResponse response = autorClient.getAllAutor();
		return new ResponseEntity<GetAllAutorResponse>(response, HttpStatus.OK);
	}
	
	@GetMapping(value = {"/{id}"})
	public ResponseEntity<GetAutorResponse> all(@PathVariable("id") int id) {
		GetAutorResponse response = autorClient.getAutor(id);
		return new ResponseEntity<GetAutorResponse>(response, HttpStatus.OK);
	}
}