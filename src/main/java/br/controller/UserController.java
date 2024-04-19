package br.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.dto.UsuarioDTO;
import br.entity.Pessoa;
import br.service.UsuarioService;

@RestController

@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UsuarioService service;
	
	@PostMapping("/add")
	public String add(@RequestBody UsuarioDTO dto){
		
		return service.add(dto);
	}
	
	@GetMapping("/all")
	public List <Pessoa> all(){
		return service.all();
	}
	
	
	@GetMapping("/test")
	public String testaResultado(){
		
		return"resposta devolvida" ;
	}

}
