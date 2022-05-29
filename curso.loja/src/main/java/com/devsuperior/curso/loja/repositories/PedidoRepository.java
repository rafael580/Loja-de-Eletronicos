package com.devsuperior.curso.loja.repositories;

import com.devsuperior.curso.loja.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido,Long> {
}
