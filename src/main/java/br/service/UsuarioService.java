package br.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;

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

	public List<Pessoa> allPessoas() {
		return pessoaRepository.findAll();
	}

	public Pessoa findPessoaById(UUID id) {
		return pessoaRepository.findById(id).get();
	}

	public List<Usuario> allUsers() {
		return usuarioRepository.findAll();
	}

	public void delete(UUID id) {
		pessoaRepository.deleteById(id);
	}

	public Usuario update(UUID id, UsuarioDTO dto) {
		Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);
		if (optionalUsuario.isPresent()) {
			Usuario usuario = optionalUsuario.get();
			usuario.setLogin(dto.login());
			usuario.setEmail(dto.email());
			usuario.setPassword(dto.password());
			usuarioRepository.save(usuario);
			return usuario;
		} else {
			System.out.println("Usuário não encontrado para o id: " + id);
			throw new RuntimeException("Usuário não encontrado para o id: " + id);

		}
	}
}