package com.devsuperior.curso.loja.servicies;

import com.devsuperior.curso.loja.entities.Categoria;
import com.devsuperior.curso.loja.repositories.CategoriaRepository;
import com.devsuperior.curso.loja.servicies.exception.ResourceNotfoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    public Categoria buscar(Long id){
        Optional<Categoria> categoria = repository.findById(id);
        return categoria.orElseThrow(()->{
            throw new ResourceNotfoundException("entidade nao encontrada");
        });
    }
}
