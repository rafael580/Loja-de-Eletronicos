package com.devsuperior.curso.loja.controllers;

import com.devsuperior.curso.loja.entities.Pedido;
import com.devsuperior.curso.loja.servicies.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoController {
    @Autowired
    private PedidoService service;

    @GetMapping
    public String listar(){
        return "rest esta funcionado";
    }
    @GetMapping("/{id}")
    public ResponseEntity<Pedido> findById(@PathVariable Long id){
        Pedido pedido = service.buscar(id);
        return ResponseEntity.ok().body(pedido);
    }
}
