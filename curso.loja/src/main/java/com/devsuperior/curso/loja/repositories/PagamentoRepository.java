package com.devsuperior.curso.loja.repositories;

import com.devsuperior.curso.loja.entities.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento,Long> {
}
