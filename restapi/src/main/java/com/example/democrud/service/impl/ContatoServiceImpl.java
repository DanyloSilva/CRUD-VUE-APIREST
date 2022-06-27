package com.example.democrud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.example.democrud.commons.GenericServiceImpl;
import com.example.democrud.dao.api.ContatoDaoAPI;

import com.example.democrud.model.Contato;
import com.example.democrud.service.api.ContatoServiceAPI;


@Service
public class ContatoServiceImpl extends GenericServiceImpl<Contato, Long> implements ContatoServiceAPI {

	@Autowired
	private ContatoDaoAPI contatoDaoAPI;
	
	@Override
	public CrudRepository<Contato, Long> getDao() {
		return contatoDaoAPI;
	}

}
