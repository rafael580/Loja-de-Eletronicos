package com.devsuperior.curso.loja.repositories;

import com.devsuperior.curso.loja.entities.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemPeditoRepository extends JpaRepository<ItemPedido,Long> {
}
