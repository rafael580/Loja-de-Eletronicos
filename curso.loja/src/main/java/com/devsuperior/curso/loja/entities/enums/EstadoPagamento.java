package com.devsuperior.curso.loja.entities.enums;

public enum EstadoPagamento {
    PENDENTE(1),
    QUITADO(2),
    CANCELADO(3);

    private Integer cont;

    private EstadoPagamento(Integer code){
        this.cont = code;
    }
    public static EstadoPagamento filtro(Integer code){
        if(code==null){
            return null;
        }
        for(EstadoPagamento estado: EstadoPagamento.values()){
            if(code.equals(estado.getCont())){
                return estado;
            }
        }
        throw new IllegalArgumentException("Codigo invalido "+ code);
    }

    public Integer getCont() {
        return cont;
    }

    public void setCont(Integer cont) {
        this.cont = cont;
    }
}
