package com.devsuperior.curso.loja.controllers;

import com.devsuperior.curso.loja.entities.Categoria;
import com.devsuperior.curso.loja.servicies.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService service;

    @GetMapping
    public String listar(){
        return "rest esta funcionado";
    }
    @GetMapping("/{id}")
    public ResponseEntity<Categoria> findById(@PathVariable Long id){
        Categoria categoria = service.buscar(id);
        return ResponseEntity.ok().body(categoria);
    }
}
