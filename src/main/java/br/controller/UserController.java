package br.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.dto.UsuarioDTO;
import br.entity.Pessoa;
import br.entity.Usuario;
import br.service.UsuarioService;
import org.springframework.web.bind.annotation.RequestParam;

@RestController

@RequestMapping("/user")
public class UserController {

	@Autowired
	private UsuarioService service;

	@PostMapping("/add")
	public String add(@RequestBody UsuarioDTO dto) {

		return service.add(dto);
	}

	@GetMapping("/all-persons")
	public List<Pessoa> findAllPessoas() {
		return service.allPessoas();
	}

	@GetMapping("/test")
	public String testaResultado() {

		return "resposta devolvida";
	}

	@GetMapping("/find-by-id/{id}")
	public Pessoa findPessoaById(@PathVariable UUID id) {
		return service.findPessoaById(id);
	}

	@GetMapping("/all-users")
	public List<Usuario> findAllUsuarios() {
		return service.allUsers();
	}

}
