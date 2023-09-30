package com.colaboradores.repository;

import com.colaboradores.model.Colaborador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ColaboradorRepository extends JpaRepository<Colaborador, Long> {

    Colaborador findByNome(String nome);

}
