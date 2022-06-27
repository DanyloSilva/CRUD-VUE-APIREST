package com.example.democrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.democrud.model.Contato;
import com.example.democrud.service.api.ContatoServiceAPI;


@Controller
public class ContatoController {
	
	@Autowired
	private ContatoServiceAPI contatoServiceAPI;
	
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("list", contatoServiceAPI.getAll());
		return "index";
	}
	
	@CrossOrigin( origins = " http://localhost:8081")
	@GetMapping("/save/{id}")
	public String showSave(@PathVariable("id") Long id , Model model) {
		if(id != null && id != 0) {
			model.addAttribute("contato", contatoServiceAPI.get(id));
		}else {
			model.addAttribute("contato", new Contato());
		}
		return "save";
	}
	
	@PostMapping("/save")
	public String save(Contato contato, Model model) {
		contatoServiceAPI.save(contato);
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id, Model model) {
		contatoServiceAPI.delete(id);
		
		return "redirect:/";
	}
	
	

}
