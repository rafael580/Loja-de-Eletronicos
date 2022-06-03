package com.devsuperior.curso.loja.servicies;

import com.devsuperior.curso.loja.entities.Categoria;
import com.devsuperior.curso.loja.entities.Pedido;
import com.devsuperior.curso.loja.repositories.PedidoRepository;
import com.devsuperior.curso.loja.servicies.exception.ResourceNotfoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repository;

    public Pedido buscar(Long id){
        Optional<Pedido> pedido = repository.findById(id);
        return pedido.orElseThrow(()->{
            throw new ResourceNotfoundException("entidade nao encontrada");
        });
    }

}
