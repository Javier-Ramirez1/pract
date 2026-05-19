package com.prac.demo.repository;

import com.prac.demo.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Usuario findByCodusuario(String codusuario);
}