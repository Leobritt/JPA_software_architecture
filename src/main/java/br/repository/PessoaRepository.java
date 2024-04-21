package br.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository; //CRUD operations
import org.springframework.stereotype.Repository;

import br.entity.Pessoa;

@Repository
// Spring annotation to indicate that the class provides the mechanism for
// storage,
// retrieval, search, update and delete operation on objects.
public interface PessoaRepository extends JpaRepository<Pessoa, UUID> {
  // repository interface that extends JpaRepository to perform CRUD operations on
  // the entity Pessoa.

}
