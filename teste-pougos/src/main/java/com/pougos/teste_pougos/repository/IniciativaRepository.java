package com.pougos.teste_pougos.repository;

import com.pougos.teste_pougos.model.Iniciativa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IniciativaRepository extends JpaRepository<Iniciativa, Long> {
}
