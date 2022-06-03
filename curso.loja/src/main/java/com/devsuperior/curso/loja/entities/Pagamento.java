package com.devsuperior.curso.loja.entities;

import com.devsuperior.curso.loja.entities.enums.EstadoPagamento;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pagamento implements Serializable {

    private static final Long serialVersionUID = 1L;

    @Id
    private Long id;
    private Integer estado;
    @JsonBackReference
    @OneToOne
    @JoinColumn(name = "pedido_id")
    @MapsId
    private Pedido pedido;

    public Pagamento() {
    }

    public Pagamento(EstadoPagamento estado, Pedido pedido) {
        this.estado = estado.getCont();
        this.pedido = pedido;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Long getId() {
        return id;
    }

    public EstadoPagamento getEstado() {
        return  EstadoPagamento.filtro(estado);
    }

    public void setEstado(EstadoPagamento estado) {
        this.estado = estado.getCont();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pagamento pagamento = (Pagamento) o;
        return Objects.equals(id, pagamento.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
