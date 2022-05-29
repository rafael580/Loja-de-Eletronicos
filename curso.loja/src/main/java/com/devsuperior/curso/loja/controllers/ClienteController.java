package com.devsuperior.curso.loja.controllers;

import com.devsuperior.curso.loja.entities.Cliente;
import com.devsuperior.curso.loja.servicies.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;
    @GetMapping
    public String listar(){
        return "rest esta funcionado";
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable Long id){
        Cliente cliente = service.buscar(id);
        return ResponseEntity.ok().body(cliente);
    }
}
