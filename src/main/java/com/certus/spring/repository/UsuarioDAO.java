
package com.certus.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.certus.spring.models.Usuario;

@Repository
public interface UsuarioDAO extends CrudRepository<Usuario, Integer> {

}
