package com.devsuperior.curso.loja.repositories;

import com.devsuperior.curso.loja.entities.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade,Long> {
}
