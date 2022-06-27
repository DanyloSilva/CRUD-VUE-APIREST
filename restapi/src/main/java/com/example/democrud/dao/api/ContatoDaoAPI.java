package com.example.democrud.dao.api;

import org.springframework.data.repository.CrudRepository;

import com.example.democrud.model.Contato;


public interface ContatoDaoAPI extends CrudRepository<Contato, Long> {

}
