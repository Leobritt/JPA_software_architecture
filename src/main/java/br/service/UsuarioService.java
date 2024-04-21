package br.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.dto.UsuarioDTO;
import br.entity.Pessoa;
import br.entity.Usuario;
import br.repository.PessoaRepository;
import br.repository.UsuarioRepository;

@Service
// Spring anotation que indica que a classe é um serviço (lóogica de negócio)
public class UsuarioService {

	@Autowired // Spring anotation que indica que a injeção de dependência
	private UsuarioRepository usuarioRepository;
	@Autowired // Spring anotation que indica que a injeção de dependência
	private PessoaRepository pessoaRepository;
	private Usuario usuario;
	private Pessoa pessoa;

	// método persistir uma nova entidade Usuario e uma nova entidade Pessoa no
	// banco de dados
	public String add(UsuarioDTO dto) {
		try {
			usuario = new Usuario(); // new user
			usuario.setLogin(dto.login()); // usando o set para atribuir o valor do login do dto ao login do usuario
			usuario.setEmail(dto.email());
			usuario.setPassword(dto.password());
			usuarioRepository.save(usuario); // salvando no banco de dados

			pessoa = new Pessoa();// new person
			pessoa.setNome(dto.nome()); // usando o set para atribuir o valor do nome do dto ao nome da pessoa
			pessoa.setUsuario(usuario); // passando a instancia de usuário para a pessoa obs: tem um campo usuario na
																	// entidade pessoa
			pessoaRepository.save(pessoa);// salvando no bd

			return "Usuario " + usuario.getLogin() + "inserido com sucesso!!";
		} catch (Exception e) {
			return "Problema na inserção do Usuario: " + e.getMessage();

		}

	}

	public List<Pessoa> all() {
		return pessoaRepository.findAll();
	}

}
