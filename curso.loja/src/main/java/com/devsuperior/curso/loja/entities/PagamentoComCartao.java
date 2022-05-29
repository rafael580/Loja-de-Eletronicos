package com.devsuperior.curso.loja.entities;

import com.devsuperior.curso.loja.entities.enums.EstadoPagamento;

import javax.persistence.Entity;

@Entity
public class PagamentoComCartao extends Pagamento{

    private static final Long serialVersionUID = 1L;

    private Integer numeroDeParcelas;

    public PagamentoComCartao() {}

    public PagamentoComCartao(EstadoPagamento estadoPagamento,Pedido pedido ,Integer numeroDeParcelas) {
        super(estadoPagamento,pedido);
        this.numeroDeParcelas = numeroDeParcelas;
    }

    public Integer getNumeroDeParcelas() {
        return numeroDeParcelas;
    }

    public void setNumeroDeParcelas(Integer numeroDeParcelas) {
        this.numeroDeParcelas = numeroDeParcelas;
    }
}
