package br.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository; //CRUD operations
import org.springframework.stereotype.Repository;

import br.entity.Usuario;

@Repository
// Spring annotation to indicate that the class provides the mechanism for
// storage,
// retrieval, search, update and delete operation on objects.
public interface UsuarioRepository
      extends JpaRepository<Usuario, UUID> {
   // repository interface that extends JpaRepository to perform CRUD operations on
   // the entity Usuario.

}
