package com.devsuperior.curso.loja.servicies;

import com.devsuperior.curso.loja.entities.Cliente;
import com.devsuperior.curso.loja.repositories.ClienteRepository;
import com.devsuperior.curso.loja.servicies.exception.ResourceNotfoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repository;

    @Transactional(readOnly = true)
    public Cliente buscar(Long id){
        Optional<Cliente> cliente  = repository.findById(id);
        return  cliente.orElseThrow(()->{
         throw new  ResourceNotfoundException("Client not found");
        });
    }
}
