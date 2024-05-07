package com.iurysouzaaraujo.CRUD.e.VALIDACOES.repositories;

import com.iurysouzaaraujo.CRUD.e.VALIDACOES.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
