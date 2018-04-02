package com.leysoft.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leysoft.client.AutorClient;
import com.leysoft.model.AutorModel;
import com.leysoft.util.AutorConverter;
import com.leysoft.ws.autor.AddAutorResponse;
import com.leysoft.ws.autor.Autor;
import com.leysoft.ws.autor.DeleteAutorResponse;
import com.leysoft.ws.autor.GetAllAutorResponse;
import com.leysoft.ws.autor.GetAutorResponse;
import com.leysoft.ws.autor.UpdateAutorResponse;

@RequestMapping(value = {"/autor"})
@RestController
public class ApiAutorController {
	
	@Autowired
	private AutorClient autorClient;
	
	@Autowired
	private AutorConverter autorConverter;
	
	@GetMapping(value = {""})
	public ResponseEntity<GetAllAutorResponse> all() {
		GetAllAutorResponse response = autorClient.getAllAutor();
		return new ResponseEntity<GetAllAutorResponse>(response, HttpStatus.OK);
	}
	
	@GetMapping(value = {"/{id}"})
	public ResponseEntity<GetAutorResponse> get(@PathVariable("id") int id) {
		GetAutorResponse response = autorClient.getAutor(id);
		return new ResponseEntity<GetAutorResponse>(response, HttpStatus.OK);
	}
	
	@PostMapping(value = {""})
	public ResponseEntity<AddAutorResponse> save(@RequestBody String name) {
		AddAutorResponse response = autorClient.addAutor(name);
		return new ResponseEntity<AddAutorResponse>(response, HttpStatus.CREATED);
	}
	
	@PutMapping(value = {"/{id}"})
	public ResponseEntity<UpdateAutorResponse> update(@PathVariable int id, @Valid @RequestBody AutorModel model) {
		Autor autor = autorConverter.getAutor(model);
		UpdateAutorResponse response = autorClient.updateAutor(id, autor);
		return new ResponseEntity<UpdateAutorResponse>(response, HttpStatus.CREATED);
	}
	
	@DeleteMapping(value = {"/{id}"})
	public ResponseEntity<DeleteAutorResponse> delete(@PathVariable int id) {
		DeleteAutorResponse response = autorClient.deleteAutor(id);
		return new ResponseEntity<DeleteAutorResponse>(response, HttpStatus.NO_CONTENT);
	}
}