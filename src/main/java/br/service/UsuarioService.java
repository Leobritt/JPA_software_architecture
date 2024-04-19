package br.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import br.dto.UsuarioDTO;
import br.entity.Pessoa;
import br.entity.Usuario;
import br.repository.PessoaRepository;
import br.repository.UsuarioRepository;


@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private PessoaRepository pessoaRepository;
	private Usuario usuario;
	private Pessoa pessoa;
	public String add(UsuarioDTO dto) {
		try {
			usuario = new Usuario();
			usuario.setLogin(dto.login());
			usuario.setEmail(dto.email());
			usuario.setPassword(dto.password());
			usuarioRepository.save(usuario);
			pessoa = new Pessoa();
			pessoa.setNome(dto.nome());
			pessoa.setUsuario(usuario);
			pessoaRepository.save(pessoa);
			
			return "Usuario " + usuario.getLogin() + "inserido com sucesso!!";
		} catch (Exception e) {
			return "Problema na inserção do Usuario: " + e.getMessage();
			
		}
		
	}

	@GetMapping("/list")
	public List <Pessoa> all(){
		return pessoaRepository.findAll();
	}
	

}
