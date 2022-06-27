package com.example.democrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.democrud.model.Contato;
import com.example.democrud.service.api.ContatoServiceAPI;

@CrossOrigin( origins = "http://localhost:8081")
@RestController
@RequestMapping(value = "/api")
public class ContatoRestController {

	@Autowired
	private ContatoServiceAPI contatoServiceAPI;

	@GetMapping(value = "/all")
	@CrossOrigin( origins = "http://localhost:8081")
	public List<Contato> getAll() {
		return contatoServiceAPI.getAll();
	}
	
	@GetMapping(value = "/find/{id}")
	@CrossOrigin( origins = " http://localhost:8081")
	public Contato find(@PathVariable Long id) {
		return contatoServiceAPI.get(id);
	}

	@PostMapping(value = "/save")
	@CrossOrigin( origins = " http://localhost:8081")
	public ResponseEntity<Contato> save(@RequestBody Contato contato) {
		Contato obj = contatoServiceAPI.save(contato);
		return new ResponseEntity<Contato>(obj, HttpStatus.OK);
	}

	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<Contato> delete(@PathVariable Long id) {
		Contato contato = contatoServiceAPI.get(id);
		if (contato != null) {
			contatoServiceAPI.delete(id);
		}else {
			return new ResponseEntity<Contato>(contato, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<Contato>(contato, HttpStatus.OK);
	}

}
