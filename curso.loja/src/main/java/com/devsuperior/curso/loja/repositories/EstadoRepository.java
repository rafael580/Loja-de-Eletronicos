package com.devsuperior.curso.loja.repositories;

import com.devsuperior.curso.loja.entities.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<Estado,Long> {
}
