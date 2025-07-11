package com.pougos.teste_pougos.repository;

import com.pougos.teste_pougos.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<Usuario, Long>, Repository<Usuario, Long> {
    boolean existsByEmail(String email);

    Optional<Usuario> findByEmail(String email);

    boolean existsByEmailAndSenha(String email, String senha);
}
