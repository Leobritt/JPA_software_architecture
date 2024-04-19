package br.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.entity.Usuario;



@Repository
public interface UsuarioRepository 
   extends JpaRepository<Usuario, UUID> {

}
