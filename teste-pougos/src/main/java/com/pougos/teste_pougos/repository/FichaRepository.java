package com.pougos.teste_pougos.repository;

import com.pougos.teste_pougos.model.Ficha;
import com.pougos.teste_pougos.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FichaRepository extends JpaRepository<Ficha, Long> {
    List<Ficha> findByUsuario(Usuario usuario);
}
