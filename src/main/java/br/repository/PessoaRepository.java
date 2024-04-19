package br.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.entity.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, UUID>{

	
}
