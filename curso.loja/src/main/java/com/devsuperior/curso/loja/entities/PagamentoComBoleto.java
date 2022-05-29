package com.devsuperior.curso.loja.entities;

import com.devsuperior.curso.loja.entities.enums.EstadoPagamento;

import javax.persistence.Entity;
import java.util.Date;
@Entity
public class PagamentoComBoleto extends Pagamento{

    private static final Long serialVersionUID = 1L;

    private Date dataVencimento;
    private Date dataPagamento;

    public PagamentoComBoleto(){}
    public PagamentoComBoleto(EstadoPagamento estadoPagamento,Pedido pedido ,Date dataVencimento,Date dataPagamento){
        super(estadoPagamento,pedido);
        this.dataPagamento = dataPagamento;
        this.dataVencimento = dataVencimento;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }
}
